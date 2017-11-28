package com.nineteen.lostfound.shiro;

import com.nineteen.lostfound.dao.harmony.entity.User;
import com.nineteen.lostfound.dao.harmony.mapper.UserMapper;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ShiroRealm extends AuthorizingRealm {
    @Autowired
   private UserMapper userMapper;

    /*
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Set<String> roleNames = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
        roleNames.add("admin");//添加角色
        permissions.add("search");  //添加权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }

    /*
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username=token.getUsername();
        User user=new User();
        user.setUserid(username);
       List<User> user1= userMapper.select(user);
        if(token.getUsername().equals(user1.get(0).getUserid())){
            return new SimpleAuthenticationInfo(user1.get(0).getUserid(), user1.get(0).getPassword(), this.getName());
        }else{
            throw new AuthenticationException();
        }
    }

}