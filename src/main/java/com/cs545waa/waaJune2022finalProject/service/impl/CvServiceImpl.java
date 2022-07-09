package com.cs545waa.waaJune2022finalProject.service.impl;

import com.cs545waa.waaJune2022finalProject.dto.CvDto;
import com.cs545waa.waaJune2022finalProject.repository.CvRepo;
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
    CvRepo cvRepo;

    @Override
    public void createCv(CvDto cvDto) {
        Cv cv = modelMapper.map(cvDto , Cv.class);
        cvRepo.save(cv);

    }

    @Override
    public void editCv(CvDto cvDto) {
        Cv cv = modelMapper.map(cvDto , Cv.class);
        cvRepo.save(cv);
    }

}
