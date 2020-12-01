package org.xp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xp.entity.Role;
import org.xp.mapper.RoleMapper;
import org.xp.mapper.UserMapper;
import org.xp.result.ResultUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xupeng
 * @date 2020/12/1 10:07
 * @description
 */
@RestController
@Slf4j
public class UserController {


    @Resource
    private UserMapper userMapper;


    @Resource
    private RoleMapper roleMapper;


    @GetMapping("/getAllRole")
    public Object getAllRole(){
        List<Role> list = roleMapper.selectList(null);
        return ResultUtil.success(list);
    }

}
