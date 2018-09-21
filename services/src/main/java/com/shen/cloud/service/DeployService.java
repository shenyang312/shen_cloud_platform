package com.shen.cloud.service;

import com.codingapi.tx.annotation.TxTransaction;
import com.shen.cloud.client.MessageClient;
import com.shen.cloud.entity.Deploy;
import com.shen.cloud.mapper.DeployMapper;
import com.shen.cloud.mapper.MapperUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeployService {

	@Resource private DeployMapper mapper;


	@Resource
	private MessageClient messageClient;

	@TxTransaction(isStart=true)
	@Transactional
	public Integer addDeploy(Deploy deploy) {
		mapper.insertSelective(deploy);
		messageClient.getSystemNos();
		return null;
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

