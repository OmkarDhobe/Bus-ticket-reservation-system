
import javax.swing.*;
import java.sql.*;
class custReport extends JFrame
{
    String colHeads[] = { "Customer id", "Customer Name", "Address","Contact" };
    String data[][];
    JTable table;

    Connection cn;    Statement stm;
    ResultSet rs;    int r_cnt=0,i;

    custReport()
    {
        super("Table & DB Connectivity");
        setSize(300,200);
        setLocation(250,250);

        try
        {
            cn = DriverManager.getConnection("jdbc:mysql:///om","root", "");
            stm = cn.createStatement();
            rs = stm.executeQuery("select count(*) from customer");
            rs.next();
            r_cnt=rs.getInt(1);

            data = new String[r_cnt][4];

            rs = stm.executeQuery("select * from customer order by cid");
            while (rs.next())
            {
                data[i][0]= rs.getString(1);                
				data[i][1]= rs.getString(2);
                data[i][2]= rs.getString(3);
                data[i][3]= rs.getString(4);
                i++;
            }
            table = new JTable(data, colHeads);
            table.setEnabled(false);
            int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
            int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
            JScrollPane jsp = new JScrollPane(table, v, h);
            add(jsp);
        }
        catch (Exception e) 
		{            
			e.printStackTrace();        
		}

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[])
    {
        new custReport();
    }
}