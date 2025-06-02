package com.adactin.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.adactin.actiondriver.Action;

public class CommonUtil {

	Action action = new Action();

	public String getDate() {
		return action.getCurrentTime();
	}

	public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd");
//        Date date1 = sd.parse("2022-12-25");
//        Date date2 = sd.parse("2022-12-06");
//        System.out.println(date2.compareTo(date1));

//		CommonUtil com = new CommonUtil();
//		String a = com.getDate();
//		System.out.println(a);
		
		String dateName = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		System.out.println(dateName);
		
		

	}

}
