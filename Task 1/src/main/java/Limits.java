import java.util.ArrayList;

public class Limits {
    public static ArrayList<Point> Limit(float ax, float ay, float res){
        ArrayList<Point> SolutionList = new ArrayList<Point>();
        for(int i = (-10); i<=30; i++){
            for(int j = (-10); j<=30; j++ ){
                float ex = ax*i + ay*j;
                if(ex==res) {
                    Point point = new Point(i, j);
                    SolutionList.add(point);
                }
            }
        }
        return SolutionList;
    }
}

