/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.ui.controller;

import com.artivisi.school.administration.domain.Cas;
import com.artivisi.school.administration.domain.Major;
import com.artivisi.school.administration.service.BelajarRestfulService;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;
/**
 *
 * @author Fauzani
 */
@Controller
public class CasController {
    @Autowired private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/master/cas", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Cas c, HttpServletRequest request, HttpServletResponse response){
        belajarRestfulService.save(c);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, c.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/master/cas/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Cas c){
        Cas casDb = belajarRestfulService.findCasById(id);
        if(casDb == null){
            throw  new IllegalStateException();
        }
        c.setId(casDb.getId());
        belajarRestfulService.save(c);
    }
    
    @RequestMapping(value="/master/cas/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        Cas casDb = belajarRestfulService.findCasById(id);
        if(casDb == null){
            throw new IllegalStateException();
        }
        belajarRestfulService.delete(casDb);
    }
    
    @RequestMapping(value="/master/cas/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Cas findById(@PathVariable String id){
        return belajarRestfulService.findCasById(id);
    }
    
    @RequestMapping(value="/master/cas", method=RequestMethod.GET)
    @ResponseBody
    public Page<Cas> findCas(Pageable pagination){
        return belajarRestfulService.findAllCas(pagination);
    }
}
