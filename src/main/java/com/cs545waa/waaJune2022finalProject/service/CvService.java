package com.cs545waa.waaJune2022finalProject.service;

import com.cs545waa.waaJune2022finalProject.dto.CvDto;
import com.cs545waa.waaJune2022finalProject.entity.Cv;

public interface CvService {


    void createCv(CvDto cv);

    void editCv(CvDto cvDto);
}
