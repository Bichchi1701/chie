/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Duc
 * 
 */
public class customer extends User {
    
    public customer(){}
    
    public customer(int id, String name, String password, String email,String fullname, String role){
        super(id, name, password, email, fullname, role);
    }
    public static Connection connection = null;
   	public static PreparedStatement ptmt = null;
   	public ResultSet resultSet = null;
   	
   	private static Connection getConnection() throws SQLException{
   		Connection conn;
   		conn = ConnectionFactory.getInstance().getConnection();
   		return conn;
   		}
    public void book(){
        try{
            connection = getConnection();                 
            Statement statement = connection.createStatement();
            Scanner keyboard = new Scanner(System.in);
            
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");  
            String regex="\\d?\\d\\D+\\d?\\d\\D+\\d\\d\\d\\d";
            System.out.println("\n========================");
            System.out.println("Booking menu");
            boolean error=false;
            
            String inDate, outDate;
            do{
                System.out.print("Input check-in date: ");
                inDate=keyboard.nextLine();

                if(inDate.matches(regex)){
                    String[] parts = inDate.split("(\\D+)");
                     inDate = parts[2] + "-" + parts[1]+ "-"+ parts[0];
                } else {
                    System.out.println("Wrong date format. Please retry.");
                    error=true;
                }
                
                System.out.print("Input check-out date: ");
                outDate=keyboard.nextLine();

                if(outDate.matches(regex)){
                    String[] parts = outDate.split("(\\D+)");
                    outDate = parts[2] + "-" + parts[1]+ "-"+ parts[0];
                } else {
                    System.out.println("Wrong date format. Please retry.");
                    error=true;
                }
            } while(error);
            
            String type="";
            System.out.println("Choose a type of room:");
            System.out.println("1/ King-sized");
            System.out.println("2/ Queen-sized");
            System.out.println("3/ Suite");
            System.out.println("4/ Any");
            System.out.print("Your choice: ");
            int inType=keyboard.nextInt();
            switch(inType){
                case 1: type="king"; break;
                case 2: type="queen"; break;
                case 3: type="suite"; break;
                default: type="*"; break;
            }
            
            System.out.println("\n========================");
            System.out.println("Available rooms from "+inDate+ " to " + outDate);
            System.out.println("N---Number---Price---Type---Status");
            
            book book = new book();
            int t=0;
            for(room room1 : book.showAvailableRoom(inDate, type)){;
                t+=1;
                System.out.println(t+"---"+room1.getNumber()+"-------"+room1.getPrice()+"----"+room1.getType()+"---"+room1.getStatus());
            }
            int inInt=0;
            String input="";
            do {
                error=false;
                System.out.print("Choose the number of the room you want to book: ");
                input= keyboard.nextLine();
                
                if(input.matches("\\d+")){
                     inInt= Integer.valueOf(input)-1;
                     if(inInt<0||inInt>=t){
                        error=true;
                        System.out.println("Please enter a number on the list.");
                     }
                } else { error=true;
                    System.out.println("Please enter a number.");}
            }while(error);
            
            room room2 = book.showAvailableRoom(inDate, type).get(inInt);
            String sql="insert into book(idUser, idRoom, dateIn, dateOut) values("+this.getId()+", "+room2.getId()+", '"+inDate+"', '"+outDate+"');";
            try{
                statement.executeUpdate(sql);
                System.out.println("Booking successful");
                System.out.println("Personal Information");
                
                System.out.println("id: "+User.user.getFullname()+ "Email: "+User.user.getEmail());
                
            }catch(Exception e){System.out.println("Update failure");}
                
            connection.close();
        }
        catch(Exception e){System.out.println(e);}
    }
}