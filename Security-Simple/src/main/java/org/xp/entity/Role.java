package org.xp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author xupeng
 * @date 2020/12/1 10:00
 * @description
 */
@Getter
@Setter
@Builder
@TableName("sys_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 5056928595996359405L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String name;
}
