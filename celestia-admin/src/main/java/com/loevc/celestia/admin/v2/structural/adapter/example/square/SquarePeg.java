package com.loevc.celestia.admin.v2.structural.adapter.example.square;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 17:39
 * @Description TODO
 * @Version 1.0
 */
public class SquarePeg {

    private double width;

    public SquarePeg(double width){
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare(){
        double res;
        res = Math.pow(this.width, 2);
        return res;
    }
}
