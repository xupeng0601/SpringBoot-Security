package org.xp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;

/**
 * @author xupeng
 * @date 2020/12/1 9:05
 * @description
 */
@Getter
@Setter
@Builder
@TableName(value = "sys_user")
public class User  implements Serializable {

    private static final long serialVersionUID = 5142340461451385099L;

    //采用雪花算法自动生成UUID
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String name;

    private String password;

}
