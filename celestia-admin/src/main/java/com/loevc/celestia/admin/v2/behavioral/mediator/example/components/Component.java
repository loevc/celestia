package com.loevc.celestia.admin.v2.behavioral.mediator.example.components;

import com.loevc.celestia.admin.v2.behavioral.mediator.example.mediator.Mediator;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:37
 * @Description TODO
 * @Version 1.0
 */
public interface Component {

    void setMediator(Mediator mediator);
    String getName();
}
