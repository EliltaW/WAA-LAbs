package edu.miu.waa.lab1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {

    private long id;
    private String title;
    private String content;
    private String author;
}
