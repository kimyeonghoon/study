package com.gd.test.web.book.service;

import java.util.HashMap;
import java.util.List;

public interface IBookService {

	public int getListCnt(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> getList(HashMap<String, String> params) throws Throwable;

	public void insertBook(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getContent(HashMap<String, String> params) throws Throwable;

	public int updateBook(HashMap<String, String> params) throws Throwable;

	public int deleteBook(HashMap<String, String> params) throws Throwable;

}
