package com.finalproject.service.impl;

import com.finalproject.models.Applied;
import com.finalproject.models.JobAdvertisement;
import com.finalproject.repository.AppliedRepository;
import com.finalproject.service.AppliedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppliedServiceImpl implements AppliedService {
    @Autowired
    private AppliedRepository rep;
    @Override
    public void ApplyJob(Applied applied, JobAdvertisement job ) {
        applied.setAdverts(job);
        rep.save(applied);

    }

    @Override
    public List<Applied> recentApplied() {

        List<Applied> hol = new ArrayList<>();
        hol = rep.findAllByApplied().stream().filter(l->l.isMark_deleteapplied()!=true)
                .limit(10)       .collect(Collectors.toList());
        return hol;

    }
}
