import java.util.ArrayList;
import java.util.Collections;

public class App {

    //here there are parametres for each limit and for final example
    //-----lim-1-----//
    public static float x1 = -2;
    public static float y1 = 3;
    public static float res1 = 13;
    //-----lim-2-----//
    public static int x2 = 3;
    public static int y2 = 1;
    public static int res2 = 8;
    //-----lim-3-----//
    public static int x3 = 1;
    public static int y3 = 4;
    public static int res3 = 32;
    //-----lim-4-----//
    public static float x4 = 5;
    public static float y4 = -1;
    public static float res4 = 34;
    //-----lim-5-----//
    public static int x5 = 3;
    public static int y5 = 5;
    public static int res5 = 12;
    //-----example-----//
    public static int ex = 4;
    public static int ey = 3;
    //res -> max

    public static Point inter12(){
        float zero = (x1*y2)-(y1*x2);
       if (zero != 0 ){
           float interX = ((res1*y2)-(y1*res2))/zero;
           float interY = ((x1*res2)-(res1*x2))/zero;

           Point point = new Point(interX, interY);
           return point;
        }
        else
            return null;
    }

    public static Point inter13(){

        float zero = (x1*y3)-(y1*x3);

        if (zero != 0){

            float interX = ((res1*y3)-(y1*res3))/zero;
            float interY = ((x1*res3)-(res1*x3))/zero;

            Point point = new Point(interX, interY);
            return point;
        }
        else
            return null;
    }

    public static Point inter14(){

        float zero = (x1*y4)-(y1*x4);

        if (zero != 0 ){

            float interX = ((res1*y4)-(y1*res4))/zero;
            float interY = ((x1*res4)-(res1*x4))/zero;

            Point point = new Point(interX, interY);
            return point;
        }
        else
            return null;
    }

    public static Point inter15(){

        float zero = (x1*y5)-(y1*x5);

        if (zero != 0 ){

            float interX = ((res1*y5)-(y1*res5))/zero;
            float interY = ((x1*res5)-(res1*x5))/zero;

            Point point = new Point(interX, interY);
            return point;
        }
        else
            return null;
    }

    public static Point inter23(){

        float zero = (x2*y3)-(y2*x3);

        if (zero != 0){

            float interX = ((res2*y3)-(y2*res3))/zero;
            float interY = ((x2*res3)-(res2*x3))/zero;

            Point point = new Point(interX, interY);
            return point;
        }
        else
            return null;
    }

    public static Point inter24(){

        float zero = (x2*y4)-(y2*x4);

        if (zero != 0 ){

            float interX = ((res2*y4)-(y2*res4))/zero;
            float interY = ((x2*res4)-(res2*x4))/zero;

            Point point = new Point(interX, interY);
            return point;
        }
        else
            return null;
    }

    public static Point inter25(){

        float zero = (x2*y5)-(y2*x5);

        if ( zero != 0 ){

            float interX = ((res2*y5)-(y2*res5))/zero;
            float interY = ((x2*res5)-(res2*x5))/zero;

            Point point = new Point(interX, interY);
            return point;
        }
        else
            return null;
    }

    public static Point inter34(){

        float zero = (x3*y4)-(y3*x4);

        if ( zero != 0 ){

            float interX = ((res3*y4)-(y3*res4))/zero;
            float interY = ((x3*res4)-(res3*x4))/zero;

            Point point = new Point(interX, interY);
            return point;
        }
        else
            return null;
    }

    public static Point inter35(){

        float zero = (x3*y5)-(y3*x5);

        if ( zero != 0 ){

            float interX = ((res3*y5)-(y3*res5))/zero;
            float interY = ((x3*res5)-(res3*x5))/zero;

            Point point = new Point(interX, interY);
            return point;
        }
        else
            return null;
    }

    public static Point inter45(){

        float zero = (x4*y5)-(y4*x5);

        if ( zero != 0 ){

            float interX = ((res4*y5)-(y4*res5))/zero;
            float interY = ((x4*res5)-(res4*x5))/zero;

            Point point = new Point(interX, interY);
            return point;
        }
        else
            return null;
    }

    public static ArrayList<Point> interPoints(){

        ArrayList<Point> interList = new ArrayList<Point>();

        Point p1 = inter12();
        Point p2 = inter13();
        Point p3 = inter14();
        Point p4 = inter15();
        Point p5 = inter23();
        Point p6 = inter24();
        Point p7 = inter25();
        Point p8 = inter34();
        Point p9 = inter35();
        Point p10 = inter45();

        if (p1.getX() >= 0 && p1.getY() >= 0){
            interList.add(p1);
        }

        if (p2.getX() >= 0 && p2.getY() >= 0){
            interList.add(p2);
        }

        if (p3.getX() >= 0 && p3.getY() >= 0){
            interList.add(p3);
        }

        if (p4.getX() >= 0 && p4.getY() >= 0){
            interList.add(p4);
        }

        if (p5.getX() >= 0 && p5.getY() >= 0){
            interList.add(p5);
        }

        if (p6.getX() >= 0 && p6.getY() >= 0){
            interList.add(p6);
        }

        if (p7.getX() >= 0 && p7.getY() >= 0){
            interList.add(p7);
        }

        if (p8.getX() >= 0 && p8.getY() >= 0){
            interList.add(p8);
        }

        if (p9.getX() >= 0 && p9.getY() >= 0){
            interList.add(p9);
        }

        if (p10.getX() >= 0 && p10.getY() >= 0){
            interList.add(p10);
        }
            return interList;
    }

    public static Point result(){

        ArrayList<Float> cal = new ArrayList<Float>();
        ArrayList<Point> p = interPoints();
        Point pnt = new Point(0, 0);
        for(int i=0; i< interPoints().size()-1; i++){
            pnt = p.get(i);
            float res1 = (p.get(i).getX() * ex) + (p.get(i).getY() * ey);
            float res2 = (p.get(i+1).getX() * ex) + (p.get(i+1).getY() * ey);

            if(res1<res2){
                pnt = p.get(i+1);
            }
        }
        return pnt;
    }
}
