package org.wsn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wsn.entity.Reader;
import org.wsn.service.UserService;
import org.wsn.utils.TokenUtil;

import java.util.List;

/**
 * @project:wsn-lib
 * @file:UserController
 * @author:wsn
 * @create:2023/1/30-23:26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    public Reader getReaderInfo(@RequestHeader("token") String token) {
        return userService.getReaderInfo(token);
    }
    public List<Reader> getAllReader() {
        return userService.getAllReader();
    }
    public void changeReaderInfo(@RequestHeader("token") String token, String name, String sex, String birth, String address, String phone) {
        userService.changeReaderInfo(token, name, sex, birth, address, phone);
    }
    public void changeReaderByAdmin(@RequestHeader("token") String token, String name, String sex, String birth, String address, String phone, String username, String password) {
        userService.changeReaderByAdmin(token, name, sex, birth, address, phone, username, password);
    }
    public int changeReaderPass(@RequestHeader("token") String token, String oldpass, String password) {
        return userService.changeReaderPass(token, oldpass, password);
    }
}
