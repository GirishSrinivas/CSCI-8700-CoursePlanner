package com.girish.DAOLayers;

public class CourseBean 
{
	private String c_no;
	private String c_name;
	private int c_credits;
	private int c_rotation;
	private String c_type;
	
	public CourseBean()
	{
		
	}

	public String getC_no() {
		return c_no;
	}

	public void setC_no(String c_no) {
		this.c_no = c_no;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_credits() {
		return c_credits;
	}

	public void setC_credits(int c_credits) {
		this.c_credits = c_credits;
	}

	public int getC_rotation() {
		return c_rotation;
	}

	public void setC_rotation(int c_rotation) {
		this.c_rotation = c_rotation;
	}

	public String getC_type() {
		return c_type;
	}

	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
	
}
