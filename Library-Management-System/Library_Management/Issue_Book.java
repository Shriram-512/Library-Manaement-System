package Library_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.*;

public class Issue_Book implements ActionListener {

	JFrame f;
	JButton l1, l2, l3, l4, l5;
	JButton b, back;
	JTextField t1, t2, t3, t4;
	int i;
	JPasswordField pd;
	
	public Issue_Book() {
		f = new JFrame("Enter Details");
		f.setBounds(600, 200, 550, 500);
		f.setLayout(null);

		f.setVisible(true);


		
		l5=new JButton("ISSUE BOOK DETALS");
		l5.setBounds(100, 30, 350, 30);
		Font f12 = new Font("Times New Roman",Font.BOLD,20);
		l5.setFont(f12);
		l5.setBackground(Color.black);
		l5.setForeground(Color.white);
		f.add(l5);
		
		

		l1 = new JButton("Book ID(BID)");
		l1.setEnabled(false);
		l1.setBackground(Color.WHITE);
		l1.setForeground(Color.RED);
		l1.setBounds(100, 100, 120, 30);
		f.add(l1);

		l3 = new JButton("User ID(UID)");
		l3.setEnabled(false);
		l3.setBackground(Color.WHITE);
		l3.setForeground(Color.RED);
		l3.setBounds(100, 150, 120, 30);
		f.add(l3);

		l2 = new JButton("Period(days)");
		l2.setEnabled(false);
		l2.setBackground(Color.WHITE);
		l2.setForeground(Color.RED);
		l2.setBounds(100, 200, 120, 30);
		f.add(l2);

		l4 = new JButton("Issued Date");
		l4.setEnabled(false);
		l4.setBackground(Color.WHITE);
		l4.setForeground(Color.RED);
		l4.setBounds(100, 250, 120, 30);
		f.add(l4);

		t1 = new JTextField();
		t1.setVisible(true);
		t1.setBounds(250, 100, 200, 30);
		f.add(t1);

		t2 = new JTextField();
		t2.setVisible(true);
		t2.setBounds(250, 150, 200, 30);
		f.add(t2);

		t3 = new JTextField();
		t3.setVisible(true);
		t3.setBounds(250, 200, 200, 30);
		f.add(t3);

		t4 = new JTextField();
		t4.setVisible(true);
		t4.setBounds(250, 250, 200, 30);
		f.add(t4);

		b = new JButton("SUBMIT");
		b.setVisible(true);
		b.setBounds(300, 350, 100, 30);
		b.addActionListener(this);
		f.add(b);

		back = new JButton("Back");
		back.setVisible(true);
		back.setBounds(100, 350, 100, 30);
		back.addActionListener(this);
		f.add(back);
		
		ImageIcon icon = new ImageIcon("F:\\AJP programs\\Swing\\SwingProjects\\src\\Library_Management\\issue.jpg");
		Image img = icon.getImage();
		JLabel l22 = new JLabel(icon, JLabel.CENTER);
		l22.setBounds(00, 00, 1200, 600);
		Image newimg = img.getScaledInstance(l22.getWidth(), l22.getHeight(), Image.SCALE_SMOOTH);
		f.add(l22);


	}

	public static void main(String[] args) {
		new Issue_Book();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == back)
		{
			new Library_Management.User_List_Page();
			f.setVisible(false);
		}
		if(e.getSource()==b)
		{
			issueBook();
		}
		
	}
	
	public void issueBook()
	{
		try 
		{
			if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() )
			{
				
				JOptionPane.showMessageDialog(null, "Please Fill All Details","ERROR", JOptionPane.ERROR_MESSAGE);
				
			}
			else 
			{
				DbConnection db = new DbConnection();
				
				PreparedStatement ps = db.con.prepareStatement(String.format("insert into issuebook values('%s','%s','%s','%s')", t1.getText(),t2.getText(),t3.getText(),t4.getText()));
				
				i =ps.executeUpdate();						
				
			}
			if(i==1)
			{
				JOptionPane.showMessageDialog(null, "Book Issued Successfully");
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
			}
			
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();
		}
		
	}

}




