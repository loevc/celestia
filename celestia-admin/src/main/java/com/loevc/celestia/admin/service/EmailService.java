package com.loevc.celestia.admin.service;

/**
 * @Author caijiliu
 * @Email L13831467435@163.com
 * @Date 2023/10/10 18:15
 * @Description
 * @Version 1.0
 */
public interface EmailService {

    void sendEmail(String to, String subject, String content);
}
