package com.shen.cloud.entity;

import com.shen.cloud.base.SYObject;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Table(schema = "`test`", name = "python_map_r")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PythonEntity extends SYObject {
	@Id
	@Column(name = "id")
	private Integer id;//

	@Column(name = "r")
	private String r;//

	@Column(name = "n")
	private String n;//

	@Column(name = "cross_walk")
	private String crossWalk;//

}

