package com.loevc.celestia.admin.v2.behavioral.chain_of_responsibility.example.middleware;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 9:08
 * @Description TODO
 * @Version 1.0
 */
public class RoleCheckMiddleware extends Middleware{

    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}
