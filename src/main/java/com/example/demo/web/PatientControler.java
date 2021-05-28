package com.example.demo.web;

import com.example.demo.entites.Patient;
import com.example.demo.reposetories.PatienReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PatientControler {
    @Autowired
    PatienReposetory patienReposetory;
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/patients")
    public String liste(Model model, @RequestParam(name="page",defaultValue = "0") int page,
                        @RequestParam(name="size",defaultValue = "4") int size,
                        @RequestParam(name="motCle",defaultValue = "") String mc){
        Page<Patient> liste= patienReposetory.findByNomContains(mc,PageRequest.of(page,size));
        model.addAttribute("patients",liste.getContent());
        model.addAttribute("pages",new int[liste.getTotalPages()]);
        model.addAttribute("pageCourente", page);
        model.addAttribute("size",size);
        model.addAttribute("motCle",mc);
        return "patients";
    }
    @GetMapping("/deletePatient")
    public String delete(Long id,String motCle, int page, int size) {
        patienReposetory.deleteById(id);

        return "redirect:/patients?page="+page+"&size="+size+"&motCle="+motCle;
    }
    @GetMapping("/formPatient")
    public String formPatient(Model model){
        model.addAttribute("patient",new Patient());
        return "form";
    }
    @PostMapping("/savePatient")
    public String savePatient(Model model, @Valid Patient patient, BindingResult bindingResult,String message){
        if (bindingResult.hasErrors()) {
           message="failed";
           model.addAttribute("message",message);
            return "form";
        }
        else patienReposetory.save(patient);
        message="succes";
        model.addAttribute("message",message);
        return "form";
    }
    @GetMapping("/edit")
    public String edit(Model model,Long id){
        Patient p = patienReposetory.findById(id).get();
        model.addAttribute("patient",p);
        return "form";
    }
}
