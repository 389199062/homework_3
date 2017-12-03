package util;

import javafx.util.Pair;
import vo.StockInfo;


import java.io.*;

public class FileHandleImpl implements FileHandler{
    public StockInfo[] getStockInfoFromFile(String filePath) {
        StockInfo[] Stock = new StockInfo[60];

        try {
            BufferedReader Buff = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
            String s = null;
            for(int a = 1;a<61;a++){
                Stock[a-1] = new StockInfo();
            }
            int i = 0;
            while((s = Buff.readLine())!= null){
                String tempS[] = s.split("\t");
                for(int d = 0; d<tempS.length;d++){
                    if(tempS[d].equals(" ")){
                        Stock[i].setInformation(d,"nothing");
                    }else{
                        Stock[i].setInformation(d,tempS[d]);
                    }
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stock;
    }

}
