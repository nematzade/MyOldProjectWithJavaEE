package com.model.service;


import com.model.entity.Manager;
import com.model.entity.University;
import com.model.entity.auth.UserRoles;
import com.model.entity.auth.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mohammad on 24/12/2017.
 */

@Service
@Transactional
public class ManagerService {

    @PersistenceContext
    EntityManager entityManager;

//**************************************************

    public void persistUsers(Manager manager)
    {
        Users user = new Users();
        user.setUSERNAME(manager.getName());
        user.setPASSWORD(manager.getPass());
        entityManager.persist(user);
    }

    public void persistUserRoles(Manager manager)
    {
        UserRoles userRoles = new UserRoles();
        userRoles.setUSERNAME(manager.getName());
        userRoles.setROLE_NAME("manager");
        entityManager.persist(userRoles);
    }

    public void mergeUsers(Manager manager)
    {
        Users user = new Users();
        user.setUSERNAME(manager.getName());
        user.setPASSWORD(manager.getPass());
        entityManager.merge(user);

    }

    public void mergeUserRoles(Manager manager)
    {
        UserRoles userRoles = new UserRoles();
        userRoles.setUSERNAME(manager.getName());
        userRoles.setROLE_NAME("manager");
        entityManager.merge(userRoles);
    }

//    public void deleteUser(Manager manager){
//        entityManager.createNativeQuery("delete from USERS where USERNAME=:x ",Users.class).setParameter("x",manager.getName());
//        entityManager.createNativeQuery("delete from USER_ROLES where USERNAME=:x ",Users.class).setParameter("x",manager.getName());
//    }

}
