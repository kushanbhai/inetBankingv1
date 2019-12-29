package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;

	public ReadConfig() {
		File src = new File("./Configuration/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is: " + e.getMessage());
		}

	}

	public String getapplicationUrl() {
		String url = prop.getProperty("baseurl");
		return url;
	}

	public String getusername() {
		String uname = prop.getProperty("username");
		return uname;
	}

	public String getpassword() {
		String paswrd = prop.getProperty("password");
		return paswrd;
	}

	public String getChromepath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIEdriverPath() {
		String iedriverpath = prop.getProperty("iepath");
		return iedriverpath;
	}
}
