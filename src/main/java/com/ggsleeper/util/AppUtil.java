package com.ggsleeper.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class AppUtil {
	public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DATE = "yyyy-MM-dd";
	static DateFormat formater = new SimpleDateFormat();

	@SuppressWarnings("rawtypes")
//	public static Map getSession() {
//		return ActionContext.getContext().getSession();
//	}

//	public static HttpServletRequest getRequest() {
//		return (HttpServletRequest) ActionContext.getContext().get(
//				ServletActionContext.HTTP_REQUEST);
//	}
//
//	public static HttpServletResponse getResponse() {
//		return (HttpServletResponse) ActionContext.getContext().get(
//				ServletActionContext.HTTP_RESPONSE);
//	}

	public static String getCurrentDateTime() {
		formater = new SimpleDateFormat(FORMAT_DATE_TIME);
		return formater.format(new Date());
	}

	public static String getCurrentShortDate() {
		formater = new SimpleDateFormat(FORMAT_DATE);
		return formater.format(new Date());
	}

	public static String getDateTime(Timestamp ts) {
		if (ts != null) {
			formater = new SimpleDateFormat(FORMAT_DATE_TIME);
			return formater.format(ts);
		}
		return "";
	}

	public static String getShortDate(Timestamp ts) {
		if (ts != null) {
			formater = new SimpleDateFormat(FORMAT_DATE);
			return formater.format(ts);
		}
		return "";
	}
	/**
	 * 根据传入时间字符串获取时间对象
	 */
	public static Date getShortDate(String dateStr) {
		try {
			if (dateStr != null && !"".equals(dateStr)) {
				return formater.parse(dateStr);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @param dateStr
	 * @return
	 */
	public static Timestamp getDateTime(String dateStr) {
		try {
			if (dateStr != null && !"".equals(dateStr)) {
				return new Timestamp(formater.parse(dateStr).getTime());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Timestamp getDateTimestamp(String timestamp){
		Timestamp ts = new Timestamp(System.currentTimeMillis());   
        try {  
            ts = Timestamp.valueOf(timestamp);  
            return ts; 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;
	}
	public static String getDateFromDatePicker(String source){
		if(source!=null && !"".equals(source) && source.contains("/")){
			String[] dateArr=source.split("/");
			formater = new SimpleDateFormat(FORMAT_DATE);
			Calendar c=Calendar.getInstance();
			c.set(Integer.valueOf(dateArr[2]), Integer.valueOf(dateArr[0])-1, Integer.valueOf(dateArr[1]));
			return formater.format(c.getTime());
		}
		return source;
	}
}
