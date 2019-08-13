
package com.kjat.web.service.login;

import com.kddi.gpas.web.page.userMst.UserMstSearchCondition;

/**
 *
 * UserFacade.java (UTF-8)
 * @since 2019/08/03
 * @author ??
 */
public interface LoginService {
     /**
     * 検索条件に該当するユーザのレコード件数を返す
     * @param condition
     * @return 
     */
    public long getCountByCondition(UserMstSearchCondition condition);
}
