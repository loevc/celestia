package com.loevc.celestia.admin.v2.behavioral.state.example.states;

import com.loevc.celestia.admin.v2.behavioral.state.example.ui.Player;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:23
 * @Description TODO
 * @Version 1.0
 */
public class ReadyState extends State{

    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        return "Locked...";
    }

    @Override
    public String onPlay() {
        String action = player.startPlayback();
        player.changeState(new PlayingState(player));
        return action;
    }

    @Override
    public String onNext() {
        return "Locked...";
    }

    @Override
    public String onPrevious() {
        return "Locked...";
    }
}
