package com.example.ProjektJAZ.service;


import com.example.ProjektJAZ.model.WorkPc;


import java.util.List;

public interface IDefinePcService {
    WorkPc getPc(long pcId);
    List<WorkPc> getAllPcs();
    WorkPc savePc(WorkPc pc);

    void updatePcName(long id ,String name);

}
