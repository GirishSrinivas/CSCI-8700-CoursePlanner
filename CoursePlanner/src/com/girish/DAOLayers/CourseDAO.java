package com.girish.DAOLayers;

import java.sql.SQLException;
import java.util.List;

public interface CourseDAO 
{
	public List<CourseBean> read() throws ClassNotFoundException, SQLException;
	public void write(CourseBean bean) throws ClassNotFoundException, SQLException;
	public void update(CourseBean bean) throws ClassNotFoundException, SQLException;
	public void delete(CourseBean bean) throws ClassNotFoundException, SQLException;
}
