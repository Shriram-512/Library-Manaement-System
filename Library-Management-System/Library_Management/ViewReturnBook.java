package Library_Management;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewReturnBook {
JFrame f;

	public ViewReturnBook() {

		f = new JFrame("Table Example");
		f.setVisible(true);
		f.setBounds(400,200,650,500);

           String[][] data = new String[100][3] ;
		

		try {
			
			DbConnection db = new DbConnection();
			

			String str = "Select * from returnbook ";
			
			Statement st = db.con.createStatement();

			ResultSet rs = st.executeQuery(str);
			int i=0;

			while(rs.next())
			{
				String[]  d1 = new String[100];
				d1[0]=rs.getString(1);
				d1[1]=rs.getString(2);
				d1[2]=rs.getString(3);
				
				
				data[i][0]=d1[0];
				data[i][1]=d1[1];
				data[i][2]=d1[2];
			
				i=i+1;
				
		
			}
			
		}
		
				
		catch (Exception e1) {
			e1.printStackTrace();

		}
		String column[] = {"BID", "UID", "RETURN DATE"};
		
		JTable t = new JTable(data, column);
		t.setBounds(30, 40, 200, 300);
		JScrollPane p = new JScrollPane(t);
		f.add(p);

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ViewReturnBook();
	}

}
