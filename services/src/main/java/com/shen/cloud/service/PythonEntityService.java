package com.shen.cloud.service;

import com.shen.cloud.mapper.MapperUtil;
import com.shen.cloud.entity.PythonEntity;

import com.shen.cloud.mapper.PythonEntityMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PythonEntityService {
	@Resource private PythonEntityMapper mapper;

	public Integer addPythonEntity(PythonEntity pythonEntity) {
		return mapper.insertSelective(pythonEntity);
	}

	public Integer modifyPythonEntity(PythonEntity pythonEntity, String... fieldStrs) {
		Example example = MapperUtil.generateExample(pythonEntity, fieldStrs);
		return mapper.updateByExampleSelective(pythonEntity, example);
	}

	public PythonEntity getPythonEntity(PythonEntity pythonEntity) {
		return mapper.selectOne(pythonEntity);
	}

	public List<PythonEntity> getPythonEntitys(PythonEntity pythonEntity) {
		return mapper.select(pythonEntity);
	}

}

