
package com.kjat.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * user.java (UTF-8)
 * @since 2019/07/29
 * @author ???
 */
@Entity
@Table(name ="m_user")
public class MUser implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "employeeNo", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    
    @Column(name = "password_update_timestamp")
    private String passwordUpdateTimestamp;
    
    @Column(name = "authority_code")
    private String authorityCode;
    
    @Column(name = "lock_cnt")
    private String lockCnt;
    
    @Column(name = "lock_timestamp")
    private String lockTimestamp;
    
    @Column(name = "lock_flg")
    private String lockFlg;
            
    
    public MUser(){
        
    }
    
    public MUser(String employeeNo){
        this.employeeNo = employeeNo;
    }
    
    public String getEmployeeNo() {
        return employeeNo;
    }
    
    public void setEmployeeNo(String employeeNo){
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    
    public void setEmployeeName(String employeeName){
        this.employeeName = employeeName;
    }

    public String getEmployeeNameKana() {
        return employeeNameKana;
    }
    
    public void setEmployeeNameKana(String employeeNameKana){
        this.employeeNameKana = employeeNameKana;
    }

    public String getKyotenCode() {
        return kyotenCode;
    }
    
    public void setKyotenCode(String kyotenCode){
        this.kyotenCode = kyotenCode;
    }

    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail){
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    public String getPasswordUpdateTimestamp() {
        return passwordUpdateTimestamp;
    }
    
    public void setPasswordUpdateTimestamp(String passwordUpdateTimestamp){
        this.passwordUpdateTimestamp = passwordUpdateTimestamp;
    }

    public String getAuthorityCode() {
        return authorityCode;
    }
    
    public void setAuthorityCode(String authorityCode){
        this.authorityCode = authorityCode;
    }

    public String getLockCnt() {
        return lockCnt;
    }
    
    public void setLockCnt(String lockCnt){
        this.lockCnt = lockCnt;
    }

    public String getLockTimestamp() {
        return lockTimestamp;
    }
    
    public void setLockTimestamp(String lockTimestamp){
        this.lockTimestamp = lockTimestamp;
    }

    public String getLockFlg() {
        return lockFlg;
    }
    
    public void setLockFlg(String lockFlg){
        this.lockFlg = lockFlg;
    }    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeNo != null ? employeeNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MUser)) {
            return false;
        }
        MUser other = (MUser) object;
        if ((this.employeeNo == null && other.employeeNo != null) || (this.employeeNo != null && !this.employeeNo.equals(other.employeeNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kjat.web.entity.user[ employeeNo=" + employeeNo + " ]";
    }

}
