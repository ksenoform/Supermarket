package com.shop.domain.abstracts;

import com.fasterxml.uuid.Generators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Robert Szczygielski on 10.08.16.
 */
@Entity
public abstract class AbstractBaseEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "CODE", nullable = false)
    private String code;
    @Column(name = "UUID")
    protected final UUID uuid = Generators.randomBasedGenerator().generate();

    public AbstractBaseEntity() {
    }

    public AbstractBaseEntity(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Long getId() {
        return id;
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

    public UUID getUuid() {
        return uuid;
    }
}
