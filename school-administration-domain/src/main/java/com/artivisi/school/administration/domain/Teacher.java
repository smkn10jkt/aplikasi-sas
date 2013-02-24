/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.Column;

/**
 *
 * @author dsemuts
 */
@Entity
@Table(name = "m_teacher")
public class Teacher {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String name;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String nip;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
    
    
}
