package com.litchi.litchi_ctf.realm;

import com.litchi.litchi_ctf.mapper.Usermapper;
import com.litchi.litchi_ctf.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


/**
 * @author 牛奶冻荔枝
 * 一个用户角色类，用于shiro框架的校验
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private Usermapper usermapper;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        //使用Optional来解决nullException的问题，这里的usermapper.getUserByUsername
        User user = Optional.ofNullable(usermapper.getUserByUsername(principal)).orElseThrow(UnknownAccountException::new);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, user.getPassword(), getName());
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("USER_SESSION", user);
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 用户的角色集合
        Set<String> roles = new HashSet<>();
        String[] roleList={"admin","normal"};
        roles.add(roleList[Integer.parseInt(user.getRole())-1]);
        info.setRoles(roles);
        return info;
    }

}
