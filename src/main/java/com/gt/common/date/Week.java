package com.gt.common.date;

/**
 * 
 * 类名称：Week    
 * 类描述：    
 * 创建人：郭金涛    
 * 创建时间：2015年9月30日 上午11:57:29
 */
public enum Week {
	
	MONDAY("星期一", "Monday", "Mon.", 1),  
    TUESDAY("星期二", "Tuesday", "Tues.", 2),  
    WEDNESDAY("星期三", "Wednesday", "Wed.", 3),  
    THURSDAY("星期四", "Thursday", "Thur.", 4),  
    FRIDAY("星期五", "Friday", "Fri.", 5),  
    SATURDAY("星期六", "Saturday", "Sat.", 6),  
    SUNDAY("星期日", "Sunday", "Sun.", 7);
	
	String name_cn;
	String name_en;
	String name_enShort;
	int number;
	
	private Week(String name_cn, String name_en, String name_enShort, int number) {
		this.name_cn = name_cn;
		this.name_en = name_en;
		this.name_enShort = name_enShort;
		this.number = number;
	}

	
	/**  
	 * name_cn.  
	 * @return  the name_cn  
	 */
	public String getName_cn() {
		return name_cn;
	}


	/**
	 * name_en
	 * @return the name_en
	 */
	public String getName_en() {
		return name_en;
	}


	/**  
	 * name_enShort.  
	 * @return  the name_enShort  
	 */
	public String getName_enShort() {
		return name_enShort;
	}

	
	/**  
	 * number.  
	 * @return  the number  
	 */
	public int getNumber() {
		return number;
	}
	
	
}
