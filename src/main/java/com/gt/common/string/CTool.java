package com.gt.common.string;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

/**
 * 此类中收集Java编程中WEB开发常用到的一些工具。
 * 为避免生成此类的实例，构造方法被申明为private类型的。
 * <p>Title: </p>
 * <p>Description: </p> 
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: </p>
 * @author:
 * @version 1.0
 */
public class CTool {

	/**
	 * Creates a new instance of CTool.
	 */
	private CTool(){}
	
	/**
	 * 用于将字符串中的特殊字符转换成Web页中可以安全显示的字符串
	 * 可对表单数据据进行处理对一些页面特殊字符进行处理如'<','>','"',''','&'
	 * @param strSrc
	 * @return
	 */
	public static String htmlEncode(String strSrc){
		if(strSrc == null)
			return "";
		
		char[] arr_cSrc = strSrc.toCharArray();
		StringBuffer buf = new StringBuffer(arr_cSrc.length);
		char ch;
		
		for(int i = 0; i< arr_cSrc.length; i++){
			ch = arr_cSrc[i];
			
			if(ch == '<')
				buf.append("&lt;");
			else if(ch == '>')
				buf.append("&gt;");
			else if(ch == '"')
				buf.append("&quot");
			else if(ch == '\'')
				buf.append("&#039;");
			else if(ch == '&')
				buf.append("&amp;");
			else
				buf.append(ch);
		}
		return buf.toString();
	}
	
	/**
	 * 将web页面中的转义字符进行转换
	 * @param strSrc 要进行转换的字符串
	 * @return
	 */
	public static final String htmlDecode(String strSrc){
		if(strSrc == null)
			return "";
		
		strSrc = strSrc.replaceAll("&lt;", "<");
		strSrc = strSrc.replaceAll("&gt;", ">");
		strSrc = strSrc.replaceAll("&quot;", "\"");
		strSrc = strSrc.replaceAll("&#039", "\'");
		strSrc = strSrc.replaceAll("&amp;", "&");
		return strSrc;
	}
	
	/**
	 * 字符串获取unicode编码
	 * @param str
	 * @return
	 */
	public static String string2Unicode(String str){
		char[] utfBytes = str.toCharArray();
		String unicodeBytes = "";
		for(int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++){
			String hexB = Integer.toHexString(utfBytes[byteIndex]);
			if(hexB.length() <= 2){
				hexB = "00" + hexB;
			}
			unicodeBytes = unicodeBytes + "\\u" + hexB;
		}
		
		return unicodeBytes;
	}
	
	/**
	 * unicode编码获取字符串
	 * @param dataStr
	 * @return
	 */
	public static String unicode2String(String dataStr){
		StringBuffer buf = new StringBuffer();
		int start = 0;
		int end = 0;
		while(start > -1){
			end = dataStr.indexOf("\\u", start + 2);
			String charStr = "";
			if(end == -1){
				charStr = dataStr.substring(start + 2, dataStr.length());
			}else{
				charStr = dataStr.substring(start + 2, end);
			}
			
			char letter = (char) Integer.parseInt(charStr, 16);
			buf.append(new Character(letter).toString());
			start = end;
		}
		return buf.toString();
	}
	
	
	public static void main(String[] args) throws IOException {
		String src = "郭金涛123";
		src = string2Unicode(src);
		System.out.println(src);
		System.out.println(unicode2String(src));
	}
}
