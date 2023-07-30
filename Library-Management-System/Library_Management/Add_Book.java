package Library_Management;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.*;

public class Add_Book implements ActionListener {
	JFrame f;
	JButton b1, b2, b3, b4, b5;
	JButton submit, back;
	JTextField t1,t4, t2, t3;
	int i;

	Add_Book()
	{
		f=new JFrame("Add New Book"); 
		f.setBounds(600, 300, 200, 400);
		
		
		
		b1=new JButton("ADD BOOK DETALIS");
		b1.setBounds(80,30,400,30);
		Font f12 = new Font("Times New Roman",Font.BOLD,20);
		b1.setFont(f12);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		f.add(b1);
		
		b2=new JButton("B_ID");
		b2.setEnabled(false);
		b2.setBackground(Color.WHITE);
		b2.setForeground(Color.RED);
		b2.setBounds(100,100,100,30);
		f.add(b2);
		
		b3=new JButton("Book Name");
		b3.setEnabled(false);
		b3.setBackground(Color.WHITE);
		b3.setForeground(Color.RED);
		b3.setBounds(100,150,100,30);
		f.add(b3);
		
		b4=new JButton("Author");
		b4.setEnabled(false);
		b4.setBackground(Color.WHITE);
		b4.setForeground(Color.RED);
		b4.setBounds(100,200,100,30);
		f.add(b4);
		
		b4=new JButton("Price");
		b4.setEnabled(false);
		b4.setBackground(Color.WHITE);
		b4.setForeground(Color.RED);
		b4.setBounds(100,250,100,30);
		f.add(b4);
		
		t1=new JTextField();
		t1.setVisible(true);
		t1.setBounds(300,100,150,25);
		f.add(t1);
		
		t2=new JTextField();
		t2.setVisible(true);
		t2.setBounds(300,150,150,25);
		f.add(t2);
		
		t3=new JTextField();
		t3.setVisible(true);
		t3.setBounds(300,200,150,25);
		f.add(t3);
		
		t4=new JTextField();
		t4.setVisible(true);
		t4.setBounds(300,250,150,25);
		f.add(t4);
		
		submit=new JButton("Submit");
		submit.setVisible(true);
		submit.setBounds(200,320,100,30);
		f.add(submit);
		
		submit.addActionListener(this);
		
		
		back=new JButton("Back To Home Page");
		back.setVisible(true);
		back.setBounds(350,320,150,30);
		
		f.add(back);
		
		back.addActionListener(this);

		f.setSize(600,400);  
		f.setLayout(null);    
		f.setVisible(true);    
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
//		ImageIcon icon = new ImageIcon("G:\\AJP programs\\Library-Management-System\\add1.jpg");
//		Image img = icon.getImage();
//		JLabel l22 = new JLabel(icon, JLabel.CENTER);
//		l22.setBounds(00, 00, 700, 570);
//		Image newimg = img.getScaledInstance(l22.getWidth(), l22.getHeight(), Image.SCALE_SMOOTH);
//		f.add(l22);
		
		
	}

	public static void main(String[] args) {
		new Add_Book();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == back)
		{
			new User_List_Page();
			f.setVisible(false);
		}
		if(e.getSource()==submit)
		{
			addBook();
		}

	}
	
	
	public void addBook()
	{
		try {
			
			if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Please Fill All Details","ERROR", JOptionPane.ERROR_MESSAGE);
				
			}
			else {
				
				DbConnection db = new DbConnection();

				int price = Integer.valueOf(t4.getText());
				PreparedStatement ps = db.con.prepareStatement(String.format("insert into addbook values('%s','%s','%s',%d)",t1.getText(),t2.getText(),t3.getText(),price));
				
				i = ps.executeUpdate();

				if(i==1)
				{
					JOptionPane.showMessageDialog(null, "Book Added Successfully" );
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
				}
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage() );
		}
	}
}