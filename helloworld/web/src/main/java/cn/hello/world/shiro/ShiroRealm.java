package cn.hello.world.shiro;

import cn.hello.world.constant.UserStatus;
import cn.hello.world.domain.Permission;
import cn.hello.world.domain.Role;
import cn.hello.world.domain.User;
import cn.hello.world.service.PermissionService;
import cn.hello.world.service.RoleService;
import cn.hello.world.service.UserService;
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
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

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
        ByteSource byteSource = ByteSource.Util.bytes(user.getUsername());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), byteSource, this.getName());
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

        /**
         * 设置角色
         */
        Set<Role> roleSet = roleService.findRolesByUserId(user.getId());
        Set<String> roleNames = new HashSet<String>(Lists.transform(new ArrayList<Role>(roleSet), r-> r.getName()));
        info.setRoles(roleNames);

        /**
         * 设置权限
         */

        Set<Permission> permissionSet = new HashSet<>();
        for (Role role : roleSet) {
            Set<Permission> set = permissionService.findPermissionsByRoleId(role.getId());
            permissionSet.addAll(set);
        }
        Set<String> permissions = new HashSet<String>(Lists.transform(new ArrayList<Permission>(permissionSet),r-> r.getName()));
        info.setStringPermissions(permissions);

        return info;
    }

}
