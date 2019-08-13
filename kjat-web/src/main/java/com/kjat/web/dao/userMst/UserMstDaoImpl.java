/** ===========================================
 * COPYRIGHT (c) 2017 KDDI CORPORATION, ALL RIGHTS RESERVED.
 * ============================================ */
package com.kjat.web.dao.userMst;


import com.kjat.entity.MUserEntity;
import com.kjat.web.dao.BaseDao;

/**
 * ユーザーマスタメンテナンス業務ロジックDAO UserMstDaoImpl.java (UTF-8)
 *
 * @since 2017/01/10
 * @author アイエックス・ナレッジ株式会社
 */
@Stateless
public class UserMstDaoImpl extends BaseDao implements UserMstDao {

    private static final String COUNT_M_USER = "SELECT COUNT(*) FROM m_user";

    /**
     * 検索条件に該当するユーザの件数取得SQL
     *
     * @param condition
     * @return
     */
    private static final String SELECT_M_USER
            = " SELECT "
            + "  employee_no"
            + "  ,employee_name"
            + "  ,employee_name_kana"
            + "  ,m_user.kyoten_code AS kyoten_code"
            + "  ,kyoten_name"
            + "  ,authority_code"
            + "  ,m_user.delete_flg AS user_delete_flg"
            + "  ,m_kyoten.delete_flg AS kyoten_delete_flg"
            + " FROM m_user"
            + "  LEFT OUTER JOIN m_kyoten"
            + "  ON m_kyoten.kyoten_code = m_user.kyoten_code";


    /**
     * 社員番号が一致するレコードを取得(論理削除含む)
     *
     * @param employeeNo
     * @return
     */
    @Override
    public MUserEntity findById(String employeeNo) {
        return findById(employeeNo, false);
    }

    /**
     * 社員番号が一致するレコードを取得 excludeDeleted=true の場合、論理削除済みは含まない。
     *
     * @param employeeNo
     * @return
     */
    @Override
    public MUserEntity findById(String employeeNo, boolean excludeDeleted) {
        return excludeDeleted
                ? dbManager.findByKeyExists(MUserEntity.class, employeeNo)
                : dbManager.findByKey(MUserEntity.class, employeeNo);
    }

}
