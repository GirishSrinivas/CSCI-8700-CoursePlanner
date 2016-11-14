package com.girish.DAOLayers;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO 
{
	public List<DepartmentBean> read() throws ClassNotFoundException, SQLException;
	public void write(DepartmentBean bean) throws ClassNotFoundException, SQLException;
	public void update(DepartmentBean bean) throws ClassNotFoundException, SQLException;
	public void delete(DepartmentBean bean) throws ClassNotFoundException, SQLException;
}
