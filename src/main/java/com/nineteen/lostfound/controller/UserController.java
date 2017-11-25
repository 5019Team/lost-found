package com.nineteen.lostfound.controller;

import com.alibaba.fastjson.JSONObject;
import com.nineteen.lostfound.dao.harmony.entity.User;
import com.nineteen.lostfound.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by mengxu on 2017/9/26.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public JSONObject checkLogin(@RequestBody JSONObject jsonObject) {
        JSONObject result=new JSONObject();
        String username=(String) jsonObject.get("username");
        String password=(String)jsonObject.get("password");
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject currentUser = SecurityUtils.getSubject();
            if (!currentUser.isAuthenticated()){
                //使用shiro来验证
                token.setRememberMe(true);
                currentUser.login(token);//验证角色和权限
                result.put("success", true);
            }
        }catch(Exception ex){
            result.put("success",false);
        }
        return result;
    }
    @RequestMapping(value="/logout",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject logout(){
        String me="hello world";
        JSONObject result=new JSONObject();
        result.put("me",me);
        userService.login(new User());
        return result;
    }
}
