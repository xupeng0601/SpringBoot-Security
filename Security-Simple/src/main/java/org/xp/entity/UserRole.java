package org.xp.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author xupeng
 * @date 2020/12/1 10:02
 * @description
 */
@Getter
@Setter
@Builder
@TableName("sys_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 3914549318645028369L;

    private String userId;
    private String roleId;
}
