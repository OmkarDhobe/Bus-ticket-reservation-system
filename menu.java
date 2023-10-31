
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class menu extends JFrame implements ActionListener
{
	JMenuBar mbr;
	JMenu m1,m2,m3;
	JMenuItem mi1,mi2;
	JLabel l1;
	Font f;

	menu()
	{
		super(" Bus Ticket Reservation System");
		setSize(650,600);
		setLocation(300,20);
		setLayout(null);

		l1 = new JLabel(new ImageIcon("dos.jpg"));
		add(l1);
		l1.setBounds(0,0,650,600);


		f=new Font("Arial",Font.BOLD,30);
	
		mbr = new JMenuBar();
		m1 = new JMenu("Home");
		//m2)for student menuitem handle
		m2 = new JMenu("Ticket");
		//m3)for test menuitem handle
		m3 = new JMenu("Report");
	
        //m1)student from		
		mi1=new JMenuItem("TicketForm");
		//m3)for test menuitem handle
		mi2=new JMenuItem("Report");
			
		//mi5=new  JMenuItem("Report studproject");		

		m2.add(mi1);
		m3.add(mi2);	
		mbr.add(m1);
		mbr.add(m2);
		mbr.add(m3);
		add(mbr);

		mbr.setBounds(0,0,650,20);
		m1.addActionListener(this);
		m2.addActionListener(this);
		m3.addActionListener(this);
		
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}//menu constructor close
	
     public void actionPerformed(ActionEvent e)
	 {
		if(e.getSource()==mi1)
		{
			new customer();
			System.out.println("Student");
		}	
		if(e.getSource()==mi2)
		{
            new custReport();			
			System.out.println("Test");
		}
	 }	
    //main method for menu
	public static void main(String args[])
	{
		new menu();
	}
}


