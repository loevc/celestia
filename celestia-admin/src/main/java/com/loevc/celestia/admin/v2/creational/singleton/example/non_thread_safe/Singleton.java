package com.loevc.celestia.admin.v2.creational.singleton.example.non_thread_safe;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 16:42
 * @Description TODO
 * @Version 1.0
 */
public class Singleton {

    private static Singleton instance;

    public String value;

    private Singleton(String value){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value){
        if (instance == null){
            instance = new Singleton(value);
        }
        return instance;

    }
}
