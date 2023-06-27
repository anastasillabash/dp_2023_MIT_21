package Controller;


import Entities.MyEntity;
import Services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private Services service;

    @GetMapping("/")
    public String HomePage(Model model){
        List<MyEntity> listEntity = service.listAll();
        model.addAttribute("listEntity", listEntity);
        return "index";
    }

    @GetMapping("/add")
    public String AddEntity(Model model){
        MyEntity entity = new MyEntity();
        model.addAttribute("entity", entity);
        return "AddNew";
    }

    @PostMapping("/add")
    public String saveEntity(@ModelAttribute("entity") MyEntity entity) {
        service.save(entity);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView UpdateForm(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("UpdateOld");
        MyEntity entity = service.get(id);
        mav.addObject("entity", entity);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String DeleteEntity(@PathVariable(name = "id") int id){
        service.delete(id);
        return "redirect:/";
    }


}
