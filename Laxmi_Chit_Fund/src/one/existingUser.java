package one;
import java.sql.*;



import java.util.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.Component;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class existingUser extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emi;
	private JTextField loan;
	private JTextField tarik;
	private JTable table2;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					existingUser frame = new existingUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
// created Frame	
	public existingUser() 
	{
		setTitle("Existing User Entry form");
		setForeground(new Color(102, 255, 153));
		setBounds(100, 100, 719, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Since 2006");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(338, 60, 104, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Laxmi Chit Fund");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.BOLD, 31));
		lblNewLabel.setBounds(259, 10, 294, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Existing User");
		lblNewLabel_2.setForeground(new Color(0, 128, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(327, 84, 104, 26);
		contentPane.add(lblNewLabel_2);
		
//labels
		JLabel nameL = new JLabel("Name :");
		nameL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameL.setBounds(88, 141, 85, 13);
		contentPane.add(nameL);
		
		JLabel emiL = new JLabel("EMI amount : ");
		emiL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emiL.setBounds(88, 194, 114, 13);
		contentPane.add(emiL);
		
		JLabel loanL = new JLabel("Loan Amount : ");
		loanL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loanL.setBounds(88, 244, 126, 13);
		contentPane.add(loanL);
		
		JLabel tarikL = new JLabel("Date (YYYY/MM/DD) : ");
		tarikL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tarikL.setBounds(88, 296, 147, 13);
		contentPane.add(tarikL);
		
		String x[]= {"deepak", "surya"};
		
		
//textfields
		emi = new JTextField();
		emi.setBounds(245, 193, 104, 19);
		contentPane.add(emi);
		emi.setColumns(10);
		
		loan = new JTextField();
		loan.setBounds(245, 243, 96, 19);
		contentPane.add(loan);
		loan.setColumns(10);
		
		tarik = new JTextField();
		tarik.setBounds(245, 295, 96, 19);
		contentPane.add(tarik);
		tarik.setColumns(10);
		
		name = new JTextField();
		name.setBounds(245, 140, 96, 19);
		contentPane.add(name);
		name.setColumns(10);
		
//table to get the values from DB
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(610, 404, 0, 0);
		contentPane.add(list);
		
		
		JLabel nameLableList = new JLabel("Existing member List: ");
		nameLableList.setBounds(475, 116, 140, 13);
		contentPane.add(nameLableList);

		
//--------------------------------------------------------------------------------------------------------------------------------------				
// when Get List pressed
//will fetch existing user list from db
		
		JButton update_exisB = new JButton("Refresh List");
		update_exisB.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				
				ArrayList<String> sqllist = new ArrayList<>();
				
				try
				{
				//loading the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//getting the connection
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/fund", "root", "WWWWWWWW");
				
				//making query
				PreparedStatement ps = con.prepareStatement("SELECT TABLE_NAME From INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'fund'");
				
				//-----------------------------------------------------------------------------------------
				//Result set is used here as it will get the data
				
						ResultSet rs = ps.executeQuery();
						int i = 0;
		
						while(rs.next())
						{
							
							sqllist.add(rs.getString("TABLE_NAME"));
							
							i++;
						}
						
				//------------------------------------------------------------
						
				rs.close();
				ps.close();
				con.close();
			}
			catch(Exception f)
			{
					System.out.println(f);
					f.printStackTrace();
			}
//---------------------------------------------------------------------------------------------------------------------------------
				
				for(String sqllistF : sqllist) //for each loop
				{
					//System.out.println("now its with variable - "+sqllistF);
					DefaultTableModel table1 =(DefaultTableModel)table2.getModel();
					table1.addRow(new Object[]{sqllistF});
				}
				
				//JOptionPane.showMessageDialog(null, "Updated Successfully");
				
							
			table2 = new JTable();        
				table2.addMouseListener(new MouseAdapter() 
				
				{
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						DefaultTableModel table3 =(DefaultTableModel)table2.getModel();
						String tableName = table3.getValueAt(table2.getSelectedRow(), 0).toString();
						
						name.setText(tableName);
						
					}
				});			
			}
		});
		update_exisB.setBounds(475, 139, 104, 21);
		contentPane.add(update_exisB);
		
		JLabel lblNewLabel_3 = new JLabel("*updated list");
		lblNewLabel_3.setBounds(475, 395, 104, 13);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(475, 170, 104, 215);
		contentPane.add(scrollPane);
//--------------------------------------------------------------------------------------------
		table2 = new JTable();
		scrollPane.setViewportView(table2);
		table2.setPreferredScrollableViewportSize(new Dimension(450, 400));
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name"
			}
		));
		
		
		
//--------------------------------------------------------------------------------------------------------------------
//here sending Existing user data to database to add the latest entry
		
		JButton submitExis = new JButton("Submit");
		submitExis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				String emig = emi.getText();
				String loang = loan.getText();
				//System.out.println("I am going for db now with: "+name.getText()+Integer.parseInt(emig)+Integer.parseInt(loang)+ tarik.getText());
				
				//sending it to db
				existingUser eU = new existingUser();
				eU.ExisUserDB(name.getText(),Integer.parseInt(emig),Integer.parseInt(loang), tarik.getText());
				
			}
		});
		submitExis.setBounds(191, 383, 85, 21);
		contentPane.add(submitExis);
		
			
	}

// Existing user new entry gets processed here
	
	void ExisUserDB(String name, int emi, int loan, String tarik)
	{
		try
		{
			 //first step : loading
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   
			   //second step :  connectivity to DB
			   Connection con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/fund","root","WWWWWWWW");
			  
			   //third step to form query
			   String query = "insert into fund."+name+ " values(\""+tarik+"\", "+emi+", "+loan+")";
			   //System.out.println(query);
			   
		       PreparedStatement p1 = con.prepareStatement(query);
		        int i = p1.executeUpdate();
		        if(i>0)
		        {
		        //	System.out.println("Entry done");
		        	JOptionPane.showMessageDialog(null,"Successfully added "+name );
		        }
		        else
		        {
		        	//System.out.println("Failed to enter the data!");
		        	JOptionPane.showMessageDialog(null,"Failed "+name );
		        	
		        }
		        
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
		
		
		
}

