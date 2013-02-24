/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Fauzani
 */
@Entity
@Table(name = "m_lesson")
public class Lesson {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "major", nullable = false)
    private Major major;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String semester;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String name;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String kkm;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String ctotal;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String description;

    public String getCtotal() {
        return ctotal;
    }

    public void setCtotal(String ctotal) {
        this.ctotal = ctotal;
    }

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

    public String getKkm() {
        return kkm;
    }

    public void setKkm(String kkm) {
        this.kkm = kkm;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    
    
}
