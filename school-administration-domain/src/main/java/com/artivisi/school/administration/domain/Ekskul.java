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
@Entity @Table(name="data_ekskul")
public class Ekskul {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id_ekskul;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="semester" , nullable = false)
    private Majors semester;
    
 
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String nama_ekskul;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String id_siswa;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String predikat;

    public String getId_ekskul() {
        return id_ekskul;
    }

    public void setId_ekskul(String id_ekskul) {
        this.id_ekskul = id_ekskul;
    }

    public Majors getSemester() {
        return semester;
    }

    public void setSemester(Majors semester) {
        this.semester = semester;
    }

    public String getNama_ekskul() {
        return nama_ekskul;
    }

    public void setNama_ekskul(String nama_ekskul) {
        this.nama_ekskul = nama_ekskul;
    }

    public String getId_siswa() {
        return id_siswa;
    }

    public void setId_siswa(String id_siswa) {
        this.id_siswa = id_siswa;
    }

    public String getPredikat() {
        return predikat;
    }

    public void setPredikat(String predikat) {
        this.predikat = predikat;
    }
    
    
    
}
