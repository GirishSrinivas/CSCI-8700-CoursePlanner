package com.girish.DAOLayers;

import java.sql.SQLException;
import java.util.List;

public interface SectionDAO 
{
	public List<SectionBean> read() throws ClassNotFoundException, SQLException;
	public void write(SectionBean bean) throws ClassNotFoundException, SQLException;
	public void update(SectionBean bean) throws ClassNotFoundException, SQLException;
	public void delete(SectionBean bean) throws ClassNotFoundException, SQLException;
}
