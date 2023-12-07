package com.loevc.celestia.admin.v2.behavioral.chain_of_responsibility.example.middleware;

import com.loevc.celestia.admin.v2.behavioral.chain_of_responsibility.example.server.Server;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 9:08
 * @Description TODO
 * @Version 1.0
 */
public class UserExistsMiddleware extends Middleware{

    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}
