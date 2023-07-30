package Library_Management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class login
{
	JLabel l1, l2,l3;
	JFrame f;
	JTextField l_user, l_pass;
	JButton b1;

	public login() 
	{
		f = new JFrame("Login"); // login page
		f.setLayout(null);
		f.setVisible(true);
		f.setBounds(550, 200, 1366, 768);

		l3 = new JLabel("Library Management System"); 
		l3.setBounds(500, 70, 450, 50);
		Font myfont = new Font("times new roman", Font.BOLD, 35);
		l3.setFont(myfont);
		l3.setForeground(Color.pink);
		f.add(l3);
		
		l1 = new JLabel("Username"); 
		l1.setBounds(500, 220, 120, 30);
		Font font = new Font("italic", Font.BOLD, 25);
		l1.setFont(font);
		l1.setForeground(Color.BLACK);
		f.add(l1);

		l2 = new JLabel("Password"); 
		l2.setBounds(500, 300, 120, 30);
		l2.setFont(font);
		l2.setForeground(Color.BLACK);
		f.add(l2);

		JTextField l_user = new JTextField();
		l_user.setBounds(700, 220, 170, 30);
		f.add(l_user);

		JPasswordField l_pass = new JPasswordField();
		l_pass.setBounds(700, 300, 170, 30);
		f.add(l_pass);
		
		JButton b1 = new JButton("Login"); 
		b1.setBounds(600, 360, 80, 25);
		b1.setBackground(Color.CYAN);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (l_user.getText().equals("admin") && l_pass.getText().equals("admin123")) {
					JOptionPane.showMessageDialog(null, "User Login Successfully!!");
					new Library_Management.User_List_Page();
					f.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Login Failed", "ERROR", JOptionPane.CANCEL_OPTION);
				}
			}
		});
		f.add(b1);
		
		ImageIcon icon = new ImageIcon("D:\\Library-Management-System\\pexels-ivo-rainha-1290141 (1).jpg");
		Image img = icon.getImage();
		JLabel l22 = new JLabel(icon, JLabel.CENTER);
		l22.setBounds(00, 00, 1366, 768);
		Image newimg = img.getScaledInstance(l22.getWidth(), l22.getHeight(), Image.SCALE_SMOOTH);
		f.add(l22);

		ImageIcon icon1 = new ImageIcon("D:\\Library-Management-System\\pexels-pixabay-256161_666x499.jpg");
		Image img1 = icon1.getImage();
		JLabel l11 = new JLabel(icon, JLabel.CENTER);
		l11.setBounds(350,150,666,499);
		Image newimg1 = img1.getScaledInstance(l11.getWidth(), l11.getHeight(), Image.SCALE_SMOOTH);
		f.add(l11);
	}

	public static void main(String args[]) 
	{
		new login();
	}
}
