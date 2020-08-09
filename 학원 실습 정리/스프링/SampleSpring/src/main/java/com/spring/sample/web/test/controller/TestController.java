package com.spring.sample.web.test.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.sample.common.bean.PagingBean;
import com.spring.sample.common.service.IPagingService;
import com.spring.sample.web.test.service.ITestService;

// DB작업
// 1) Controller에서 DB에 접근할 메소드에 throws Throwable 추가
// 2) service 호출 생성
// 3) service 호출 메소드 빨간줄에 커서이동 후 create method
// 4) 생성된 인터페이스 메소드 앞에 public 뒤에 throws Throwable 추가
// 5) 인터페이스명에 ctrl 누른 상태로 커서 이동 후 Open Implimentation
// 6) service 클래스명 빨간줄에 커서 이동 후 add unimpli~~~~~
// 7) dao 호출 생성
// 8) dao 호출 메소드 빨간줄에 커서이동 후 create method
// 9) 생성된 인터페이스 메소드 앞에 public 뒤에 throws Throwable 추가
// 10) 인터페이스명에 ctrl 누른 상태로 커서 이동 후 Open Implimentation
// 11) dao 클래스명 빨간줄에 커서이동 후 add unimplie~~~

@Controller
public class TestController {
	@Autowired
	public ITestService iTestService;
	
	@Autowired
	public IPagingService iPagingService;
	
	@RequestMapping(value="/test1")
	public ModelAndView test1(@RequestParam HashMap<String, String> params,
							   ModelAndView mav) throws Throwable {
		//페이지 값이 없을 경우 페이지값 1 셋팅
		if(params.get("page") == null) {
			params.put("page", "1");
		}
		
		// 총 게시글 수 구하기
		int cnt = iTestService.getListCnt(params);
		
		PagingBean pb = iPagingService.getPagingBean(Integer.parseInt(params.get("page")), cnt);
		
		params.put("startCnt", Integer.toString(pb.getStartCount()));
		params.put("endCnt", Integer.toString(pb.getEndCount()));
		
		
		List<HashMap<String,String>> list = iTestService.getList(params);
		
		mav.addObject("page", params.get("page"));
		mav.addObject("pb", pb);
		mav.addObject("list", list);
		
		mav.setViewName("test/test1");
		
		return mav;
	}
	
	@RequestMapping(value = "/test2")
	public ModelAndView test2(ModelAndView mav) {
		
		mav.setViewName("test/test2");
		
		return mav;
	}
	
	@RequestMapping(value = "/test2s")
	public ModelAndView test2s(@RequestParam HashMap<String,String> params, ModelAndView mav) {
		
		try {
			iTestService.insertTest(params);
			// setViewName에서의 redirect:주소 => 해당 주소로  이동한다.
			// 컨트롤러에서 컨트롤러로 이동
			// 단점 : GET방식으로 이동(보낼 것이 없을 경우는 상관없음)
			mav.setViewName("redirect:test1");
			
		} catch (Throwable e) {
			e.printStackTrace();
			
			mav.setViewName("test/test2s");
		}
		
		
		return mav;
	}
	
	@RequestMapping(value = "/test3")
	public ModelAndView test3(@RequestParam HashMap<String,String> params, 
									ModelAndView mav) throws Throwable {
		HashMap<String,String> data = iTestService.getTest(params);
		
		mav.addObject("data", data);
		
		mav.setViewName("test/test3");
		
		return mav;
	}

	@RequestMapping(value = "/test4")
	public ModelAndView test4(@RequestParam HashMap<String,String> params, 
									ModelAndView mav) throws Throwable {
		
		HashMap<String,String> data = iTestService.getTest(params);
		
		mav.addObject("data", data);
		
		mav.setViewName("test/test4");
		return mav;
	}

	@RequestMapping(value = "/test4s")
	public ModelAndView test4s(@RequestParam HashMap<String,String> params, ModelAndView mav) {

		boolean res = false;
		
		
		try {
			int cnt = iTestService.updateTest(params);
			
			if(cnt > 0) {
				res = true;
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		
		mav.addObject("res", res);
		
		mav.setViewName("test/test4s");
		
		return mav;
	}
	
	@RequestMapping(value = "/test5")
	public ModelAndView test5(@RequestParam HashMap<String, String> params,
							  ModelAndView mav) {
		
		boolean res = false;
		
		try {
			int cnt = iTestService.deleteTest(params);
			
			if(cnt > 0) {
				res = true;
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		mav.addObject("res", res);
		
		mav.setViewName("test/test5");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/bJoin")
	public ModelAndView bJoin(ModelAndView mav) {
		
		mav.setViewName("test/bJoin");
		
		return mav;
	}
	
	@RequestMapping(value = "/bJoins")
	public ModelAndView bJoins(@RequestParam HashMap<String, String> params, ModelAndView mav) {
		
		int res = 0;
		
		try {
			int cnt = iTestService.getBmIdCheck(params);
			
			if(cnt > 0) {
				res = 1;
			} else {
				iTestService.insertJoin(params);
			}
		} catch (Throwable e) {
			res = 2;
			e.printStackTrace();
		}
		mav.addObject("res", res);
		mav.setViewName("test/bJoins");
		return mav;
	}
	
	@RequestMapping(value = "/bLogin")
	public ModelAndView bLogin(HttpSession session, ModelAndView mav) {
		if(session.getAttribute("sBmNo") != null) {
			mav.setViewName("redirect:bMain");			
		} else  {
			mav.setViewName("test/bLogin");
		}
		return mav;
	}
	
	@RequestMapping(value = "/bLogins")
	public ModelAndView bLogins(//HttpServletRequest req, // 세션 취득(옛날 방식)
						        HttpSession session,
								@RequestParam HashMap<String,String> params, ModelAndView mav) throws Throwable {
		
		HashMap<String,String> data = iTestService.getBm(params);
		
		if(data != null) { // 해당 사용자 정보가 있을 때
			//HttpSession session = req.getSession(); // 세션 정보 취득(옛날 방식)
			//세션 정보 할당(충돌 방지하기 위해 앞에 s를 달아줌)
			session.setAttribute("sBmNo", data.get("BM_NO"));
			session.setAttribute("sBmId", data.get("BM_ID"));
			session.setAttribute("sBmNm", data.get("BM_NM"));
			//세션 정보 취득
			System.out.println(session.getAttribute("sBmNm"));
			
			mav.setViewName("redirect:bMain");
			
		} else { // 사용자 정보가 없을 때
			mav.setViewName("test/bLogins");
		}
		return mav;
	}
	
	@RequestMapping(value = "/bMain")
	public ModelAndView bMain(HttpSession session, ModelAndView mav) {
		
		mav.setViewName("test/bMain");
	
		return mav;
	}
	
	@RequestMapping(value = "/bLogout")
	public ModelAndView bLogout(HttpSession session, ModelAndView mav) {
		session.invalidate(); // 세션 초기화
		
		mav.setViewName("redirect:bLogin");
		
		return mav;
	}
	
	@RequestMapping(value = "/bWrite")
	public ModelAndView bWrite(ModelAndView mav) {
		mav.setViewName("test/bWrite");
		
		return mav;
	}
	
	// RequestMapping의 method : 전송방식
	// 현재는 post일때만 작동하겠다는 의미
	// 옵션들은 추가적인 효과를 제공
	// produces : 결과의 형태 지정
	@RequestMapping(value = "/bWriteAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	// ResponseBody : View로 인식. 돌려주는 결과가 View의 내용으로 인식됨.
	@ResponseBody
	public String bWriteAjax(@RequestParam HashMap<String,String> params, ModelAndView modelAndView) throws Throwable {
		// ObjectMapper : jackson에서 제공. 객체정보를 문자열로 변환.(JSON 형태)
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			iTestService.bWrite(params);
			
			modelMap.put("result", "success");
		} catch (Throwable e) {
			e.printStackTrace();
			modelMap.put("result", "exception");
		}
		System.out.println(mapper.writeValueAsString(modelMap));
		//writeValueAsString : 값을 문자열로 변환(JSON 형태)
		return mapper.writeValueAsString(modelMap);
		
	}
	
	
	@RequestMapping(value = "/bListAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String bListAjax(@RequestParam HashMap<String,String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			int cnt = iTestService.getBCnt(params);
			
			PagingBean pb = iPagingService.getPagingBean(Integer.parseInt(params.get("page")), cnt, 10, 5);
			
			params.put("startCnt", Integer.toString(pb.getStartCount()));
			params.put("endCnt", Integer.toString(pb.getEndCount()));
			
			List<HashMap<String,String>> list = iTestService.getBList(params);
			
			modelMap.put("list", list);
			modelMap.put("pb", pb);
			modelMap.put("result", "success");
			
		} catch (Throwable e) {
			e.printStackTrace();
			modelMap.put("result", "exception");
		}
		System.out.println(mapper.writeValueAsString(modelMap));

		return mapper.writeValueAsString(modelMap);
	}
	
	@RequestMapping(value = "/bRead")
	public ModelAndView bRead(@RequestParam HashMap<String,String> params, ModelAndView mav) throws Throwable {
		
		
		iTestService.updateBHit(params);
		
		
		HashMap<String,String> data = iTestService.getB(params);
		
		mav.addObject("data", data);
		mav.setViewName("test/bRead");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/bUpdate")
	public ModelAndView bUpdate(@RequestParam HashMap<String,String> params, ModelAndView mav) throws Throwable {
		
		HashMap<String,String> data = iTestService.getB(params);
		mav.addObject("data", data);
		mav.setViewName("test/bUpdate");
		return mav;
	}
	
	
	@RequestMapping(value = "/bUpdateAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String bUpdateAjax(@RequestParam HashMap<String,String> params, ModelAndView modelAndView) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String,Object>();
		try {
			int cnt = iTestService.bUpdate(params);
			
			if(cnt > 0) {
				modelMap.put("result", "success");
			} else {
				modelMap.put("result", "fail");
			}
			
		} catch (Throwable e) {
				e.printStackTrace();
				modelMap.put("result", "exception");
		}
		
		return mapper.writeValueAsString(modelMap);
	}
	
	
	
	
	@RequestMapping(value = "bDeleteAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String bDeleteAjax(@RequestParam HashMap<String,String> params, HttpSession session) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String,Object>();
		try {
			
			params.put("bmNo", String.valueOf(session.getAttribute("sBmNo")));
			
			int cnt = iTestService.bDelete(params);
			
			if(cnt > 0) {
				modelMap.put("result", "success");
			} else {
				modelMap.put("result", "fail");
			}
			
		} catch (Throwable e) {
				e.printStackTrace();
				modelMap.put("result", "exception");
		}
		
		return mapper.writeValueAsString(modelMap);
	}
	
	// 여러 개의 주소를 하나의 메소드에 할당할 때는 {}로 묶어서 지정한다.
	// 로그인이나 메인화면의 주소에 할당 ex) {"/", "/login"}
	@RequestMapping(value = {"/test", "/abc"})
	public ModelAndView test(ModelAndView mav) {
		mav.setViewName("test/test");
		return mav;
	}
	
	//RequestMapping의 value에서 문자열안의 {} : 어떤 것이 들어올지 모른다.
	//PathVariable의 경우 기본저긍로 값이 안넘어오는 것에 대한 처리가 되어있지 않음
	//PathVariable의 옵션으로 required는 필수여부로 false인 경우 null을 허용한다.
	//PathVariable에서 HashMap을 사용할 경우 RequestParam과 동일하게 null을 허용.
	@RequestMapping(value = {"testa", "/testa/{a}"})
	public ModelAndView testa(@PathVariable(name = "a", required = false) String s, ModelAndView mav) {
		System.out.println(s);
		mav.setViewName("test/test");
		return mav;
	}
	
	@RequestMapping(value = "/oBList")
	public ModelAndView oBList(HttpSession session, ModelAndView mav) {

		mav.setViewName("test/oBList");
		return mav;
	}
	
	
	@RequestMapping(value = "/oBListAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String oBListAjax(HttpSession session, @RequestParam HashMap<String,String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		session.setAttribute("sBmNm", modelMap.get("BM_NM"));
		session.setAttribute("sBmId", modelMap.get("BM_ID"));
		
		
		if(params.get("page") == null) {
			params.put("page", "1");
		}
		
		try {
			
			
			int cnt = iTestService.getOBCnt(params);
			
			PagingBean pb = iPagingService.getPagingBean(Integer.parseInt(params.get("page")), cnt, 5, 3);
			
			params.put("startCnt", Integer.toString(pb.getStartCount()));
			params.put("endCnt", Integer.toString(pb.getEndCount()));
			
			List<HashMap<String,String>> list = iTestService.getOBList(params);
			
			modelMap.put("list", list);
			modelMap.put("pb", pb);
			modelMap.put("result", "success");
			
		} catch (Throwable e) {
			e.printStackTrace();
			modelMap.put("result", "exception");
		}
		System.out.println(mapper.writeValueAsString(modelMap));

		return mapper.writeValueAsString(modelMap);
	}
	
	@RequestMapping(value = "oBDeleteAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String oBDeleteAjax(@RequestParam HashMap<String,String> params, HttpSession session) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String,Object>();
		
		System.out.println(params.get("bmNo"));
		System.out.println(params.get("bNo"));
		
		
		
		if(params.get("page") == null) {
			params.put("page", "1");
		}

		try {
			
			int cnt = iTestService.oBDelete(params);

			if(cnt > 0) {
				modelMap.put("result", "success");
			} else {
				modelMap.put("result", "fail");
			}
			
		} catch (Throwable e) {
				e.printStackTrace();
				modelMap.put("result", "exception");
		}
		
		return mapper.writeValueAsString(modelMap);
	}
	
	@RequestMapping(value = "/oBWriteAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String oBWriteAjax(@RequestParam HashMap<String,String> params, ModelAndView modelAndView, HttpSession session) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();

		
		try {
			
			iTestService.oBWrite(params);
			
			modelMap.put("result", "success");
		} catch (Throwable e) {
			e.printStackTrace();
			modelMap.put("result", "exception");
		}
		System.out.println(mapper.writeValueAsString(modelMap));
		return mapper.writeValueAsString(modelMap);
		
	}
	
	
	
	
	@RequestMapping(value = "/oBUpdateAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String oBUpdateAjax(@RequestParam HashMap<String,String> params, ModelAndView modelAndView) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String,Object>();
		try {
			int cnt = iTestService.oBUpdate(params);
			
			if(cnt > 0) {
				modelMap.put("result", "success");
			} else {
				modelMap.put("result", "fail");
			}
			
		} catch (Throwable e) {
				e.printStackTrace();
				modelMap.put("result", "exception");
		}
		
		return mapper.writeValueAsString(modelMap);
	}
	
	@RequestMapping(value = "/oBConAjax", method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String oBConAjax(HttpSession session, @RequestParam HashMap<String,String> params) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			
			List<HashMap<String,String>> data = iTestService.oBCon(params);
			
			modelMap.put("data", data);
			modelMap.put("result", "success");
			
		} catch (Throwable e) {
			e.printStackTrace();
			modelMap.put("result", "exception");
		}
		System.out.println(mapper.writeValueAsString(modelMap));

		return mapper.writeValueAsString(modelMap);
	}
	
	
}
