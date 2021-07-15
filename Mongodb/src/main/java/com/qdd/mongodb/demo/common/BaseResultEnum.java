package com.qdd.mongodb.demo.common;

import lombok.Getter;

/**
 * BaseResult的code编码枚举
 *
 */
@Getter
public enum BaseResultEnum {
    /**
     * SUCCESS: 200 成功
     * FAIL: 400 失败
     * NOT_FOUND： 404 不存在
     * SERVER_ERROR: 500 网络服务异常
     */
    SUCCESS(200, "成功"),
    FAIL(400, "失败"),
    NOT_FOUND(404, "不存在"),
    SERVER_ERROR(500, "服务异常"),
    NOT_NETWORK(400, "系统繁忙，请稍后再试。"),
    LOGIN_VERIFY_FALL(452, "登录失效"),
    PARAM_VERIFY_FALL(453, "参数验证错误"),
    AUTH_FAILED(454, "权限验证失败"),
    DATA_NOT(455, "没有相关数据"),
    DATA_CHANGE(456, "数据没有任何更改"),
    DATA_REPEAT(457, "数据已存在"),
    DATA_EMPTITY_MSG(656,"没有更多数据了"),
    LOG_SAVE_ERROR(661,"日志保存失败"),
    PARAM_EMPTITY(633,"缺少参数"),
    PAGE_EXCEEDED(655,"超出最大页码"),
    DATA_EMPTITY(654,"查询不到数据"),
    PAGE_TYPE_ERROR(653,"分页参数类型错误"),
    PAGE_EMPTITY(652,"分页数为空"),
    DEPLOYMENT_NOTEXIT(613,""),
    PACKAGE_NOTEXIT(611,"包名不存在"),
    MOBILE_FORMAT_ERROR(622,"手机号格式错误"),
    ACCOUNT_NOT_FOUND(603, "账号不存在"),
    ACCOUNT_NOT_LOGIN(677, "账号未登录"),
    SMS_NOT_VALID(604, "验证码无效"),
    SMS_NOT_MISMATCH(605, "验证码不匹配"),
    SMS_SEND_ERROR(606, "验证码发送失败"),
    SMS_SEND_TOOFAST(607, "验证码发送频繁"),
    SUBSCRIBER_NOTEXIT(621,"手机号为空"),
    SUBSCRIBER_SUCCESS(620,"预约成功"),
	SUBSCRIBER_EXIT(610,"重复预约"),
	FEEDBACK_NOTEXIT(667,"联系方式不能为空");
	

	
    private int code;

    private String message;

    BaseResultEnum(int code, String message) {
        this.code = code;
        this.message =message;
    }
   

}
