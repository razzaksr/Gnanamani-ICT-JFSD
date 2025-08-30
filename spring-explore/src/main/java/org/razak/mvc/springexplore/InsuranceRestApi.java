package org.razak.mvc.springexplore;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class InsuranceRestApi {
    @Autowired
    private InsuranceService service;

    @PostMapping("/open")
    public Insurance openInsurance(@Valid @RequestBody Insurance ins){
        Insurance received = service.implementSave(ins);
        return received;
    }
    @GetMapping("/view")
    public List<Insurance> readAllInsurance(){
        return service.implementFindAll();
    }
    @GetMapping("/edit/{key}")
    public Optional<Insurance> readOneForEdit(@PathVariable int key){
        Optional<Insurance> received = service.implementFindById(key);
        return received;
    }
    @PutMapping("/update")
    public Insurance updateInsurance(@Valid @RequestBody Insurance ins){
        Insurance received = service.implementSave(ins);
        return received;
    }
    @DeleteMapping("/remove/{key}")
    public void removeOneViaId(@PathVariable int key){
        service.implementDeleteById(key);
    }
    @PostMapping("/filters/amount")
    public List<Insurance> readAllInsurance(@Valid @RequestParam double start, @RequestParam double end){
        return service.implementFindAllByMaturityAmountBetween(start, end);
    }
    @GetMapping("/filters/names")
    public List<Insurance> readAllNames(@RequestParam String search){
        return service.implemenetByOwn(search);
    }
    @GetMapping("/filters/types")
    public List<Insurance> readAllTypes(@RequestParam String search){
        return service.implementFindAllBySchemeType(search);
    }
    @GetMapping("/filters/pretime")
    public List<Insurance> readAllNames(@RequestParam int premium, @RequestParam int duration){
        return service.implementFindAllByPremiumGreaterThanEqualAndDurationEquals(premium, duration);
    }
}
