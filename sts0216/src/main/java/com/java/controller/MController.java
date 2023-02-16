package com.java.controller;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.vo.Member;

@Controller
@RequestMapping("/member")
public class MController {

	@ResponseBody
	@PostMapping("/checkId")
	//public Member checkId(Member m) {
	public String checkId(@RequestBody Member m) {  //json타입으로 올때 @RequestBody받음
		System.out.println("MController id : "+ m.getId());
		//객체데이터 전송
		String[] hobbys = {"swim","game","book"};
		Member member = new Member("aaa","1111","홍길동","010-1111-1111","male",hobbys);
		
		//Json데이터 전송
		JSONObject obj1 = new JSONObject();  //{"name":"kim","age":19,....}
		obj1.put("name","kim");
		obj1.put("age",19);
		obj1.put("address",null);
		obj1.put("isMarried",false);
		
        JSONObject obj2 = new JSONObject();
		obj2.put("name","lee");
		obj2.put("age",22);
		obj2.put("address","seoul");
		obj2.put("isMarried",true);

		JSONArray arr = new JSONArray();
		arr.add(obj1);
		arr.add(obj2);
		System.out.println(obj1.toJSONString());
		System.out.println(obj2.toJSONString());
		System.out.println(arr.toJSONString());
		
		// 공공데이터 가져오기
		PublicData publicData = new PublicData();
		System.out.println("공공데이터 : ");
		try {
			publicData.publicData();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//--->
		return arr.toJSONString();  //  /WEB-INF/views/member.jsp
	}
	
	
	@GetMapping("/memberWrite")
	public String memberWrite() {
		return "member/memberWrite";
	}
	
	@PostMapping("/memberView")
	public String memberView(Member member,Model model) {
		
		model.addAttribute("member",member);
		
		return "member/memberView";
		
	}//memberView - 객체
	
	
//	@PostMapping("/memberView")
//	public String memberView(@RequestParam(required=false) String id,@RequestParam(required=false) String pw,
//			@RequestParam(required=false) String name,@RequestParam(defaultValue = "010-1111-1111", required=false) String phone,
//			@RequestParam(required=false) String gender,@RequestParam(required=false) String[] hobbys,Model model) {
//		//
//		for(int i=0;i<hobbys.length;i++) {
//			if(i==0) hobby += hobbys[i];
//			else hobby += ","+hobbys[i];
//		}
//		
//		model.addAttribute("id",id);
//		model.addAttribute("pw",pw);
//		model.addAttribute("name",name);
//		model.addAttribute("phone",phone);
//		model.addAttribute("gender",gender);
//		model.addAttribute("hobby",hobby);
//		
//		return "member/memberView";
//	}//memberView - @RequestParam
	
	
//	@PostMapping("/memberView")
//	public String memberView(HttpServletRequest request,Model model) {
//		id = request.getParameter("id");
//		pw = request.getParameter("pw");
//		name = request.getParameter("name");
//		phone = request.getParameter("phone");
//		gender = request.getParameter("gender");
//		hobbys = request.getParameterValues("hobbys");
//		for(int i=0;i<hobbys.length;i++) {
//			if(i==0) hobby += hobbys[i];
//			else hobby += ","+hobbys[i];
//		}
//		model.addAttribute("id",id);
//		model.addAttribute("pw",pw);
//		model.addAttribute("name",name);
//		model.addAttribute("phone",phone);
//		model.addAttribute("gender",gender);
//		model.addAttribute("hobby",hobby);
//		
//		return "member/memberView";
//	}//memberView - request
	
	
	
	
}//class
