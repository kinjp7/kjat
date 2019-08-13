/** ===========================================
 * COPYRIGHT (c) 2017 KDDI CORPORATION, ALL RIGHTS RESERVED.
 * ============================================ */
package com.kjat.web.service.login;

import com.kjat.entity.MUserEntity;
import com.kddi.gpas.web.page.userMst.UserMstEditDto;
import com.kddi.gpas.web.page.userMst.UserMstSearchResultItem;
import com.kddi.gpas.web.page.userMst.UserMstSearchCondition;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 * ユーザーマスタメンテナンスに関する業務部品クラス
 * UserMstService.java (UTF-8)
 * @since 2017/01/10
 * @author アイエックス・ナレッジ株式会社
 */
public interface UserMstService {
    
    /**
     * 検索条件に該当するユーザのレコード件数を返す
     * @param condition
     * @return 
     */
    public long getCountByCondition(UserMstSearchCondition condition);
    
}
