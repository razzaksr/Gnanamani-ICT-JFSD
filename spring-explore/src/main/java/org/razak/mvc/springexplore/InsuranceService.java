package org.razak.mvc.springexplore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRemote remote;
    public Insurance implementSave(Insurance insurance){
       return remote.save(insurance);
    }
    public List<Insurance>  implementFindAll(){
        return remote.findAll();
    }
}
