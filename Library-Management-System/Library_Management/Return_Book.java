package Library_Management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.*;

public class Return_Book implements ActionListener {
	JFrame f;
	JButton l1, l2, l3, l4, l5;
	JButton b1, back;
	JTextField t1, t2, t3;
	int i;

	public Return_Book() {
		f = new JFrame("Return Details");
		f.setLayout(null);
		f.setVisible(true);
		f.setBounds(600, 200, 550, 500);
		

		
		l5 = new JButton("RETURN BOOK DETAILS");
		l5.setBounds(100, 30, 350, 30);
		l5.setBackground(Color.pink);
		l5.setForeground(Color.black);
		Font myfont = new Font(null, Font.BOLD, 25);
		l5.setFont(myfont);
		f.add(l5);

		l1 = new JButton("User ID");
		l1.setEnabled(false);
		l1.setBackground(Color.WHITE);
		l1.setForeground(Color.RED);
		l1.setBounds(100, 100, 100, 30);
		f.add(l1);

		l2 = new JButton("Book ID");
		l2.setEnabled(false);
		l2.setBackground(Color.WHITE);
		l2.setForeground(Color.RED);
		l2.setBounds(100, 150, 100, 30);
		f.add(l2);

		l3 = new JButton("Return Date");
		l3.setEnabled(false);
		l3.setBackground(Color.WHITE);
		l3.setForeground(Color.RED);
		l3.setBounds(100, 200, 100, 30);
		f.add(l3);

		t1 = new JTextField();
		t1.setBounds(220, 100, 200, 30);
		f.add(t1);

		t2 = new JTextField();
		t2.setBounds(220, 150, 200, 30);
		f.add(t2);

		t3 = new JTextField();
		t3.setBounds(220, 200, 200, 30);
		f.add(t3);

		b1 = new JButton("Return");
		b1.setVisible(true);
		b1.setBounds(300, 300, 120, 30);
		b1.addActionListener(this);
		b1.setBackground(Color.cyan);
		f.add(b1);

		back = new JButton("Back");
		back.setVisible(true);
		back.setBounds(100, 300, 120, 30);
		back.addActionListener(this);
		back.setBackground(Color.cyan);
		f.add(back);
		
		ImageIcon icon = new ImageIcon("F:\\AJP programs\\Swing\\SwingProjects\\src\\Library_Management\\return1.jpg");
		Image img = icon.getImage();
		JLabel l22 = new JLabel(icon, JLabel.CENTER);
		l22.setBounds(00, 00, 1200, 600);
		Image newimg = img.getScaledInstance(l22.getWidth(), l22.getHeight(), Image.SCALE_SMOOTH);
		f.add(l22);

	}

	public static void main(String[] args) {
		new Return_Book();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == back) {
			new Library_Management.User_List_Page();
			f.setVisible(false);
		}
		if (e.getSource() == b1) {
			returnBook();
		}

	}

	public void returnBook() {

		if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please Fill All Details", "ERROR", JOptionPane.ERROR_MESSAGE);
		} else {

			try {
				DbConnection db = new DbConnection();

				PreparedStatement ps = db.con.prepareStatement(String.format(
						"insert into returnbook values('%s','%s','%s')", t1.getText(), t2.getText(), t3.getText()));

				i = ps.executeUpdate();

				if (i == 1) {
					JOptionPane.showMessageDialog(null, "Book Return Successfully");
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				e.printStackTrace();
			}
		}

	}

}