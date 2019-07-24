package com.liuyq.boot.serviceB.mapper;

import com.liuyq.boot.serviceB.model.Demo;
import com.liuyq.boot.serviceB.model.DemoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo
     *
     * @mbg.generated
     */
    long countByExample(DemoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo
     *
     * @mbg.generated
     */
    int deleteByExample(DemoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo
     *
     * @mbg.generated
     */
    int insert(Demo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo
     *
     * @mbg.generated
     */
    int insertSelective(Demo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo
     *
     * @mbg.generated
     */
    List<Demo> selectByExample(DemoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo
     *
     * @mbg.generated
     */
    Demo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Demo record, @Param("example") DemoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Demo record, @Param("example") DemoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Demo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_demo
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Demo record);

    int saveList(@Param("recordList") List<Demo> recordList);
}