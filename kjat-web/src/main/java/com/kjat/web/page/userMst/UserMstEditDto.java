/** ===========================================
 * COPYRIGHT (c) 2017 KDDI CORPORATION, ALL RIGHTS RESERVED.
 * ============================================ */
package com.kddi.gpas.web.page.userMst;

import com.kddi.gpas.base.db.entity.MKyotenEntity;
import java.io.Serializable;
import jp.co.ikic.argo.core.validation.annotation.EmChar;
import jp.co.ikic.argo.core.validation.annotation.EmKanaChar;
import jp.co.ikic.argo.core.validation.annotation.EnNumber;
import jp.co.ikic.argo.core.validation.annotation.FixedLength;
import jp.co.ikic.argo.core.validation.annotation.MaxLength;
import jp.co.ikic.argo.core.validation.annotation.Required;
import com.kddi.gpas.web.common.validation.annotation.MRefereneValue;
import com.kddi.gpas.web.common.validation.annotation.RecordExsits;
import com.kddi.gpas.web.common.validation.annotation.GpasEmail;

/**
 * ユーザーマスタ登録/更新用 UserMstEditDto.java (UTF-8)
 *
 * @since 2017/01/17
 * @author アイエックス・ナレッジ株式会社
 */
public class UserMstEditDto implements Serializable {

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
     * @return the employeeNo
     */
    public String getEmployeeNo() {
        return employeeNo;
    }

    /**
     * @param employeeNo the employeeNo to set
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName the employeeName to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return the employeeNameKana
     */
    public String getEmployeeNameKana() {
        return employeeNameKana;
    }

    /**
     * @param employeeNameKana the employeeNameKana to set
     */
    public void setEmployeeNameKana(String employeeNameKana) {
        this.employeeNameKana = employeeNameKana;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the authorityCode
     */
    public String getAuthorityCode() {
        return authorityCode;
    }

    /**
     * @param authorityCode the authorityCode to set
     */
    public void setAuthorityCode(String authorityCode) {
        this.authorityCode = authorityCode;
    }

    /**
     * @return the deleteFlg
     */
    public boolean getDeleteFlg() {
        return deleteFlg;
    }

    /**
     * @param deleteFlg the deleteFlg to set
     */
    public void setDeleteFlg(boolean deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    /**
     * 社員番号
     */
    @Required
    @FixedLength(length = UserMstConst.EMPLOYEE_NO_FIXEDLENGTH)
    @EnNumber
    private String employeeNo;

    /**
     * 社員名
     */
    @Required
    @MaxLength(length = UserMstConst.EMPLOYEE_NAME_MAXLENGTH)
    @EmChar
    private String employeeName;

    /**
     * 社員名フリガナ
     */
    @Required
    @MaxLength(length = UserMstConst.EMPLOYEE_NAME_MAXLENGTH)
    @EmKanaChar
    private String employeeNameKana;

    /**
     * メールアドレス
     */
    @Required
    @MaxLength(length = UserMstConst.MAIL_MAXLENGTH)
    @GpasEmail
    private String email;

    /**
     * 拠点
     */
    @Required
    @RecordExsits(entityClass = MKyotenEntity.class, excludeDeleted = true)
    private String kyotenCode;

    /**
     * 権限
     */
    @Required
    @MRefereneValue(category = "AUTHORITY")
    private String authorityCode;

    /**
     * 削除フラグ
     */
    private boolean deleteFlg;

}
