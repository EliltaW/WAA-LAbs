package edu.miu.waa.lab1.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.miu.waa.lab1.model.Post;
import edu.miu.waa.lab1.model.Role;
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
    @JsonProperty("user_email")
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("role_list")
    private List<Role> roles;
    @JsonProperty("user_password")
    private String password;



}
