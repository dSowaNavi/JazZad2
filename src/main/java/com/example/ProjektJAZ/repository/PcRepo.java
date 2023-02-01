package com.example.ProjektJAZ.repository;


import com.example.ProjektJAZ.model.AppUser;
import com.example.ProjektJAZ.model.WorkPc;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PcRepo extends JpaRepository<WorkPc, Long> {
    WorkPc findPcById(Long id);
}
