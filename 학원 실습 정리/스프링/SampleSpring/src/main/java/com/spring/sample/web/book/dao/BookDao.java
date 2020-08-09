package com.spring.sample.web.book.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao implements IBookDao {
	
	@Autowired
	public SqlSession sqlSession;

	@Override
	public int getListCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("book.getListCnt", params);
	}

	@Override
	public List<HashMap<String, String>> getList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("book.getList", params);
	}

	@Override
	public void insertBook(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("book.insertBook", params);
	}

	@Override
	public HashMap<String, String> getContent(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("book.getContent", params);
	}

	@Override
	public int updateBook(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("book.updateBook", params);
	}

	@Override
	public int deleteBook(HashMap<String, String> params) throws Throwable {
		return sqlSession.delete("book.deleteBook", params);
	}
	
}
