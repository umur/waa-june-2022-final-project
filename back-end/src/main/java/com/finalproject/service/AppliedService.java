package com.finalproject.service;

import com.finalproject.models.Applied;
import com.finalproject.models.JobAdvertisement;

import java.util.List;


public interface AppliedService {
    void ApplyJob(Applied applied, JobAdvertisement job);
    List<Applied> recentApplied();

}
