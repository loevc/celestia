package com.loevc.celestia.admin.v2.structural.proxy.example.some_cool_media_library;

import java.util.HashMap;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 19:16
 * @Description
 * @Version 1.0
 */
public interface ThirdPartyYouTubeLib {

    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}
