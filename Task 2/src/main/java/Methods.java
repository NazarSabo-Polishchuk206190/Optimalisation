import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.XMLFormatter;

public class Methods {

    static Object[][] calculteZj_Cj(Object[][] data, Object[][] newData, Object[] Cj){
            for (int j = 4; j < 10; j++) {
                float[] temp = new float[4];
                for (int i = 0; i < 4; i++) {
                    float P = ((Number) data[i][j]).floatValue();
                    float Cb = ((Number) data[i][2]).floatValue();
                    temp[i] = P*Cb;
                }
                float Zj_Cj = ((Number)temp[0]).floatValue() + ((Number)temp[1]).floatValue() + ((Number)temp[2]).floatValue() + ((Number)temp[3]).floatValue() - ((Number)Cj[j]).floatValue();
                newData[4][j] = Zj_Cj;
            }
            return newData;
    }

    static boolean isOptimal(Object[][] data){
        boolean optimal = true;
        for (int i=4; i<10; i++){
            float value = (Float) data[4][i];
            if(value>0){
                optimal = false;
            }
        }
        return optimal;
    }

    static int getKeyColumn(Object[][] data){
        int keyColumn = 0;
        float max =0;
        for (int i=4; i<10; i++){
            float temp;
            temp = (Float) data[4][i];
            if((temp>=max)&&(temp>=0)){
                max = temp;
                keyColumn = i;
            }
        }
        return keyColumn;
    }

    static Object[][] calculateRatio(Object[][] data, int keyColumn){
        Object[][] result = data;
      for (int i=0; i<4; i++){
          float Cb = ((Number) data[i][3]).floatValue();
          float keyColumnValue = ((Number) data[i][keyColumn]).floatValue();
          float ratio = Cb/keyColumnValue;
          result[i][10] = ratio;
      }
      return result;
    }

    static int getKeyRow(Object[][] data){
        int keyRow = 0;
        float min = (Float) data[0][10];
        for (int i=0; i<4; i++){
             float temp = (Float) data[i][10];
             if((temp<=min)&&(temp>0)){
                min = temp;
                keyRow = i;
            }
        }
        if(min>0){
            return keyRow;
        }else {
            return -1;
        }
    }

    static float newValue(float oldValue, float verticalKeyValue, float horizontalKeyValue, float interKeyValue){
        float value;
        value = (oldValue - ((verticalKeyValue*horizontalKeyValue)/interKeyValue));
        return value;
    }

    static void fillCb(Object[][] data, Object[][] newData, int keyColumn, int keyRow, Object[] Cj){
        for(int i=0; i<4; i++){
            newData[i][2] = data[i][2];
        }
        newData[keyRow][2] = (Number) Cj[keyColumn];
    }

    static void fillx0_b(Object[][] data, Object[][] newData, int keyColumn, int keyRow, Object[] Cj){
        for (int i = 0; i<4; i++){
            newData[i][3] = newValue(((Number) data[i][3]).floatValue(), ((Number) data[i][keyColumn]).floatValue(),((Number) data[keyRow][3]).floatValue(),((Number) data[keyRow][keyColumn]).floatValue());
        }
        System.out.println((((Number) data[keyRow][3]).floatValue()));
        System.out.println((((Number) data[keyRow][keyColumn]).floatValue()));

        newData[2][3] = ((((Number) data[2][3]).floatValue()) / (((Number) data[2][5]).floatValue()));
    }

    static void fillP123KeyColumn(Object[][] newData, int keyColumn, int keyRow){
        for (int i=0; i<4; i++){
            newData[i][keyColumn] = 0;
        }
        newData[keyRow][keyColumn] = 1;
    }

    static void fillP123KeyRow(Object[][] data, Object[][] newData, int keyColumn, int keyRow){
        for (int i=4; i<10;i++){
            newData[keyRow][i] = (((Number) data[keyRow][i]).floatValue() / ((Number) data[keyRow][keyColumn]).floatValue());
        }
    }

    static void fillP123(Object[][] data, Object[][] newData, int keyColumn, int keyRow){
        for (int j=4; j<10; j++){
            for (int i=0; i<4; i++){
                newData[i][j] = newValue(((Number) data[i][j]).floatValue(),((Number) data[i][keyColumn]).floatValue(),((Number) data[keyRow][j]).floatValue(),((Number) data[keyRow][keyColumn]).floatValue());
            }
        }
        fillP123KeyColumn(newData, keyColumn, keyRow);
        fillP123KeyRow(data, newData, keyColumn, keyRow);
    }


    static Object[][] fillNextTable(Object[][] data, int keyColumn, int keyRow, Object[] Cj){
        Object[][] newData = data;
        fillCb(data,newData, keyColumn, keyRow, Cj);
        fillx0_b(data,newData, keyColumn, keyRow, Cj);
        fillP123(data, newData, keyColumn, keyRow);
        newData = calculteZj_Cj(newData, newData, Cj);
        int keyColumn2 = getKeyColumn(data);
        newData = calculateRatio(data, keyColumn2);
        return newData;
    }

    static Object[][] initialTableSolve(Object[][] data, Object[] Cj) {
        Object[][] result = data;
        data = calculteZj_Cj(data, data, Cj);
        int keyColumn = getKeyColumn(data);
        if (keyColumn != 0) {

            result = calculateRatio(data, keyColumn);
            return result;
        }
            return null;
    }


    public static Object[][] Solve(Object[][] data, Object[] Cj) {
        Object[][] tempTable1;
        Object[][] tempTable2;
        ArrayList<Object> solutionTableList = new ArrayList<Object>();
        tempTable1 = initialTableSolve(data,Cj);
        solutionTableList.add(tempTable1);
        //System.out.println(getKeyRow(tempTable1));
        //System.out.println(getKeyColumn(tempTable1));
        //solutionTableList.add(fillNextTable(tempTable1,getKeyColumn(tempTable1),getKeyRow(tempTable1),Cj));
//        while (!isOptimal(tempTable1)){
//            int keyColumn = getKeyColumn(tempTable1);
//            int keyRow = getKeyRow(tempTable1);
//            if(keyRow!=(-1)) {
//                tempTable2 = fillNextTable(tempTable1, keyColumn, keyRow, Cj);
//                solutionTableList.add(tempTable2);
//                tempTable1 = tempTable2;
//            }else {
//                break;
//            }
//        }
        return tempTable1;
    }

    public static Object[][] next(Object[][] data, Object[] Cj){
        return fillNextTable(data,getKeyColumn(data),getKeyRow(data),Cj);
    }
}
