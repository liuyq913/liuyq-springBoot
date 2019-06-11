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
}
