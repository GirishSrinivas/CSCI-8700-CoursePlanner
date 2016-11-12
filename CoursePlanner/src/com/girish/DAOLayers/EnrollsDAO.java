package com.girish.DAOLayers;

import java.sql.SQLException;
import java.util.List;

public interface EnrollsDAO 
{
	public List<EnrollsBean> read() throws ClassNotFoundException, SQLException;
	public void write(EnrollsBean bean) throws ClassNotFoundException, SQLException;
	public void update(EnrollsBean bean) throws ClassNotFoundException, SQLException;
	public void delete(EnrollsBean bean) throws ClassNotFoundException, SQLException;
}
