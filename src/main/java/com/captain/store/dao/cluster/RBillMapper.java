package com.captain.store.dao.cluster;

import com.captain.store.model.RBill;

public interface RBillMapper{
    /**
     *
     * @mbg.generated 2018-07-18
     */
    int deleteByPrimaryKey(Long lid);

    /**
     *
     * @mbg.generated 2018-07-18
     */
    int insert(RBill record);

    /**
     *
     * @mbg.generated 2018-07-18
     */
    int insertSelective(RBill record);

    /**
     *
     * @mbg.generated 2018-07-18
     */
    RBill selectByPrimaryKey(Long lid);

    /**
     *
     * @mbg.generated 2018-07-18
     */
    int updateByPrimaryKeySelective(RBill record);

    /**
     *
     * @mbg.generated 2018-07-18
     */
    int updateByPrimaryKey(RBill record);
}