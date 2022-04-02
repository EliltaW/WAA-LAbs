package edu.miu.waa.lab1.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PostDto {

   @JsonProperty("post_id")
    private long id;
    @JsonProperty("post_title")
    private String title;
    @JsonProperty("author_name")
    private String author;
    @JsonProperty("post_content")
    private String content;

}
