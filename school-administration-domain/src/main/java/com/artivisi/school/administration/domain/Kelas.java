/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;


/**
 *
 * @author JC
 */
@Entity
@Table(name = "m_kelas")
public class Kelas {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String majors;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String grade;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String name;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String homeroom;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getHomeroom() {
        return homeroom;
    }

    public void setHomeroom(String homeroom) {
        this.homeroom = homeroom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
