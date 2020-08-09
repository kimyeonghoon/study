package com.gd.test.web.test.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.test.web.test.dao.ITestDao;

@Service
public class TestService implements ITestService {
	@Autowired
	public ITestDao iTestDao;

	@Override
	public List<HashMap<String, String>> getList(HashMap<String, String> params) throws Throwable {
		
		return iTestDao.getList(params);
	}

	@Override
	public int getListCnt(HashMap<String, String> params) throws Throwable {
		return iTestDao.getListCnt(params);
	}

	@Override
	public void insertTest(HashMap<String, String> params) throws Throwable {
			iTestDao.insertTest(params);
	}

	@Override
	public HashMap<String, String> getTest(HashMap<String, String> params) throws Throwable {
		return iTestDao.getTest(params);
	}

	@Override
	public int updateTest(HashMap<String, String> params) throws Throwable {
		return iTestDao.updateTest(params);
	}

	@Override
	public int deleteTest(HashMap<String, String> params) throws Throwable {
		return iTestDao.deleteTest(params);
	}

	@Override
	public void insertJoin(HashMap<String, String> params) throws Throwable {
		iTestDao.insertJoin(params);
	}

	@Override
	public int getBmIdCheck(HashMap<String, String> params) throws Throwable {
		return iTestDao.getBmIdCheck(params);
	}

	@Override
	public HashMap<String, String> getBm(HashMap<String, String> params) throws Throwable {
		return iTestDao.getBm(params);
	}

	@Override
	public void bWrite(HashMap<String, String> params) throws Throwable {
		iTestDao.bWrite(params);
	}

	@Override
	public int getBCnt(HashMap<String, String> params) throws Throwable {
		return iTestDao.getBCnt(params);
	}

	@Override
	public List<HashMap<String, String>> getBList(HashMap<String, String> params) throws Throwable {
		return iTestDao.getBList(params);
	}

	@Override
	public HashMap<String, String> getB(HashMap<String, String> params) throws Throwable {
		return iTestDao.getB(params);
	}

	@Override
	public void updateBHit(HashMap<String, String> params) throws Throwable {
		iTestDao.updateBHit(params);
	}

	@Override
	public int bDelete(HashMap<String, String> params) throws Throwable {
		return iTestDao.bDelete(params);
	}

	@Override
	public int bUpdate(HashMap<String, String> params) throws Throwable {
		return iTestDao.bUpdate(params);
	}

	@Override
	public int getOBCnt(HashMap<String, String> params) throws Throwable {
		return iTestDao.getOBCnt(params);
	}

	@Override
	public List<HashMap<String, String>> getOBList(HashMap<String, String> params) throws Throwable {
		return iTestDao.getOBList(params);
	}

	@Override
	public int oBDelete(HashMap<String, String> params) throws Throwable {
		return iTestDao.oBDelete(params);
	}

	@Override
	public void oBWrite(HashMap<String, String> params) throws Throwable {
		iTestDao.oBWrite(params);
	}

	@Override
	public int oBUpdate(HashMap<String, String> params) throws Throwable {
		return iTestDao.oBUpdate(params);
	}

	@Override
	public List<HashMap<String, String>> oBCon(HashMap<String, String> params) throws Throwable {
		return iTestDao.oBCon(params);
	}
}
