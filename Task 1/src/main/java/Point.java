public class Point {

    // point is  coordinate of axes which satisfies limt
    private float x;
    private float y;

    Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public void setPoint(float x, float y){
        this.x = x;
        this.y = y;
    }
}
