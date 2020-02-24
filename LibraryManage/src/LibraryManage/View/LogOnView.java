package LibraryManage.View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import LibraryManage.Model.Administer;
import LibraryManage.Model.ReadUser;
import LibraryManageUtil.DbUtil;
import LibraryManageUtil.IntUtil;
import LibraryManageUtil.Regedit;
import LibraryManageUtil.StringUtil;

public class LogOnView extends JFrame {

	private JPanel contentPane;
	private JTextField IDTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField PasswordTxt;
	private JRadioButton SystemRadio;
	private JRadioButton ReaderRadio ;
	private JButton RegeditButton;
	private DbUtil dbUtil = new DbUtil();
	private Regedit regedit =new Regedit();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnView frame = new LogOnView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogOnView() {
		setResizable(false);
		setTitle("\u6B22\u8FCE\u8FDB\u5165");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u897F\u7535\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("�����п�", Font.BOLD, 30));
		label.setBounds(100, 64, 265, 49);
		contentPane.add(label);
		
		IDTxt = new JTextField();
		IDTxt.setBounds(155, 185, 210, 21);
		contentPane.add(IDTxt);
		IDTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8D26    \u53F7");
		label_1.setFont(new Font("����", Font.BOLD, 18));
		label_1.setBounds(67, 184, 78, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5BC6    \u7801");
		label_2.setFont(new Font("����", Font.BOLD, 18));
		label_2.setBounds(67, 239, 90, 23);
		contentPane.add(label_2);
		
		JButton LogInButton = new JButton("\u767B\u5F55");
		
		/**
		 * ��¼�¼�����
		 */
		LogInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginActionPerformed(e);
			}
		});
		LogInButton.setFont(new Font("����", Font.BOLD, 18));
		LogInButton.setBounds(314, 386, 97, 23);
		contentPane.add(LogInButton);
		
		RegeditButton = new JButton("\u6CE8\u518C");
		/**
		 * ע���¼�����
		 */
		RegeditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegeditView().setVisible(true);
			}
		});
		RegeditButton.setFont(new Font("����", Font.BOLD, 18));
		RegeditButton.setBounds(60, 386, 97, 23);
		contentPane.add(RegeditButton);
		
		ReaderRadio = new JRadioButton("\u8BFB \u8005");
		buttonGroup.add(ReaderRadio);
		ReaderRadio.setSelected(true);
		ReaderRadio.setFont(new Font("����", Font.BOLD, 18));
		ReaderRadio.setBounds(100, 323, 78, 23);
		contentPane.add(ReaderRadio);
		
		SystemRadio = new JRadioButton("\u7CFB\u7EDF\u7BA1\u7406\u5458");
		buttonGroup.add(SystemRadio);
		SystemRadio.setFont(new Font("����", Font.BOLD, 18));
		SystemRadio.setBounds(238, 323, 127, 23);
		contentPane.add(SystemRadio);
		
		PasswordTxt = new JPasswordField();
		PasswordTxt.setBounds(155, 241, 210, 21);
		contentPane.add(PasswordTxt);
	}
	
	private void LoginActionPerformed(ActionEvent etv) {
		String id=this.IDTxt.getText();
		String password = new String(this.PasswordTxt.getPassword());
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�"); 
			return ;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
			return ;
		}
		if(!IntUtil.IsInt(id)) {
			JOptionPane.showMessageDialog(null, "�û������벻��ȷ��");
			return ;
		}
		/**
		 * ϵͳ����Ա
		 */
		if(SystemRadio.isSelected()) {
			Administer administer = new Administer(id,null,password, null, null, null);
			Connection con = null;
			try {
				con=dbUtil.getCon();
				Administer currentadminister = regedit.Administerlogin(con, administer);
				if(currentadminister!=null)
				{
					//��¼��ʾ����
					
					dispose();
					new AdministerView().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "�û��������������");
				}
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
			/**
			 * ����
			 */
		}else if(ReaderRadio.isSelected()) {
			ReadUser reader = new ReadUser(id,null,password,null,null,null);
			Connection con = null;
			try {
				con=dbUtil.getCon();
				ReadUser currentadreader = regedit.Readerlogin(con, reader);
				if(currentadreader!=null)
				{
					//��¼��ʾ����
					
					dispose();
					new ReaderView().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "�û��������������");
				}
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
