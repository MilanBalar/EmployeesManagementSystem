package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.EmpBean;

public class EmpDAO
{
	
	public static Session getSession() 
	{
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		return s;
		
	}
	
	public static void Edit2Data(EmpBean b)
	{
		Session sf=EmpDAO.getSession();
		sf.beginTransaction();
	    sf.update(b);
	    
		sf.getTransaction().commit();
		sf.close();

		
		
	}
	
	
	public static EmpBean updateData(Long eid)
	{
		Session sf=EmpDAO.getSession();
		sf.beginTransaction();
	    EmpBean b=sf.get(EmpBean.class, eid);
	    
		sf.getTransaction().commit();
		sf.close();
		return b;
		
		
	}
	
	public static void deleteData(Long eid)
	{
		Session sf=EmpDAO.getSession();
		sf.beginTransaction();
	    EmpBean b=sf.get(EmpBean.class, eid);
	    sf.delete(b);
		sf.getTransaction().commit();
		sf.close();
		
		
	}
	
	
	
	
	public static List<EmpBean> getAllData()
	{
		Session sf=EmpDAO.getSession();
		sf.beginTransaction();
		List<EmpBean> l= sf.createQuery("from EmpBean").list();
		sf.getTransaction().commit();
		sf.close();
		return l;
		
	}
	
	
	
	
	public static void SaveData(EmpBean b)
	{
		Session sf=EmpDAO.getSession();
		sf.beginTransaction();
		sf.save(b);
		sf.getTransaction().commit();
		sf.close();
		
		
	}
	

}
