package com.cs545waa.waaJune2022finalProject.service;

import com.cs545waa.waaJune2022finalProject.entity.JobAttachment;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;


public interface JobAttachmentService {

    void init();

    void store(MultipartFile file);
    JobAttachment save(Integer id,MultipartFile file);


    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

    Resource readFileById(@PathVariable Integer attachmentId);
    String saveAll(Integer id,MultipartFile[] files);

    String getFileNameById (int id);

}
