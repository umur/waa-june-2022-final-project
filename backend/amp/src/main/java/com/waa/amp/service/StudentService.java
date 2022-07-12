package com.waa.amp.service;

import com.waa.amp.dto.JobApplyReq;
import com.waa.amp.dto.JobReq;
import com.waa.amp.dto.StudentReq;
import com.waa.amp.dto.StudentSearchReq;
import com.waa.amp.entity.*;
import com.waa.amp.repository.JobApplyRepository;
import com.waa.amp.repository.JobRepository;
import com.waa.amp.repository.StudentRepository;
import com.waa.amp.repository.TagRepository;
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

    public Job postJob(JobReq jobReq) {

        List<Tag> tags = new ArrayList<>();

        for (String it : jobReq.tag()) {
            var t = tagRepository.findByTags(it);
            tags.add(t);
        }

        var job = new Job(null,
                jobReq.description(),
                tags,
                jobReq.state(),
                jobReq.city(),
                jobReq.companyName(),
                userService.getLoggedUser()
        );

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

        var updatedJob = new Job(id,
                jobReq.description(),
                tags,
                jobReq.state(),
                jobReq.city(),
                jobReq.companyName(),
                userService.getLoggedUser()
        );

        return jobRepository.save(updatedJob);
    }

    public List<Job> getJob() {
        User loggedUser = userService.getLoggedUser();
        return jobRepository.findAllByPostedBy(loggedUser);
    }

    public List<Job> getALlJob(){
        return jobRepository.findAll().stream().peek(Job::getPostedBy).toList();
    }

    public Student createStudent(StudentReq studentReq) {
        return updateStudent(null, studentReq);
    }

    public Student updateStudent(Long id, StudentReq studentReq) {
        Student student = new Student(id,
                userService.getLoggedUser(),
                studentReq.email(),
                studentReq.firstName(),
                studentReq.lastname(),
                studentReq.major(),
                studentReq.gpa(),
                studentReq.city());

        return studentRepository.save(student);
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
}
