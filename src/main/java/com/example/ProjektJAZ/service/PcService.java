package com.example.ProjektJAZ.service;


import com.example.ProjektJAZ.model.WorkPc;
import com.example.ProjektJAZ.repository.PcRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
//@CacheConfig(cacheNames = {"Computer"})
public class PcService implements IDefinePcService{
    private final PcRepo pcRepo;

    @Override
    public WorkPc getPc(long pcId) {
        log.info("Fetching a Pc with id {} from the database", pcId);
        return pcRepo.findPcById(pcId);
    }

    @Override
    public List<WorkPc> getAllPcs() {
        log.info("Fetching all Pcs from the database");
        return pcRepo.findAll();
    }

    @Override
    public WorkPc savePc(WorkPc pc) {
        log.info("Saving a pc into the database");
        return pcRepo.save(pc);
    }
    @Override
    public void updatePcName(long id, String name){
        log.info("Changing name of a Pc with id {} to {}.", id, name);
        WorkPc pc = pcRepo.findPcById(id);
        pc.setName(name);
    };
}
