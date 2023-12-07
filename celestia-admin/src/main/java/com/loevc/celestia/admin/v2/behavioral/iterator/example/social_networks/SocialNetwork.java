package com.loevc.celestia.admin.v2.behavioral.iterator.example.social_networks;

import com.loevc.celestia.admin.v2.behavioral.iterator.example.iterators.ProfileIterator;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:24
 * @Description TODO
 * @Version 1.0
 */
public interface SocialNetwork {

    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
