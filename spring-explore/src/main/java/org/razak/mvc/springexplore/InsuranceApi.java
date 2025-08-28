package org.razak.mvc.springexplore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        if(received!=null)
            model.addAttribute("msg","New Insurance introduced");
        else
            model.addAttribute("msg","New Insurance not introduced");
        return "redirect:/insure/new";
    }
}
