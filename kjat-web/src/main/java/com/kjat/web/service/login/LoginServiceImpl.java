/** ===========================================
 * COPYRIGHT (c) 2017 KDDI CORPORATION, ALL RIGHTS RESERVED.
 * ============================================ */
package com.kjat.web.service.login;

import com.kjat.web.dao.userMst.UserMstDao;
import com.kjat.entity.MUserEntity;
import com.kjat.web.service.BaseService;
import javax.enterprise.context.Dependent;

import javax.inject.Inject;

/**
 * ユーザーマスタメンテナンスに関する業務部品クラス UserMstServiceImpl.java (UTF-8)
 *
 * @since 2017/01/10
 * @author アイエックス・ナレッジ株式会社
 */
@Dependent
public class LoginServiceImpl extends BaseService implements UserMstService {

    @Inject
    private UserMstDao userMstDao;

    /**
     * 社員番号が一致するユーザレコードを取得する
     *  excludeDeleted=true の場合、論理削除済みは含まない。
     * @param employeeNo
     * @return 
     */
    public MUserEntity findByEmployeeNo(String employeeNo, boolean excludeDeleted){
        return excludeDeleted ? userMstDao.findById(employeeNo, true)
                : userMstDao.findById(employeeNo);
    }

}
