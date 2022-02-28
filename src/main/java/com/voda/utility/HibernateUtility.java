package com.voda.utility;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.proxy.* ;

public class HibernateUtility {

	private final static SessionFactory sessionFactory; 
static {
	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
	sessionFactory = metaData.getSessionFactoryBuilder().build();
  }
  
public static SessionFactory get() {
	return sessionFactory ;
}

}
