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
 * @author user
 */
@Entity @Table(name="data_peta_pelajaran")
public class MapLesson {
     @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="id_kelas" , nullable = false)
    private Majors id_kelas;
    
 
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String semester;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String id_matpel;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String no_urut;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Majors getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(Majors id_kelas) {
        this.id_kelas = id_kelas;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getId_matpel() {
        return id_matpel;
    }

    public void setId_matpel(String id_matpel) {
        this.id_matpel = id_matpel;
    }

    public String getNo_urut() {
        return no_urut;
    }

    public void setNo_urut(String no_urut) {
        this.no_urut = no_urut;
    }
    
    
    
    
}
