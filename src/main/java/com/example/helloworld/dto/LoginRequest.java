package com.example.helloworld.dto;

// 完全移除 Lombok 注解，手动编写所有方法
public class LoginRequest {
    private String username;
    private String password;

    // 无参构造器（Spring 解析 JSON 需要）
    public LoginRequest() {
    }

    // 全参构造器（可选）
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // 手动编写 getUsername() 方法（解决核心错误）
    public String getUsername() {
        return username;
    }

    // 手动编写 setUsername() 方法
    public void setUsername(String username) {
        this.username = username;
    }

    // 手动编写 getPassword() 方法
    public String getPassword() {
        return password;
    }

    // 手动编写 setPassword() 方法
    public void setPassword(String password) {
        this.password = password;
    }
}