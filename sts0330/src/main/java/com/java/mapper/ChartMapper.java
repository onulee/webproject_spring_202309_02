package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.vo.ChartVo;

@Mapper
public interface ChartMapper {

	List<ChartVo> selectAll();

}
