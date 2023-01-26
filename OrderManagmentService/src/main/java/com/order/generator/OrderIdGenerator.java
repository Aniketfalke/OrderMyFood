package com.order.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.jdbc.ReturningWork;


public class OrderIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		String prefix="ODR";
		 String suffix="";
		
		  Connection connection = session.doReturningWork(new ReturningWork<Connection>() {
	            @Override
	            public Connection execute(Connection conn) throws SQLException {
	                return conn;
	            }
	        });
		  
		  try {
			Statement stmt= connection.createStatement();
			String query="select count(order_id) as Id from orderdb.order_tbl";
			
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()) {
				int seqval=rs.getInt(1)+101;
				
				suffix=String.valueOf(seqval);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		  
		return prefix+suffix;
	}

}
