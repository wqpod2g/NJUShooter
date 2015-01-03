package iip.dao;

import iip.util.OurConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * 数据库操作
 * @author wangqiang
 * @since 2015-1-3
 */
public class SubDao {
	
	 public ArrayList<String> select(String query_words) {
		 ArrayList<String>sub_list=new ArrayList<String>();
		 try{
			 Connection conn=OurConnection.getConn();
			 String sql = "select * from shooter where FilePath LIKE '%"+query_words+"%'";
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 sub_list.add(rs.getString(1));
			 }
			 
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	
		 return sub_list;
	 }

}
