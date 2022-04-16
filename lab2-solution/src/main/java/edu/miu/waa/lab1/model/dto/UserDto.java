package edu.miu.waa.lab1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.miu.waa.lab1.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @JsonProperty("user_id")
    private Long id;
    @JsonProperty("user_name")
    private String name;
    @JsonProperty("post_list")
    private List<PostDto> posts;



}
