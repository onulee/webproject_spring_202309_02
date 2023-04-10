package com.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.service.ChartService;
import com.java.vo.ChartVo;

@Controller
public class ChartController {
	
	@Autowired
	ChartService chartService;
	
	
	@GetMapping("/chart")
	public String chart() {
		return "chart";
	}
	
	@GetMapping("/chartData")
	@ResponseBody //ajax데이터 가져오기
	public Map<String, Object> chartData(@RequestParam String period ) {
		System.out.println("period data : "+period);
		Map<String, Object> map = new HashMap<>();
		String[] memberLabel=null;
		int[] memberData=null;
		//DB에 접근 memberLabel,memberData
		List<ChartVo> list = chartService.selectAll();
		
		if(list != null) {
			memberLabel = new String[list.size()];
			memberData = new int[list.size()];
			//배열형태로 변경
			for(int i=0;i<list.size();i++) {
				memberLabel[i] = list.get(i).getMemberlabel();
				memberData[i] = list.get(i).getMemberData();
			}
		}
		
		String memberTitle="주별 회원가입";
//		String[] memberLabel= {"1주","2주","3주","4주","5주","6주"};
//		int[] memberData= {2500, 3500, 5000, 1000, 2400, 4000};
		
	    map.put("memberTitle", memberTitle);
	    map.put("memberLabel", memberLabel);
	    map.put("memberData", memberData);
		
		return map;
	}

}
