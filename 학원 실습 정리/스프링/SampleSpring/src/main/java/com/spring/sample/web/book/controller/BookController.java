package com.spring.sample.web.book.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.sample.common.bean.PagingBean;
import com.spring.sample.common.service.IPagingService;
import com.spring.sample.web.book.dao.IBookDao;
import com.spring.sample.web.book.service.IBookService;

@Controller
public class BookController {
	
	@Autowired
	public IBookService iBookService;
	
	@Autowired
	public IBookDao iBookDao;
	
	@Autowired
	public IPagingService iPagingService;
	
	@RequestMapping(value = "/book")
	public ModelAndView list(@RequestParam HashMap<String,String> params, ModelAndView mav) throws Throwable {
		
		if(params.get("page") == null) {
			params.put("page", "1");
		}
		
		int cnt = iBookService.getListCnt(params);
		
		PagingBean pb = iPagingService.getPagingBean(Integer.parseInt(params.get("page")), cnt);
		
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		List<HashMap<String,String>> list = iBookService.getList(params);
		
		mav.addObject("page", params.get("page"));
		mav.addObject("pb", pb);
		mav.addObject("list",list);

		mav.setViewName("book/book");
		
		return mav;
	}
	
	@RequestMapping(value = "/add")
	public ModelAndView add(ModelAndView mav) {
		
		mav.setViewName("book/add");
		
		return mav;
	}
	
	@RequestMapping(value = "/addsend")
	public ModelAndView addsend(@RequestParam HashMap<String,String> params, ModelAndView mav) {
		
		try {
			iBookService.insertBook(params);
			mav.setViewName("redirect:book");
		} catch (Throwable e) {
			e.printStackTrace();
			mav.setViewName("book/addsend");
		}

		return mav;
	}
	
	@RequestMapping(value = "/content")
	public ModelAndView content(@RequestParam HashMap<String,String> params, ModelAndView mav) throws Throwable {
		
		HashMap<String,String> content = iBookService.getContent(params);
		
		mav.addObject("content", content);
		
		mav.setViewName("book/content");
		
		return mav;
	}
	
	@RequestMapping(value = "/modify")
	public ModelAndView modify(@RequestParam HashMap<String,String> params, ModelAndView mav) throws Throwable {
		
		HashMap<String,String> content = iBookService.getContent(params);
		
		mav.addObject("content", content);
		
		mav.setViewName("book/modify");
		
		return mav;
	}
	
	@RequestMapping(value = "/modifysend")
	public ModelAndView modifysend(@RequestParam HashMap<String,String> params, ModelAndView mav) {

		boolean res = false;
		
		
		try {
			int cnt = iBookService.updateBook(params);
			
			if(cnt > 0) {
				res = true;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		mav.addObject("res", res);
		
		mav.setViewName("book/modifysend");
		
		return mav;
	}
	
	@RequestMapping(value = "/deletesend")
	public ModelAndView delete(@RequestParam HashMap<String,String> params, ModelAndView mav) {

		boolean res = false;
		
		
		try {
			int cnt = iBookService.deleteBook(params);
			
			if(cnt > 0) {
				res = true;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		mav.addObject("res", res);
		
		mav.setViewName("book/deletesend");
		
		return mav;
	}

}
