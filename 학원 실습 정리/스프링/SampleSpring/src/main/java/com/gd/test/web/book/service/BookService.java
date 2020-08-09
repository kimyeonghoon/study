package com.gd.test.web.book.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.book.dao.IBookDao;

@Service
public class BookService implements IBookService {

	@Autowired
	public IBookDao iBookDao;
	
	@Override
	public int getListCnt(HashMap<String, String> params) throws Throwable {
		return iBookDao.getListCnt(params);
	}

	@Override
	public List<HashMap<String, String>> getList(HashMap<String, String> params) throws Throwable {
		return iBookDao.getList(params);
	}

	@Override
	public void insertBook(HashMap<String, String> params) throws Throwable {
		iBookDao.insertBook(params);
	}

	@Override
	public HashMap<String, String> getContent(HashMap<String, String> params) throws Throwable {
		return iBookDao.getContent(params);
	}

	@Override
	public int updateBook(HashMap<String, String> params) throws Throwable {
		return iBookDao.updateBook(params);
	}

	@Override
	public int deleteBook(HashMap<String, String> params) throws Throwable {
		return iBookDao.deleteBook(params);
	}

}
