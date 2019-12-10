package com.softarex.app.logotype.entity;

import javax.persistence.*;

@Entity
@Table(name = "fields", schema = "logotype")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id = 0;
    @Column(name = "label")
    private String label;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(name = "required")
    private boolean isRequired;
    @Column(name = "active")
    private boolean isActive;
    @Column(name = "options")
    private String options;

    public Field() {
    }

    public Field(String label, Type type, boolean isRequired, boolean isActive, String options) {
        this.label = label;
        this.type = type;
        this.isRequired = isRequired;
        this.isActive = isActive;
        this.options = options;
    }

    public Field(String label, String type, boolean isRequired, boolean isActive, String options) {
        this.label = label;
        this.type = getTypeByName(type);
        this.isRequired = isRequired;
        this.isActive = isActive;
        this.options = options;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setType(String type){
        this.type = Type.valueOf(type.replaceAll(" ", "_").toUpperCase());
    }

    private static Type getTypeByName(String type){
        return Type.valueOf(type.replaceAll(" ", "_").toUpperCase());
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        this.isRequired = required;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
