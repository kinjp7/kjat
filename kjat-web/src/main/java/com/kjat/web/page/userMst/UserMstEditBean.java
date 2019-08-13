/** ===========================================
 * COPYRIGHT (c) 2017 KDDI CORPORATION, ALL RIGHTS RESERVED.
 * ============================================ */
package com.kddi.gpas.web.page.userMst;

import com.kjat.entity.MUserEntity;
import com.kjat.web.service.login.LoginService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * ユーザーマスターメンテナンス(登録/詳細) UserMstEditBean.java (UTF-8)
 *
 * @since 2017/01/17
 * @author 
 */
@Named
@ViewScoped
public class UserMstEditBean extends FWBean {

    /**
     * 画面項目
     */
    private UserMstEditDto userMstEditDto;

    @Inject
    private UserMstService userMstService;

    @Inject
    private KyotenService kyotenService;

    /**
     * 更新画面表示フラグ true：編集画面表示 false：登録画面表示
     */
    private boolean isDisplayUpdate;

    /**
     * 初期処理
     */
    @MethodAround
    @PostConstruct
    public void init() {
        // セッションにユーザー情報が退避されている場合、
        // 画面のユーザー情報入力項目を退避中のユーザー情報で初期化。
        userMstEditDto = new UserMstEditDto();
        if (sessionBean.containsKey(UserMstConst.USER_INFO_KEY)) {

            MUserEntity userInfo = userMstService.findByEmployeeNo(sessionBean.getValue(UserMstConst.USER_INFO_KEY));

            // 社員番号
            userMstEditDto.setEmployeeNo(userInfo.getEmployeeNo());

            // 社員名
            userMstEditDto.setEmployeeName(userInfo.getEmployeeName());

            // 社員名フリガナ
            userMstEditDto.setEmployeeNameKana(userInfo.getEmployeeNameKana());

            // メールアドレス
            userMstEditDto.setEmail(userInfo.getMail());

            // 拠点コード
            userMstEditDto.setKyotenCode(userInfo.getKyotenCode());

            // 権限
            userMstEditDto.setAuthorityCode(userInfo.getAuthorityCode());

            // 削除フラグ
            userMstEditDto.setDeleteFlg(userInfo.getDeleteFlg());

        }
        
        // 検索ページで社員番号リンクが押された場合、
        // 編集画面を表示するためのフラグがセットされている。
        setIsDisplayUpdate(sessionBean.containsKey(UserMstConst.DISPLAY_FLG_KEY));
    }

    /**
     * 登録処理
     *
     * @return
     */
    @MethodAround
    public String register() {

        // 選択した拠点と権限の組合せチェック
        if (!userMstService.isValidSelectCombination(userMstEditDto)) {
            // メッセージ追加
            getMessage();
            return null;

        }

        // 社員番号の重複チェック
        if (userMstService.findByEmployeeNo(userMstEditDto.getEmployeeNo()) != null) {
            messenger.addErrorMessage(new LogicMessenger("gpas.message.ERR0006", "社員番号"));
            return null;
        }

        // ユーザー情報登録
        userMstService.registUserInfo(userMstEditDto);

        messenger.addInfoMessage(new LogicMessenger("gpas.message.INFO0002", "登録"), true);

        return GpasViewId.D9020.toPrettyRedirect();
    }

    /**
     * 更新処理
     *
     * @return
     */
    @MethodAround
    public String update() {

        // 選択した拠点と権限の組合せチェック
        if (!userMstService.isValidSelectCombination(userMstEditDto)) {
            // メッセージ追加
            getMessage();
            return null;

        }

        MUserEntity mUserEntity = userMstService.findByEmployeeNo(userMstEditDto.getEmployeeNo());

        // 社員番号の存在チェック
        if (mUserEntity == null) {
            // メッセージを追加
            messenger.addErrorMessage(new LogicMessenger("gpas.message.ERR0018", "ユーザー"));
            return null;
        }

        // ユーザー情報更新
        userMstService.updateUserInfo(userMstEditDto, mUserEntity);

        // メッセージを追加
        messenger.addInfoMessage(new LogicMessenger("gpas.message.INFO0002", "更新"), true);

        // 編集画面へリダイレクトする
        return GpasViewId.D9020.toPrettyRedirect();
    }

    /**
     * 入力項目 拠点プルダウン作成用
     *
     * @return
     */
    public List<SelectItem> getKyotenSelectItems() {
        return kyotenService.getSelectItems();
    }

    /**
     * 入力項目 権限ラジオボタン作成用
     *
     * @return
     */
    public List<SelectItem> getAuthoritySelectItems() {
        return userMstService.getSelectItems();
    }

    /**
     * 確認メッセージ（CONF0001）を返却する
     *
     * @param confirmTarget 確認対象処理名称
     * @return
     */
    public String getConfirmMessage(String confirmTarget) {
        return MessageResource.getMessage("gpas.message.CONF0001", confirmTarget);
    }

    /**
     * エラーメッセージ（ERR0020）を追加する
     */
    private void getMessage() {
        String kyotenName = kyotenService.toDisplayKyotenCode(userMstEditDto.getKyotenCode());
        String authorityName = MReferenceResource.toDisplayValue("AUTHORITY", userMstEditDto.getAuthorityCode());
        messenger.addErrorMessage(new LogicMessenger("gpas.message.ERR0020", kyotenName, authorityName));
    }

    /**
     * @return the userMstEditDto
     */
    public UserMstEditDto getUserMstEditDto() {
        return userMstEditDto;
    }

    /**
     * @param userMstEditDto the userMstEditDto to set
     */
    public void setUserMstEditDto(UserMstEditDto userMstEditDto) {
        this.userMstEditDto = userMstEditDto;
    }

    /**
     * @return the isDisplayUpdate
     */
    public boolean isIsDisplayUpdate() {
        return isDisplayUpdate;
    }

    /**
     * @param isDisplayUpdate the isDisplayUpdate to set
     */
    public void setIsDisplayUpdate(boolean isDisplayUpdate) {
        this.isDisplayUpdate = isDisplayUpdate;
    }

}
