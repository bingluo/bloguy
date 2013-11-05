package cn.seu.bingluo.view.util;

import java.util.Date;

import org.joda.time.DateTime;

import cn.seu.bingluo.util.Constant;

public class ViewUtil {
	public static String[] resolveTags(String tagString) {
		return tagString.split(";");
	}

	public static String resolveDateGetMonth(Date date) {
		DateTime dateTime = new DateTime(date);
		return Constant.MONTH_MAP[dateTime.getMonthOfYear()];
	}

	public static int resolveDateGetDay(Date date) {
		DateTime dateTime = new DateTime(date);
		return dateTime.getDayOfMonth();
	}

	public static String resolveDateGetTime(Date date) {
		DateTime dateTime = new DateTime(date);
		return dateTime.toString("hh:mm a");
	}

	public static String timeFormat(Date date) {
		DateTime dateTime = new DateTime(date);
		return dateTime.toString("yyyy/MM/dd HH:mm (Ea)");
	}

	public static String timeFormat1(Date date) {
		DateTime dateTime = new DateTime(date);
		return dateTime.toString("yyyy/MM/dd HH:mm");
	}

	public static String dateFormat(Date date) {
		DateTime dateTime = new DateTime(date);
		return dateTime.toString("yyyy年MM月dd日");
	}
}
