package com.captain.store.model;

import java.util.Date;

public class RBill {
    /**
     * 主键
     */
    private Long lid;

    /**
     * 催收计划ID
     */
    private Long lrecallplanid;

    /**
     * 借款人Id
     */
    private Long lborrowerid;

    /**
     * 借款人登录名
     */
    private String strborrowerloginid;

    /**
     * 借款人姓名
     */
    private String strborrowername;

    /**
     * 借款意向Id
     */
    private Long lborrowintentid;

    /**
     * 借款模式 0:达飞90天贷款 1:海尔现金贷 2:PPMoney
     */
    private Byte nborrowmode;

    /**
     * 还款目标 0:达飞 1:海尔 2:PPMoney
     */
    private Byte nrepaymentdest;

    /**
     * 借款帐单ID
     */
    private Long lborrowerbillid;

    /**
     * 账单期Index
     */
    private Byte ntermindex;

    /**
     * 逾期本金，单位：分
     */
    private Long lprincipal;

    /**
     * 逾期利息，单位：分
     */
    private Long linterest;

    /**
     * 逾期违约金，单位：分
     */
    private Long lbreachamount;

    /**
     * 逾期总金额，单位：分
     */
    private Long lamount;

    /**
     * 减免本金
     */
    private Long lreduceprincipal;

    /**
     * 减免利息
     */
    private Long lreduceinterest;

    /**
     * 减免违约金
     */
    private Long lreducebreachamount;

    /**
     * 减免总金额
     */
    private Long lreduceamount;

    /**
     * 待划扣本金
     */
    private Long lrepayedprincipal;

    /**
     * 待划扣利息
     */
    private Long lrepayedinterest;

    /**
     * 待划扣违约金
     */
    private Long lrepayedbreachamount;

    /**
     * 待划扣总金额
     */
    private Long lrepayedamount;

    /**
     * 截止时间
     */
    private Date dtenddate;

    /**
     * 创建人Id
     */
    private Long lcreatorid;

    /**
     * 创建人姓名
     */
    private String strcreatorname;

    /**
     * 创建时间
     */
    private Date dtcreatetime;

    /**
     * 
     */
    private Date tsrefreshtime;

    /**
     * 应还手续费
     */
    private Long lloanfee;

    /**
     * 应还手续费违约金
     */
    private Long loverdueloanfee;

    /**
     * 实还手续费
     */
    private Long lrepayedloanfee;

    /**
     * 实还手续费违约金
     */
    private Long lrepayedoverdueloanfee;

    /**
     * 主键
     * @return lId 主键
     */
    public Long getLid() {
        return lid;
    }

    /**
     * 主键
     * @param lid 主键
     */
    public void setLid(Long lid) {
        this.lid = lid;
    }

    /**
     * 催收计划ID
     * @return lRecallPlanId 催收计划ID
     */
    public Long getLrecallplanid() {
        return lrecallplanid;
    }

    /**
     * 催收计划ID
     * @param lrecallplanid 催收计划ID
     */
    public void setLrecallplanid(Long lrecallplanid) {
        this.lrecallplanid = lrecallplanid;
    }

    /**
     * 借款人Id
     * @return lBorrowerId 借款人Id
     */
    public Long getLborrowerid() {
        return lborrowerid;
    }

    /**
     * 借款人Id
     * @param lborrowerid 借款人Id
     */
    public void setLborrowerid(Long lborrowerid) {
        this.lborrowerid = lborrowerid;
    }

    /**
     * 借款人登录名
     * @return strBorrowerLoginId 借款人登录名
     */
    public String getStrborrowerloginid() {
        return strborrowerloginid;
    }

    /**
     * 借款人登录名
     * @param strborrowerloginid 借款人登录名
     */
    public void setStrborrowerloginid(String strborrowerloginid) {
        this.strborrowerloginid = strborrowerloginid == null ? null : strborrowerloginid.trim();
    }

    /**
     * 借款人姓名
     * @return strBorrowerName 借款人姓名
     */
    public String getStrborrowername() {
        return strborrowername;
    }

    /**
     * 借款人姓名
     * @param strborrowername 借款人姓名
     */
    public void setStrborrowername(String strborrowername) {
        this.strborrowername = strborrowername == null ? null : strborrowername.trim();
    }

    /**
     * 借款意向Id
     * @return lBorrowIntentId 借款意向Id
     */
    public Long getLborrowintentid() {
        return lborrowintentid;
    }

    /**
     * 借款意向Id
     * @param lborrowintentid 借款意向Id
     */
    public void setLborrowintentid(Long lborrowintentid) {
        this.lborrowintentid = lborrowintentid;
    }

    /**
     * 借款模式 0:达飞90天贷款 1:海尔现金贷 2:PPMoney
     * @return nBorrowMode 借款模式 0:达飞90天贷款 1:海尔现金贷 2:PPMoney
     */
    public Byte getNborrowmode() {
        return nborrowmode;
    }

    /**
     * 借款模式 0:达飞90天贷款 1:海尔现金贷 2:PPMoney
     * @param nborrowmode 借款模式 0:达飞90天贷款 1:海尔现金贷 2:PPMoney
     */
    public void setNborrowmode(Byte nborrowmode) {
        this.nborrowmode = nborrowmode;
    }

    /**
     * 还款目标 0:达飞 1:海尔 2:PPMoney
     * @return nRepaymentDest 还款目标 0:达飞 1:海尔 2:PPMoney
     */
    public Byte getNrepaymentdest() {
        return nrepaymentdest;
    }

    /**
     * 还款目标 0:达飞 1:海尔 2:PPMoney
     * @param nrepaymentdest 还款目标 0:达飞 1:海尔 2:PPMoney
     */
    public void setNrepaymentdest(Byte nrepaymentdest) {
        this.nrepaymentdest = nrepaymentdest;
    }

    /**
     * 借款帐单ID
     * @return lBorrowerBillId 借款帐单ID
     */
    public Long getLborrowerbillid() {
        return lborrowerbillid;
    }

    /**
     * 借款帐单ID
     * @param lborrowerbillid 借款帐单ID
     */
    public void setLborrowerbillid(Long lborrowerbillid) {
        this.lborrowerbillid = lborrowerbillid;
    }

    /**
     * 账单期Index
     * @return nTermIndex 账单期Index
     */
    public Byte getNtermindex() {
        return ntermindex;
    }

    /**
     * 账单期Index
     * @param ntermindex 账单期Index
     */
    public void setNtermindex(Byte ntermindex) {
        this.ntermindex = ntermindex;
    }

    /**
     * 逾期本金，单位：分
     * @return lPrincipal 逾期本金，单位：分
     */
    public Long getLprincipal() {
        return lprincipal;
    }

    /**
     * 逾期本金，单位：分
     * @param lprincipal 逾期本金，单位：分
     */
    public void setLprincipal(Long lprincipal) {
        this.lprincipal = lprincipal;
    }

    /**
     * 逾期利息，单位：分
     * @return lInterest 逾期利息，单位：分
     */
    public Long getLinterest() {
        return linterest;
    }

    /**
     * 逾期利息，单位：分
     * @param linterest 逾期利息，单位：分
     */
    public void setLinterest(Long linterest) {
        this.linterest = linterest;
    }

    /**
     * 逾期违约金，单位：分
     * @return lBreachAmount 逾期违约金，单位：分
     */
    public Long getLbreachamount() {
        return lbreachamount;
    }

    /**
     * 逾期违约金，单位：分
     * @param lbreachamount 逾期违约金，单位：分
     */
    public void setLbreachamount(Long lbreachamount) {
        this.lbreachamount = lbreachamount;
    }

    /**
     * 逾期总金额，单位：分
     * @return lAmount 逾期总金额，单位：分
     */
    public Long getLamount() {
        return lamount;
    }

    /**
     * 逾期总金额，单位：分
     * @param lamount 逾期总金额，单位：分
     */
    public void setLamount(Long lamount) {
        this.lamount = lamount;
    }

    /**
     * 减免本金
     * @return lReducePrincipal 减免本金
     */
    public Long getLreduceprincipal() {
        return lreduceprincipal;
    }

    /**
     * 减免本金
     * @param lreduceprincipal 减免本金
     */
    public void setLreduceprincipal(Long lreduceprincipal) {
        this.lreduceprincipal = lreduceprincipal;
    }

    /**
     * 减免利息
     * @return lReduceInterest 减免利息
     */
    public Long getLreduceinterest() {
        return lreduceinterest;
    }

    /**
     * 减免利息
     * @param lreduceinterest 减免利息
     */
    public void setLreduceinterest(Long lreduceinterest) {
        this.lreduceinterest = lreduceinterest;
    }

    /**
     * 减免违约金
     * @return lReduceBreachAmount 减免违约金
     */
    public Long getLreducebreachamount() {
        return lreducebreachamount;
    }

    /**
     * 减免违约金
     * @param lreducebreachamount 减免违约金
     */
    public void setLreducebreachamount(Long lreducebreachamount) {
        this.lreducebreachamount = lreducebreachamount;
    }

    /**
     * 减免总金额
     * @return lReduceAmount 减免总金额
     */
    public Long getLreduceamount() {
        return lreduceamount;
    }

    /**
     * 减免总金额
     * @param lreduceamount 减免总金额
     */
    public void setLreduceamount(Long lreduceamount) {
        this.lreduceamount = lreduceamount;
    }

    /**
     * 待划扣本金
     * @return lRepayedPrincipal 待划扣本金
     */
    public Long getLrepayedprincipal() {
        return lrepayedprincipal;
    }

    /**
     * 待划扣本金
     * @param lrepayedprincipal 待划扣本金
     */
    public void setLrepayedprincipal(Long lrepayedprincipal) {
        this.lrepayedprincipal = lrepayedprincipal;
    }

    /**
     * 待划扣利息
     * @return lRepayedInterest 待划扣利息
     */
    public Long getLrepayedinterest() {
        return lrepayedinterest;
    }

    /**
     * 待划扣利息
     * @param lrepayedinterest 待划扣利息
     */
    public void setLrepayedinterest(Long lrepayedinterest) {
        this.lrepayedinterest = lrepayedinterest;
    }

    /**
     * 待划扣违约金
     * @return lRepayedBreachAmount 待划扣违约金
     */
    public Long getLrepayedbreachamount() {
        return lrepayedbreachamount;
    }

    /**
     * 待划扣违约金
     * @param lrepayedbreachamount 待划扣违约金
     */
    public void setLrepayedbreachamount(Long lrepayedbreachamount) {
        this.lrepayedbreachamount = lrepayedbreachamount;
    }

    /**
     * 待划扣总金额
     * @return lRepayedAmount 待划扣总金额
     */
    public Long getLrepayedamount() {
        return lrepayedamount;
    }

    /**
     * 待划扣总金额
     * @param lrepayedamount 待划扣总金额
     */
    public void setLrepayedamount(Long lrepayedamount) {
        this.lrepayedamount = lrepayedamount;
    }

    /**
     * 截止时间
     * @return dtEndDate 截止时间
     */
    public Date getDtenddate() {
        return dtenddate;
    }

    /**
     * 截止时间
     * @param dtenddate 截止时间
     */
    public void setDtenddate(Date dtenddate) {
        this.dtenddate = dtenddate;
    }

    /**
     * 创建人Id
     * @return lCreatorId 创建人Id
     */
    public Long getLcreatorid() {
        return lcreatorid;
    }

    /**
     * 创建人Id
     * @param lcreatorid 创建人Id
     */
    public void setLcreatorid(Long lcreatorid) {
        this.lcreatorid = lcreatorid;
    }

    /**
     * 创建人姓名
     * @return strCreatorName 创建人姓名
     */
    public String getStrcreatorname() {
        return strcreatorname;
    }

    /**
     * 创建人姓名
     * @param strcreatorname 创建人姓名
     */
    public void setStrcreatorname(String strcreatorname) {
        this.strcreatorname = strcreatorname == null ? null : strcreatorname.trim();
    }

    /**
     * 创建时间
     * @return dtCreateTime 创建时间
     */
    public Date getDtcreatetime() {
        return dtcreatetime;
    }

    /**
     * 创建时间
     * @param dtcreatetime 创建时间
     */
    public void setDtcreatetime(Date dtcreatetime) {
        this.dtcreatetime = dtcreatetime;
    }

    /**
     * 
     * @return tsRefreshTime 
     */
    public Date getTsrefreshtime() {
        return tsrefreshtime;
    }

    /**
     * 
     * @param tsrefreshtime 
     */
    public void setTsrefreshtime(Date tsrefreshtime) {
        this.tsrefreshtime = tsrefreshtime;
    }

    /**
     * 应还手续费
     * @return lLoanFee 应还手续费
     */
    public Long getLloanfee() {
        return lloanfee;
    }

    /**
     * 应还手续费
     * @param lloanfee 应还手续费
     */
    public void setLloanfee(Long lloanfee) {
        this.lloanfee = lloanfee;
    }

    /**
     * 应还手续费违约金
     * @return lOverdueLoanFee 应还手续费违约金
     */
    public Long getLoverdueloanfee() {
        return loverdueloanfee;
    }

    /**
     * 应还手续费违约金
     * @param loverdueloanfee 应还手续费违约金
     */
    public void setLoverdueloanfee(Long loverdueloanfee) {
        this.loverdueloanfee = loverdueloanfee;
    }

    /**
     * 实还手续费
     * @return lRepayedLoanFee 实还手续费
     */
    public Long getLrepayedloanfee() {
        return lrepayedloanfee;
    }

    /**
     * 实还手续费
     * @param lrepayedloanfee 实还手续费
     */
    public void setLrepayedloanfee(Long lrepayedloanfee) {
        this.lrepayedloanfee = lrepayedloanfee;
    }

    /**
     * 实还手续费违约金
     * @return lRepayedOverdueLoanFee 实还手续费违约金
     */
    public Long getLrepayedoverdueloanfee() {
        return lrepayedoverdueloanfee;
    }

    /**
     * 实还手续费违约金
     * @param lrepayedoverdueloanfee 实还手续费违约金
     */
    public void setLrepayedoverdueloanfee(Long lrepayedoverdueloanfee) {
        this.lrepayedoverdueloanfee = lrepayedoverdueloanfee;
    }
}