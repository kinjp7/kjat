
package com.kjat.service;

import com.kjat.entity.MUser;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
        
        Query query = em.createNamedQuery("SELECT a FROM m_user a WHERE a.employee_no = :employee_no");
        query.setParameter("employee_no", loginId);
        MUser mUser = (MUser)query.getSingleResult();
        return mUser;
        
    }
}
