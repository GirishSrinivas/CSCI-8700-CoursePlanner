package com.girish.DAOLayers;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO 
{
	public List<StudentBean> read() throws ClassNotFoundException, SQLException;
	public void write(StudentBean bean) throws ClassNotFoundException, SQLException;
	public void update(StudentBean bean) throws ClassNotFoundException, SQLException;
	public void delete(StudentBean bean) throws ClassNotFoundException, SQLException;
	public StudentBean read(String netid) throws ClassNotFoundException, SQLException;
	public List<Object []> customSelect(String netid) throws ClassNotFoundException, SQLException;
	public List<Object []> customSelect() throws ClassNotFoundException, SQLException;
}
