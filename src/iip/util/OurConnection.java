package iip.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class is used for 
 * 
 * @version 1.0, 2012-3-20 
 * @author  wangqiang
 **/

public class OurConnection {
	private static Connection conn = null;
	private static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
 	private static final String DBURL = "jdbc:mysql://114.212.83.18:3306/wqtest" ;
	private static final String DBUSER = "root" ;
	private static final String DBPASSWORD = "1234" ;

	public static Connection getConn() {
		try {
			Class.forName(DBDRIVER).newInstance();
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
