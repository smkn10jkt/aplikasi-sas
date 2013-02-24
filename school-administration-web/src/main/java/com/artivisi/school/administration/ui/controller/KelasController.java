/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.ui.controller;

import com.artivisi.school.administration.domain.Kelas;
import com.artivisi.school.administration.service.BelajarRestfulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import java.net.URI;
import org.springframework.web.util.UriTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author JC
 */
@Controller
public class KelasController {
    @Autowired private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/master/class", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Kelas s, HttpServletRequest request, HttpServletResponse response){
        belajarRestfulService.save(s);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, s.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/master/class/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Kelas s){
        Kelas kelasDB = belajarRestfulService.findKelasById(id);
        if(kelasDB == null){
            throw  new IllegalStateException();
        }
        s.setId(kelasDB.getId());
        belajarRestfulService.save(s);
    }
    
    @RequestMapping(value="/master/class/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        Kelas kelasDB = belajarRestfulService.findKelasById(id);
        if(kelasDB == null){
            throw new IllegalStateException();
        }
        belajarRestfulService.delete(kelasDB);
    }
    
    @RequestMapping(value="/master/class/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Kelas findById(@PathVariable String id){
        return belajarRestfulService.findKelasById(id);
    }
    
    @RequestMapping(value="/master/class", method=RequestMethod.GET)
    @ResponseBody
    public Page<Kelas> findKelas(Pageable pagination){
        return belajarRestfulService.findAllKelas(pagination);
    }
    
    
}
