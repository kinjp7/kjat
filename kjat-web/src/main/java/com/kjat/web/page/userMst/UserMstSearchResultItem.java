/**===========================================
 * COPYRIGHT (c) 2017 KDDI CORPORATION, ALL RIGHTS RESERVED.
 * ============================================*/
package com.kddi.gpas.web.page.userMst;

import com.kddi.gpas.base.db.converter.BooleanConverter;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ユーザーマスタ一覧データ
 UserMstSearchResultItem.java (UTF-8)
 * @since 2017/02/01
 * @author アイエックス・ナレッジ株式会社
 */
@Entity
public class UserMstSearchResultItem implements Serializable {
    @Id
    @Column(name = "employee_no")
    private String employeeNo;
    
    @Column(name = "employee_name")
    private String employeeName;
    
    @Column(name = "employee_name_kana")
    private String employeeNameKana;
    
    @Column(name = "kyoten_code")
    private String kyotenCode;
    
    @Column(name = "kyoten_name")
    private String kyotenName;
    
    @Column(name = "authority_code")
    private String authorityCode;
    
    @Convert(converter = BooleanConverter.class)
    @Column(name = "user_delete_flg")
    private boolean userDeleteFlg;
    
    @Convert(converter = BooleanConverter.class)
    @Column(name = "kyoten_delete_flg")
    private boolean kyotenDeleteFlg;
    
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
     * @return the kyotenName
     */
    public String getKyotenName() {
        return kyotenName;
    }

    /**
     * @param kyotenName the kyotenName to set
     */
    public void setKyotenName(String kyotenName) {
        this.kyotenName = kyotenName;
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
     * @return the userDeleteFlg
     */
    public boolean isUserDeleteFlg() {
        return userDeleteFlg;
    }

    /**
     * @param userDeleteFlg the userDeleteFlg to set
     */
    public void setUserDeleteFlg(boolean userDeleteFlg) {
        this.userDeleteFlg = userDeleteFlg;
    }

    /**
     * @return the kyotenDeleteFlg
     */
    public boolean isKyotenDeleteFlg() {
        return kyotenDeleteFlg;
    }

    /**
     * @param kyotenDeleteFlg the kyotenDeleteFlg to set
     */
    public void setKyotenDeleteFlg(boolean kyotenDeleteFlg) {
        this.kyotenDeleteFlg = kyotenDeleteFlg;
    }

}
