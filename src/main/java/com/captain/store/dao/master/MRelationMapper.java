package com.captain.store.dao.master;


import com.captain.store.model.MRelation;

import java.util.List;
import java.util.Map;

public interface MRelationMapper {
    /**
     *
     * @mbg.generated 2018-07-12
     */
    int deleteByPrimaryKey(Long lid);

    /**
     *
     * @mbg.generated 2018-07-12
     */
    int insert(MRelation record);

    /**
     *
     * @mbg.generated 2018-07-12
     */
    int insertSelective(MRelation record);

    /**
     *
     * @mbg.generated 2018-07-12
     */
    MRelation selectByPrimaryKey(Long lid);

    /**
     *
     * @mbg.generated 2018-07-12
     */
    int updateByPrimaryKeySelective(MRelation record);

    /**
     *
     * @mbg.generated 2018-07-12
     */
    int updateByPrimaryKey(MRelation record);

    List<MRelation> selectAll();

    void pro_callFlushMatchRelationData();

    long sum_LendIntent(Map<String, Object> condition);

    long sum_borrowIntent(Map<String, Object> condition);

    long sum_matchRelation(Map<String, Object> condition);

    long sum_borrowBill(Map<String, Object> condition);

    long sum_redemptionIntent(Map<String, Object> condition);

}