import java.util.ArrayList;

//The main funktion of this class is checkIntersection() function which returns set of intersection points intersectionPoints

public class Limits {
    public static ArrayList<Point> Limit(int ax, int ay, int res){
        ArrayList<Point> SolutionList = new ArrayList<Point>();
        for(int i = (-10); i<=30; i++){
            for(int j = (-10); j<=30; j++ ){
                int ex = ax*i + ay*j;

                //1*1 + 4*5 = 8
                if(ex==res) {
                    //System.out.print("ex = " + ex + " " + "res = " + res + "   ");
                    //System.out.println("--- " + i + " --- " + i + " ---");
                    Point point = new Point(i, j);
                    SolutionList.add(point);
                }
            }
        }
        return SolutionList;
    }

    public void checkSolutionList(ArrayList<Point> solList, int x1, int y1, int res1, boolean sign1,
                                  int x2, int y2, int res2, boolean sign2,
                                  int x3, int y3, int res3, boolean sign3,
                                  int x4, int y4, int res4, boolean sign4,
                                  int x5, int y5, int res5, boolean sign5){
        ArrayList<Point> modifiedSolutionList = new ArrayList<Point>();
        for(int i=0; i<solList.size(); i++){
            int ex1 = x1*solList.get(i).getX() + y1*solList.get(i).getY();
            int ex2 = x2*solList.get(i).getX() + y2*solList.get(i).getY();
            int ex3 = x3*solList.get(i).getX() + y4*solList.get(i).getY();
            int ex4 = x4*solList.get(i).getX() + y4*solList.get(i).getY();
            int ex5 = x5*solList.get(i).getX() + y5*solList.get(i).getY();
            if(sign1 == true){
                if(ex1<=res1){
                    Point point = new Point(solList.get(i).getX(),solList.get(i).getY());
                    modifiedSolutionList.add(point);
                }

            }else{
                if(res1<=ex1){
                    Point point = new Point(solList.get(i).getX(),solList.get(i).getY());
                    modifiedSolutionList.add(point);
                }
            }
        }
    }

    public static Point intersectionPoint(ArrayList<Point> ar1, ArrayList<Point> ar2){
        Point point = null;
        Point temp1;
        Point temp2;
        for(int i=0; i<ar1.size(); i++){
            for(int j=0; j<ar2.size(); j++){
                temp1 = new Point(ar1.get(i).getX(),ar1.get(i).getY());
                temp2 = new Point(ar2.get(j).getX(),ar2.get(j).getY());
//                System.out.println("--- " + ar1.get(i).getX() + " --- " + ar1.get(i).getY() + " ---"
//                        + ar2.get(j).getX() + " --- " + ar2.get(j).getY() + " ---");
                if((temp1.getX() == temp2.getX())&&(temp1.getY() == temp2.getY())){
                    //missed second if
                        point = temp1;
                        System.out.println("Point of intersection " + point.getX() + " + " + point.getY());
                }
            }
        }
        return point;
    }

    public static Point lineIntersectionPoint(int x1, int y1, int res1, int x2, int y2, int res2){
        double x;
        double y;
        double paramY;

//        paramY =(((x1*x) - res1) / (-y1));
//        x = (res2 - (y2*paramY))/x2;
        return null;
    }

    public static ArrayList<Point> intersectionList(ArrayList<Point> ar1, ArrayList<Point> ar2, ArrayList<Point> ar3,
                                                    ArrayList<Point> ar4, ArrayList<Point> ar5){
        ArrayList<Point> list = new ArrayList<Point>();
        list.add(intersectionPoint(ar1, ar2));
        list.add(intersectionPoint(ar1, ar3));
        list.add(intersectionPoint(ar1, ar4));
        list.add(intersectionPoint(ar1, ar5));

        list.add(intersectionPoint(ar2, ar3));
        list.add(intersectionPoint(ar2, ar4));
        list.add(intersectionPoint(ar2, ar5));

        list.add(intersectionPoint(ar3, ar4));
        list.add(intersectionPoint(ar3, ar5));

        list.add(intersectionPoint(ar4, ar5));

        return list;
    }
}

