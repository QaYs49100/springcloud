package com.baidu.springcloud.dot;

import  org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;


@Validated
public class Person {

    @NotBlank(message = "用户名不能为空")
    @Size(min = 6,max = 11,message = "用户名字符长度不符合6～11")
    //@Max(value = 5,message = "用户名为大于指定值5")
    private String username;

    @NotBlank(message = "地址不能为空")
    @Size(min = 6,max = 11,message = "用户地址符长度不符合6～11")
    private String address;

    @NotEmpty(message = "密码不能为空")
    @Pattern(regexp = "[a-zA-z0-9]{6,11}")
    private String password;

    @NotNull
    @Max(value = 100,message = "年龄大于100")
    @Min(value = 1,message = "年龄不能小于1")
    private Integer age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
