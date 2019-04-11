package com.mingrisoft;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entity.En_News;

public class News {
	//分页查询新闻
	public static ArrayList<En_News> QueryByPage(int page) {
		String sql="select top 5 * from news where NewsID not in(select top(5*("+page+"-1)) NewsID from news)";
		BaseDao bs=new BaseDao();
		ResultSet rs = bs.Find(sql);
		ArrayList<En_News> list=new ArrayList();
		
		try {
			while (rs.next()) {
				En_News en_News=new En_News();
				en_News.setNewsID(rs.getInt("NewsID"));
				en_News.setNewsTitle(rs.getString("NewsTitle"));
				en_News.setNewsContent(rs.getString("NewsContent"));
				en_News.setNewsTime(rs.getString("NewsTime"));
				en_News.setAdminName(rs.getString("AdminName"));
				list.add(en_News);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
			
		}
		return list;
	}
	//根据id查详情
	public static En_News QueryNewsByID(int id) {
		BaseDao dao=new BaseDao();
		String sql="select * from news where NewsID=?";
		ResultSet rs = dao.Find(sql,id);
		En_News news=null;
		try {
			if (rs.next()) {
				news=new En_News();
				news.setNewsTitle(rs.getString("NewsTitle"));
				news.setNewsContent(rs.getString("NewsContent"));
			}else {
				news=null;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return news;   
	}
	public static boolean addNews(En_News news) {
		//添加新闻
		BaseDao dao=new BaseDao();
		String sql="insert into news(NewsTitle,NewsContent,NewsTime,AdminName) values(?,?,?,?)";
		boolean b = dao.Update(sql,news.getNewsTitle(),news.getNewsContent(),news.getNewsTime(),news.getAdminName());//记得传参
		return b?true:false;
	}
	public static boolean delNews(String newsID) {
		//删除新闻	
		BaseDao dao=new BaseDao();
		String sql="delete from news where NewsID=?";
		boolean b = dao.Update(sql,newsID);//记得传参
		return b?true:false;
	}
	public static boolean updNews(En_News news) {
		//修改新闻
		BaseDao dao=new BaseDao();
		String sql="update news set NewsTitle=?,NewsContent=? where NewsID=?";
		boolean b = dao.Update(sql,news.getNewsTitle(),news.getNewsContent(),news.getNewsID());//记得传参
		return b?true:false;
	}
}
