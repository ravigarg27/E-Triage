package com.ravi.Final;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Final {

    public static void main(String [] args) throws Exception{
        String dept=args[0];
        String lat1=args[1];
        String lon1=args[2];
        String ra=args[3];
        if(ra.equals("yes"))
          dept="orthopedist";
        double lat_p=Double.parseDouble(lat1);
        double lon_p=Double.parseDouble(lon1);
        double dist=Double.MAX_VALUE;
        String final_name="";
        String final_location="";
        Class.forName("com.mysql.jdbc.Driver") ;
        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Heisenbug", "root", "r") ;
        Statement stmt = (Statement) conn.createStatement() ;
        //String query = "select name,location,latitude,longitude from DOCTORS where specialization='orthopedist';";
        PreparedStatement prepStmt = (PreparedStatement) conn.prepareStatement( "select name,location,latitude,longitude from DOCTORS where specialization=?;");
        prepStmt.setString(1, dept);
        ResultSet rs = prepStmt.executeQuery() ;
         while (rs.next()) {
                  String name = rs.getString("name");
                  String location = rs.getString("location");
                  Double lat = rs.getDouble("latitude");
                  Double lon = rs.getDouble("longitude");
                  double dist_n=Math.pow((Math.pow(lat-lat_p,2) + Math.pow(lon-lon_p,2)),0.5);
                  if(dist_n<dist){
                    dist=dist_n;
                    final_name=name;
                    final_location=location;
                  }
         }
         System.out.println(final_name+" | "+final_location+" | "+Math.floor(dist*1000)+"m");
      }
}
