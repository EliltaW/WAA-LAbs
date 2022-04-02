package edu.miu.waa.lab1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostV2 {

    private long id;
    private String title;
    private String content;
    private String author;
}
