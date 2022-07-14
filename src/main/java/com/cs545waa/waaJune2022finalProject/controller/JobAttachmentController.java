package com.cs545waa.waaJune2022finalProject.controller;

import com.cs545waa.waaJune2022finalProject.service.JobAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobattachment")
@CrossOrigin("*")
public class JobAttachmentController {
    @Autowired
    private JobAttachmentService jobAttachmentService;

    @GetMapping("/{advertisement_id}")
    public ResponseEntity<Resource> readFileByAdvertisement(@PathVariable int advertisement_id) {
        String filename = jobAttachmentService.getFileNameById(advertisement_id);
        Resource file = jobAttachmentService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "inline; filename=\"" + file.getFilename() + "\"").body(file);
    }

//    @PostMapping(value = "/upload", consumes = { "application/Json" ,"multipart/form-data" })
//    public String jobAttachmentUpload( @RequestPart("file") MultipartFile file) {
//
//        jobAttachmentService.save(file);
//        return "Success !!";
//    }

//    @GetMapping("/read/{filename:.+}")
//    public ResponseEntity<Resource> readFileByFileName(@PathVariable String filename) {
//
//        Resource file = jobAttachmentService.loadAsResource(filename);
//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
//                "inline; filename=\"" + file.getFilename() + "\"").body(file);
//    }



//    @PostMapping("/multipleupload")
//    public String uploadMultipleFiles(@RequestParam("file") MultipartFile[] files ) {
//
//        return jobAttachmentService.saveAll(files);

//        try {
//
//            Arrays.asList(files).stream().forEach(file -> {
//                jobAttachmentService.save( file);
//
//            });
//
//            return "Uploaded the files successfully: " ;
//        } catch (Exception e) {
//
//            return "Fail to upload files!";
//        }

}
