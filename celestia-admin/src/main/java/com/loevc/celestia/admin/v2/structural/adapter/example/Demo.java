package com.loevc.celestia.admin.v2.structural.adapter.example;

import com.loevc.celestia.admin.v2.structural.adapter.example.adapters.SquarePegAdapter;
import com.loevc.celestia.admin.v2.structural.adapter.example.round.RoundHole;
import com.loevc.celestia.admin.v2.structural.adapter.example.round.RoundPeg;
import com.loevc.celestia.admin.v2.structural.adapter.example.square.SquarePeg;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 17:53
 * @Description TODO
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg rPeg = new RoundPeg(5);
        if (hole.fits(rPeg)){
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);

        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)){
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)){
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }
    }
}
