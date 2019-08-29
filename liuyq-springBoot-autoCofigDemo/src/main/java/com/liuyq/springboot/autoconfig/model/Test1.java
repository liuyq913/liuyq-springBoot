package com.liuyq.springboot.autoconfig.model;

import com.liuyq.springboot.autoconfig.annotation.FieldType;

/**
 * Created by liuyq on 2019/8/28.
 */
public class Test1 {

    @FieldType(type = "AN", length = 23)
    private Integer id;

    @FieldType(type = "AN", length = 12)
    private String name;


    public Test1(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
