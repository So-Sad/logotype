package com.softarex.app.logotype.controller;

import com.softarex.app.logotype.entity.Field;
import com.softarex.app.logotype.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class FieldController {

    private FieldService fieldService;

    @Autowired
    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }


    @RequestMapping(path = "/fields", method = RequestMethod.GET)
    public String getAllFields(Model model){
        List<Field> fields = fieldService.getAllFields();
        model.addAttribute("fields", fields);
        return "field";
    }

    @RequestMapping(path = "/fields/getOne", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Field> getFieldById(long id){
        return fieldService.getFieldById(id);
    }

    @RequestMapping(path = "/fields/addNew", method = RequestMethod.POST)
    public String addNewField(Field field){
        fieldService.addNew(field);
        return "redirect:/fields";
    }

    @RequestMapping(path = "/fields/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateFields(Field field){
        fieldService.update(field);
        return "redirect:/fields";
    }

    @RequestMapping(path = "/fields/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleteField(long id){
        fieldService.delete(id);
        return "redirect:/fields";
    }

}
