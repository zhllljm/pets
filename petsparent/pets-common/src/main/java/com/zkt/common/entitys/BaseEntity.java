
package com.zkt.common.entitys;

import java.sql.Timestamp;



import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
public class BaseEntity {

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 创建时间
	 */
	private Timestamp created;
	/**
	 * 修改时间
	 */
	private Timestamp updated;
}
