package com.shen.cloud.service;

import com.shen.cloud.mapper.MapperUtil;
import com.shen.cloud.entity.Deploy;

import com.shen.cloud.mapper.DeployMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeployService {
	@Resource private DeployMapper mapper;

	public Integer addDeploy(Deploy deploy) {
		return mapper.insertSelective(deploy);
	}

	public Integer modifyDeploy(Deploy deploy, String... fieldStrs) {
		Example example = MapperUtil.generateExample(deploy, fieldStrs);
		return mapper.updateByExampleSelective(deploy, example);
	}

	public Deploy getDeploy(Deploy deploy) {
		return mapper.selectOne(deploy);
	}

	public List<Deploy> getDeploys(Deploy deploy) {
		return mapper.select(deploy);
	}

}

