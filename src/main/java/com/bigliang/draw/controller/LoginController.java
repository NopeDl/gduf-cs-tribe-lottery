package com.bigliang.draw.controller;

import com.bigliang.draw.cache.LoginUsers;
import com.bigliang.draw.utils.PhoneUtil;
import com.bigliang.draw.utils.TokenUtil;
import com.bigliang.draw.vo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/8/28 15:54
 */

@RestController
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/login")
    public Message login(@PathParam("phone") String phone) {
        try {
            if (phone.length() < 11) {
                return new Message(40001, "未输入正确的电话号码，请重试，谢谢！");
            } else if (!PhoneUtil.check(phone)) {
                return new Message(40001, "未输入正确的电话号码，请重试，谢谢！");
            } else {
                String token = TokenUtil.getToken();
                LoginUsers.addUser(token, phone);
                return new Message(200, token);
            }
        } catch (NullPointerException nullPointerException) {
            logger.error(nullPointerException.getMessage());
            return new Message(4002, "手机号不能为空！请重试！");
        }
    }


}
