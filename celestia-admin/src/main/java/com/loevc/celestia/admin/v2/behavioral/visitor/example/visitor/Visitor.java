package com.loevc.celestia.admin.v2.behavioral.visitor.example.visitor;

import com.loevc.celestia.admin.v2.behavioral.visitor.example.shapes.Circle;
import com.loevc.celestia.admin.v2.behavioral.visitor.example.shapes.CompoundShape;
import com.loevc.celestia.admin.v2.behavioral.visitor.example.shapes.Dot;
import com.loevc.celestia.admin.v2.behavioral.visitor.example.shapes.Rectangle;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 11:38
 * @Description TODO
 * @Version 1.0
 */
public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);

}
