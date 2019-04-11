package entity;

public class En_News {
	int NewsID;
	String NewsTitle;
	String NewsContent;
	String NewsTime;
	String AdminName;
	public En_News() {
		
	}
	
	public En_News(String newsTitle, String newsContent, String newsTime, String adminName) {
		
		NewsTitle = newsTitle;
		NewsContent = newsContent;
		NewsTime = newsTime;
		AdminName = adminName;
	}

	public En_News(int newsID, String newsTitle, String newsContent, String newsTime, String adminName) {
		
		NewsID = newsID;
		NewsTitle = newsTitle;
		NewsContent = newsContent;
		NewsTime = newsTime;
		AdminName = adminName;
	}
	public int getNewsID() {
		return NewsID;
	}
	public void setNewsID(int newsID) {
		NewsID = newsID;
	}
	public String getNewsTitle() {
		return NewsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		NewsTitle = newsTitle;
	}
	public String getNewsContent() {
		return NewsContent;
	}
	public void setNewsContent(String newsContent) {
		NewsContent = newsContent;
	}
	public String getNewsTime() {
		return NewsTime;
	}
	public void setNewsTime(String newsTime) {
		NewsTime = newsTime;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	
	
}
