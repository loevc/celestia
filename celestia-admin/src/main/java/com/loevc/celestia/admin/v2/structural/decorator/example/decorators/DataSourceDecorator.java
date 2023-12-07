package com.loevc.celestia.admin.v2.structural.decorator.example.decorators;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 18:25
 * @Description TODO
 * @Version 1.0
 */
public class DataSourceDecorator implements DataSource{

    private DataSource wrappee;

    DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }

}
