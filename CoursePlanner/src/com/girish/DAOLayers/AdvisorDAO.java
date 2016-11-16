package com.girish.DAOLayers;

import java.sql.SQLException;
import java.util.List;

public interface AdvisorDAO 
{
	public List<AdvisorBean> read() throws ClassNotFoundException, SQLException;
	public void write(AdvisorBean bean) throws ClassNotFoundException, SQLException;
	public void update(AdvisorBean bean) throws ClassNotFoundException, SQLException;
	public void delete(AdvisorBean bean) throws ClassNotFoundException, SQLException;
}
