package org.wsn.entity;

import lombok.*;

/**
 * @project:wsn-lib
 * @file:Reader
 * @author:wsn
 * @create:2023/1/30-22:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reader {
    public int readerId;
    public String name;
    public String sex;
    public String birth;
    public String address;
    public String phone;
    public String username;
    public String password;
}
