/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.school.administration.ui.controller;

import com.artivisi.school.administration.domain.Lesson;
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
public class LessonController {
     @Autowired private BelajarRestfulService belajarRestfulService;
    
    @RequestMapping(value="/master/lesson", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid Lesson l, HttpServletRequest request, HttpServletResponse response){
        belajarRestfulService.save(l);
        String requestUrl = request.getRequestURL().toString();
        URI uri = new UriTemplate("{requestUrl}/{id}").expand(requestUrl, l.getId());
        response.setHeader("Location", uri.toASCIIString());
    }
    
    @RequestMapping(value="/master/lesson/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody @Valid Lesson l){
        Lesson lessonDB = belajarRestfulService.findLessonById(id);
        if(lessonDB == null){
            throw  new IllegalStateException();
        }
        l.setId(lessonDB.getId());
        belajarRestfulService.save(l);
    }
    
    @RequestMapping(value="/master/lesson/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String id){
        Lesson lessonDB = belajarRestfulService.findLessonById(id);
        if(lessonDB == null){
            throw new IllegalStateException();
        }
        belajarRestfulService.delete(lessonDB);
    }
    
    @RequestMapping(value="/master/lesson/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Lesson findById(@PathVariable String id){
        return belajarRestfulService.findLessonById(id);
    }
    
    @RequestMapping(value="/master/lesson", method=RequestMethod.GET)
    @ResponseBody
    public Page<Lesson> findLesson(Pageable pagination){
        return belajarRestfulService.findAllLesson(pagination);
    }
    
}
