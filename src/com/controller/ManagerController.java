package com.controller;

import com.model.entity.Manager;
import com.model.service.ManagerService;
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
import java.util.List;

/**
 * Created by Mohammad on 24/12/2017.
 */

@Controller
@RequestMapping(value = "managerController")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @Autowired
    GenericRepository<Manager> genericRepository;

    @RequestMapping(value = "/persist")
    @ResponseBody
    public Object persist(HttpServletRequest request, @ModelAttribute Manager manager) {

        genericRepository.persist(manager,request);
        managerService.persistUsers(manager);
        managerService.persistUserRoles(manager);
        return manager;
    }

    @RequestMapping(value = "/read")
    @ResponseBody
    public List<Manager> read(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Manager manager)
    {
        List<Manager> managers =  genericRepository.read(Manager.class);
        request.getSession().setAttribute("managerList",managers);
        return managers;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public void update(HttpServletRequest request, @ModelAttribute Manager manager){

        String id = request.getParameter("managerId");
        Manager find = genericRepository.find(Manager.class,Long.parseLong(id));
        find.setName(manager.getName());
        find.setFamily(manager.getFamily());
        find.setPass(manager.getPass());
        find.setUniId(manager.getUniId());
        genericRepository.update(find);

        managerService.mergeUserRoles(manager);
        managerService.mergeUsers(manager);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public void delete(HttpServletRequest request,HttpServletResponse response,@RequestParam long managerId){

        genericRepository.remove(Manager.class,managerId,request);
        try {
            response.sendRedirect("/view/admin/defineManager.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
