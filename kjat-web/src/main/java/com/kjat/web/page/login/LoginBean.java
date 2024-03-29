
package com.kjat.web.page.login;

import com.kjat.entity.MUserEntity;
import com.kjat.web.service.login.LoginService;
import java.io.Serializable;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

/**
 *
 * LoginBean.java (UTF-8)
 * @since 2019/07/27
 * @author ????
 */
//@Dependent
@Named
@RequestScoped
public class LoginBean implements Serializable{
    
    @Inject 
    LoginService loginService;
    
    //@Required(allowSpace = false)
     
    private String loginId; // ログインID
    
    //@Required(allowSpace = false)
    private String password; // パスワード
    
    //gg
    /*@Required(allowSpace = false)
    private String userId;
    
    @Required(allowSpace = false)
    private String password;
    */
    
    public String getLoginId(){
        return this.loginId;
    }
    public void setLoginId(String loginId){
        this.loginId = loginId;
    }
    
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public String login(){
        try{
        //String page = null;
        //AppUser user = new AppUser();
        //user.setUserId(userId);
        //AuthStatus authStatus = authenticator.authenticate(user, password, userManager);
            //ユーザーマスタ情報取得を行う。
                    //ユーザIDからアカウント情報を取得
        // 件数取得
        recordCount = loginService.getCountByCondition(getCondition());
        
            //ユーザーマスタの取得チェックを行う。
            
            
            
            //ログイン後画面に遷移
            return "/secure/application/inquiry?faces-redirect=true";
            
        }catch(Exception e){
            //ログインエラー時はエラー画面へ遷移
            return "error";
        }
    }
    
    //お知らせ欄表示
    public String getInfo(){
        return "";
    }
    
    
}
