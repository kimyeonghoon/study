package com.spring.sample.web.test.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// Controller, Service, Repository 분리 이유
// 1. 용도에 따라 관리포인트를 달리하기 위해
// 2. 재사용성을 위해
@Repository
public class TestDao implements ITestDao {
	@Autowired
	public SqlSession sqlSession;

	@Override
	public List<HashMap<String, String>> getList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("test.getList", params);
	}

	@Override
	public int getListCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("test.getListCnt", params);
	}

	@Override
	public void insertTest(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("test.insertTest", params);
	}

	@Override
	public HashMap<String, String> getTest(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("test.getTest", params);
	}

	@Override
	public int updateTest(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("test.updateTest", params);
	}

	@Override
	public int deleteTest(HashMap<String, String> params) throws Throwable {
		return sqlSession.delete("test.deleteTest", params);
	}
	
	@Override
	public void insertJoin(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("test.insertJoin", params);
	}

	@Override
	public int getBmIdCheck(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("test.getBmIdCheck", params);
	}

	@Override
	public HashMap<String, String> getBm(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("test.getBm", params);
	}

	@Override
	public void bWrite(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("test.bWrite", params);
	}

	@Override
	public int getBCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("test.getBCnt", params);
	}

	@Override
	public List<HashMap<String, String>> getBList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("test.getBList", params);
	}

	@Override
	public HashMap<String, String> getB(HashMap<String, String> params) throws Throwable {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("test.getB", params);
	}

	@Override
	public void updateBHit(HashMap<String, String> params) throws Throwable {
		sqlSession.update("test.updateBHit", params);
	}

	@Override
	public int bDelete(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("test.bDelete", params);
	}

	@Override
	public int bUpdate(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("test.bUpdate", params);
	}

	@Override
	public int getOBCnt(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectOne("test.getOBCnt", params);
	}

	@Override
	public List<HashMap<String, String>> getOBList(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("test.getOBList", params);
	}

	@Override
	public int oBDelete(HashMap<String, String> params) throws Throwable{
		return sqlSession.update("test.oBDelete", params);
	}

	@Override
	public void oBWrite(HashMap<String, String> params) throws Throwable {
		sqlSession.insert("test.oBWrite", params);
	}

	@Override
	public int oBUpdate(HashMap<String, String> params) throws Throwable {
		return sqlSession.update("test.oBUpdate", params);
	}

	@Override
	public List<HashMap<String, String>> oBCon(HashMap<String, String> params) throws Throwable {
		return sqlSession.selectList("test.oBCon", params);
	}
	
	
	
}
