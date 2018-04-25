import javax.swing.*;
import java.util.logging.XMLFormatter;

public class Methods {

    Object[][] calculteZj_Cj(Object[][] data, Object[][] newData, Object[] Cj){
            for (int j = 4; j < 10; j++) {
                Float[] temp = new Float[4];
                for (int i = 0; i < 4; i++) {
                    float P = (Float) data[i][j];
                    float Cb = (Float) data[i][2];
                    temp[i] = P*Cb;
                }
                float Zj_Cj = temp[0] + temp[1] + temp[2] + temp[3] - ((Float) Cj[j]);
                newData[4][j] = Zj_Cj;
            }
            return newData;
    }

    boolean isOptimal(Object[][] data){
        boolean optimal = true;
        for (int i=4; i<10; i++){
            float value = (Float) data[4][i];
            if(value>0){
                optimal = false;
            }
        }
        return optimal;
    }

    int getKeyColumn(Object[][] data){
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

    void calculateRatio(Object[][] data, int keyColumn){
      for (int i=0; i<4; i++){
          float Cb = (Float) data[i][2];
          float keyColumnValue = (Float) data[i][keyColumn];
          float ratio = Cb/keyColumnValue;
          data[i][10] = ratio;
      }
    }

    int getKeyRow(Object[][] data){
        int keyRow = 0;
        float min = (Float) data[0][10];
        for (int i=1; i<4; i++){
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

    float newValue(float oldValue, float verticalKeyValue, float horizontalKeyValue, float interKeyValue){
        float value;
        value = (oldValue - ((verticalKeyValue*horizontalKeyValue)/interKeyValue));
        return value;
    }

    void fillCb(Object[][] data, Object[][] newData, int keyColumn, int keyRow, Object[] Cj){
        for(int i=0; i<4; i++){
            newData[i][2] = data[i][2];
        }
        newData[keyRow][2] = (Float) Cj[keyColumn];
    }

    void fillx0_b(Object[][] data, Object[][] newData, int keyColumn, int keyRow, Object[] Cj){
        for (int i = 0; i<4; i++){
            newData[i][3] = newValue(((Float) data[i][3]), ((Float) data[i][keyColumn]),((Float) data[keyRow][3]),((Float) data[keyRow][keyColumn]));
        }
        newData[keyRow][3] = ((Float) data[keyRow][3]) / ((Float) data[keyRow][keyColumn]);
    }

    void fillP123general(Object[][] data, Object[][] newData, int keyColumn, int keyRow){
        for (int j=4; j<10; j++){
            for (int i=0; i<4; i++){
                newData[i][j] = newValue(((Float) data[i][j]),((Float) data[i][keyColumn]),((Float) data[keyRow][j]),((Float) data[keyRow][keyColumn]));
            }
        }
    }

    void fillP123KeyColumn(Object[][] newData, int keyColumn, int keyRow){
        for (int i=0; i<4; i++){
            newData[i][keyColumn] = 0;
        }
        newData[keyRow][keyColumn] = 1;
    }

    void fillP123KeyRow(Object[][] data, Object[][] newData, int keyColumn, int keyRow){
        for (int i=4; i<10;i++){
            newData[keyRow][i] = (((Float) data[keyRow][i]) / ((Float) data[keyRow][keyColumn]));
        }
    }

    Object[][] fillNextTable(Object[][] data, Object[][] newData, int keyColumn, int keyRow, Object[] Cj){
        fillCb(data,newData, keyColumn, keyRow, Cj);
        fillx0_b(data,newData, keyColumn, keyRow, Cj);
        fillP123general(data, newData, keyColumn, keyRow);
        fillP123KeyColumn(newData, keyColumn, keyRow);
        fillP123KeyRow(data, newData, keyColumn, keyRow);
        return newData;
    }



    Object[][] Solve(Object[][] data, Object[] Cj) {
        data = calculteZj_Cj(data, data, Cj);
        if (isOptimal(data)) {
        Object[][] newData = new Object[][]{
                {1, "x1", 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, "x2", 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, "x3", 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {4, "x4", 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {null, null, null, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        int keyColumn = getKeyColumn(data);
        if (keyColumn != 0) {
            int keyRow;
            calculateRatio(data, keyColumn);
            keyRow = getKeyRow(data);
            if (keyRow != -1) {
                System.out.println("There is no solution");
                return null;
            } else {
                fillNextTable(data, newData, keyColumn, keyRow, Cj);
                return newData;
            }
        } else {
            System.out.println("The solution is in last table");
            return null;
        }
    }else{
            System.out.println("Solution is optimal");
            return data;
        }
    }
}
