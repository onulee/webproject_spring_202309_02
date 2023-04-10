package com.java.service;

import java.util.List;
import com.java.vo.ChartVo;

public interface ChartService {

	// 차트데이터 전체 가져오기
	List<ChartVo> selectAll();

}
