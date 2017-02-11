class Head {

    private int x, y;

    Head(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    private Head() {
        x = 0;
        y = 0;
    }


    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }
}
