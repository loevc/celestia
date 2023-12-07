package com.loevc.celestia.admin.v2.creational.prototype.caching.cache;

import com.loevc.celestia.admin.v2.creational.prototype.example.shapes.Circle;
import com.loevc.celestia.admin.v2.creational.prototype.example.shapes.Rectangle;
import com.loevc.celestia.admin.v2.creational.prototype.example.shapes.Shape;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/6 16:33
 * @Description TODO
 * @Version 1.0
 */
public class BundleShapeCache {

    private Map<String, Shape> cache = new HashMap<>();

    public BundleShapeCache(){
        Circle circle = new Circle();
        circle.x = 5;
        circle.y = 7;
        circle.radius = 45;
        circle.color = "Green";

        Rectangle rectangle = new Rectangle();
        rectangle.x = 6;
        rectangle.y = 9;
        rectangle.width = 8;
        rectangle.height = 10;
        rectangle.color = "Blue";

        cache.put("Big green circle", circle);
        cache.put("Medium blue rectangle", rectangle);
    }

    public Shape put(String key, Shape shape){
        cache.put(key, shape);
        return shape;
    }

    public Shape get(String key){
        return cache.get(key).clone();
    }
}
