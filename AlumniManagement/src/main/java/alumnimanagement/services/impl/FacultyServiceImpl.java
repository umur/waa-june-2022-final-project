package alumnimanagement.services.impl;

import alumnimanagement.dto.FacultyDTO;
import alumnimanagement.entity.Address;
import alumnimanagement.entity.Faculty;
import alumnimanagement.repo.FacultyRepo;
import alumnimanagement.services.FacultyService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
}
