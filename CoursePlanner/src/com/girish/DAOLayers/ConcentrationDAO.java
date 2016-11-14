package com.girish.DAOLayers;

import java.sql.SQLException;
import java.util.List;

public interface ConcentrationDAO 
{
	public List<ConcentrationBean> read() throws ClassNotFoundException, SQLException;
	public void write(ConcentrationBean bean) throws ClassNotFoundException, SQLException;
	public void update(ConcentrationBean bean) throws ClassNotFoundException, SQLException;
	public void delete(ConcentrationBean bean) throws ClassNotFoundException, SQLException;
}
