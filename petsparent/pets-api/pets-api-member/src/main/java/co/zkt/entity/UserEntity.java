
package co.zkt.entity;


import com.zkt.common.entitys.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserEntity extends BaseEntity implements Serializable {
	private String username;
	private String password;
	private String phone;
	private String email;
	private String img;
}
