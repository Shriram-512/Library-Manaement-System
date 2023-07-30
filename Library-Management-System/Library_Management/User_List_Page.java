package Library_Management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class User_List_Page implements ActionListener{

	JFrame f1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	public User_List_Page()
	{
		
		f1=new JFrame("Library Management System");
		
		f1.setVisible(true);
		f1.setLayout(null);
		f1.setBounds(400,300,950,400);
		
		ImageIcon icon = new ImageIcon("F:\\Others\\Title.jpg");
		Image img = icon.getImage();
		JLabel l22 = new JLabel(icon, JLabel.CENTER);
		l22.setBounds(00, 00, 950, 400);
		Image newimg = img.getScaledInstance(l22.getWidth(), l22.getHeight(), Image.SCALE_SMOOTH);
		f1.add(l22);
		
		b1 = new JButton("View Books");
		b1.setVisible(true);
		b1.setBounds(100,100,150,40);
		b1.addActionListener(this);
		f1.add(b1);
		
		b2 = new JButton("Add User");
		b2.setVisible(true);
		b2.setBounds(100,200,150,40);
		b2.addActionListener(this);
		f1.add(b2);
		
		b3 = new JButton("View User");
		b3.setVisible(true);
		b3.setBounds(300,100,150,40);
		b3.addActionListener(this);
		f1.add(b3);
		
		b4 = new JButton("Add Book");
		b4.setVisible(true);
		b4.setBounds(300,200,150,40);
		b4.addActionListener(this);
		f1.add(b4);
		
		b5 = new JButton("View Issued Book");
		b5.setVisible(true);
		b5.setBounds(500,100,150,40);
		b5.addActionListener(this);
		f1.add(b5);
		
		b6 = new JButton("Return Book");
		b6.setVisible(true);
		b6.setBounds(500,200,150,40);
		b6.addActionListener(this);
		f1.add(b6);
		
		b7 = new JButton("Issue Book");
		b7.setVisible(true);
		b7.setBounds(700,100,150,40);
		b7.addActionListener(this);
		f1.add(b7);
		
		b8 = new JButton("View Return Book");
		b8.setVisible(true);
		b8.setBounds(700,200,150,40);
		b8.addActionListener(this);
		f1.add(b8);
		
		
		b9 = new JButton("Log Out");
		b9.setBounds(750,300,150,40);
		b9.addActionListener(this);
		f1.add(b9);
		
	}
	
	public static void main(String[] args) 
	{
		new User_List_Page();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1)
		{
			new ViewBook();
		}
		if(e.getSource()==b2)
		{
			new addusers();
			f1.setVisible(false);
		}
		if(e.getSource()==b3)
		{
			new ViewUsers();
		}
		if(e.getSource()==b4)
		{
			new Add_Book();
//			f1.setVisible(false);
		}
		if(e.getSource()==b5)
		{
			new View_Issued_Book();
		}
		if(e.getSource()==b6)
		{
			new Return_Book();
			f1.setVisible(false);
		}
		if(e.getSource()==b7)
		{
			new Issue_Book();
			f1.setVisible(false);
		}
		if(e.getSource()==b8)
		{
			new ViewReturnBook();
			
		}
		if(e.getSource()==b9)
		{
			System.exit(0);
		}
	}
}
