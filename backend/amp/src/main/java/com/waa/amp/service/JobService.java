package com.waa.amp.service;

import com.waa.amp.dto.JobSearchReq;
import com.waa.amp.dto.StatRes;
import com.waa.amp.entity.Job;
import com.waa.amp.entity.Student;
import com.waa.amp.entity.Tag;
import com.waa.amp.repository.JobRepository;
import com.waa.amp.repository.StudentRepository;
import com.waa.amp.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final StudentRepository studentRepository;
    private final TagRepository tagRepository;

    public List<Job> searchJob(JobSearchReq jobSearchReq) {
        return jobRepository.searchJob(jobSearchReq);
    }

    public StatRes stat() {
        List<Job> jobs = jobRepository.findAll();

        Map<String, Long> jobByState = jobs.stream()
                .collect(Collectors.groupingBy(Job::getState, Collectors.counting()));

        Map<String, Long> jobByCity = jobs.stream()
                .collect(Collectors.groupingBy(Job::getCity, Collectors.counting()));

        List<Student> students = studentRepository.findAll();

        Map<String, Long> studentByCity = students.stream()
                .collect(Collectors.groupingBy(Student::getCity, Collectors.counting()));

        Map<String, Long> studentByState = null;

        Set<String> tags = new HashSet<>(tagRepository.findAll().stream().map(Tag::getTags).toList());

//         tags, location
        Map<String, Set<String>> tagInLocation = new HashMap<>();

        jobs.forEach(it -> {
            List<Tag> jobTag = it.getTags();
            String state = it.getState();

            jobTag.forEach(i -> {
                if (tags.contains(i.getTags())) {
                    if (tagInLocation.get(i.getTags()) == null) {
                        Set<String> l = new HashSet<>();
                        l.add(state);
                        tagInLocation.put(i.getTags(), l);
                    } else {
                        tagInLocation.get(i.getTags()).add(state);
                    }
                }
            });

        });

        return new StatRes(jobByState, jobByCity, studentByCity, studentByState, tagInLocation);
    }
}
