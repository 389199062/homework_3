import javax.swing.*;

import javafx.util.Pair;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import org.ansj.splitWord.analysis.ToAnalysis;
import tf_idf.TF_IDF;
import tf_idf.TF_IDFImpl;
import vo.StockInfo;
import util.*;


public class FileDivede extends JFrame {

    private JFileChooser fileChooser;
    private JButton fileButton;
//    private FileHandler fileHandler;
    private JPanel panel1;
    private JButton searchButton;
    private JTextArea textSearch;
    private List kywords;
    private StockInfo[] stocks;
    private TF_IDF compare;


    public FileDivede(){
        super("FileDevide");
        setLayout(null);
        setBounds(0,0,500,300);
        searchButton = new JButton("开始搜索");
        searchButton.setLocation(new Point(20,100));
        searchButton.setSize(new Dimension(100,30));
        fileButton = new JButton("选择文件");
        fileButton.setLocation(new Point(20,10));
        fileButton.setSize(new Dimension(100,30));
        textSearch = new JTextArea("Search");
        textSearch.setSize(new Dimension(300, 150));
        textSearch.setLocation(new Point(150,10));
        add(fileButton);
        add(searchButton);
        add(textSearch);
        compare = new TF_IDFImpl();

        fileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Choose Your File");
                fileChooser.showOpenDialog(null);
                File file = fileChooser.getSelectedFile();
                String path = file.getAbsolutePath();
                FileHandler fileHandler = new FileHandleImpl();
                stocks = fileHandler.getStockInfoFromFile(path);
                System.out.println("mlgb");

            }
        });
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = textSearch.getText();
//                Pair<String,Double>[] list = compare.getResult( compare.getWordsFromInput(stocks),stocks);
//                Pair<Integer,Double>[] l = compare.CompareSentence(stocks,list,s);
//                Recommender recommender = new Recommender(stocks,l,compare.getsameWordsList());
//                recommender.setVisible(true);
                System.out.println(s);
            }
        });
    }

}
