package com.liuyq.boot.serviceA.model;

import java.io.Serializable;
import java.util.Date;

public class TxException implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_tx_exception.id
     *
     * @mbg.generated
     */
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

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_tx_exception
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_tx_exception.id
     *
     * @return the value of t_tx_exception.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_tx_exception.id
     *
     * @param id the value for t_tx_exception.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_tx_exception.group_id
     *
     * @return the value of t_tx_exception.group_id
     *
     * @mbg.generated
     */
    public String getGroup_id() {
        return group_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_tx_exception.group_id
     *
     * @param group_id the value for t_tx_exception.group_id
     *
     * @mbg.generated
     */
    public void setGroup_id(String group_id) {
        this.group_id = group_id == null ? null : group_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_tx_exception.unit_id
     *
     * @return the value of t_tx_exception.unit_id
     *
     * @mbg.generated
     */
    public String getUnit_id() {
        return unit_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_tx_exception.unit_id
     *
     * @param unit_id the value for t_tx_exception.unit_id
     *
     * @mbg.generated
     */
    public void setUnit_id(String unit_id) {
        this.unit_id = unit_id == null ? null : unit_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_tx_exception.mod_id
     *
     * @return the value of t_tx_exception.mod_id
     *
     * @mbg.generated
     */
    public String getMod_id() {
        return mod_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_tx_exception.mod_id
     *
     * @param mod_id the value for t_tx_exception.mod_id
     *
     * @mbg.generated
     */
    public void setMod_id(String mod_id) {
        this.mod_id = mod_id == null ? null : mod_id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_tx_exception.transaction_state
     *
     * @return the value of t_tx_exception.transaction_state
     *
     * @mbg.generated
     */
    public Byte getTransaction_state() {
        return transaction_state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_tx_exception.transaction_state
     *
     * @param transaction_state the value for t_tx_exception.transaction_state
     *
     * @mbg.generated
     */
    public void setTransaction_state(Byte transaction_state) {
        this.transaction_state = transaction_state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_tx_exception.registrar
     *
     * @return the value of t_tx_exception.registrar
     *
     * @mbg.generated
     */
    public Byte getRegistrar() {
        return registrar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_tx_exception.registrar
     *
     * @param registrar the value for t_tx_exception.registrar
     *
     * @mbg.generated
     */
    public void setRegistrar(Byte registrar) {
        this.registrar = registrar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_tx_exception.remark
     *
     * @return the value of t_tx_exception.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_tx_exception.remark
     *
     * @param remark the value for t_tx_exception.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_tx_exception.ex_state
     *
     * @return the value of t_tx_exception.ex_state
     *
     * @mbg.generated
     */
    public Byte getEx_state() {
        return ex_state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_tx_exception.ex_state
     *
     * @param ex_state the value for t_tx_exception.ex_state
     *
     * @mbg.generated
     */
    public void setEx_state(Byte ex_state) {
        this.ex_state = ex_state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_tx_exception.create_time
     *
     * @return the value of t_tx_exception.create_time
     *
     * @mbg.generated
     */
    public Date getCreate_time() {
        return create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_tx_exception.create_time
     *
     * @param create_time the value for t_tx_exception.create_time
     *
     * @mbg.generated
     */
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tx_exception
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TxException other = (TxException) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGroup_id() == null ? other.getGroup_id() == null : this.getGroup_id().equals(other.getGroup_id()))
            && (this.getUnit_id() == null ? other.getUnit_id() == null : this.getUnit_id().equals(other.getUnit_id()))
            && (this.getMod_id() == null ? other.getMod_id() == null : this.getMod_id().equals(other.getMod_id()))
            && (this.getTransaction_state() == null ? other.getTransaction_state() == null : this.getTransaction_state().equals(other.getTransaction_state()))
            && (this.getRegistrar() == null ? other.getRegistrar() == null : this.getRegistrar().equals(other.getRegistrar()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getEx_state() == null ? other.getEx_state() == null : this.getEx_state().equals(other.getEx_state()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tx_exception
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGroup_id() == null) ? 0 : getGroup_id().hashCode());
        result = prime * result + ((getUnit_id() == null) ? 0 : getUnit_id().hashCode());
        result = prime * result + ((getMod_id() == null) ? 0 : getMod_id().hashCode());
        result = prime * result + ((getTransaction_state() == null) ? 0 : getTransaction_state().hashCode());
        result = prime * result + ((getRegistrar() == null) ? 0 : getRegistrar().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getEx_state() == null) ? 0 : getEx_state().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        return result;
    }
}