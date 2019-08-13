/** ===========================================
 * COPYRIGHT (c) 2017 KDDI CORPORATION, ALL RIGHTS RESERVED.
 * ============================================ */
package com.kddi.gpas.web.page.userMst;

import com.kddi.gpas.base.resource.MReferenceResource;
import java.io.Serializable;
import java.util.List;

/**
 * ユーザー検索条件 
 * UserMstSearchCondition.java (UTF-8)
 * @since 2017/01/10
 * @author アイエックス・ナレッジ株式会社
 */
public class UserMstSearchCondition implements Serializable {

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userNameKana
     */
    public String getUserNameKana() {
        return userNameKana;
    }

    /**
     * @param userNameKana the userNameKana to set
     */
    public void setUserNameKana(String userNameKana) {
        this.userNameKana = userNameKana;
    }

    /**
     * @return the kyotenCode
     */
    public String getKyotenCode() {
        return kyotenCode;
    }

    /**
     * @param kyotenCode the kyotenCode to set
     */
    public void setKyotenCode(String kyotenCode) {
        this.kyotenCode = kyotenCode;
    }

    /**
     * @return the authority
     */
    public List<String> getAuthority() {
        return authority;
    }

    /**
     * @param authority the authority to set
     */
    public void setAuthority(List<String> authority) {
        this.authority = authority;
    }

    /**
     * @return the deleteFlg
     */
    public String getDeleteFlg() {
        return deleteFlg;
    }

    /**
     * @param deleteFlg the deleteFlg to set
     */
    public void setDeleteFlg(String deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 社員番号
     */
    private String userId;

    /**
     * 社員名
     */
    private String userName;

    /**
     * 社員名フリガナ
     */
    private String userNameKana;

    /**
     * 拠点
     */
    private String kyotenCode;

    /**
     * 権限
     */
    private List<String> authority;

    /**
     * 削除フラグ(初期表示のためにリファレンスマスタから値を取得)
     */
    private String deleteFlg = MReferenceResource.getValue("DELETE_CONDITION", "ALL");

    /**
     * カレントページ
     */
    private int currentPage = 1;

}
