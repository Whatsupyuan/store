package com.captain.store.model;

import java.util.Date;

public class MRelation {
    /**
     * ID
     */
    private Long lid;

    /**
     * 资金意向表ID
     */
    private Long llendintentid;

    /**
     * 借款意向表ID
     */
    private Long lborrowintentid;

    /**
     * 匹配资金
     */
    private Long lmatchamount;

    /**
     * 投资人ID
     */
    private Long llenderid;

    /**
     * 借款人ID
     */
    private Long lborrowerid;

    /**
     * 投资人身份证
     */
    private String strlenderidentity;

    /**
     * 投资人姓名
     */
    private String strlendername;

    /**
     * 投资人手机号
     */
    private String strlendermobile;

    /**
     * 理财产品ID
     */
    private Long llendproductid;

    /**
     * 理财产品编码
     */
    private String strlendproductcode;

    /**
     * 理财产品名称
     */
    private String strlendproductname;

    /**
     * 理财产品模式
     */
    private String strlendmodelcode;

    /**
     * 理财时间
     */
    private String dtlendtime;

    /**
     * 理财金额
     */
    private Long llendamount;

    /**
     * 借款人身份证
     */
    private String strborrowidentity;

    /**
     * 借款人姓名
     */
    private String strborrowname;

    /**
     * 借款人手机号
     */
    private String strborrowmobile;

    /**
     * 借款时间
     */
    private String dtborrowtime;

    /**
     * 借款金额
     */
    private Long lborrowamount;

    /**
     * 匹配关系状态：-1:匹配完成,0:待还款,8处理中,10:已完成,11:已作废
     */
    private Integer nstate;

    /**
     * 匹配生效日期，yyyy-MM-dd，采用银行返回的放款日期
     */
    private String strstartdate;

    /**
     * 匹配结束日期，yyyy-MM-dd
     */
    private String strenddate;

    /**
     * 资金渠道类型：1000投资、2000回退、3000利息复投、4000本金复投、5000代偿
     */
    private Integer nlendtype;

    /**
     * 借款渠道类型：1000借款、2000赎回
     */
    private Integer nborrowtype;

    /**
     * 理财年华利率
     */
    private Integer nlendyearrate;

    /**
     * 借款年华利率
     */
    private Integer nborrowyearrate;

    /**
     * 
     */
    private Date tsrefreshtime;

    /**
     * 创建时间
     */
    private Date dtcreatetime;

    /**
     * 理财系统标识:10-1.0系统 20-2.0系统 30-老核心 
     */
    private Byte nlendsystemsign;

    /**
     * 借款系统标识:10-1.0系统 20-2.0系统 30-老核心
     */
    private Byte nborrowsystemsign;

    /**
     * ID
     * @return lId ID
     */
    public Long getLid() {
        return lid;
    }

    /**
     * ID
     * @param lid ID
     */
    public void setLid(Long lid) {
        this.lid = lid;
    }

    /**
     * 资金意向表ID
     * @return lLendIntentId 资金意向表ID
     */
    public Long getLlendintentid() {
        return llendintentid;
    }

    /**
     * 资金意向表ID
     * @param llendintentid 资金意向表ID
     */
    public void setLlendintentid(Long llendintentid) {
        this.llendintentid = llendintentid;
    }

    /**
     * 借款意向表ID
     * @return lBorrowIntentId 借款意向表ID
     */
    public Long getLborrowintentid() {
        return lborrowintentid;
    }

    /**
     * 借款意向表ID
     * @param lborrowintentid 借款意向表ID
     */
    public void setLborrowintentid(Long lborrowintentid) {
        this.lborrowintentid = lborrowintentid;
    }

    /**
     * 匹配资金
     * @return lMatchAmount 匹配资金
     */
    public Long getLmatchamount() {
        return lmatchamount;
    }

    /**
     * 匹配资金
     * @param lmatchamount 匹配资金
     */
    public void setLmatchamount(Long lmatchamount) {
        this.lmatchamount = lmatchamount;
    }

    /**
     * 投资人ID
     * @return lLenderId 投资人ID
     */
    public Long getLlenderid() {
        return llenderid;
    }

    /**
     * 投资人ID
     * @param llenderid 投资人ID
     */
    public void setLlenderid(Long llenderid) {
        this.llenderid = llenderid;
    }

    /**
     * 借款人ID
     * @return lBorrowerId 借款人ID
     */
    public Long getLborrowerid() {
        return lborrowerid;
    }

    /**
     * 借款人ID
     * @param lborrowerid 借款人ID
     */
    public void setLborrowerid(Long lborrowerid) {
        this.lborrowerid = lborrowerid;
    }

    /**
     * 投资人身份证
     * @return strLenderIdentity 投资人身份证
     */
    public String getStrlenderidentity() {
        return strlenderidentity;
    }

    /**
     * 投资人身份证
     * @param strlenderidentity 投资人身份证
     */
    public void setStrlenderidentity(String strlenderidentity) {
        this.strlenderidentity = strlenderidentity == null ? null : strlenderidentity.trim();
    }

    /**
     * 投资人姓名
     * @return strLenderName 投资人姓名
     */
    public String getStrlendername() {
        return strlendername;
    }

    /**
     * 投资人姓名
     * @param strlendername 投资人姓名
     */
    public void setStrlendername(String strlendername) {
        this.strlendername = strlendername == null ? null : strlendername.trim();
    }

    /**
     * 投资人手机号
     * @return strLenderMobile 投资人手机号
     */
    public String getStrlendermobile() {
        return strlendermobile;
    }

    /**
     * 投资人手机号
     * @param strlendermobile 投资人手机号
     */
    public void setStrlendermobile(String strlendermobile) {
        this.strlendermobile = strlendermobile == null ? null : strlendermobile.trim();
    }

    /**
     * 理财产品ID
     * @return lLendProductId 理财产品ID
     */
    public Long getLlendproductid() {
        return llendproductid;
    }

    /**
     * 理财产品ID
     * @param llendproductid 理财产品ID
     */
    public void setLlendproductid(Long llendproductid) {
        this.llendproductid = llendproductid;
    }

    /**
     * 理财产品编码
     * @return strLendProductCode 理财产品编码
     */
    public String getStrlendproductcode() {
        return strlendproductcode;
    }

    /**
     * 理财产品编码
     * @param strlendproductcode 理财产品编码
     */
    public void setStrlendproductcode(String strlendproductcode) {
        this.strlendproductcode = strlendproductcode == null ? null : strlendproductcode.trim();
    }

    /**
     * 理财产品名称
     * @return strLendProductName 理财产品名称
     */
    public String getStrlendproductname() {
        return strlendproductname;
    }

    /**
     * 理财产品名称
     * @param strlendproductname 理财产品名称
     */
    public void setStrlendproductname(String strlendproductname) {
        this.strlendproductname = strlendproductname == null ? null : strlendproductname.trim();
    }

    /**
     * 理财产品模式
     * @return strLendModelCode 理财产品模式
     */
    public String getStrlendmodelcode() {
        return strlendmodelcode;
    }

    /**
     * 理财产品模式
     * @param strlendmodelcode 理财产品模式
     */
    public void setStrlendmodelcode(String strlendmodelcode) {
        this.strlendmodelcode = strlendmodelcode == null ? null : strlendmodelcode.trim();
    }

    /**
     * 理财时间
     * @return dtLendTime 理财时间
     */
    public String getDtlendtime() {
        return dtlendtime;
    }

    /**
     * 理财时间
     * @param dtlendtime 理财时间
     */
    public void setDtlendtime(String dtlendtime) {
        this.dtlendtime = dtlendtime == null ? null : dtlendtime.trim();
    }

    /**
     * 理财金额
     * @return lLendAmount 理财金额
     */
    public Long getLlendamount() {
        return llendamount;
    }

    /**
     * 理财金额
     * @param llendamount 理财金额
     */
    public void setLlendamount(Long llendamount) {
        this.llendamount = llendamount;
    }

    /**
     * 借款人身份证
     * @return strBorrowIdentity 借款人身份证
     */
    public String getStrborrowidentity() {
        return strborrowidentity;
    }

    /**
     * 借款人身份证
     * @param strborrowidentity 借款人身份证
     */
    public void setStrborrowidentity(String strborrowidentity) {
        this.strborrowidentity = strborrowidentity == null ? null : strborrowidentity.trim();
    }

    /**
     * 借款人姓名
     * @return strBorrowName 借款人姓名
     */
    public String getStrborrowname() {
        return strborrowname;
    }

    /**
     * 借款人姓名
     * @param strborrowname 借款人姓名
     */
    public void setStrborrowname(String strborrowname) {
        this.strborrowname = strborrowname == null ? null : strborrowname.trim();
    }

    /**
     * 借款人手机号
     * @return strBorrowMobile 借款人手机号
     */
    public String getStrborrowmobile() {
        return strborrowmobile;
    }

    /**
     * 借款人手机号
     * @param strborrowmobile 借款人手机号
     */
    public void setStrborrowmobile(String strborrowmobile) {
        this.strborrowmobile = strborrowmobile == null ? null : strborrowmobile.trim();
    }

    /**
     * 借款时间
     * @return dtBorrowTime 借款时间
     */
    public String getDtborrowtime() {
        return dtborrowtime;
    }

    /**
     * 借款时间
     * @param dtborrowtime 借款时间
     */
    public void setDtborrowtime(String dtborrowtime) {
        this.dtborrowtime = dtborrowtime == null ? null : dtborrowtime.trim();
    }

    /**
     * 借款金额
     * @return lBorrowAmount 借款金额
     */
    public Long getLborrowamount() {
        return lborrowamount;
    }

    /**
     * 借款金额
     * @param lborrowamount 借款金额
     */
    public void setLborrowamount(Long lborrowamount) {
        this.lborrowamount = lborrowamount;
    }

    /**
     * 匹配关系状态：-1:匹配完成,0:待还款,8处理中,10:已完成,11:已作废
     * @return nState 匹配关系状态：-1:匹配完成,0:待还款,8处理中,10:已完成,11:已作废
     */
    public Integer getNstate() {
        return nstate;
    }

    /**
     * 匹配关系状态：-1:匹配完成,0:待还款,8处理中,10:已完成,11:已作废
     * @param nstate 匹配关系状态：-1:匹配完成,0:待还款,8处理中,10:已完成,11:已作废
     */
    public void setNstate(Integer nstate) {
        this.nstate = nstate;
    }

    /**
     * 匹配生效日期，yyyy-MM-dd，采用银行返回的放款日期
     * @return strStartDate 匹配生效日期，yyyy-MM-dd，采用银行返回的放款日期
     */
    public String getStrstartdate() {
        return strstartdate;
    }

    /**
     * 匹配生效日期，yyyy-MM-dd，采用银行返回的放款日期
     * @param strstartdate 匹配生效日期，yyyy-MM-dd，采用银行返回的放款日期
     */
    public void setStrstartdate(String strstartdate) {
        this.strstartdate = strstartdate == null ? null : strstartdate.trim();
    }

    /**
     * 匹配结束日期，yyyy-MM-dd
     * @return strEndDate 匹配结束日期，yyyy-MM-dd
     */
    public String getStrenddate() {
        return strenddate;
    }

    /**
     * 匹配结束日期，yyyy-MM-dd
     * @param strenddate 匹配结束日期，yyyy-MM-dd
     */
    public void setStrenddate(String strenddate) {
        this.strenddate = strenddate == null ? null : strenddate.trim();
    }

    /**
     * 资金渠道类型：1000投资、2000回退、3000利息复投、4000本金复投、5000代偿
     * @return nLendType 资金渠道类型：1000投资、2000回退、3000利息复投、4000本金复投、5000代偿
     */
    public Integer getNlendtype() {
        return nlendtype;
    }

    /**
     * 资金渠道类型：1000投资、2000回退、3000利息复投、4000本金复投、5000代偿
     * @param nlendtype 资金渠道类型：1000投资、2000回退、3000利息复投、4000本金复投、5000代偿
     */
    public void setNlendtype(Integer nlendtype) {
        this.nlendtype = nlendtype;
    }

    /**
     * 借款渠道类型：1000借款、2000赎回
     * @return nBorrowType 借款渠道类型：1000借款、2000赎回
     */
    public Integer getNborrowtype() {
        return nborrowtype;
    }

    /**
     * 借款渠道类型：1000借款、2000赎回
     * @param nborrowtype 借款渠道类型：1000借款、2000赎回
     */
    public void setNborrowtype(Integer nborrowtype) {
        this.nborrowtype = nborrowtype;
    }

    /**
     * 理财年华利率
     * @return nLendYearRate 理财年华利率
     */
    public Integer getNlendyearrate() {
        return nlendyearrate;
    }

    /**
     * 理财年华利率
     * @param nlendyearrate 理财年华利率
     */
    public void setNlendyearrate(Integer nlendyearrate) {
        this.nlendyearrate = nlendyearrate;
    }

    /**
     * 借款年华利率
     * @return nBorrowYearRate 借款年华利率
     */
    public Integer getNborrowyearrate() {
        return nborrowyearrate;
    }

    /**
     * 借款年华利率
     * @param nborrowyearrate 借款年华利率
     */
    public void setNborrowyearrate(Integer nborrowyearrate) {
        this.nborrowyearrate = nborrowyearrate;
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
     * 理财系统标识:10-1.0系统 20-2.0系统 30-老核心 
     * @return nLendSystemSign 理财系统标识:10-1.0系统 20-2.0系统 30-老核心 
     */
    public Byte getNlendsystemsign() {
        return nlendsystemsign;
    }

    /**
     * 理财系统标识:10-1.0系统 20-2.0系统 30-老核心 
     * @param nlendsystemsign 理财系统标识:10-1.0系统 20-2.0系统 30-老核心 
     */
    public void setNlendsystemsign(Byte nlendsystemsign) {
        this.nlendsystemsign = nlendsystemsign;
    }

    /**
     * 借款系统标识:10-1.0系统 20-2.0系统 30-老核心
     * @return nBorrowSystemSign 借款系统标识:10-1.0系统 20-2.0系统 30-老核心
     */
    public Byte getNborrowsystemsign() {
        return nborrowsystemsign;
    }

    /**
     * 借款系统标识:10-1.0系统 20-2.0系统 30-老核心
     * @param nborrowsystemsign 借款系统标识:10-1.0系统 20-2.0系统 30-老核心
     */
    public void setNborrowsystemsign(Byte nborrowsystemsign) {
        this.nborrowsystemsign = nborrowsystemsign;
    }
}