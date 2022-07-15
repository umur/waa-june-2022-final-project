package com.waa.amp.service;

import com.waa.amp.dto.JobApplyReq;
import com.waa.amp.dto.JobReq;
import com.waa.amp.dto.StudentReq;
import com.waa.amp.dto.StudentSearchReq;
import com.waa.amp.entity.*;
import com.waa.amp.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentService {

    private final UserService userService;
    private final JobRepository jobRepository;
    private final TagRepository tagRepository;

    private final StudentRepository studentRepository;
    private final JobApplyRepository jobApplyRepository;
    private final FacultyRepository facultyRepository;

    public Job postJob(JobReq jobReq) {

        List<Tag> tags = new ArrayList<>();

        for (String it : jobReq.tag()) {
            var t = tagRepository.findByTags(it);
            tags.add(t);
        }

        var job = new Job(null, jobReq.description(), tags, jobReq.state(), jobReq.city(), jobReq.companyName(), userService.getLoggedUser());

        return jobRepository.save(job);
    }

    public Job updateJob(Long id, JobReq jobReq) {
        Job job = jobRepository.findByIdAndPostedBy(id, userService.getLoggedUser()).orElseThrow(() -> new RuntimeException("This is not your job"));

        List<Tag> tags = new ArrayList<>();

        for (String it : jobReq.tag()) {
            var t = tagRepository.findByTags(it);
            tags.add(t);
        }

        job.setTags(tags);

        var updatedJob = new Job(id, jobReq.description(), tags, jobReq.state(), jobReq.city(), jobReq.companyName(), userService.getLoggedUser());

        return jobRepository.save(updatedJob);
    }

    public List<Job> getJob() {
        User loggedUser = userService.getLoggedUser();
        return jobRepository.findAllByPostedBy(loggedUser);
    }

    public List<Job> getALlJob() {
        return jobRepository.findAll().stream().peek(Job::getPostedBy).toList();
    }

    public Student createStudent(StudentReq studentReq) {
        return updateStudent(null, studentReq);
    }

    public Student updateStudent(Long id, StudentReq studentReq) {
        Student student = new Student(id, userService.getLoggedUser(), studentReq.email(), studentReq.firstName(), studentReq.lastname(), studentReq.major(), studentReq.gpa(), studentReq.city());

        return studentRepository.save(student);
    }

    public void updateProfile(StudentReq studentReq) {
        User loggedUser = userService.getLoggedUser();

        if (studentReq.userType() == UserType.STUDENT) {
            Student student = studentRepository.findByUser(loggedUser);
            student.setEmail(studentReq.email());
            student.setFirstname(studentReq.firstName());
            student.setLastname(studentReq.lastname());
            student.setMajor(studentReq.major());
            student.setGpa(studentReq.gpa());
            student.setCity(studentReq.city());
            studentRepository.save(student);
        } else {
            Faculty faculty = facultyRepository.findByUser(loggedUser);
            faculty.setFirstname(studentReq.firstName());
            faculty.setLastname(studentReq.lastname());
            faculty.setCity(studentReq.city());
            facultyRepository.save(faculty);
        }

    }

    public StudentReq getProfile() {
        User loggedUser = userService.getLoggedUser();
        UserType userType = loggedUser.getUserType();

        if (userType == UserType.STUDENT) {
            Student student = studentRepository.findByUser(loggedUser);

            return new StudentReq(student.getEmail(), student.getFirstname(), student.getLastname(), student.getMajor(), student.getGpa(), student.getCity(), userType);

        } else {
            Faculty faculty = facultyRepository.findByUser(loggedUser);
            return new StudentReq(loggedUser.getEmail(), faculty.getFirstname(), faculty.getLastname(), null, null, faculty.getCity(), userType);
        }

    }

    public Student getById(Long id) {
        return studentRepository.findByIdAndUser(id, userService.getLoggedUser());
    }

    public JobApply applyJob(JobApplyReq jobApplyReq) {
        return jobApplyRepository.save(new JobApply(null, userService.getLoggedUser(), jobRepository.findById(jobApplyReq.jobId()).orElseThrow(RuntimeException::new)));
    }

    public List<Student> searchStudent(StudentSearchReq studentSearchReq) {
        return studentRepository.searchStudent(studentSearchReq);
    }

    public List<Student> allStudent() {
        return studentRepository.findAll();
    }

    public Student getLoggedInStudent() {
        return studentRepository.findByUser(userService.getLoggedUser());
    }
}
