package com.bdqn.controller;

import cn.bdqn.RpcQgUserService;
import cn.bdqn.common.*;
import cn.bdqn.pojo.QgUser;
import cn.bdqn.vo.TokenVO;
import com.alibaba.boot.dubbo.annotation.DubboConsumer;
import com.alibaba.fastjson.JSONArray;
import com.bdqn.biz.UserBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("api")
public class UserController {
    @Resource
    RedisUtils redisUtils;

    @DubboConsumer
    private RpcQgUserService userService;

    @RequestMapping("/dologin")
    @ResponseBody
    public Object doLogin(String phone, String token,String password, HttpServletResponse response){
        response.addHeader("Access-Control-Allow-Origin","*");
        try {
            QgUser user = userService.findByPhone(phone);
            if(user != null && user.getPassword().equals(password)){
                String key = getToken(user);
                //判断是否有redis
                if(EmptyUtils.isEmpty(token)){
                    //存入redis
                    redisUtils.set(key,3600, JSONArray.toJSONString(user));
                }
                TokenVO tokenVO = new TokenVO(key,
                        Calendar.getInstance().getTimeInMillis()+3600,
                        Calendar.getInstance().getTimeInMillis());
                return DtoUtil.returnDataSuccess(tokenVO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DtoUtil.returnFail("登录失败","100000");
    }

    @RequestMapping("/iUser")
    @ResponseBody
    public Dto insertUser(){
        for(int i = 1; i <= 1000; i++){
            QgUser user = new QgUser();
            user.setId(i+"");
            user.setPhone("18201408673");
            redisUtils.set("U:"+i,JSONArray.toJSONString(user));
        }
        return DtoUtil.returnDataSuccess("1000个用户插入成功");
    }

    public String getToken(QgUser user){
        //MD5加密（手机号）-uid-时间戳
        StringBuffer buffer = new StringBuffer();
        buffer.append(MD5.getMd5(user.getPhone(),32)+"-");
        buffer.append(user.getId()+"-");
        buffer.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        return buffer.toString();
    }
}
