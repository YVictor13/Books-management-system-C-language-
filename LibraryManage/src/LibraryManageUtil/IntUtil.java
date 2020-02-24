package LibraryManageUtil;
/**
 * ����������
 * @author dell
 *
 */
public class IntUtil {
	/**
	 * �ж��������Ϊ����
	 */
	public static boolean IsInt(String str) {
		boolean isNum = str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
		if(isNum) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * �ж���������Ƿ������Ƿ���ʵ
	 * @param args
	 */
	public static boolean isYear(int year) {
		if(year>1900&&year<2020) {
			return true;
		}else {
			return false;	
		}
	}
	
	/**
	 * �ж������·��Ƿ������ʵ
	 * @param args
	 */
	
	public static boolean isMonth(int month) {
		if(month>=1&&month<=12) {
			return true;
		}else {
			return false;	
		}
	}
	
	/**
	 * �ж����������Ƿ������ʵ
	 * @param args
	 */
	
	public static boolean isDay(int year ,int month ,int day) {
		int monthDay[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		if((year%4==0 && year%100 != 0)|| year%400==0 ) 
			monthDay[1]++;
		if(day>=1&&day<=monthDay[month-1]) {
			return true;
		}else {
			return false;	
		}
	}
	
}

