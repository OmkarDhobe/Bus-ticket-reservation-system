
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class customer extends JFrame implements ActionListener
{
    //declaration

   JLabel l1,l2,l3,l4;
   JTextField t1,t2,t3,t4;
   JButton b1,b2,b3,b4,b5;
   Font f;

    //this is for sql connectivity and CRUD operations
   Connection cn;    
   PreparedStatement prstm;
  Statement stm;
   String sql;
   ResultSet rs;

   customer()
   {
    setTitle("Student informationform");
    setSize(460,460);
    setLocation(400,150);
    setLayout(null);
    setVisible(true);

    //memory allocation
    l1=new JLabel("Customer ID");
    l2=new JLabel("Customer Name");
    l3=new JLabel("Customer Address");
    l4=new JLabel("Customer contact");
    
    b1=new JButton("Insert");
    b2=new JButton("update");
    b3=new JButton("Delete");
    b4=new JButton("clear");
    b5=new JButton("Exit");
    
    f=new Font("Arial",Font.BOLD,20);
    l1.setFont(f); l2.setFont(f); l3.setFont(f); l4.setFont(f);
    t1=new JTextField();
    t2=new JTextField();
    t3=new JTextField();
    t4=new JTextField();
     //add components on frame
    add(l1); add(l2); add(l3); add(l4);
    add(t1); add(t2); add(t3); add(t4);
    add(b1); add(b2); add(b3); add(b4); add(b5);
    
    //location on frame
    l1.setBounds(10,70,200,30);
    t1.setBounds(230,70,200,30);
    l2.setBounds(10,120,200,30);
    t2.setBounds(230,120,200,30);
    l3.setBounds(10,170,200,30);
    t3.setBounds(230,170,200,30);
    l4.setBounds(10,220,200,30);
    t4.setBounds(230,220,200,30);
    b1.setBounds(10,270,200,30);
    b2.setBounds(230,270,200,30);
    b3.setBounds(10,320,200,30);
    b4.setBounds(230,320,200,30);
   b5.setBounds(10,370,200,30);

    try
    {
         cn=DriverManager.getConnection("jdbc:mysql:///om","root","");
    }
    catch(Exception e)
     {
        e.printStackTrace();
     }

    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
	b5.addActionListener(this);

	  addWindowListener(new WindowAdapter()
	  {
		  public void windowClosing(WindowEvent e)
		  {
			  dispose();
		  }
	  });
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }//constructor of student close
   public void actionPerformed(ActionEvent e)
   {
       try
       {
			  if(e.getSource()==b1)
			  {
				sql="insert into customer values("+t1.getText()+",'"
				+t2.getText()+"','"+t3.getText()+"',"+t4.getText()+")";
				prstm=cn.prepareStatement(sql);
				prstm.execute();
				//prstm.close();
				JOptionPane.showMessageDialog(null, "Record inserted successfully");
			  }
			  if(e.getSource()==b2)
			  {
				 sql = "update customer set cname='" +t2.getText()+"', adr='"
					+t3.getText()+"', con="+t4.getText()+" where cid = "+t1.getText();
					prstm = cn.prepareStatement(sql);
					prstm.execute() ;
					prstm.close();
					JOptionPane.showMessageDialog(null, "Record Updated Successfully");
			  }//end of b2
				if(e.getSource() == b3)
				{
					sql = "delete from customer where cid ="+t1.getText();
					prstm = cn.prepareStatement(sql);
					prstm.execute() ;
					prstm.close();
					JOptionPane.showMessageDialog(null, "Record Deleted Successfully !!!");
			  }//end of b3
			  if(e.getSource()==b4)
			  {
				  t1.setText("");
				  t2.setText("");
				  t3.setText("");
				  t4.setText("");
				  t1.requestFocus();
			  }//end of b4
			  if(e.getSource() == b5)
              dispose();
        }     
        catch(Exception ee)
        {
           ee.printStackTrace();
        }
        
   }//End of actionPerformed method
  
   

   public static void main(String args[])
   {
    new customer();
   }
}//End of student class