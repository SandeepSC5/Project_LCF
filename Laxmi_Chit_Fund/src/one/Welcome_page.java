package one;

import java.awt.Button;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import java.awt.TextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;

public class Welcome_page extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try {
					Welcome_page frame = new Welcome_page();
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
	public Welcome_page() 
	{
		setForeground(new Color(255, 245, 238));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 247);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(224, 255, 255));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Laxmi Chit Fund");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setBounds(233, 10, 262, 28);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setFont(new Font("Goudy Old Style", Font.BOLD, 31));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Are you a/an..");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(298, 70, 103, 28);
		contentPane.add(lblNewLabel_1);
		
		
		
		JRadioButton rbnew = new JRadioButton("New User"); //button 1
		rbnew.setForeground(new Color(128, 0, 0));
		rbnew.setSelected(true);
		
		
		rbnew.setFont(new Font("Arial Black", Font.PLAIN, 12));
		rbnew.setBounds(158, 113, 103, 21);
		contentPane.add(rbnew);
		
		JRadioButton rbexis = new JRadioButton("Existing User"); //button 2
		rbexis.setForeground(new Color(34, 139, 34));
		rbexis.setSelected(true);
		
		
		//for creating button group
		ButtonGroup group = new ButtonGroup();
		group.add(rbnew);
		group.add(rbexis);
		rbexis.setFont(new Font("Arial Black", Font.PLAIN, 12));
		rbexis.setBounds(441, 113, 138, 21);
		contentPane.add(rbexis);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rbexis.isSelected())
				{
				//System.out.println("I am inmain of swing1");
				existingUser eU = new existingUser();
				eU.main(null);
				}
				else
				{
					newUser nU= new newUser();
					nU.main(null);
				}
				
			}
		});
		btnNewButton.setBounds(305, 163, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("In your service since 2006");
		lblNewLabel_2.setForeground(new Color(47, 79, 79));
		lblNewLabel_2.setBounds(269, 47, 149, 13);
		contentPane.add(lblNewLabel_2);
	}
}
