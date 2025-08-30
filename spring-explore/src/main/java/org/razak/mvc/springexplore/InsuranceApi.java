package org.razak.mvc.springexplore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "redirect:/insure/view";
    }
    @GetMapping("/remove/{key}")
    public String removeOneViaId(@PathVariable int key){
        service.implementDeleteById(key);
        return "redirect:/insure/view";
    }
    @GetMapping("/shortlist")
    public String shortlist(){
        return "filters";
    }
    @PostMapping("/filters/amount")
    public String readAllInsurance(Model model,@RequestParam double start, @RequestParam double end){
        List<Insurance> obj = service.implementFindAllByMaturityAmountBetween(start, end);
        model.addAttribute("policies",obj);
        return "insurehome";
    }
    @GetMapping("/filters/names")
    public String readAllNames(Model model,@RequestParam String search){
        List<Insurance> obj = service.implemenetByOwn(search);
        model.addAttribute("policies",obj);
        return "insurehome";
    }
    @GetMapping("/filters/types")
    public String readAllTypes(Model model,@RequestParam String search){
        List<Insurance> obj = service.implementFindAllBySchemeType(search);
        model.addAttribute("policies",obj);
        return "insurehome";
    }
    @GetMapping("/filters/pretime")
    public String readAllNames(Model model,@RequestParam int premium, @RequestParam int duration){
        List<Insurance> obj = service.implementFindAllByPremiumGreaterThanEqualAndDurationEquals(premium, duration);
        model.addAttribute("policies",obj);
        return "insurehome";
    }
}
