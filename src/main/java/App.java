import java.util.ArrayList;

public class App {

    //here there are parametres for each limit and for final example
    //-----lim-1-----//
    public static int x1 = -2;
    public static int y1 = 3;
    public static int res1 = 13;
    //-----lim-2-----//
    public static int x2 = 3;
    public static int y2 = 1;
    public static int res2 = 8;
    //-----lim-3-----//
    public static int x3 = 1;
    public static int y3 = 4;
    public static int res3 = 32;
    //-----lim-4-----//
    public static int x4 = 5;
    public static int y4 = -1;
    public static int res4 = 34;
    //-----lim-5-----//
    public static int x5 = 3;
    public static int y5 = 5;
    public static int res5 = 12;
    //-----example-----//
    public static int ex = 4;
    public static int ey = 3;
    //res -> max

    public static ArrayList<Point> SolutionList1 = new ArrayList<Point>();
    public static ArrayList<Point> SolutionList2 = new ArrayList<Point>();
    public static ArrayList<Point> SolutionList3 = new ArrayList<Point>();
    public static ArrayList<Point> SolutionList4 = new ArrayList<Point>();
    public static ArrayList<Point> SolutionList5 = new ArrayList<Point>();

    public static void Solve(){
        int max = 0;
        ArrayList<Point> FinalSolutionList = new ArrayList<Point>();

        SolutionList1 = Limits.Limit(x1,y1,res1);
        SolutionList2 =  Limits.Limit(x2,y2,res2);
        SolutionList3 =  Limits.Limit(x3,y3,res3);
        SolutionList4 =  Limits.Limit(x4,y4,res4);
        SolutionList5 =  Limits.Limit(x5,y5,res5);

        FinalSolutionList =  Limits.checkIntersection(SolutionList1, SolutionList2, SolutionList3, SolutionList4, SolutionList5);

        for(int i=0; i<FinalSolutionList.size(); i++){
            int x = FinalSolutionList.get(i).getX();
            int y = FinalSolutionList.get(i).getY();
            int temp = ex*x + ey*y;
            if(temp>= max){
                max = temp;
            }
        }
        System.out.print("The max result is:" + max + ".");
    }
}
