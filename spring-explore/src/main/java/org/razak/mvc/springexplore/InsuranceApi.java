package org.razak.mvc.springexplore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

// Controller always respond html page
@Controller
@RequestMapping("/insure")
public class InsuranceApi {
    @Autowired
    private InsuranceService service;
    @GetMapping("/hi")
    // respond html file's name
    public String hiThere(){return "greet";}
    @GetMapping("/new")
    public String newInsurance(Model model){
        Insurance ins = new Insurance();
        model.addAttribute("obj",ins);
        return "Introduce";
    }
    @PostMapping("/open")
    public String openInsurance(Model model, Insurance ins){
//        System.out.println(ins);
        Insurance received = service.implementSave(ins);
        return "redirect:/insure/view";
    }
    @GetMapping("/view")
    public String readAllInsurance(Model model){
        List<Insurance> obj = service.implementFindAll();
        model.addAttribute("policies",obj);
        return "insurehome";
    }
    @GetMapping("/edit/{key}")
    public String readOneForEdit(Model model, @PathVariable int key){
        Optional<Insurance> received = service.implementFindById(key);
        if(received.isPresent()){
            model.addAttribute("obj",received.get());
            return "update";
        }
        return "redirect:/view";
    }
}
