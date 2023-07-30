package Library_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.*;

public class addusers implements ActionListener {
	
	JFrame f;

	JLabel l1, l2, l3, l4, l5;
	JButton b1,b2,b3,b4 ,back,add;
	JTextField t1,t2, t3;
	int i;


	public addusers() {
		f = new JFrame("Add New User");
		f.setBounds(600, 200, 550, 500);
		f.setLayout(null);
		f.setVisible(true);


		b1 =new JButton("ENTER USER DETALIS");
		b1.setBounds(100,30,400,30);
		Font f12 = new Font("Algerian",Font.BOLD,20);
		b1.setFont(f12);
		b1.setBackground(Color.pink);
		b1.setForeground(Color.black);
		f.add(b1);
		
		b2=new JButton("Name :");
		b2.setEnabled(false);
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.RED);
		b2.setBounds(100,100,135,30);
		f.add(b2);
		
		b3 =new JButton("Roll No :");
		b3.setEnabled(false);
		b3.setBackground(Color.WHITE);
		b3.setForeground(Color.RED);
		b3.setBounds(100,150,135,30);
		f.add(b3);
		
		b4 =new JButton("Class :");
		b4.setEnabled(false);
		b4.setBackground(Color.WHITE);
		b4.setForeground(Color.RED);
		b4.setBounds(100,200,135,30);
		f.add(b4);
		
		t1 = new JTextField();
		t1.setVisible(true);
		t1.setBounds(250, 100, 150, 30);
		f.add(t1);

		t2 = new JTextField();
		t2.setVisible(true);
		t2.setBounds(250, 150, 150, 30);
		f.add(t2);

		t3 = new JTextField();
		t3.setVisible(true);
		t3.setBounds(250, 200, 150, 25);
		f.add(t3);

		add = new JButton("Add User");
		add.setVisible(true);
		add.setBounds(300, 300, 100, 30);
		add.addActionListener(this);
		f.add(add);

		back = new JButton("Back");
		back.setVisible(true);
		back.setBounds(100, 300, 100, 30);
		back.addActionListener(this);
		f.add(back);
		
//		ImageIcon icon = new ImageIcon("F:\\\\\\\\AJP programs\\\\\\\\Swing\\\\\\\\SwingProjects\\\\\\\\src\\\\\\\\Library_Management\\\\user3.jpg");
//		Image img = icon.getImage();
//		JLabel l22 = new JLabel(icon, JLabel.CENTER);
//		l22.setBounds(00, 00, 650, 450);
//		Image newimg = img.getScaledInstance(l22.getWidth(), l22.getHeight(), Image.SCALE_SMOOTH);
//		f.add(l22);

	}

	public static void main(String[] args) 
	{
		new addusers();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == back) {
			new Library_Management.User_List_Page();
			f.setVisible(false);
		}
		if(e.getSource() == add)
		{
			addUser();
		}
	}
	
	public void addUser()
	{
		
		try {
			
			if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please Fill All Details", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			else{
			DbConnection db = new DbConnection();
			
			int roll_no = Integer.valueOf(t2.getText());
			String sql = String.format("insert into adduser values('%s',%d,'%s')", t1.getText(),roll_no,t3.getText());
			PreparedStatement ps = db.con.prepareStatement(sql);
			i = ps.executeUpdate();
			}
			if(i==1)
			{
				JOptionPane.showMessageDialog(null, "User Added Successfully");
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);	
			}
			
			
		}
		catch(Exception e)
		{
			JOptionPane.showInternalMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

}