/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.ui.controller;

import com.artivisi.school.administration.domain.Major;
import com.artivisi.school.administration.domain.Teacher;
import com.artivisi.school.administration.service.BelajarRestfulService;
import com.artivisi.school.administration.service.TeacherService;
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
 * @author dsemuts
 */
@Controller
public class MajorController {
    @Autowired private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/master/major", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Major mj, HttpServletRequest request, HttpServletResponse response){
        belajarRestfulService.save(mj);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, mj.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/master/major/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Major mj){
        Major majorDb = belajarRestfulService.findMajorById(id);
        if(majorDb == null){
            throw  new IllegalStateException();
        }
        mj.setId(majorDb.getId());
        belajarRestfulService.save(mj);
    }
    
    @RequestMapping(value="/master/major/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        Major majorDb = belajarRestfulService.findMajorById(id);
        if(majorDb == null){
            throw new IllegalStateException();
        }
        belajarRestfulService.delete(majorDb);
    }
    
    @RequestMapping(value="/master/major/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Major findById(@PathVariable String id){
        return belajarRestfulService.findMajorById(id);
    }
    
    @RequestMapping(value="/master/major", method=RequestMethod.GET)
    @ResponseBody
    public Page<Major> findMajor(Pageable pagination){
        return belajarRestfulService.findAllMajor(pagination);
    }
}
