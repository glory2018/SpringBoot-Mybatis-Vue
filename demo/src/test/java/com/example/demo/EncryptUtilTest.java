package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class EncryptUtilTest {
//    public static void main(String[] args) {
//        String pass = "admin";
//        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
//        String hashPass = bcryptPasswordEncoder.encode(pass);
//        System.out.println(hashPass);
//
//        boolean f = bcryptPasswordEncoder.matches("admin",hashPass);
//        System.out.println(f);
//
//    }
    //从配置文件中获得
    private static final String SITE_WIDE_SECRET = "my-secret-key";
    private static final PasswordEncoder encoder = new StandardPasswordEncoder(
            SITE_WIDE_SECRET);

    public static String encrypt(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public static boolean match(String rawPassword, String password) {
        return encoder.matches(rawPassword, password);
    }

//    public static void main(String[] args) {
//        String a=EncryptUtilTest.encrypt("123456");
//        System.out.println(a);
//        System.out.println(match(a,"5dabfb85ca1e0bd9b93237276b77899d914ded7ca7225e7ff111a6d49ca451e10f73b9183f227b56"));
//         a=EncryptUtilTest.encrypt("123456");
//        System.out.println(a);
//        System.out.println(match(a,"5dabfb85ca1e0bd9b93237276b77899d914ded7ca7225e7ff111a6d49ca451e10f73b9183f227b56"));
//         a=EncryptUtilTest.encrypt("123456");
//        System.out.println(a);
//        System.out.println(match(a,"5dabfb85ca1e0bd9b93237276b77899d914ded7ca7225e7ff111a6d49ca451e10f73b9183f227b56"));
//
//        //但是把每次结果拿出来进行match，你会发现可以得到true。
//    }
    public static void main(String[] args) {
        BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
        String mm_pub = "123456";
        String mm_encode = bcp.encode(mm_pub);
        System.out.println(mm_encode);
        //bcp.matches(mm_pub,mm_encode)，第一个参数是前端传递过来的明文密码，如123456，第二个参数是添加用户时存储的密码
        if(bcp.matches(mm_pub,mm_encode)){
            System.out.println("密码校验成功");
        }else{
            System.out.println("密码错误");
        }
    }

}