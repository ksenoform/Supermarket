package com.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by RSzczygielski on 10.08.16.
 */
@Entity
public abstract class EntityBaseForm {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer entityId;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "CODE", nullable = false)
    private String code;

    public  EntityBaseForm() {}

    public EntityBaseForm(Integer entityId, String name, String code) {
        this.entityId = entityId;
        this.name = name;
        this.code = code;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
