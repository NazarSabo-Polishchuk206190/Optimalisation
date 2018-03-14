import java.util.ArrayList;

public class App {

    //res -> max

    public int Solve(){
        int max = 0;

        int x1 = -2;
        int y1 = 3;
        int res1 = 13;
        ArrayList<Point> solutionList1 = Limits.Limit(x1, y1, res1);
        int x2 = 3;
        int y2 = 1;
        int res2 = 8;
        ArrayList<Point> solutionList2 = Limits.Limit(x2, y2, res2);
        int x3 = 1;
        int y3 = 4;
        int res3 = 32;
        ArrayList<Point> solutionList3 = Limits.Limit(x3, y3, res3);
        int x4 = 5;
        int y4 = -1;
        int res4 = 34;
        ArrayList<Point> solutionList4 = Limits.Limit(x4, y4, res4);
        int x5 = 3;
        int y5 = 5;
        int res5 = 12;
        ArrayList<Point> solutionList5 = Limits.Limit(x5, y5, res5);

        ArrayList<Point> finalSolutionList = Limits.checkIntersection(solutionList1, solutionList2, solutionList3, solutionList4, solutionList5);

        for(int i = 0; i< finalSolutionList.size(); i++){
            int x = finalSolutionList.get(i).getX();
            int y = finalSolutionList.get(i).getY();
            int ex = 4;
            int ey = 3;
            int temp = ex *x + ey *y;
            if(temp>= max){
                max = temp;
            }
        }
        return max;
    }
}
