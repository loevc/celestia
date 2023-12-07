package com.loevc.celestia.admin.v2.structural.decorator.example.decorators;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 18:23
 * @Description
 * @Version 1.0
 */
public interface DataSource {

    void writeData(String data);

    String readData();
}
