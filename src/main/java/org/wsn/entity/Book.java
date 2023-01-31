package org.wsn.entity;

import lombok.*;

/**
 * @project:wsn-lib
 * @file:Book
 * @author:wsn
 * @create:2023/1/30-14:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    public int id;

    public String name;
    public String author;
    public String publish;
    public String ISBN;
    public String introduction;
    public String lang;
    public double price;
    public String date;
    public String className;
    public int letNum;
    public String img;
}
