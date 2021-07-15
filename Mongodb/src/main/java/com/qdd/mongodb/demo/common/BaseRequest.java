package com.qdd.mongodb.demo.common;

import lombok.Data;

/**
 * 公用请求参数
 * @author gjh
 *
 */
@Data
public class BaseRequest {
	/**
	 * 通用包名,可用，由于早期
	 */
	private String packageNameCommon;

	/**
	 * 渠道号
	 */
	private String channelCode;

	private String appVersion;

	private String mac;

	private String imsi;

	private String imei;

	private String hsman;

	private String hstype;

	private String androidVersion;

	private String screenSize;

	private Integer ramSize;

	private Integer romSize;

	private String cpu;

	private Integer dpi;

	private Short networktype;

	private String provider;
}
