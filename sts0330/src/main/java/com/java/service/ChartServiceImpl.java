package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mapper.ChartMapper;
import com.java.vo.ChartVo;

@Service
public class ChartServiceImpl implements ChartService {

	@Autowired
	ChartMapper chartMapper;
	
	@Override
	public List<ChartVo> selectAll() {
		List<ChartVo> list = chartMapper.selectAll(); 
		return list;
	}

}
