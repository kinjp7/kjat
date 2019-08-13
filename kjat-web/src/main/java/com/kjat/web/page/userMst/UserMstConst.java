/** ===========================================
 * COPYRIGHT (c) 2017 KDDI CORPORATION, ALL RIGHTS RESERVED.
 * ============================================ */
package com.kjat.web.page.userMst;

/**
 * ユーザーマスタメンテナンスに関する定数クラス UserMstConst.java (UTF-8)
 *
 * @since 2017/01/17
 * @author アイエックス・ナレッジ株式会社
 */
public class UserMstConst {

    /**
     * 検索条件セッションキー
     */
    public static final String SEARCH_CONDITION_KEY = "userMst.search.condition.key";
    
    /**
     * ユーザー情報格納セッションキー
     */
    public static final String USER_INFO_KEY = "userMst.user.info.key";
    
    /**
     * 画面表示フラグ格納セッションキー
     */
    public static final String DISPLAY_FLG_KEY = "userMst.display.flg.key";
        
    /**
     * バリデーションチェック 社員番号固定長
     */
    public static final int EMPLOYEE_NO_FIXEDLENGTH = 6;
    
    /**
     * バリデーションチェック 社員名最大文字数
     */
    public static final int EMPLOYEE_NAME_MAXLENGTH = 15;
    
    /**
     * バリデーションチェック メールアドレス最大文字数
     */
    public static final int MAIL_MAXLENGTH = 256;
    
    /**
     * パスワード更新日時(新規ユーザー登録時)
     */
    public static final String PASSWORD_FIRST_TIME = "2000-01-01T00:00:00.000";

}
