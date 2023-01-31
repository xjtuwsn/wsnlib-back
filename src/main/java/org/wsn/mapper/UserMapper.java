package org.wsn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.wsn.entity.Reader;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    Reader getReaderInfo(int id);
    List<Reader> getAllReader();
    void changeReaderInfo(int id, String name, String sex, String birth, String address, String phone);
    void changeReaderByAdmin(int id, String name, String sex, String birth, String address, String phone, String username, String password);
    void changeReaderPass(int id, String password);
    String getPass(int id);
}
