
package com.kjat;

import com.kjat.web.service.login.*;
import com.kjat.entity.MUserEntity;
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
public class LoginService {
    @PersistenceContext(unitName = "kjatPU")
    private EntityManager em;
    
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoginService() {
    }    
    
    public MUserEntity findByUserId(String loginId){
        
        String jpql = "SELECT k FROM m_user k";
      
        TypedQuery<MUserEntity> query = em.createQuery(jpql,MUserEntity.class);
        List<MUserEntity> mUserList = query.getResultList();
        mUserList.stream().forEach(a -> System.out.println(a.getEmployeeNameKana()));

        MUserEntity mUser = null;
        return mUser;
        
    }
}
