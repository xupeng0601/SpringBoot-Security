package org.xp.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.xp.entity.Role;
import org.xp.entity.User;
import org.xp.entity.UserRole;
import org.xp.mapper.RoleMapper;
import org.xp.mapper.UserMapper;
import org.xp.mapper.UserRoleMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author xupeng
 * @date 2020/12/1 10:20
 * @description
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
       //根据用户名从数据库取出用户信息
       User user =  userMapper.selectOne(
               new LambdaQueryWrapper<User>().eq(name != null, User::getName, name));

        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        //根据userId查询出对应的RoleIds
        String userId = user.getId();
        List<UserRole> userRoles =  userRoleMapper.selectList(
                new LambdaQueryWrapper<UserRole>().eq(userId != null, UserRole::getUserId, userId));

        List<String> roleIds = new ArrayList();
        userRoles.forEach(i -> roleIds.add(i.getRoleId()));

        //根据roleIds查询role名称
        List<Role> roles = roleMapper.selectList(
                new LambdaQueryWrapper<Role>().in(roleIds.size() != 0 ,Role::getId,roleIds));

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(i -> authorities.add(new SimpleGrantedAuthority(i.getName())));

        //返回用户信息
       return new org.springframework.security.core.userdetails.User(
               user.getName(), user.getPassword(), authorities);
    }
}
