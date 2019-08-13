/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kjat.web.page.login;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jin04038
 */
@Entity
public class LoginDto implements Serializable {
    @Id
    @Column(name = "employee_no")
    private String employeeNo;
    
    @Column(name = "employee_name")
    private String employeeName;
    
    @Column(name = "employee_name_kana")
    private String employeeNameKana;
    
    @Column(name = "kyoten_code")
    private String kyotenCode;
    
    @Column(name = "mail")
    private String mail;
    
    @Column(name = "password")
    private String password;
    
    //@Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "password_update_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime passwordUpdateTimestamp;
    
    @Column(name = "authority_code")
    private String authorityCode;
    
    @Column(name = "lock_cnt")
    private Integer lockCnt;
    
    //@Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "lock_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime lockTimestamp;
    
    @Column(name = "lock_flg")
    private String lockFlg;
    
    @Column(name = "temp_password")
    private String tempPassword;
    
    //@Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "temp_password_issue_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime tempPasswordIssueTimestamp;

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
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the passwordUpdateTimestamp
     */
    public LocalDateTime getPasswordUpdateTimestamp() {
        return passwordUpdateTimestamp;
    }

    /**
     * @param passwordUpdateTimestamp the passwordUpdateTimestamp to set
     */
    public void setPasswordUpdateTimestamp(LocalDateTime passwordUpdateTimestamp) {
        this.passwordUpdateTimestamp = passwordUpdateTimestamp;
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
     * @return the lockCnt
     */
    public Integer getLockCnt() {
        return lockCnt;
    }

    /**
     * @param lockCnt the lockCnt to set
     */
    public void setLockCnt(Integer lockCnt) {
        this.lockCnt = lockCnt;
    }

    /**
     * @return the lockTimestamp
     */
    public LocalDateTime getLockTimestamp() {
        return lockTimestamp;
    }

    /**
     * @param lockTimestamp the lockTimestamp to set
     */
    public void setLockTimestamp(LocalDateTime lockTimestamp) {
        this.lockTimestamp = lockTimestamp;
    }

    /**
     * @return the lockFlg
     */
    public String getLockFlg() {
        return lockFlg;
    }

    /**
     * @param lockFlg the lockFlg to set
     */
    public void setLockFlg(String lockFlg) {
        this.lockFlg = lockFlg;
    }

    /**
     * @return the tempPassword
     */
    public String getTempPassword() {
        return tempPassword;
    }

    /**
     * @param tempPassword the tempPassword to set
     */
    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
    }

    /**
     * @return the tempPasswordIssueTimestamp
     */
    public LocalDateTime getTempPasswordIssueTimestamp() {
        return tempPasswordIssueTimestamp;
    }

    /**
     * @param tempPasswordIssueTimestamp the tempPasswordIssueTimestamp to set
     */
    public void setTempPasswordIssueTimestamp(LocalDateTime tempPasswordIssueTimestamp) {
        this.tempPasswordIssueTimestamp = tempPasswordIssueTimestamp;
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
    
}
