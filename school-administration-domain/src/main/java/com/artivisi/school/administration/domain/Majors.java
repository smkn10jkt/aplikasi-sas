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
@Entity @Table(name="raw_pk")
public class Majors {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="id_kelas" , nullable = false)
    private Kelas kelas;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String nama_pk;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    public String getNama_pk() {
        return nama_pk;
    }

    public void setNama_pk(String nama_pk) {
        this.nama_pk = nama_pk;
    }
    
    
    
}
