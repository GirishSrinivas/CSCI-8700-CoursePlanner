package com.girish.DAOLayers;

public class StudentBean  
{
	private String s_netid;
	private String level;
	private String major;
	private String concentration;
	private String a_netid;
	
	public StudentBean()
	{
		
	}


	public String getS_netid() {
		return s_netid;
	}

	public void setS_netid(String s_netid) {
		this.s_netid = s_netid;
	}

	public String getA_netid() {
		return a_netid;
	}

	public void setA_netid(String a_netid) {
		this.a_netid = a_netid;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getConcentration() {
		return concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}
	
	
}
