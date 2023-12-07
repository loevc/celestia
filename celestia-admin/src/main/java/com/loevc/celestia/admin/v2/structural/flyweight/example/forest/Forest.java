package com.loevc.celestia.admin.v2.structural.flyweight.example.forest;

import com.loevc.celestia.admin.v2.structural.flyweight.example.trees.Tree;
import com.loevc.celestia.admin.v2.structural.flyweight.example.trees.TreeFactory;
import com.loevc.celestia.admin.v2.structural.flyweight.example.trees.TreeType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 19:10
 * @Description TODO
 * @Version 1.0
 */
public class Forest extends JFrame {

    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Tree tree : trees) {
            tree.draw(graphics);
        }
    }

}
