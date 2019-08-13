/** ===========================================
 * COPYRIGHT (c) 2017 KDDI CORPORATION, ALL RIGHTS RESERVED.
 * ============================================ */
package com.kddi.gpas.web.page.userMst;

import com.kddi.gpas.base.db.entity.MUserEntity;
import com.kddi.gpas.base.resource.MReferenceResource;
import com.kddi.gpas.web.common.constant.GpasViewId;
import com.kddi.gpas.web.service.kyoten.KyotenService;
import com.kddi.gpas.web.service.userMst.UserMstService;
import javax.inject.Named;
import javax.inject.Inject;
import javax.faces.view.ViewScoped;
import javax.faces.model.SelectItem;
import java.util.List;
import jp.co.ikic.argo.core.utility.LogicMessenger;
import jp.co.ikic.argo.javaee.annotation.MethodAround;
import jp.co.ikic.argo.javaee.annotation.FWAround;
import jp.co.ikic.argo.javaee.bean.FWBean;

/**
 * ユーザーマスタメンテナンス(検索)
 *
 * @author アイエックス・ナレッジ株式会社
 */
@Named
@ViewScoped
@FWAround
public class UserMstSearchBean extends FWBean {

    /**
     * ユーザーマスタ情報リスト
     */
    private List<UserMstSearchResultItem> resultList = null;

    @Inject
    private KyotenService kyotenService;

    @Inject
    private UserMstService userMstService;

    /**
     * 検索条件
     */
    private UserMstSearchCondition condition = new UserMstSearchCondition();

    /**
     * 検索結果件数
     */
    private long recordCount;

    /**
     * 初期処理
     */
    @MethodAround
    public void init() {
        //セッションに検索条件が退避されている場合、
        // 画面の検索条件を退避中の検索条件で初期化。
        // 退避中の検索条件は削除する。
        sessionBean.removeValue(UserMstConst.USER_INFO_KEY);
        sessionBean.removeValue(UserMstConst.DISPLAY_FLG_KEY);
        if (sessionBean.containsKey(UserMstConst.SEARCH_CONDITION_KEY)) {
            setCondition(sessionBean.getValue(UserMstConst.SEARCH_CONDITION_KEY, true));
            searchexe();
        }
    }

    /**
     * 検索処理
     */
    @MethodAround
    public void search() {
        // ページ番号をセット
        condition.setCurrentPage(1);
        // 検索実行
        searchexe();

    }

    /**
     * ページング処理
     */
    public void paging() {
        // ページ番号をセット
        condition.setCurrentPage(Integer.parseInt(getRequestParam("pageNo")));
        // 検索実行
        searchexe();
    }

    /**
     * 検索実行
     */
    private void searchexe() {
        // 件数取得
        recordCount = userMstService.getCountByCondition(getCondition());

        // 件数チェック
        if (recordCount == 0) {
            // メッセージを追加
            messenger.addInfoMessage(new LogicMessenger("gpas.message.INFO0001"));
            resultList = null;
        } else {
            // 検索実行
            resultList = userMstService.getListByCondition(getCondition());
            // 検索条件保存
            sessionBean.setValue(UserMstConst.SEARCH_CONDITION_KEY, condition);
        }

    }

    /**
     * 詳細画面へ遷移
     *
     * @param employeeNo
     * @return
     */
    @MethodAround
    public String update(String employeeNo) {
        MUserEntity entity = userMstService.findByEmployeeNo(employeeNo);

        // 社員番号の存在チェック
        if (entity == null) {
            // メッセージを追加
            messenger.addErrorMessage(new LogicMessenger("gpas.message.ERR0009"));
            return null;
        } else {
            // 取得情報を保存
            sessionBean.setValue(UserMstConst.DISPLAY_FLG_KEY, true);
            sessionBean.setValue(UserMstConst.USER_INFO_KEY, entity.getEmployeeNo());

        }

        // 編集画面へリダイレクトする
        return GpasViewId.D9020.toPrettyRedirect();
    }

    /**
     * 一覧表示用 権限名取得
     *
     * @param authorityCode
     * @return
     */
    public String getAuthorityName(String authorityCode) {
        return MReferenceResource.toDisplayValue("AUTHORITY", authorityCode);
    }

    /**
     * 検索項目 拠点プルダウン作成用
     *
     * @return
     */
    public List<SelectItem> getKyotenSelectItems() {
        return kyotenService.getSelectItems();
    }

    /**
     * 検索項目 権限チェックボックス作成用
     *
     * @return
     */
    public List<SelectItem> getAuthoritySelectItems() {
        return userMstService.getSelectItems();
    }

    /**
     * 検索項目 削除フラグラジオボタン作成用
     *
     * @return
     */
    public List<SelectItem> getDeleteFlgSelectItems() {
        return MReferenceResource.getSelectItems("DELETE_CONDITION");
    }

    /**
     * リファレンスマスタから1ページの表示件数取得
     *
     * @return
     */
    public String getDisplayedResults() {
        return MReferenceResource.getValue("DISPLAYED_RESULTS", "M_USER");
    }

    /**
     * @return the condition
     */
    public UserMstSearchCondition getCondition() {
        return condition;
    }

    /**
     * @param condition the condition to set
     */
    public void setCondition(UserMstSearchCondition condition) {
        this.condition = condition;
    }

    /**
     * @return the resultList
     */
    public List<UserMstSearchResultItem> getResultList() {
        return resultList;
    }

    /**
     * @param resultList the resultList to set
     */
    public void setResultList(List<UserMstSearchResultItem> resultList) {
        this.resultList = resultList;
    }

    /**
     * @return the recordCount
     */
    public long getRecordCount() {
        return recordCount;
    }
}
