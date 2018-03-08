import java.util.ArrayList;

public class Example {
    public static ArrayList<Point> SolutionList = new ArrayList<Point>();

    public static int x1 = -2;
    public static int y1 = 3;
    public static int res = 13;

    public static ArrayList<Point> Limit(int ax, int ay, int res){
        for(int x = 0; x<=30; x++){
            for(int y = 0; y<=30; y++ ){
                int ex = ax*x + ay*y;
                if(ex==res){
                    Point point = new Point(x, y);
                    SolutionList.add(point);
                }
            }
        }
        return SolutionList;
    }

    public static ArrayList<Point> checkIntersection(ArrayList<Point> ar1, ArrayList<Point> ar2, ArrayList<Point> ar3, ArrayList<Point> ar4, ArrayList<Point> ar5){

        ArrayList<Point> intersectionPoints = new ArrayList<Point>();

        for(int i = 0; i < ar1.size(); i++){
            for(int j = 0; j < ar2.size(); j++){
                for(int a = 0; a < ar3.size(); a++){
                    int tempx1 = ar1.get(i).getX();
                    int tempy1 = ar1.get(i).getY();
                    int tempx2 = ar2.get(j).getY();
                    int tempy2 = ar2.get(j).getY();
                    if((tempx1 == tempx2)&&(tempy1 == tempy2)){
                        Point point = new Point(tempx1, tempy1);
                        intersectionPoints.add(point);
                    }
                }
            }
        }

        return intersectionPoints;

    }
}

