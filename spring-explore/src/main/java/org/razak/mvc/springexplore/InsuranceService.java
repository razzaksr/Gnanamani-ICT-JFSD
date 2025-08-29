package org.razak.mvc.springexplore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Insurance> implementFindById(int id){
        return remote.findById(id);
    }
}
