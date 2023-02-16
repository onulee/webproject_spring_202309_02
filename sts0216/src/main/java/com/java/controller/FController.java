package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("board/publicDataList")
	public String publicDataList() {
		return "board/publicDataList";
	}
	
	//공공데이터 불러오기 메소드
	@ResponseBody
	@RequestMapping("board/publicSearch")
	public String publicSearch(@RequestParam String id) {
		String jsonData = "";
		System.out.println("FController id : "+id);
		PublicData publicData = new PublicData();
		try {
			jsonData = publicData.publicData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jsonData;
	}
	
	
	
}
