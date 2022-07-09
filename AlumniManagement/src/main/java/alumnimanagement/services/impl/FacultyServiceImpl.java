package alumnimanagement.services.impl;

import alumnimanagement.dto.FacultyDTO;
import alumnimanagement.dto.FacultyListDto;
import alumnimanagement.entity.Address;
import alumnimanagement.entity.Faculty;
import alumnimanagement.entity.Student;
import alumnimanagement.repo.FacultyRepo;
import alumnimanagement.services.FacultyService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor

public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepo facultyRepo;
    private final ModelMapper modelMapper;

    @Override
    public void create(FacultyDTO facultyDTO) {
        facultyRepo.save(modelMapper.map(facultyDTO, Faculty.class));
    }

    @Override
    public void update(long id, FacultyDTO facultyDTO) throws Exception {
        Faculty faculty = facultyRepo.findById(id).orElseThrow(() -> new Exception("Invalid id"));
        faculty.setId(id);
        faculty.setAddress(modelMapper.map(facultyDTO.getAddress(), Address.class));
        faculty.setFirstName(facultyDTO.getFirstName());
        faculty.setLastName(facultyDTO.getLastName());
        faculty.setEmail(facultyDTO.getEmail());
        facultyRepo.save(faculty);

    }

    @Override
    public List<FacultyDTO> findAll() {
        List<FacultyDTO> facultyDTOS = facultyRepo.findAll().stream().map(faculty -> modelMapper.map(faculty, FacultyDTO.class)).toList();
        return facultyDTOS;
    }

    @Override
    public void remove(long id) {
        facultyRepo.deleteById(id);

    }

    @Override
    public List<FacultyListDto> findAllByParam(int page, int size, String searchValue) {
        Pageable pageable = PageRequest.of(page, size);
        List<Faculty> facultyList = facultyRepo.findAll(pageable).stream().toList();
        List<FacultyListDto> dtos = new ArrayList<>();
        for(Faculty f : facultyList)
        {
            FacultyListDto facultyListDto = new FacultyListDto();
            facultyListDto.setCity(f.getAddress().getCity());
            facultyListDto.setEmail(f.getEmail());
            facultyListDto.setId(f.getId());
            facultyListDto.setFirstName(f.getFirstName());
            facultyListDto.setLastName(f.getLastName());
            facultyListDto.setState(f.getAddress().getState());
            facultyListDto.setDepartment(f.getDepartment());
            dtos.add(facultyListDto);
        }
        return dtos;
    }

    @Override
    public Long count() {
        Long count = facultyRepo.count();
        return count;
    }
}
