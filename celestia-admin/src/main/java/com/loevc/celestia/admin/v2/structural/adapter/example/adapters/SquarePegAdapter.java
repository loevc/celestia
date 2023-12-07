package com.loevc.celestia.admin.v2.structural.adapter.example.adapters;

import com.loevc.celestia.admin.v2.structural.adapter.example.round.RoundPeg;
import com.loevc.celestia.admin.v2.structural.adapter.example.square.SquarePeg;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 17:46
 * @Description TODO
 * @Version 1.0
 */
public class SquarePegAdapter extends RoundPeg {

    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg){
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double res;
        res = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return res;
    }
}
