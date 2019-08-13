/** ===========================================
 * COPYRIGHT (c) 2017 KDDI CORPORATION, ALL RIGHTS RESERVED.
 * ============================================ */
package com.kjat.web.dao.userMst;

import com.kjat.entity.MUserEntity;
import java.util.List;

/**
 * ユーザーマスタメンテナンス業務ロジックDAO UserMstDao.java (UTF-8)
 *
 * @since 2017/01/10
 * @author アイエックス・ナレッジ株式会社
 */
public interface UserMstDao {

    /**
     * 承認者リストを取得する
     *
     * @param authorityCode
     * @param kyotenCode (人事部権限以外の場合に指定)
     * @return
     */
    public List<MUserEntity> getApproverList(String authorityCode, String kyotenCode);

    /**
     * 社員番号が一致するレコードを取得
     *
     * @param employeeNo
     * @return
     */
    public MUserEntity findById(String employeeNo);

    /**
     * 社員番号が一致するレコードを取得 excludeDeleted=true の場合、論理削除済みは含まない。
     *
     * @param employeeNo
     * @param excludeDeleted
     * @return
     */
    public MUserEntity findById(String employeeNo, boolean excludeDeleted);

    /**
     * ユーザー情報登録
     *
     * @param mUserEntity
     * @return
     */
    public int registUser(MUserEntity mUserEntity);

    /**
     * ユーザー情報更新
     *
     * @param mUserEntity
     * @return
     */
    public int updateUser(MUserEntity mUserEntity);
}
