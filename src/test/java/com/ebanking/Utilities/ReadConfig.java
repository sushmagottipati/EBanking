package com.ebanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
		File src=new File("./Configurations//Config.Properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);	
		}catch(Exception e) {
			System.out.println("Exception is"+e.getMessage());
		}
		
	}
	
	public String getApplicationURL()
	{
		String URL=pro.getProperty("URL");
		return URL;
	}
	
	public String getChromepath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}

}
