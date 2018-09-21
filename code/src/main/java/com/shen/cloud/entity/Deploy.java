package com.shen.cloud.entity;

import com.shen.cloud.base.SYObject;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Table(schema = "`test`", name = "java_deploy")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deploy extends SYObject {
	@Id
	@Column(name = "uuid")
	private String uuid;//UUID

	@Column(name = "name")
	private String name;//项目名称

	@Column(name = "profile")
	private String profile;//Maven profile

	@Column(name = "module")
	private String module;//模块名称

	@Column(name = "type")
	private Integer type;//版本控制工具类型(1.SVN;2.GIT)

	@Column(name = "url")
	private String url;//svn/git地址

	@Column(name = "branch")
	private String branch;//git branch

}

