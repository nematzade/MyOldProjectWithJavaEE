package com.controller;

import com.model.entity.Uni;
import com.model.entity.UniversityAndUniView;
import com.model.service.UniService;
import com.model.util.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mohammad on 23/12/2017.
 */

@Controller
@RequestMapping(value = "uniController")
public class UniController {

    @Autowired
    UniService uniService;

    @Autowired
    GenericRepository<Uni> genericRepository;

    @RequestMapping(value = "/persist")
    @ResponseBody
    public Object persist(HttpServletRequest request, @ModelAttribute Uni uni)
    {
        try {
            genericRepository.persist(uni,request);
            return uni;
        }catch (Exception e){
            Map map = new HashMap();
            map.put("خطا","درج انجام نشد!!");
            return map;
        }
    }

    @RequestMapping(value = "/read")
    @ResponseBody
    public List<UniversityAndUniView> read(HttpServletRequest request, HttpServletResponse response)
    {
        List<UniversityAndUniView> uniList =  uniService.read();
        request.getSession().setAttribute("uniList",uniList);
        return uniList;
    }


    @RequestMapping(value = "/readForDetail")
    @ResponseBody
    public List<UniversityAndUniView> readForDetail(HttpServletRequest request, HttpServletResponse response, @RequestParam String id)
    {
        List<UniversityAndUniView> uniList =  uniService.readForDetail(Long.parseLong(id));
        return uniList;
    }



    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(HttpServletRequest request, @ModelAttribute Uni uni)
    {
        String id = request.getParameter("uniId");
        Uni find = genericRepository.find(Uni.class,Long.parseLong(id));
        find.setUniName(uni.getUniName());
        find.setUniversityId(uni.getUniversityId());
        return genericRepository.update(find);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public void delete(HttpServletRequest request,HttpServletResponse response,@RequestParam long uniId){
        genericRepository.remove(Uni.class,uniId,request);
        try {
            response.sendRedirect("/view/admin/viewListUni.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
