package org.wsn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wsn.entity.Reader;
import org.wsn.mapper.UserMapper;
import org.wsn.utils.TokenUtil;

import java.util.List;

/**
 * @project:wsn-lib
 * @file:UserService
 * @author:wsn
 * @create:2023/1/30-22:58
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public Reader getReaderInfo(String token) {
        return userMapper.getReaderInfo(TokenUtil.getUid(token));
    }
    public List<Reader> getAllReader() {
        return userMapper.getAllReader();
    }
    public void changeReaderInfo(String token, String name, String sex, String birth, String address, String phone) {
        userMapper.changeReaderInfo(TokenUtil.getUid(token), name, sex, birth, address, phone);
    }
    public void changeReaderByAdmin(String token, String name, String sex, String birth, String address, String phone, String username, String password) {
        userMapper.changeReaderByAdmin(TokenUtil.getUid(token), name, sex, birth, address, phone, username, password);
    }
    public int changeReaderPass(String token, String oldpass, String password) {
        int id = TokenUtil.getUid(token);
        String pass = userMapper.getPass(id);
        if (!pass.equals(oldpass)) return 400;
        userMapper.changeReaderPass(id, password);
        return 200;
    }

}
