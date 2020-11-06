package com.model.util;

import com.model.entity.BaseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Mohammad on 20/01/2018.
 */


@Service
@Transactional
public class GenericRepository<T extends BaseEntity> {

    @PersistenceContext
    EntityManager entityManager;

    public T persist(T t, HttpServletRequest request){
       t.setCreatedBy(request.getRemoteUser());
       t.setDeleted(false);
       entityManager.persist(t);
       return t;
    }

    public T update(T t){
        return entityManager.merge(t);
    }

    public List<T> read(Class tClass)
    {
      return entityManager.createQuery("select entity from " + ((Entity) tClass.getAnnotation(Entity.class)).name() + " entity where entity.deleted=false")
              .getResultList();
    }

    public T remove(Class tClass,Long id,HttpServletRequest request)
    {
        BaseEntity baseEntity = entityManager.find((Class<T>) tClass,id);
        baseEntity.setDeleted(true);
        baseEntity.setDeletedBy(request.getRemoteUser());
        return entityManager.merge((T) baseEntity);
    }

    public T find(Class tClass,Long id){
        return entityManager.find((Class<T>) tClass,id);
    }

}
