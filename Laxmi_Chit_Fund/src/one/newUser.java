package one;

import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Color;

public class newUser extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField newName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newUser frame = new newUser();//calling method which is a constructor. came from swing1
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
	  JButton btnNewButton = new JButton("Submit");
	public newUser() 
	{
		setBounds(100, 100, 483, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register new user here!!");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(133, 95, 239, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name (first_last) :");
		lblNewLabel_1.setBounds(44, 145, 104, 13);
		contentPane.add(lblNewLabel_1);
		//String newName;                                              //checking now
		newName = new JTextField();
		newName.setBounds(172, 142, 113, 19);
		contentPane.add(newName);
		newName.setColumns(10);
	   // JButton btnNewButton = new JButton("Submit 2");
		
		btnNewButton.setBounds(186, 171, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Laxmi Chit Fund");
		lblNewLabel_2.setForeground(new Color(47, 79, 79));
		lblNewLabel_2.setFont(new Font("Goudy Old Style", Font.BOLD, 31));
		lblNewLabel_2.setBounds(133, 10, 294, 51);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Since 2006");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(181, 60, 104, 13);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("*remember the registered name");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(152, 218, 261, 13);
		contentPane.add(lblNewLabel_3);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				NewUserDB nU = new NewUserDB(newName.getText());// calling one contructor for registering data into database
				
			}
		});
		
	}
}
class NewUserDB extends newUser
{
    NewUserDB(String name) //name is passed here
    {
    	
    	try 
		{
		   //first step : loading
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   
		   //second step :  connectivity to DB
		   Connection con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/fund","root","#WWWWWW");
		   
		   //thirdstep : type the sql query
		   
		   String first ="CREATE TABLE `fund`.`" ;
		   String between = first.concat(name); //between = first + name
		   String second ="` (`date_col` DATE NOT NULL,`emi` INT NOT NULL,`loan` INT NOT NULL);";
		   String query = between.concat(second);//query = between(first + name) + second;
		  // System.out.println(query);
		   
		   PreparedStatement ps = con.prepareStatement(query);
		  // PreparedStatement gs = con.prepareStatement("SELECT table_name FROM information_schema.tables WHERE table_schema = 'fund' AND table_name = '"+name+"';");

		    int i = ps.executeUpdate();//this method works for insert create delete update. here i gave value in 0(failed) or 1(passed)
		    if(i>=0)
		    {
		    	
		    	//System.out.println("Successfully added");
		    	JOptionPane.showMessageDialog(null,"Successfully added "+name );
		    }
		    else
		    {
		    	System.out.println("Some error occured");
		    }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
    	
    	
    	
    }
}
