package com.girish.DAOLayers;

import java.sql.SQLException;
import java.util.List;

public interface CoursePlanDAO 
{
	public List<Object[]> read(String netid) throws ClassNotFoundException, SQLException;
	public void write(CoursePlanBean bean) throws ClassNotFoundException, SQLException;
	public boolean isPresent(CoursePlanBean bean) throws ClassNotFoundException, SQLException;
	public void delete(CoursePlanBean bean) throws ClassNotFoundException, SQLException;
}
