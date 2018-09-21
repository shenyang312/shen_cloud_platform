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

	/**
	 * LCN分布式事务框架的核心功能是对本地事务的协调控制，
	 * 框架本身并不创建事务，只是对本地事务做协调控制。
	 * 因此该框架与其他第三方的框架兼容性强，
	 * 支持所有的关系型数据库事务，支持多数据源，
	 * 支持与第三方数据库框架一块使用（例如 sharding-jdbc），
	 * 在使用框架的时候只需要添加分布式事务的注解即可，对业务的侵入性低。
	 * LCN框架主要是为微服务框架提供分布式事务的支持，在微服务框架上做了进一步的事务机制优化，
	 * 在一些负载场景上LCN事务机制要比本地事务机制的性能更好，4.0以后框架开方了插件机制可以让更多的第三方框架支持进来
	 * @param deploy
	 * @return
	 */
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

