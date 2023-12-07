package com.loevc.celestia.admin.v2.behavioral.iterator.example.iterators;

import com.loevc.celestia.admin.v2.behavioral.iterator.example.profile.Profile;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:21
 * @Description TODO
 * @Version 1.0
 */
public interface ProfileIterator {

    boolean hasNext();

    Profile getNext();

    void reset();
}
