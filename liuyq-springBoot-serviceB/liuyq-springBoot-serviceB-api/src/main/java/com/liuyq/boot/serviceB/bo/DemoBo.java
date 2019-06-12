package com.liuyq.boot.serviceB.bo;

import lombok.*;

import java.util.Date;

/**
 * @author liuyq
 * @date 2019/6/11 0011 下午 21:50
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoBo {
    private Long id;


    private String kid;



    private String group_id;

    private String demo_field;


    private String app_name;


    private Date create_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getDemo_field() {
        return demo_field;
    }

    public void setDemo_field(String demo_field) {
        this.demo_field = demo_field;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
