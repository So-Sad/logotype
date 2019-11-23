package com.softarex.app.logotype.service;

import com.softarex.app.logotype.entity.Field;

import java.util.List;
import java.util.Optional;


public interface FieldService {

    public List<Field> getAllFields();
    public Optional<Field> getFieldById(long id);
    public void addNew(Field field);
    public void update(Field field);
    public void delete(long id);

}
