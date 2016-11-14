package com.girish.DAOLayers;

import java.sql.SQLException;
import java.util.List;

public interface InstructorDAO 
{
	public List<InstructorBean> read() throws ClassNotFoundException, SQLException;
	public void write(InstructorBean bean) throws ClassNotFoundException, SQLException;
	public void update(InstructorBean bean) throws ClassNotFoundException, SQLException;
	public void delete(InstructorBean bean) throws ClassNotFoundException, SQLException;
}
