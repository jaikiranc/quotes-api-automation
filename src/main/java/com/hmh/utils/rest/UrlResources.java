package com.hmh.utils.rest;


public class UrlResources {

	private static String url = ExecutionUtils.getUrl();

	public static final String FAVQ = url+"api/quotes";
	public static final String LOGIN = url+"api/session";

	public static String getFavQuotes(){
		return  FAVQ;
	}

	public static String getQuoteById(String id){
		return  FAVQ+"/"+id;
	}
	public static String markAsUsersFavorite(String id){
		return  FAVQ+"/"+id+"/fav";
	}



}
