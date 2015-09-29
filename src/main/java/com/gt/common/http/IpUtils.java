package com.gt.common.http;

import javax.servlet.http.HttpServletRequest;

/**
 * http常用工具类
 * @author guojintao
 * @date: 2015年9月29日 上午10:29:29 <br/>
 */
public abstract class IpUtils {

	/**
	 * 获取Ip地址
	 * @author guojintao 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// 当通过代理访问时，x-forwarded-for获取的IP地址格式：clientIP, proxy1IP, proxy2IP, ……
		// 添加过滤处理，只获取客户真实IP，过滤掉代理服务器IP
		if (ip == null) {
			ip = "";
		}
		String ips[] = ip.split(",");
		for (int i = 0; i < ips.length; i++) {
			String realIP = ips[i] == null ? "" : ips[i].trim();
			if (!"unknown".equals(realIP) && !"".equals(realIP)) {
				ip = realIP;
				break;
			}
		}

		return ip;
	}
}
