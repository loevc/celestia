package com.loevc.celestia.admin.v2.creational.singleton.example.thread_safe;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 16:57
 * @Description TODO
 * @Version 1.0
 */
public class Singleton {

    private static volatile Singleton instance;

    public String value;

    private Singleton(String value){
        this.value = value;
    }

    public static Singleton getInstance(String value){
        Singleton res = instance;
        if (res != null){
            return res;
        }
        synchronized (Singleton.class){
            if (instance == null){
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}
