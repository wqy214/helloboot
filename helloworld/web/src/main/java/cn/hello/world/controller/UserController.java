package cn.hello.world.controller;

import cn.hello.world.constant.UserStatus;
import cn.hello.world.domain.PageBean;
import cn.hello.world.domain.Rest;
import cn.hello.world.domain.Role;
import cn.hello.world.domain.User;
import cn.hello.world.service.RoleService;
import cn.hello.world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.ArrayUtils;

import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {


        @Autowired
        private UserService userService;
        @Autowired private RoleService roleService;

        @RequestMapping({"","/","/list"})
        public String index(){
            return "user/user-list";
        }

        @RequestMapping("/json")
        @ResponseBody
        public Rest json(
                @RequestParam(value="page",defaultValue="1") Integer page,
                @RequestParam(value="limit",defaultValue="10") Integer size
        ){
            PageBean pageBean = userService.pageQuery(new PageBean(page,size));
            return Rest.okCountData(pageBean.getTotalCount(), pageBean.getData());
        }

        @RequestMapping("/add")
        public String add(Model model){

            model.addAttribute("roleList", roleService.findAll());
            return "user/user-add";
        }

        @ResponseBody
        @RequestMapping("/doAdd")
        public Rest doAdd(User user,String confPassword){
            user.setCreateTime(new Date());
            if(!confPassword.equals(user.getPassword())){
                return Rest.failure("两次输入的密码不一致");
            }

            if(user.getStatus() == null){
                user.setStatus(UserStatus.OFF.getStatus());
            }

//            user.setPassword(ShiroUtil.md51024Pwd(user.getPassword(), user.getUsername()));

            userService.save(user);

            return Rest.ok();
        }
//
//        /**
//         * 执行删除
//         * @param ids
//         * @return
//         */
//        @ResponseBody
//        @RequestMapping("/delete")
//        public Rest delete(@RequestParam("ids[]") Long[] ids){
//            if(ArrayUtils.isEmpty(ids)){
//                return Rest.failure("客户端传入对象id为空");
//            }
//            userService.delete(ids);
//            return Rest.ok();
//        }
//
//        @RequestMapping("/edit")
//        public String edit(Long id,Model model){
//            model.addAttribute("user", userService.findOne(id));
//            return "user/user-edit";
//        }
//
//        @ResponseBody
//        @RequestMapping("/doEdit")
//        public Rest doEdit(User submitUser){
//            if(submitUser.getUserState() == null){
//                submitUser.setUserState(0);
//            }
//            userService.updateById(submitUser, submitUser.getId());
//            return Rest.ok();
//        }
}
