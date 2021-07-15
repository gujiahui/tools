package com.qdd.mongodb.demo.common;


import lombok.Data;
import lombok.EqualsAndHashCode;




/**
 * 分页的表单
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class ListPageRequest extends BaseRequest{

    private Integer currentPage;

    private Integer pageSize;

}
