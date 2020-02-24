package LibraryManageUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import LibraryManage.Model.Book;
import LibraryManage.Model.BorrowAndReturn;

public class BookUtil {

	/**
	 * ͨ��ͼ������ѯ����
	 */
	public ResultSet BookNameBooklist(Connection con,Book book)throws Exception{
		StringBuffer sb=new StringBuffer("select bookID,ISBNNumber,bookName,author,price from book where bookName=?");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		pstmt.setString(1, book.getBookName());
		return pstmt.executeQuery();
	}
	
	/**
	 * ͨ��ͼ���Ų�ѯ����
	 */
	public ResultSet BookIDBooklist(Connection con,Book book)throws Exception{
		StringBuffer sb=new StringBuffer("select bookID,ISBNNumber,bookName,author,price from book where bookID=?");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		pstmt.setString(1, book.getBookID());
		return pstmt.executeQuery();
	}
	/**
	 * ͨ��ͼ���ź�ͼ�����ƽ��в�ѯ����
	 */
	
	public ResultSet Booklist(Connection con,Book book)throws Exception{
		StringBuffer sb=new StringBuffer("select bookID,ISBNNumber,bookName,author,price from book where bookID=? and bookName=?");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		pstmt.setString(1, book.getBookID());
		pstmt.setString(2, book.getBookName());
		return pstmt.executeQuery();
	}
	
	/**
	 * ͳ��ͼ�������
	 * 
	 */
	public int BookNumber(Connection con,String ISBNNumber)throws Exception{
		String sql="select count(*)as BookNumber from  book where ISBNNumber=?";
		int count = 0;
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, ISBNNumber);
		ResultSet rs=pstmt.executeQuery(); 
	    if(rs.next()) { 
	        	count=rs.getInt("BookNumber"); 
	        }
	    return count;
	}
		
	
	
	/**
	 * 
	 */
	public int BookResidueNumber(Connection con,String ISBNNumber,int bookState)throws Exception{
		String sql="select count(*)as BookNumber from  book where ISBNNumber=? and bookState=?";
		int count = 0;
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, ISBNNumber);
		pstmt.setInt(2, bookState);
		ResultSet rs=pstmt.executeQuery(); 
	    if(rs.next()) { 
	        	count=rs.getInt("BookNumber"); 
	        }
	    return count;
	}
	/**
	 * ��ѯ��ǰ��ͼ���״̬
	 */
	
	public ResultSet LookBookState(Connection con,String bookID,String bookName)throws Exception{
		String sql ="select bookState,IsDelete from book where bookID=? and bookName=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookID);
		pstmt.setString(2, bookName);
		return pstmt.executeQuery();
	}
	
	/**
	 * �������ݿ����
	 */
	
	public static int BorrowBook(Connection con,String bookID,String userID,String bookName) throws Exception{
		String sql="insert into borrowandreturn values(null,?,?,?,?,null,null)";
		PreparedStatement pstmt1=con.prepareStatement(sql);
		pstmt1.setString(1, userID);
		pstmt1.setString(2, bookID);
		pstmt1.setString(3, bookName);
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		pstmt1.setString(4, df.format(day));
		return pstmt1.executeUpdate();
	}
	
	/**
	 * �������ͼ���״̬
	 */
	
	public static int BorrowUpdateBookState(Connection con,String bookID,String bookName) throws Exception{
		String sql="update book set bookState=0 where bookID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookID);
		return pstmt.executeUpdate();
	}
	
	/**
	 * ��ѯ���鵥��Ϣ
	 */
	public ResultSet BorrowBooklist(Connection con,String userID)throws Exception{
		StringBuffer sb=new StringBuffer("select id,readerID,bookID,bookName,borrrowdate,returndate from borrowandreturn where readerID=?");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		pstmt.setString(1, userID);
		return pstmt.executeQuery();
	}
	
	/**
	 * �黹ͼ��,֮�����ͼ���ڿ�״̬Ϊ1
	 */
	public static int ReturnUpdateBookState(Connection con,String bookID) throws Exception{
		String sql="update book set bookState=1 where bookID=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookID);
		return pstmt.executeUpdate();
	}
	
	/**
	 * �黹ͼ�飬���ӹ黹ͼ��ʱ��
	 */
	public static int ReturnBook(Connection con,String bookID,String userID) throws Exception{
		String sql="update borrowandreturn set returndate=? where bookID=? and readerID=?" ;
		PreparedStatement pstmt1=con.prepareStatement(sql);
		Date day=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		pstmt1.setString(1, df.format(day));
		pstmt1.setString(2, bookID);
		pstmt1.setString(3, userID);
		return pstmt1.executeUpdate();
		
	}
	
			
	
	////////////////////////////////////////
	/**
	 * ͼ��������ݲ���
	 */
	
	public static int AddBook(Connection con,Book book) throws Exception{
		String sql="insert into book values(?,?,?,?,?,?,?,null,?)";
		PreparedStatement pstmt1=con.prepareStatement(sql);
		pstmt1.setString(1, book.getBookID());
		pstmt1.setString(2, book.getISBNNumber());
		pstmt1.setString(3, book.getBookName());
		pstmt1.setString(4, book.getAuthor());
		pstmt1.setString(5, book.getPrice());
		pstmt1.setString(6, "1");
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		pstmt1.setString(7, df.format(day));
		pstmt1.setString(8, "1");
		return pstmt1.executeUpdate();
	}
	
	/**
	 * ��ѯ���ͼ����Ϣ
	 */
	
	public ResultSet SelectAddBooklist(Connection con,String putindate)throws Exception{
		StringBuffer sb=new StringBuffer("select bookID,ISBNNumber,bookName,author,price,bookState,putinDate,outputDate from book where putinDate=?");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		pstmt.setString(1, putindate);
		return pstmt.executeQuery();
	}
	
	/**
	 * ע��ͼ��
	 */
	
	public int DeleteBooklist(Connection con,Book book)throws Exception{
		StringBuffer sb=new StringBuffer("update book set outputDate =? ,IsDelete=0 where bookID = ? and  ISBNNumber = ? and bookName=?");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		pstmt.setString(1, df.format(day));
		pstmt.setString(2, book.getBookID());
		pstmt.setString(3, book.getISBNNumber());
		pstmt.setString(4, book.getBookName());
		return pstmt.executeUpdate();
	}
	/**
	 * ��ѯͼ���Ƿ�Ϊ�Ѿ�ע��ͼ��
	 */
	public ResultSet DeleteBookState(Connection con,String bookID)throws Exception{
		StringBuffer sb=new StringBuffer("select IsDelete from book where bookID=?");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		pstmt.setString(1, bookID);
		return pstmt.executeQuery();
	}
	
	/**
	 * ��ѯע��ͼ����Ϣ
	 */
	
	public ResultSet SelectDeleteBooklist(Connection con,String outputDate)throws Exception{
		StringBuffer sb=new StringBuffer("select bookID,ISBNNumber,bookName,author,price,putinDate,outputDate from book where outputDate=?");
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		pstmt.setString(1, outputDate);
		return pstmt.executeQuery();
	}
	
	
}
