package LibraryManageUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import LibraryManage.Model.Administer;
import LibraryManage.Model.ReadUser;

/**
 * ������ע�᷽��
 * @author dell
 *
 */
public class Regedit {
	public int regeditAdminister(Connection con,Administer administer) throws Exception{
		String sql="insert into administer values(?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		int  num =(int)(10000+Math.random()*100000);
		pstmt.setInt(1, num);
		pstmt.setString(2, administer.getName());
		pstmt.setString(3, administer.getPassword());
		pstmt.setString(4, administer.getDepartment());
		pstmt.setString(5, administer.getAddress());
		pstmt.setString(6, administer.getPhone());
		
		return pstmt.executeUpdate();
	}
	/**
	 * ����ע�᷽��
	 * @param con
	 * @param reader
	 * @return
	 * @throws Exception
	 */
	public int regeditReader(Connection con,ReadUser reader) throws Exception{
		String sql="insert into reader values(?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		int  num =(int)(100000+Math.random()*1000000);
		pstmt.setInt(1, num);
		pstmt.setString(2, reader.getUsername());
		pstmt.setString(3, reader.getPassword());
		pstmt.setString(4, reader.getDepartment());
		pstmt.setString(5, reader.getAddress());
		pstmt.setString(6, reader.getPhone());
		
		return pstmt.executeUpdate();
	}

	
	/**
	 * ���ߵ�¼����
	 */
	
	public ReadUser Readerlogin(Connection con,ReadUser reader ) throws Exception{
		ReadUser resultreader =null;
		String sql="select readID ,password from reader where readID=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, reader.getReaderid());
		pstmt.setString(2, reader.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			resultreader=new ReadUser();
			resultreader.setReaderid(rs.getString("readID"));
			resultreader.setPassword(rs.getString("password"));
		}
		return resultreader;
	}
	
	
	/**
	 * ϵͳ����Ա��¼��ʽ
	 */
	
	public Administer Administerlogin(Connection con,Administer administer) throws Exception{
		Administer resultadminister =null;
		String sql="select administerID ,password from administer where administerID=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, administer.getID());
		pstmt.setString(2, administer.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			resultadminister=new Administer();
			resultadminister.setID(rs.getString("administerID"));
			resultadminister.setPassword(rs.getString("password"));
		}
		return resultadminister;
	}
	
	
	
	
	
	
}
