package com.df.realm;

import com.df.pojo.SysUser;
import com.df.service.MenuService;
import com.df.service.RoleService;
import com.df.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @Cauthor: zb
 * @date: 2020/4/18 - 15:22
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RoleService roleService;



    @Autowired
    private MenuService menuService;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //得到用户名和密码
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());
        SysUser userByUsername = sysUserService.findUserByUsername(username);
        if (userByUsername == null){
            throw new UnknownAccountException("账户不存在");
        }
        if (!userByUsername.getPassword().equals(password)){
            throw new IncorrectCredentialsException("密码不正确");
        }
        if(userByUsername.getStatus() == 0){
            throw new LockedAccountException("账户被冻结");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userByUsername, password, this.getName());
        return info;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser sysUser = (SysUser)principalCollection.getPrimaryPrincipal();
        Long userId = sysUser.getUserId();
        //用户的角色
        List<String> rolsByUserId = roleService.findRolesByUserId(userId);
        //用户的菜单权限
        List<String> permsByUserId = menuService.findPermsByUserId(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(rolsByUserId);
        info.addStringPermissions(permsByUserId);
        return info;
    }


}
