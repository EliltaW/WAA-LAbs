package edu.miu.waa.lab1.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class PostDto {

    private long id;
    private String title;
    private String author;
}
