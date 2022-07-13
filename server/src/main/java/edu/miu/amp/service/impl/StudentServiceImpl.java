package edu.miu.amp.service.impl;

import edu.miu.amp.domain.JobHistory;
import edu.miu.amp.domain.Student;
import edu.miu.amp.dto.JobHistoryDto;
import edu.miu.amp.dto.StudentDto;
import edu.miu.amp.exception.ResourceNotFoundException;
import edu.miu.amp.helper.UserPrincipal;
import edu.miu.amp.repository.StudentRepo;
import edu.miu.amp.repository.UserRepo;
import edu.miu.amp.service.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student savedStudent = studentRepo.save(modelMapper.map(studentDto, Student.class));
        return modelMapper.map(savedStudent, StudentDto.class);
    }

    @Override
    public List<JobHistoryDto> getStudentJobHistory(Integer id) {
        var student = studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        var jobHistory = student.getJobHistoryList();
        System.out.println(jobHistory);

        if (jobHistory == null) {
//            @TODO
//          Hibernate returns null @ first and return [] on second time execution
            return new ArrayList<JobHistoryDto>();

        } else {
            return jobHistory.stream().map(x -> modelMapper.map(x, JobHistoryDto.class)).toList();
        }

    }

    @Override
    public StudentDto getMyProfile() {
        var authUser = UserPrincipal.getAuthUser();

        var user = userRepo.findByUserName(authUser.getUserName()).orElse(null);

        var student = studentRepo.findById(user.getId()).get();
        return modelMapper.map(student, StudentDto.class);

    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentRepo.findAll();
        return students.stream()
                .map(s -> modelMapper.map(s, StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto findById(Integer id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto update(StudentDto studentDto, Integer id) {
        Student existingStudent = this.studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        // note here: DO NOT CHANGE ID HERE WHILE UPDATING
        existingStudent.setGpa(studentDto.getGpa());
        existingStudent.setCVFile(studentDto.getCVFile());
        existingStudent.setFirstName(studentDto.getFirstName());
        existingStudent.setLastName(studentDto.getLastName());
        existingStudent.setEmail(studentDto.getEmail());

        existingStudent.setUserName(studentDto.getUserName());

        existingStudent.setAddress(studentDto.getAddress());

        Student updatedStudent = this.studentRepo.save(existingStudent);
        return modelMapper.map(updatedStudent, StudentDto.class);
    }

    @Override
    public void remove(Integer id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        studentRepo.delete(student);
    }
}
