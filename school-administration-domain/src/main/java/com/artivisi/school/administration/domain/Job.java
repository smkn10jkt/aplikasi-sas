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
 * @author Pingkan
 */
@Entity @Table (name="data_prakerin")
public  class Job {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name = "system-uuid" , strategy= "uuid2")
    private String id_prakerin;
            
    @NotNull
    @ManyToOne
    @JoinColumn(name="id_siswa" , nullable=false)
    private Student student;
    
 
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String semester;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String nama_matpel;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String nama_dudi;
    
     @NotNull @NotEmpty
    @Column(nullable = false)
    private String alamat;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String lama; 
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String nilai;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getId_prakerin() {
        return id_prakerin;
    }

    public void setId_prakerin(String id_prakerin) {
        this.id_prakerin = id_prakerin;
    }

    public Student getId_siswa() {
        return student;
    }

    public void setId_siswa(Student id_siswa) {
        this.student = id_siswa;
    }

    public String getLama() {
        return lama;
    }

    public void setLama(String lama) {
        this.lama = lama;
    }

    public String getNama_dudi() {
        return nama_dudi;
    }

    public void setNama_dudi(String nama_dudi) {
        this.nama_dudi = nama_dudi;
    }

    public String getNama_matpel() {
        return nama_matpel;
    }

    public void setNama_matpel(String nama_matpel) {
        this.nama_matpel = nama_matpel;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    
    
    
}
