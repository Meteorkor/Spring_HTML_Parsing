package com.meteor.module;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Name_gener {

	public static final String default_path = "c:\\log\\";
	
	public static String gener_name() {
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMdd");
		
		StringBuffer stb = new StringBuffer();
		
		stb.append(default_path);
		stb.append("log_");
		stb.append( simpleDateFormat.format(date) );
		stb.append(".txt");
		//return simpleDateFormat.format(date);
		
		return stb.toString();
	}
	
}
