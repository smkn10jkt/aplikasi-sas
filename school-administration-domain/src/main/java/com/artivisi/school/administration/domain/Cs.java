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
 * @author Fauzani
 */
@Entity @Table(name="raw_sk")
public class Cs {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id_sk;
    
    @NotNull @NotEmpty
    @Column(nullable = false)
    private String nama_sk;

    public String getId_sk() {
        return id_sk;
    }

    public void setId_sk(String id_sk) {
        this.id_sk = id_sk;
    }

    public String getNama_sk() {
        return nama_sk;
    }

    public void setNama_sk(String nama_sk) {
        this.nama_sk = nama_sk;
    }
    
    
}
