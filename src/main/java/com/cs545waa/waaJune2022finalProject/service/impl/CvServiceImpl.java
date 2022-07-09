package com.cs545waa.waaJune2022finalProject.service.impl;

import com.cs545waa.waaJune2022finalProject.dto.CvDto;
import com.cs545waa.waaJune2022finalProject.entity.Student;
import com.cs545waa.waaJune2022finalProject.repository.StudentRepo;
import com.cs545waa.waaJune2022finalProject.service.CvService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Data
@Transactional
public class CvServiceImpl implements CvService {
    ModelMapper modelMapper;

    StudentRepo studentRepo;


    @Override
    public CvDto getCv(String username) {
        return modelMapper.map(studentRepo.getStudentByUsername(username),CvDto.class);

    }

//    @Override
//    public void saveCv(CvDto cvDto) {
//        cvDto.
//        modelMapper.map(cvDto, Student.class);
//    }


}
