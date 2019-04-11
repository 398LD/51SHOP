package com.mingrisoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	private final String url="jdbc:sqlserver://localhost:1433; DatabaseName=News";
	private final String user="sa";
	private final String pwd="123";
	Connection con=null;
	public BaseDao() {
		// TODO 自动生成的构造函数存根
		try {
			 con = DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	PreparedStatement ps =null;
	 ResultSet rs=null;
	 //执行查询
	public ResultSet Find(String sql,Object...o) {
		try {
			 ps = con.prepareStatement(sql);
			 if(o.length==0) {
				  rs = ps.executeQuery();
			 }else {
				for (int i = 0; i < o.length; i++) {
					ps.setObject(i+1,o[i]);
				}
				rs=ps.executeQuery();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	//执行增删改
	public boolean Update(String sql,Object...o) {
		int  count=0;
		try {
			 ps = con.prepareStatement(sql);
			 if(o.length==0) {
				 count = ps.executeUpdate();
			 }else {
				for (int i = 0; i < o.length; i++) {
					ps.setObject(i+1,o[i]);
				}
			count=ps.executeUpdate();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if (count>0) {
			return true;
		}else {
			return false;
		}
	}
	//关闭连接
	public void close() {
		try {
			if (ps!=null) {
				ps.close();
			}
			if (con!=null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
//	public static void main(String[] args) throws SQLException {
//		BaseDao baseDao=new BaseDao();
//		ResultSet rs = baseDao.Find("select *from News");
//		while (rs.next()) {
//			System.out.println(rs.getString(1));
//		}
//	}
}
