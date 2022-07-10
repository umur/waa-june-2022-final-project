package com.finalproject.service.impl;

import com.finalproject.models.Applied;
import com.finalproject.repository.AppliedRepository;
import com.finalproject.service.AppliedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppliedServiceImpl implements AppliedService {
    @Autowired
    private AppliedRepository rep;
    @Override
    public void ApplyJob(Applied applied) {
        rep.save(applied);

    }
}
