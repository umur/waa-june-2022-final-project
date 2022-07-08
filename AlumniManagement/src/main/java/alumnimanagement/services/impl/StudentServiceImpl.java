package alumnimanagement.services.impl;

import alumnimanagement.dto.StudentDTO;
import alumnimanagement.dto.StudentListDto;
import alumnimanagement.entity.Address;
import alumnimanagement.entity.Student;
import alumnimanagement.repo.StudentRepo;
import alumnimanagement.services.StudentService;
import alumnimanagement.utility.Helper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
        student.setAddress(modelMapper.map(studentDTO.getAddress(), Address.class));
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
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
    public Long totalStudents() {
        Long count = studentRepo.count();
        return count;
    }

    @Override
    public StudentDTO findStudentById(long id) {
        Student s= studentRepo.findById(id).get();
        return modelMapper.map(s,StudentDTO.class);
    }

    @Override
    public List<StudentListDto> findAllByParam(int page, int size, String searchValue) {
//        List<Student> student = studentRepo.findAll().stream().toList();
        Long id = Helper.getLoggedUserId();
        var a = Helper.getCurrentDate();
        Pageable pageable = PageRequest.of(page, size);
        List<Student> student = studentRepo.findAll(pageable).stream().toList();
        List<StudentListDto> studentListDtos = new ArrayList<>();
        for(Student r : student)
        {
            StudentListDto dtp = new StudentListDto();
            dtp.setEmail(r.getEmail());
            dtp.setFirstName(r.getFirstName());
            dtp.setLastName(r.getLastName());
            dtp.setCity(r.getAddress().getCity());
            dtp.setState(r.getAddress().getState());
            dtp.setId(r.getId());
            studentListDtos.add(dtp);
        }
        return studentListDtos;
    }

    @Override
    public void remove(long id) {
        studentRepo.deleteById(id);
    }
}
