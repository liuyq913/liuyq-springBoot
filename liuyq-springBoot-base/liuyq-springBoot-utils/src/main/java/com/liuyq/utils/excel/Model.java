package com.liuyq.utils.excel;

import lombok.*;

/**
 * Created by liuyq on 2019/9/2.
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    private String name;

    private Boolean isBlack;

    private String date;

    private Boolean isHoliday;

    private Boolean isLegal;

    private Double num;

}
