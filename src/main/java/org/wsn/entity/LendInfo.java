package org.wsn.entity;

import lombok.*;

/**
 * @project:wsn-lib
 * @file:LendInfo
 * @author:wsn
 * @create:2023/1/30-22:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LendInfo {
    public String serNum;
    public String ISBN;
    public String bookName;
    public String lendDate;
    public String backDate;
    public String author;
    public String img;
}
