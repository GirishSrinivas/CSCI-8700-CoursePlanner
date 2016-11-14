package com.girish.DAOLayers;

import java.sql.SQLException;
import java.util.List;

public interface CourseConcDAO 
{
	public List<CourseConcBean> read() throws ClassNotFoundException, SQLException;
	public void write(CourseConcBean bean) throws ClassNotFoundException, SQLException;
	public void update(CourseConcBean bean) throws ClassNotFoundException, SQLException;
	public void delete(CourseConcBean bean) throws ClassNotFoundException, SQLException;
}
