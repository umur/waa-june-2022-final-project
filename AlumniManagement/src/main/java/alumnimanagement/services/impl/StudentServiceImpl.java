package alumnimanagement.services.impl;

import alumnimanagement.dto.StudentDTO;
import alumnimanagement.entity.Student;
import alumnimanagement.repo.StudentRepo;
import alumnimanagement.services.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;
    private ModelMapper modelMapper;

    @Override
    public void create(StudentDTO studentDTO) {
        studentRepo.save(modelMapper.map(studentDTO, Student.class));
    }

    @Override
    public void update(long id, StudentDTO studentDTO) throws Exception {
        Student student = studentRepo.findById(id).orElseThrow(() -> new Exception("Student id is invalid"));
        student.setAddress(studentDTO.getAddress());
        student.setName(studentDTO.getName());
        student.setId(id);
        studentRepo.save(student);

    }

    @Override
    public List<StudentDTO> findAll() {

        List<StudentDTO> studentDTOS = studentRepo.findAll().stream().map(student -> {
            return modelMapper.map(student, StudentDTO.class);
        }).toList();
        return studentDTOS;
    }

    @Override
    public void remove(long id) {
        studentRepo.deleteById(id);
    }
}
