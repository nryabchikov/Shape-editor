package by.ryabchikov.lab1.friend_plugin;

import java.awt.*;

public abstract class Figure {

    public String fabricName="";

    protected double angle=0;

    protected int mode=0;

    protected Color lineColor=Color.BLACK;

    public MyPoint leftHigh;

    public int w;

    public int h;

    public MyPoint centr;

    public MyPoint anchorPoint;

    protected Stroke stroke=new BasicStroke();

    abstract public void setPoints(MyPoint dot, int w, int h);

    abstract public boolean pointInFigure(int x, int y);

    public Figure(){}


    public void setColor(int color)
    {
        lineColor=new Color(color);
    }
    public void setStroke(int stroke)
    {
        this.stroke=new BasicStroke(stroke);
    }

    public void setAngle(double ang)
    {
        angle=ang;
    }

    public void setMode(int m)
    {
        mode=m;
    }

    public int getColor()
    {
        return lineColor.getRGB();
    }

    public int getMode()
    {
        return mode;
    }

    public double getAngle()
    {
        return angle;
    }

    public int getStroke()
    {
        return (int)(((BasicStroke)stroke).getLineWidth());
    }

    public void setAnchorPoint(MyPoint dot){
        anchorPoint=dot;
    }

    public MyPoint getAnchorPoint()
    {
        return anchorPoint;
    }

    public void setCentr(MyPoint dot){
        centr=dot;
    }

    public MyPoint getCentr()
    {
        return centr;
    }

    public void setLeftHigh(MyPoint dot){
        leftHigh=dot;
    }

    public MyPoint getLeftHigh()
    {
        return leftHigh;
    }

    public void setW(int w)
    {
        this.w=w;
    }

    public int getW()
    {
        return w;
    }

    public void setH(int h)
    {
        this.h=h;
    }

    public int getH()
    {
        return h;
    }

    public void setFabricName(String name)
    {
        this.fabricName=name;
    }

    public String getFabricName()
    {
        return fabricName;
    }
}
