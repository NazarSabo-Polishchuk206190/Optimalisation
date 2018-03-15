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

    public static ArrayList<Point> checkIntersection(ArrayList<Point> ar1, ArrayList<Point> ar2, ArrayList<Point> ar3, ArrayList<Point> ar4, ArrayList<Point> ar5){

        ArrayList<Point> intersectionPoints = new ArrayList<Point>();
        ArrayList<Point> temparr1 = new ArrayList<Point>();
        ArrayList<Point> temparr2 = new ArrayList<Point>();
        int counter = 0;

        if(ar1.size() < ar2.size() ){
            temparr1 = ar1;
            temparr2 = ar2;
            counter++;
        }
        for(int i = 0; i < temparr1.size(); i++){
            for(int j = 0; j < temparr2.size(); j++){
                for(int a = 0; a < ar3.size(); a++){
                    int tempx1 = temparr1.get(i).getX();
                    int tempy1 = temparr1.get(i).getY();
                    int tempx2 = temparr2.get(j).getY();
                    int tempy2 = temparr2.get(j).getY();
                    if((tempx1 == tempx2)&&(tempy1 == tempy2)){
                        Point point = new Point(tempx1, tempy1);
                        intersectionPoints.add(point);
                    }
                    if(((i == (temparr1.size())-1))&&((j == (temparr2.size())-1)) &&(counter == 1)){
                        if(ar1.size() < ar3.size() ){
                            temparr1 = ar1;
                            temparr2 = ar3;
                        }else{
                            temparr1 = ar3;
                            temparr2 = ar1;
                        }
                           j = 0;
                           i = 0;
                           counter++;
                    }
                    if(((i == (temparr1.size())-1))&&((j == (temparr2.size())-1)) &&(counter == 2)){
                        if(ar1.size() < ar4.size() ){
                            temparr1 = ar1;
                            temparr2 = ar4;
                        }else{
                            temparr1 = ar4;
                            temparr2 = ar1;
                        }
                        j = 0;
                        i = 0;
                        counter++;
                    }
                    if(((i == (temparr1.size())-1))&&((j == (temparr2.size())-1)) &&(counter == 3)){
                        if(ar1.size() < ar5.size() ){
                            temparr1 = ar1;
                            temparr2 = ar5;
                        }else{
                            temparr1 = ar5;
                            temparr2 = ar1;
                        }
                        j = 0;
                        i = 0;
                        counter++;
                    }
                    if(((i == (temparr1.size())-1))&&((j == (temparr2.size())-1)) &&(counter == 4)){
                        if(ar2.size() < ar3.size() ){
                            temparr1 = ar2;
                            temparr2 = ar3;
                        }else{
                            temparr1 = ar3;
                            temparr2 = ar2;
                        }
                        j = 0;
                        i = 0;
                        counter++;
                    }
                    if(((i == (temparr1.size())-1))&&((j == (temparr2.size())-1)) &&(counter == 5)){
                        if(ar2.size() < ar4.size() ){
                            temparr1 = ar2;
                            temparr2 = ar4;
                        }else{
                            temparr1 = ar4;
                            temparr2 = ar2;
                        }
                        j = 0;
                        i = 0;
                        counter++;
                    }
                    if(((i == (temparr1.size())-1))&&((j == (temparr2.size())-1)) &&(counter == 6)){
                        if(ar2.size() < ar5.size() ){
                            temparr1 = ar2;
                            temparr2 = ar5;
                        }else{
                            temparr1 = ar5;
                            temparr2 = ar2;
                        }
                        j = 0;
                        i = 0;
                        counter++;
                    }
                    if(((i == (temparr1.size())-1))&&((j == (temparr2.size())-1)) &&(counter == 7)){
                        if(ar3.size() < ar4.size() ){
                            temparr1 = ar3;
                            temparr2 = ar4;
                        }else{
                            temparr1 = ar4;
                            temparr2 = ar3;
                        }
                        j = 0;
                        i = 0;
                        counter++;
                    }
                    if(((i == (temparr1.size())-1))&&((j == (temparr2.size())-1)) &&(counter == 8)){
                        if(ar3.size() < ar5.size() ){
                            temparr1 = ar3;
                            temparr2 = ar5;
                        }else{
                            temparr1 = ar5;
                            temparr2 = ar3;
                        }
                        j = 0;
                        i = 0;
                        counter++;
                    }
                    if(((i == (temparr1.size())-1))&&((j == (temparr2.size())-1)) &&(counter == 9)){
                        if(ar4.size() < ar5.size() ){
                            temparr1 = ar4;
                            temparr2 = ar5;
                        }else{
                            temparr1 = ar5;
                            temparr2 = ar4;
                        }
                        j = 0;
                        i = 0;
                        counter++;
                    }
                }
            }
        }
        return intersectionPoints;
    }
}

