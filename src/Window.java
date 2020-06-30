import com.company.MyLinkedList;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Window {
    private JPanel panel;
    private JTextField input;
    private JTextField output;
    private JButton readBut;
    private JButton but;

    private Window(){

        but.addActionListener(actionEvent -> {

            MyLinkedList l = toList(input.getText().split(" "));
            l.reverse();
            try {
                output.setText(l.toString().replaceAll("(\\s+)", " "));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        readBut.addActionListener(actionEvent -> {
            JFileChooser jfc = new JFileChooser();
            int ret = jfc.showDialog(null, "Загрузить списки");
            File file = null;
            if (ret == JFileChooser.APPROVE_OPTION) {
                file = jfc.getSelectedFile();
            }
            try {
                assert file != null;
                Scanner scn = new Scanner(file);
                input.setText(scn.nextLine());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private MyLinkedList toList(Object[] objects){
        MyLinkedList list = new MyLinkedList();
        for (int i = 0; i < objects.length; i++) {
            list.addLast(objects[i]);
        }
        return list;
    }

    public static void main (String[] args){
        JFrame frame = new JFrame("List reverser");
        frame.setContentPane(new Window().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit tkt = Toolkit.getDefaultToolkit();
        Dimension dim = tkt.getScreenSize();
        frame.setBounds(dim.width / 2 - 250, dim.height / 2 - 150, 500, 300);
        frame.setVisible(true);
    }
}
