package com.softarex.app.logotype.controller;

import com.softarex.app.logotype.entity.Field;
import com.softarex.app.logotype.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FieldController {

    private FieldService fieldService;

    @Autowired
    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @RequestMapping(path = "/fields", method = RequestMethod.GET)
    public List<Field> getAllFields(){
        return fieldService.getAllFields();
    }

    @RequestMapping(path = "/fields/{id}", method = RequestMethod.GET)
    public Optional<Field> getUserById(@PathVariable("id") long id){
        return fieldService.getFieldById(id);
    }

}
