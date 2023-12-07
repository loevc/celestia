package com.loevc.celestia.admin.v2.structural.proxy.example.some_cool_media_library;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 19:18
 * @Description TODO
 * @Version 1.0
 */
public class Video {

    public String id;
    public String title;
    public String data;

    Video(String id, String title) {
        this.id = id;
        this.title = title;
        this.data = "Random video.";
    }
}
