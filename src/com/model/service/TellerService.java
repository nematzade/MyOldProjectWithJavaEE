package com.model.service;

import com.model.entity.Teacher;
import com.model.entity.Teller;
import com.model.entity.auth.UserRoles;
import com.model.entity.auth.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Mohammad on 24/12/2017.
 */
@Service
@Transactional
public class TellerService {

    @PersistenceContext
    EntityManager entityManager;

    public void persistUser(Teller teller)
    {

        Users user = new Users();
        user.setUSERNAME(teller.getName());
        user.setPASSWORD(teller.getPass());
        entityManager.persist(user);

    }

    public void persistUserRoles(Teller teller)
    {
        UserRoles userRoles = new UserRoles();
        userRoles.setUSERNAME(teller.getName());
        userRoles.setROLE_NAME("teller");
        entityManager.persist(userRoles);
    }

}
