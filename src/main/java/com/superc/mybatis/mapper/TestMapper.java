package com.superc.mybatis.mapper;

import com.superc.mybatis.model.Test;

public interface TestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int insert(Test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int insertSelective(Test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    Test selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Test record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Test record);
}