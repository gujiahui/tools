package com.qdd.mongodb.demo.bean;

import com.mongodb.client.result.DeleteResult;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document
public class UserEntity  {

    @Id
    private String id;
    private String name ;
    private Integer age;
    private String email;
    private Date birthday;
    private Integer status;

}
