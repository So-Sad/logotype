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
    private Type type;
    @Column(name = "required")
    private boolean required;
    @Column(name = "active")
    private boolean isActive;

    public Field() {
    }

    public Field(String label, Type type, boolean required, boolean isActive) {
        this.label = label;
        this.type = type;
        this.required = required;
        this.isActive = isActive;
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

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
