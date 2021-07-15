package com.qdd.mongodb.demo.exception;



import com.qdd.mongodb.demo.common.BaseResultEnum;
import lombok.Getter;

/**
 * 错误处理类
 */
@Getter
public class JsonException extends RuntimeException{

    private Integer code;

    public JsonException(BaseResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public JsonException(BaseResultEnum resultEnum, String message) {
        super(message);
        this.code = resultEnum.getCode();
    }

    public JsonException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
