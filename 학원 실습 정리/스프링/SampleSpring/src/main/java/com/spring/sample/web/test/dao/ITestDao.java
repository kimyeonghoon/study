package com.spring.sample.web.test.dao;

import java.util.HashMap;
import java.util.List;

public interface ITestDao {

	public List<HashMap<String, String>> getList(HashMap<String, String> params) throws Throwable;

	public int getListCnt(HashMap<String, String> params) throws Throwable;

	public void insertTest(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getTest(HashMap<String, String> params) throws Throwable;

	public int updateTest(HashMap<String, String> params) throws Throwable;

	public int deleteTest(HashMap<String, String> params) throws Throwable;

	public void insertJoin(HashMap<String, String> params) throws Throwable;

	public int getBmIdCheck(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getBm(HashMap<String, String> params) throws Throwable;

	public void bWrite(HashMap<String, String> params) throws Throwable;

	public int getBCnt(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> getBList(HashMap<String, String> params) throws Throwable;

	public HashMap<String, String> getB(HashMap<String, String> params) throws Throwable;

	public void updateBHit(HashMap<String, String> params) throws Throwable;

	public int bDelete(HashMap<String, String> params) throws Throwable;

	public int bUpdate(HashMap<String, String> params) throws Throwable;

	public int getOBCnt(HashMap<String, String> params)  throws Throwable;

	public List<HashMap<String, String>> getOBList(HashMap<String, String> params) throws Throwable;

	public int oBDelete(HashMap<String, String> params) throws Throwable;

	public void oBWrite(HashMap<String, String> params) throws Throwable;

	public int oBUpdate(HashMap<String, String> params) throws Throwable;

	public List<HashMap<String, String>> oBCon(HashMap<String, String> params) throws Throwable;

}
