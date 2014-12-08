package JsonClasses;

public class getCalendar implements java.io.Serializable {
	private  final long serialVersionUID = 2L;
	private String overallID = "getCalender";
	private String userName;
	
	public String getoverallID()
	{
		return overallID;
	}
	public void setoverallID(String overallID)
	{
		this.overallID = overallID;
	}
	
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
}
