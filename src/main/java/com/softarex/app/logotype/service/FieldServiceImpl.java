package com.softarex.app.logotype.service;

import com.softarex.app.logotype.entity.Field;
import com.softarex.app.logotype.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldServiceImpl implements FieldService {

    @Autowired
    private FieldRepository fieldRepository;


    @Override
    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    @Override
    public Optional<Field> getFieldById(long id) {
        return fieldRepository.findById(id);
    }

    @Override
    public void addNew(Field field) {
        fieldRepository.save(field);
    }

    @Override
    public void update(Field field) {
        fieldRepository.save(field);
    }

    @Override
    public void delete(long id) {
        fieldRepository.deleteById(id);
    }
}
