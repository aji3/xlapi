package org.xlbean.xlapi.dao;

public class DaoUtilContext {

	private static ThreadLocal<DaoUtilContext> INSTANCE = new ThreadLocal<>();
	
	public static DaoUtilContext getInstance() {
		return INSTANCE.get();
	}
	
	public String getUser() {
		return "testuser";
	}
}
