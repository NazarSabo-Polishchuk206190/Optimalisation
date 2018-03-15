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


    public static void Solve(){
        int max = 0;
        ArrayList<Point> FinalSolutionList = new ArrayList<Point>();


        FinalSolutionList =  Limits.checkIntersection(Chart.SolutionList1, Chart.SolutionList2, Chart.SolutionList3,
                Chart.SolutionList4, Chart.SolutionList5);

        for(int i=0; i<FinalSolutionList.size(); i++){
            int x = FinalSolutionList.get(i).getX();
            int y = FinalSolutionList.get(i).getY();
            int temp = ex*x + ey*y;
            if(temp>= max){
                max = temp;
            }
            System.out.print("The max result is:" + max + ".");
        }
        System.out.print("The max result is:" + max + ".");
    }
}
