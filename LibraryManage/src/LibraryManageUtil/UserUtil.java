package LibraryManageUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import LibraryManage.Model.Administer;
import LibraryManage.Model.Book;
import LibraryManage.Model.ReadUser;

public class UserUtil {
	
	/**
	 * ������Ϣ��ѯ����
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	
	
	public ResultSet readlist(Connection con,ReadUser read)throws Exception{
		StringBuffer sb=new StringBuffer("select * from reader where readID=?");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		pstmt.setString(1, read.getReaderid());
		return pstmt.executeQuery();
	}
	
	/**
	 * ϵͳ����Ա��Ϣ��ѯ����
	 * 
	 */
	
	public ResultSet administerlist(Connection con,Administer administer)throws Exception{
		StringBuffer sb=new StringBuffer("select * from administer where administerID=?");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		pstmt.setString(1, administer.getID());
		return pstmt.executeQuery();
	}
	
	
	/**
	 * ���¶�����Ϣ
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int ReaderInformanationUpdate(Connection con,ReadUser reader)throws Exception{
		String sql="update reader set password=?,department=?,address=?,phone=? where readID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, reader.getPassword());
		pstmt.setString(2, reader.getDepartment());
		pstmt.setString(3, reader.getAddress());
		pstmt.setString(4, reader.getPhone());
		pstmt.setString(5, reader.getReaderid());
		
		return pstmt.executeUpdate();
	}
	/**
	 * ���¶�������
	 * @param con
	 * @param reader
	 * @return
	 * @throws Exception
	 */
	public int ReaderPasswordUpdate(Connection con,ReadUser reader)throws Exception{
		String sql="update reader set password=? where readID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, reader.getPassword());
		pstmt.setString(2, reader.getReaderid());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ���¶��ߵ�ַ����λ����ϵ��ʽ
	 * @param con
	 * @param reader
	 * @return
	 * @throws Exception
	 */
	public int ReaderDAPUpdate(Connection con,ReadUser reader)throws Exception{
		String sql="update reader set department=?,address=?,phone=? where readID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, reader.getDepartment());
		pstmt.setString(2, reader.getAddress());
		pstmt.setString(3, reader.getPhone());
		pstmt.setString(4, reader.getReaderid());
		return pstmt.executeUpdate();
	}
	/**
	 * ���¶��ߵ�λ
	 */
	public int ReaderDepartmentUpdate(Connection con,ReadUser reader)throws Exception{
		String sql="update reader set department=? where readID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, reader.getDepartment());
		pstmt.setString(2, reader.getReaderid());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ���¶��ߵ�ַ
	 */
	
	public int ReaderAddressUpdate(Connection con,ReadUser reader)throws Exception{
		String sql="update reader set address=? where readID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,reader.getAddress());
		pstmt.setString(2, reader.getReaderid());
		return pstmt.executeUpdate();
	}
	/**
	 * ���¶�����ϵ��ʽ
	 */
	public int ReaderPhoneUpdate(Connection con,ReadUser reader)throws Exception{
		String sql="update reader set phone=? where readID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,reader.getPhone());
		pstmt.setString(2,reader.getReaderid());
		return pstmt.executeUpdate();
	}
	/**
	 * ���¶��ߵ�ַ����ϵ��ʽ
	 */
	public int ReaderAPUpdate(Connection con,ReadUser reader)throws Exception{
		String sql="update reader set address=?, phone=? where readID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,reader.getAddress());
		pstmt.setString(2,reader.getPhone());
		pstmt.setString(3,reader.getReaderid());
		return pstmt.executeUpdate();
	}
	/**
	 * ���¶��ߵ�λ����ϵ��ʽ
	 */
	public int ReaderDPUpdate(Connection con,ReadUser reader)throws Exception{
		String sql="update reader set department=?, phone=? where readID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, reader.getDepartment());
		pstmt.setString(2,reader.getPhone());
		pstmt.setString(3,reader.getReaderid());
		return pstmt.executeUpdate();
	}
	/**
	 * 
	 */
	
	/**
	 * ����ϵͳ������Ϣ
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int AdministerInformanationUpdate(Connection con,Administer administer)throws Exception{
		String sql="update administer set password=?,department=?,address=?,phone=? where administerID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, administer.getPassword());
		pstmt.setString(2, administer.getDepartment());
		pstmt.setString(3, administer.getAddress());
		pstmt.setString(4, administer.getPhone());
		pstmt.setString(5, administer.getID());
		
		return pstmt.executeUpdate();
	}
	/**
	 * ���¶�������
	 * @param con
	 * @param reader
	 * @return
	 * @throws Exception
	 */
	public int AdministerPasswordUpdate(Connection con,Administer administer)throws Exception{
		String sql="update administer set password=? where administerID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, administer.getPassword());
		pstmt.setString(2, administer.getID());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ���¶��ߵ�ַ����λ����ϵ��ʽ
	 * @param con
	 * @param reader
	 * @return
	 * @throws Exception
	 */
	public int AdministerDAPUpdate(Connection con,Administer administer)throws Exception{
		String sql="update administer set department=?,address=?,phone=? where administerID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, administer.getDepartment());
		pstmt.setString(2, administer.getAddress());
		pstmt.setString(3, administer.getPhone());
		pstmt.setString(4, administer.getID());
		return pstmt.executeUpdate();
	}
	/**
	 * ����ϵͳ����Ա��λ
	 */
	public int AdministerDepartmentUpdate(Connection con,Administer administer)throws Exception{
		String sql="update administer set department=? where administerID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, administer.getDepartment());
		pstmt.setString(2, administer.getID());
		return pstmt.executeUpdate();
	}
	
	/**
	 * ����ϵͳ����Ա��ַ
	 */
	
	public int AdministerAddressUpdate(Connection con,Administer administer)throws Exception{
		String sql="update administer set address=? where administerID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,administer.getAddress());
		pstmt.setString(2, administer.getID());
		return pstmt.executeUpdate();
	}
	/**
	 * ����ϵͳ����Ա��ϵ��ʽ
	 */
	public int AdministerPhoneUpdate(Connection con,Administer administer)throws Exception{
		String sql="update administer set phone=? where administerID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,administer.getPhone());
		pstmt.setString(2,administer.getID());
		return pstmt.executeUpdate();
	}
	/**
	 * ����ϵͳ����Ա��ַ����ϵ��ʽ
	 */
	public int AdministerAPUpdate(Connection con,Administer administer)throws Exception{
		String sql="update administer set address=?, phone=? where administerID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,administer.getAddress());
		pstmt.setString(2,administer.getPhone());
		pstmt.setString(3,administer.getID());
		return pstmt.executeUpdate();
	}
	/**
	 * ����ϵͳ����Ա��λ����ϵ��ʽ
	 */
	public int AdministerDPUpdate(Connection con,Administer administer)throws Exception{
		String sql="update administer set department=?, phone=? where administerID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, administer.getDepartment());
		pstmt.setString(2,administer.getPhone());
		pstmt.setString(3,administer.getID());
		return pstmt.executeUpdate();
	}
}
