package com.controller;

import com.model.entity.University;
import com.model.util.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mohammad on 21/12/2017.
 */

@Controller
@RequestMapping(value = "universityController")
public class UniversityController {


    @Autowired
    GenericRepository<University> genericRepository;

    @RequestMapping(value = "/persist")
    @ResponseBody
    public Object persist(HttpServletRequest request, @ModelAttribute University university)
    {
        try {
            genericRepository.persist(university, request);
            return university;
        }catch (Exception e){
            Map map = new HashMap();
            map.put("خطا","درج انجام نشد!!");
            return map;
        }
    }

    @RequestMapping(value = "/read")
    @ResponseBody
    public List<University> read(HttpServletRequest request, @ModelAttribute University university)
    {
        return genericRepository.read(University.class);
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public void update(HttpServletRequest request, @ModelAttribute University university)
    {
        String id = request.getParameter("universityId");
        University find = genericRepository.find(University.class,Long.parseLong(id));
        find.setUniversityName(university.getUniversityName());
        genericRepository.update(find);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public void delete(HttpServletRequest request){
        String id = request.getParameter("universityId");
        genericRepository.remove(University.class,Long.parseLong(id),request);
    }

}
