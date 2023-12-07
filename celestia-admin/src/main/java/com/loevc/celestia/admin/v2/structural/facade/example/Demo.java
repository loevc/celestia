package com.loevc.celestia.admin.v2.structural.facade.example;

import com.loevc.celestia.admin.v2.structural.facade.example.facade.VideoConversionFacade;

import java.io.File;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 19:06
 * @Description TODO
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        // ...
    }
}
