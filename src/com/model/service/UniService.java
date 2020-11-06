package com.model.service;

import com.model.entity.Uni;
import com.model.entity.University;
import com.model.entity.UniversityAndUniView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Mohammad on 23/12/2017.
 */

@Service
@Transactional
public class UniService {

    @PersistenceContext
    EntityManager entityManager;

/*
    public void persist(Uni uni){
        uni.setDeleted(false);
        entityManager.persist(uni);

    }
*/

    public List<UniversityAndUniView> read()
    {
        List<UniversityAndUniView> uniList;
        uniList = (List<UniversityAndUniView>) entityManager.createQuery("select o from uni_view o where o.deleted=:x").setParameter("x",false).getResultList();
        return uniList;
    }

    public List<UniversityAndUniView> readForDetail(Long id)
    {
        List<UniversityAndUniView> uniList;
        uniList = entityManager.createQuery("select o from uni_view o where o.deleted=:x and o.universityId=:y",UniversityAndUniView.class )
                .setParameter("x",false)
                .setParameter("y",id)
                .getResultList();

        return uniList;
    }


/*
    public void update(Uni uni){
        entityManager.merge(uni);
    }

    public Uni findById(long id){
        return entityManager.find(Uni.class,id);
    }

    public void delete(long uniId)
    {
        Uni uni = entityManager.find(Uni.class,uniId);
        uni.setDeleted(true);
        entityManager.merge(uni);

    }
*/

//    public List<University> getCombo(){
//
//       List<University> universityList = entityManager.createQuery("select h from university h where h.deleted=:x").setParameter("x",false).getResultList();
//        return universityList;
//    }

}
