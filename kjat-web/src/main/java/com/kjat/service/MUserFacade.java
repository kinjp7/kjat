
package com.kjat.service;

import com.kjat.entity.MUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * UserFacade.java (UTF-8)
 * @since 2019/08/03
 * @author ??
 */
public class MUserFacade {
    @PersistenceContext(unitName = "kjatPU")
    private EntityManager em;
    
    protected EntityManager getEntityManager() {
        return em;
    }

    public MUserFacade() {
    }    
    
    public MUser findByUserId(String loginId){
        
        String jpql = "SELECT k FROM m_user k";
      
        TypedQuery<MUser> query = em.createQuery(jpql,MUser.class);
        List<MUser> mUserList = query.getResultList();
        mUserList.stream().forEach(a -> System.out.println(a.getEmployeeNameKana()));

        MUser mUser = null;
        return mUser;
        
    }
}
