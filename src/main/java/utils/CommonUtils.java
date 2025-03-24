package utils;

import java.util.Date;

public class CommonUtils 
{
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_WAIT_TIME=10;

	public String getEmailTimeStamp()
	{
		Date date=new Date();
		return "ak"+date.toString().replace(" ", "_").replace(":","_")+"@gmail.com";
	}

}
