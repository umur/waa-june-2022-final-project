package com.finalproject.service.impl;

import com.finalproject.models.Comments;
import com.finalproject.models.ERole;
import com.finalproject.models.Student;
import com.finalproject.models.User;
import com.finalproject.payload.request.PostRequest;
import com.finalproject.repository.CommentRepo;
import com.finalproject.repository.StudentRepo;
import com.finalproject.repository.UserRepository;
import com.finalproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Override
    public List<User> findAllStudent() {

        List<User> holder = new ArrayList<>();
        holder = userRepo.findAll().stream().filter(k -> k.isSoft_deleted() != true).collect(Collectors.toList());
        return holder;
    }
//        userRepo.findAll().forEach(user -> {
//            ERole role = user.getRoles().stream().toList().get(0).getName();
//            if (role == ERole.ROLE_STUDENT) {
//                allUserStudents.add(user);
//            }
//        });
//        return allUserStudents;


    @Override
    public User findById(long id) throws Exception {

        var n=  userRepo.findById(id).orElseThrow(() -> new RuntimeException("Error: User not found"));

        if(!n.isSoft_deleted()){
            return n;
        }
    else {
        throw  new Exception("already deleted ");
        }
    }

    @Override
    public Student getbyId(Long id) throws Exception {
        var n= studentRepo.findById(id).orElseThrow();

        if(!n.getUser().isSoft_deleted()){
            return n;
        }
        else {
            throw new Exception("already deleted ");
        }
    }

    @Override
    public void post(PostRequest postRequest, long id) {
        var student = studentRepo.findById(id).orElseThrow(()-> new RuntimeException("Error: Student not found."));
        Comments comment = new Comments();
        comment.setComment(postRequest.getComment());
        comment.setCommenter(postRequest.getCommenter());
        comment.setPostTime(LocalDateTime.now());
        comment.setStudent(student);
        commentRepo.save(comment);
    }

    @Override
    public List<Student> getByCity(String city) {

        List<Student>  holder = new ArrayList<>();
        holder = studentRepo.findAllByAddress_City(city).stream().filter(k -> k.getUser().isSoft_deleted() != true).collect(Collectors.toList());
        return holder;
    }

    @Override
    public List<Student> getByState(String state) {
        List<Student>  holder = new ArrayList<>();
        holder = studentRepo.findAllByAddress_State(state).stream().filter(k -> k.getUser().isSoft_deleted() != true).collect(Collectors.toList());
        return holder;
    }

    @Override
    public List<Student> getByMajor(String major) {
        List<Student>  holder = new ArrayList<>();
        holder = studentRepo.findAllByMajor(major).stream().filter(k -> k.getUser().isSoft_deleted() != true).collect(Collectors.toList());
        return holder;
    }

    @Override
    public Student getByStudentId(Integer id) throws Exception {

        var n= studentRepo.findByStudentId(id);
   if(!n.getUser().isSoft_deleted()){

    return  n;
   }
    else {

        throw new Exception("student could  be deleted ");
   }
    }

    @Override
    public List<Student> getByName(String name) {
       List<Student>  holder = new ArrayList<>();
        holder =studentRepo.findAllByFirstName(name).stream().filter(k->k.getUser().isSoft_deleted()!=true).collect(Collectors.toList());
        return holder;
    }



    @Override
    public void deleteStudent(Long id) {
        var n= userRepo.findById(id).orElseThrow();
        n.setSoft_deleted(true);
    }

    @Override
    public Integer countByCity(String city) {
        return studentRepo.countAllByAddress_City(city);
    }

    @Override
    public Integer countByState(String state) {
        return studentRepo.countAllByAddress_State(state);
    }

    // updating his profile
    @Override
    public void updateProfile(Student student,Long id) {

        var  old =studentRepo.findById(id).orElseThrow();
        old.setId(student.getId());
        old.setFirstName(student.getFirstName());
        old.setLastName(student.getLastName());
        old.setGpa(student.getGpa());
        old.setAddress(student.getAddress());
        old.setMajor(student.getMajor());
        old.setJobHistory(student.getJobHistory());
      studentRepo.save(old);
    }

}

