import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import util.WordCloudBuilder;
import vo.StockInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

public class LabelListener extends java.awt.event.MouseAdapter {
    private static boolean flag=false;
    private static int clickNum=0;
    private JLabel label;
    private StockInfo stock;
    private List<String> keyWords;
    public LabelListener(StockInfo oStock,List<String> list){
       this.stock = oStock;
       keyWords = list;
    }

    public void mouseClicked(MouseEvent e) {
        final MouseEvent mouseEvent=e;
        int clickTimes = e.getClickCount();
        if (clickTimes == 2) {
            this.mouseDoubleClicked(mouseEvent,stock);
        }


    }


    public void mouseSingleClicked(MouseEvent e){
        System.out.println("Single Clicked!");
    }


    public void mouseDoubleClicked(MouseEvent e,StockInfo stock){
        JFrame frameNB = new JFrame();
        frameNB.setLayout(null);

        Result result = ToAnalysis.parse(stock.getInformation(5)+stock.getInformation(6)+stock.getInformation(7));
        List<Term> terms = result.getTerms();
        List<String> sList = new LinkedList<String>();
        for(int i = 0;i<terms.size();i++){
            sList.add(terms.get(i).getName());
        }
        Color[] colors = new Color[10];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = new Color(
                    (new Double(Math.random() * 128)).intValue() + 128,
                    (new Double(Math.random() * 128)).intValue() + 128,
                    (new Double(Math.random() * 128)).intValue() + 128);
        }
        WordCloudBuilder.buildWordCouldByWords(300,300,4,30,5,sList,new Color(-1),"D:\\wordCould.png",colors);


        JLabel tLabel = new JLabel(stock.getInformation(5));
        JLabel imgLabel = new JLabel();
        imgLabel.setText("<html><img src=\"D:\\wordCould.png\"></html>");
        tLabel.setSize(400,400);
        tLabel.setLocation(new Point(10,10));
        imgLabel.setSize(200,200);
        imgLabel.setLocation(new Point(300,10));
        frameNB.add(tLabel);
        frameNB.add(imgLabel);
        frameNB.setSize(500,300);
        frameNB.setVisible(true);
        System.out.println("Doublc Clicked!");
    }
}
