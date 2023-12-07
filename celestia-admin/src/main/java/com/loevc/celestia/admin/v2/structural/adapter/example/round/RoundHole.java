package com.loevc.celestia.admin.v2.structural.adapter.example.round;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 17:11
 * @Description TODO
 * @Version 1.0
 */
public class RoundHole {

    private double radius;

    public RoundHole(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg peg){
        boolean res;
        res = (this.getRadius() >= peg.getRadius());
        return res;
    }
}
