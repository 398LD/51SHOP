package com.mingrisoft;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Users;

public class UsersDao {
	public static Users SerichByNameAndPwd(String user,String pwd) {
		//根据用户名和密码查询
		String sql="select * from Users where AdminName=? and AdminPwd=?";
		BaseDao dao=new BaseDao();
		ResultSet rs = dao.Find(sql,user,pwd);
		Users users=null;
		try {
			if (rs.next()) {
				//存在一个用户
				 users=new Users();
				users.setAdminName(rs.getString("AdminName"));
				
			}else {
				user=null;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			
			
			e.printStackTrace();
		}
		return users;
	}
	public static ArrayList<Users> serichAllUsers() {
		//查询所有用户
		String sql="select * from Users";
		BaseDao dao=new BaseDao();
		ResultSet rs = dao.Find(sql);
		ArrayList<Users> list=new ArrayList();
		try {
			while (rs.next()) {
				Users users=new Users();
				users.setAdminID(rs.getInt("AdminID"));
				users.setAdminName(rs.getString("AdminName"));
				users.setAdminPwd(rs.getString("AdminPwd"));
				users.setLastLoginTime(rs.getString("LastLoginTime"));
				list.add(users);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}
}
