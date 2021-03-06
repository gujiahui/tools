package com.qdd.logback.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常工具类
 *
 * @author qdd
 */
public class ExceptionUtil {

	/**
	 * 将异常堆栈 信息 转换为字符串
	 *
	 * @param e
	 *            异常
	 * @return 该异常的错误堆栈信息
	 */
	public static String getStackTraceMessage(Exception e) throws IOException {
		try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
			// 将异常的的堆栈信息输出到printWriter中
			e.printStackTrace(pw);
			pw.flush();
			sw.flush();
			return sw.toString();
		}
	}
}
