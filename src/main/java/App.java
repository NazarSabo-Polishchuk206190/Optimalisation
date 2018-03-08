import java.util.ArrayList;

public class App {
    public static int x1 = -2;
    public static int y1 = 3;
    public static int res1 = 13;

    public static int x2 = 3;
    public static int y2 = 1;
    public static int res2 = 8;

    public static int x3 = 1;
    public static int y3 = 4;
    public static int res3 = 32;

    public static int x4 = 5;
    public static int y4 = -1;
    public static int res4 = 34;

    public static int x5 = 3;
    public static int y5 = 5;
    public static int res5 = 12;

    public static ArrayList<Point> SolutionList1 = new ArrayList<Point>();
    public static ArrayList<Point> SolutionList2 = new ArrayList<Point>();
    public static ArrayList<Point> SolutionList3 = new ArrayList<Point>();
    public static ArrayList<Point> SolutionList4 = new ArrayList<Point>();
    public static ArrayList<Point> SolutionList5 = new ArrayList<Point>();

    void Solve(){
        SolutionList1 = Example.Limit(x1,y1,res1);
        SolutionList2 =  Example.Limit(x2,y2,res2);
        SolutionList3 =  Example.Limit(x3,y3,res3);
        SolutionList4 =  Example.Limit(x4,y4,res4);
        SolutionList5 =  Example.Limit(x5,y5,res5);

    }
}
