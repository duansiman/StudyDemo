package com.epdc.surface.widget;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Epdc on 2015/9/20.
 */
public abstract class Container {

    List<Container> childerns;
    public int x, y;

    public Container(){
        childerns = new ArrayList<>();
    }

    public void draw(Canvas canvas){

        canvas.save();
        canvas.translate(x,y);

        //先画自己
        drawChildern(canvas);

        //再画子控件
        for (Container c : childerns) {
            c.draw(canvas);
        }
        canvas.restore();
    }

    public abstract void drawChildern(Canvas canvas);

    public void addChildern(Container child){
        this.childerns.add(child);
    }

    public void remove(Container child){
        this.childerns.remove(child);
    }

}
