import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

/*

package hotelmanagement.Class;

import Connection.MySQLConnUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Duc
 * 
 */
public class room {
    private int id;
    private String number;
    private int price;
    private String type;
    private int status;
    
    public Connection connection = null;
	public PreparedStatement ptmt = null;
	public ResultSet resultSet = null;
	
	private Connection getConnection() throws SQLException{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
		}
    
    public room(){};
    
    public room(int id, String number, int price, String type, int status){
        this.id=id;
        this.number=number;
        this.price=price;
        this.type=type;
        this.status=status;
    }
 
    public ArrayList<room> RoomList(){
        ArrayList<room> list = new ArrayList<>();
        try{
        	
        	String queryString = "Select * from rooms;";
        	connection = getConnection();
        	ptmt = connection.prepareStatement(queryString);
            // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
        	resultSet = ptmt.executeQuery();
            
            // Duyệt trên kết quả trả về.
            while (resultSet.next()) {// Di chuyển con trỏ xuống bản ghi kế tiếp.
                int id = resultSet.getInt(1);
                String number = resultSet.getString(2);
                int price = resultSet.getInt(3); 
                String type = resultSet.getString(4);
                int status = resultSet.getInt(5);
                room room1 = new room(id, number, price, type, status);
                list.add(room1);
                System.out.println("id: " +resultSet.getInt("id") + "\nnumber: " + resultSet.getString("number") + "\nprice: " +resultSet.getInt("price")+"\ntype: " +resultSet.getString("type") +"\nstatus: " +resultSet.getInt("status"));
            }
            connection.close();
        } catch(Exception e){System.out.println(e);}
        return list;
    }
    public ArrayList<room> FilterRoom(){
    	ArrayList<room> list = new ArrayList<>();
    	try {
    		
    		 
			String queryString= "Select * from rooms where type LIKE 'queen' , price LIKE '500';";
			
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			resultSet = ptmt.executeQuery();
			
		//Duyệt trên kết quả trả về
			while(resultSet.next())
			{
				int id = resultSet.getInt(1);
                String number = resultSet.getString(2);
                int price = resultSet.getInt(3);
                String type = resultSet.getString(4);
                int status = resultSet.getInt(5);
                room room1 = new room(id, number, price, type, status);
                System.out.println("id: " +resultSet.getInt("id") + "\nnumber: " + resultSet.getString("number") + "\nprice: " +resultSet.getInt("price")+"\ntype: " +resultSet.getString("type") +"\nstatus: " +resultSet.getInt("status"));
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
		return null;
    	
    }
    public void changeStatus(String status){
      try{
    	  
         String queryString = "update rooms set status = "+status+" where id = "+this.getId()+";";
         connection = getConnection();
         ptmt = connection.prepareStatement(queryString);
         ptmt.executeUpdate(queryString);  
      } catch(Exception e){}  }
    public int getId(){
        return this.id;
    }
    public String getNumber(){
       return this.number;
    }
    public int getPrice(){
        return this.price;
    }
    public String getType(){
        return this.type;
    }
    public int getStatus(){
       return this.status;
    }
    
    public void setId(int id){
        this.id=id;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public void setPrice(int price){
        this.price=price;
    }
    public void setType(String type){
        this.type=type;
    }
    public void setStatus(int status){
        this.status=status;
    }
}