package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;
    @Email(message = "邮箱格式不正确")
    private String email;
    @NotBlank(message = "昵称不能为空")
    private String username;
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdate;
    private String address;
    private Byte status;
}