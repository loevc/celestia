package com.loevc.celestia.admin.v2.behavioral.state.example.states;

import com.loevc.celestia.admin.v2.behavioral.state.example.ui.Player;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:22
 * @Description TODO
 * @Version 1.0
 */
public abstract class State {
    Player player;

    /**
     * Context passes itself through the state constructor. This may help a
     * state to fetch some useful context data if needed.
     */
    State(Player player) {
        this.player = player;
    }

    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();

}
