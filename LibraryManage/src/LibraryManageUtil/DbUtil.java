package LibraryManageUtil;


import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	 private String dbUrl="jdbc:mysql://localhost:3306/library?serverTimezone=UTC&characterEncoding=utf-8";
	 private String dbUserName="root";
	 private String dbpassword="lh2222";
	 private String jdbacName="com.mysql.cj.jdbc.Driver";
	 
	 /**
	  * ��ȡ���ݿ�����
	  * @return
	  * @throws Exception
	  */
	 public Connection getCon()throws Exception{
		 Class.forName(jdbacName);
		 Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbpassword);
		 return con;
		 
	 }
	 
	 /**
	  * �ر����ݿ�����
	  */

	 
	 public void closeCon(Connection con)throws Exception{
		 if(con!=null) {
			 con.close();
			 
		 }
	 }
	
	 
	 public static void main(String[] args) {
		DbUtil dbUtil =new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
		
	}
}
