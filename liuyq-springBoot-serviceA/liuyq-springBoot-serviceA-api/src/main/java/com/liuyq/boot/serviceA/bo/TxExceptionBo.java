package com.liuyq.boot.serviceA.bo;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuyq
 * @date 2019/6/11 0011 下午 21:38
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TxExceptionBo implements Serializable {

    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_tx_exception.group_id
     *
     * @mbg.generated
     */
    private String group_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_tx_exception.unit_id
     *
     * @mbg.generated
     */
    private String unit_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_tx_exception.mod_id
     *
     * @mbg.generated
     */
    private String mod_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_tx_exception.transaction_state
     *
     * @mbg.generated
     */
    private Byte transaction_state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_tx_exception.registrar
     *
     * @mbg.generated
     */
    private Byte registrar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_tx_exception.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_tx_exception.ex_state
     *
     * @mbg.generated
     */
    private Byte ex_state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_tx_exception.create_time
     *
     * @mbg.generated
     */
    private Date create_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(String unit_id) {
        this.unit_id = unit_id;
    }

    public String getMod_id() {
        return mod_id;
    }

    public void setMod_id(String mod_id) {
        this.mod_id = mod_id;
    }

    public Byte getTransaction_state() {
        return transaction_state;
    }

    public void setTransaction_state(Byte transaction_state) {
        this.transaction_state = transaction_state;
    }

    public Byte getRegistrar() {
        return registrar;
    }

    public void setRegistrar(Byte registrar) {
        this.registrar = registrar;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getEx_state() {
        return ex_state;
    }

    public void setEx_state(Byte ex_state) {
        this.ex_state = ex_state;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}