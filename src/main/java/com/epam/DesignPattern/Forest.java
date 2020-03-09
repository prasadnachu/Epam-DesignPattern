package com.epam.DesignPattern;

import javax.swing.*;

import com.epam.DesignPattern.Tree;
import com.epam.DesignPattern.TreeFactory;
import com.epam.DesignPattern.TreeType;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Forest extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, Color color, String otherTreeData) {
        TreeType type = TreeFactory.getTreeType(name, color, otherTreeData);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void paint(Graphics graphics) {
        for (Tree tree : trees) {
            tree.draw(graphics);
        }
    }
}