package edu.miu.amp.service.impl;

import edu.miu.amp.domain.Faculty;
import edu.miu.amp.dto.FacultyDto;
import edu.miu.amp.dto.StudentDto;
import edu.miu.amp.helper.UserPrincipal;
import edu.miu.amp.repository.FacultyRepository;
import edu.miu.amp.repository.UserRepo;
import edu.miu.amp.service.FacultyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Override
    public FacultyDto getMyProfile() {
        var authUser = UserPrincipal.getAuthUser();

        var user = userRepo.findByUserName(authUser.getUserName()).orElse( null );

        var faculty =  facultyRepository.findById(user.getId()).get();
        return modelMapper.map(faculty, FacultyDto.class);
    }

    @Override
    public List<FacultyDto> findAll() {
        List<Faculty> faculty = facultyRepository.findAll();
        List<FacultyDto> facultyDto = faculty.stream()
                .map(f -> toDto(f))
                .collect(Collectors.toList());
        return facultyDto;
    }



    @Override
    public FacultyDto save(FacultyDto facultyDto) {
        Faculty faculty = toEntity(facultyDto);
        return toDto(facultyRepository.save(faculty));
    }

    @Override
    public FacultyDto findById(Integer id) {
        var faculty = facultyRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Faculty with id %s does not exists", id)));
        FacultyDto facultyDto = toDto(faculty);
        return facultyDto;
    }

    @Override
    public void remove(Integer id) {
        facultyRepository.deleteById(id);

    }

    @Override
    public FacultyDto updateById(FacultyDto facultyDto,Integer id) {
        Faculty faculty = toEntity(facultyDto);
        facultyRepository.findById(id).map(faculty1 -> {
            faculty1.setDepartment(faculty.getDepartment());
            faculty1.setCommentList((faculty.getCommentList()));
            faculty1.setAddress(faculty.getAddress());
            faculty1.setEmail(faculty.getEmail());
            faculty1.setFirstName(faculty.getFirstName());
            faculty1.setLastName(faculty.getLastName());

            faculty1.setUserName(faculty.getUserName());


            return facultyRepository.save(faculty);
        });
        return toDto(faculty);
    }

    public FacultyDto toDto(Faculty faculty){
        FacultyDto facultyDto = modelMapper.map(faculty, FacultyDto.class);
        return facultyDto;
    }

    public Faculty toEntity(FacultyDto facultyDto){
        Faculty faculty = modelMapper.map(facultyDto, Faculty.class);
        return faculty;
    }
}
