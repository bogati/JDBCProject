package com.cognixia.jump.javafinalproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognixia.jump.javafinalproject.connection.SingletonConnectionManager;

public class AddressDAOImpl implements AddressDAO{
	static Connection conn = SingletonConnectionManager.getConnection();

	@Override
	public boolean addAddress(Address addr) {
		
		
		
		try(PreparedStatement pstmt = conn.prepareStatement("insert into Address values(null,?,?,?,?,?,?)"))
		   {
			
			pstmt.setString(1, addr.getAddress1());
			pstmt.setString(2, addr.getAddress2());
			pstmt.setString(3,addr.getCity());
			pstmt.setString(4, addr.getState());
			pstmt.setString(5, addr.getCountry());
			pstmt.setString(6, addr.getZipcode());
			
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				System.out.println("Address added to Address table \n ");
				return true;
			}
			
		} catch(SQLException e) {
			//e.printStackTrace();
			
		} 
		
		
		
		
		return false;
	}

	@Override
	public long getIdOflastAddedAddress() {
		
		ResultSet rs = null;
		long max_val=0;
		
		
		try(PreparedStatement pstmt = conn.prepareStatement("select max(address_id) from Address"))
				{
					rs = pstmt.executeQuery();
					
					rs.next();
					max_val= rs.getLong(1);
						
				
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return max_val;
	}

}
