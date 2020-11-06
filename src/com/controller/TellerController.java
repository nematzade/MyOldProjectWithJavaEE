package com.controller;

import com.model.entity.Teller;
import com.model.service.TellerService;
import com.model.util.GenericRepository;
import org.hibernate.validator.jtype.Generic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mohammad on 24/12/2017.
 */
@Controller
@RequestMapping(value = "tellerController")
public class TellerController {

    @Autowired
    TellerService tellerService;

    @Autowired
    GenericRepository<Teller> genericRepository;

    @RequestMapping(value = "/persist")
    @ResponseBody
    public Object persist(HttpServletRequest request, @ModelAttribute Teller teller)
    {
        genericRepository.persist(teller,request);
        tellerService.persistUserRoles(teller);
        tellerService.persistUser(teller);
        return teller;
    }

    @RequestMapping(value = "/read")
    @ResponseBody
    public List<Teller> read(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Teller teller)
    {
        List<Teller> tellers =  genericRepository.read(Teller.class);
        request.getSession().setAttribute("tellerList",tellers);
        return tellers;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public void update(HttpServletRequest request, @ModelAttribute Teller teller){

        String id = request.getParameter("tellerId");
        Teller find = genericRepository.find(Teller.class,Long.parseLong(id));
        find.setName(teller.getName());
        find.setFamily(teller.getFamily());
        find.setPass(teller.getPass());
        find.setUniId(teller.getUniId());

        genericRepository.update(find);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public void delete(HttpServletRequest request,HttpServletResponse response,@RequestParam long tellerId){
        genericRepository.remove(Teller.class,tellerId,request);
        try {
            response.sendRedirect("/view/manager/defineTeller.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
