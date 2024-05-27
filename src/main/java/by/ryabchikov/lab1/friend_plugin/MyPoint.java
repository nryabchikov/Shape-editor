package by.ryabchikov.lab1.friend_plugin;

public class MyPoint {
    public int x;
    public int y;

    public static MyPoint getMinCoords(MyPoint a, MyPoint b) {
        return new MyPoint(Math.min(a.x, b.x), Math.min(a.y, b.y));
    }

    public static MyPoint getMaxCoords(MyPoint a, MyPoint b) {
        return new MyPoint(Math.max(a.x, b.x), Math.min(a.y, b.y));
    }

    public MyPoint(){}

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y)
    {
        this.y=y;
    }

    public int getY() {
        return y;
    }
}

