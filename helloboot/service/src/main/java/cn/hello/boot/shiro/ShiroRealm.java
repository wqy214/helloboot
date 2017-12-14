package cn.hello.boot.shiro;

import cn.hello.boot.constant.UserStatus;
import cn.hello.boot.domain.Menu;
import cn.hello.boot.domain.Role;
import cn.hello.boot.domain.User;
import cn.hello.boot.service.UserService;
import com.google.common.collect.Lists;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.*;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {


        UsernamePasswordToken upt = (UsernamePasswordToken) token;
        User user = userService.findByName(upt.getUsername());

        if(user == null){
            throw new UnknownAccountException();
        }
        if(user.getStatus() == UserStatus.OFF.getStatus()){
            throw new LockedAccountException();
        }
        ByteSource byteSource = ByteSource.Util.bytes(user.getUserName());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPswd(),byteSource,getName());
        return info;
    }


    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // TODO Auto-generated method stub

        User user = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User repUser = userService.findByName(user.getUserName());

        /**
         * 设置角色
         */
        Set<Role> roleSet = repUser.getRoles();
        Set<String> roleResources = new HashSet<String>(Lists.transform(new ArrayList<Role>(roleSet), r-> r.getResource()));
        info.setRoles(roleResources);

        /**
         * 设置权限
         */
        Set<Menu> menuSet = repUser.getMenus();
        roleSet.forEach(role->{ menuSet.addAll(role.getMenus());});
        Set<String> menuResources = new HashSet<String>(Lists.transform(new ArrayList<Menu>(menuSet),r-> r.getResource()));
        info.setStringPermissions(menuResources);

        return info;
    }

}
