package tablelession;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TableLession {

    public static void main(String[] args) {
        MyFrame mf = new MyFrame();
    }

}

class MyFrame extends JFrame implements ActionListener, MouseListener {

    int row = 0;
    String[] header = {"NAME", "AGE"};
    String[][] data = {{"Rundorn", "52"}, {"Burapa", "19"}, {"Porn", "47"}};
    DefaultTableModel model = new DefaultTableModel(data, header);                // 1. สร้าง object ของ DefaultTableModel สำหร้บช่วยในการจัดการข้อมูลของ JTable
    JTable tbl = new JTable(model);                      // 2. สร้าง object ของ JTable เพื่อสร้างตารางโดยใช้ DefaltTableModel มาช่วยในการจัดการข้อมูลในตาราง
    JScrollPane scroll = new JScrollPane(tbl);          //  3.เอา ตาราง(tbl) ไปไว้บน JScrollPane เพื่อให้แสดง scroll สำหรับเลื่อนดูข้อมูลได้ แต่จะแสดงก็ต่อเมื่อ ข้อมูลมีมากเกินที่่จะแสดงในตารางได้
    JPanel pnl = new JPanel();
    JButton[] btn = new JButton[2];
    JTextField[] txt = new JTextField[2];

    public MyFrame() {
        txt[0] = new JTextField();
        txt[1] = new JTextField();
        btn[0] = new JButton("Button");
        btn[1] = new JButton("nottuB");
        setBounds(0, 0, 600 + 14, 400 + 35);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pnl.setBounds(0, 0, 600, 400);
        pnl.setLayout(null);

        btn[0].setBounds(10, 340, 280, 50);
        btn[1].setBounds(310, 340, 280, 50);

        txt[0].setBounds(10, 280, 280, 50);
        txt[1].setBounds(310, 280, 280, 50);

        //การสร้าง JTable
        scroll.setBounds(10, 10, 580, 80);               // 4.กำหนดขนาดและตำแหน่งของ scroll  ซึ่งจะเป็นการกำหนดขนาดของ table เพราะ table อยู่บน scroll

        pnl.add(txt[0]);
        pnl.add(txt[1]);
        pnl.add(btn[0]);
        pnl.add(scroll);
        pnl.add(btn[1]);
        tbl.addMouseListener(this);
        btn[0].addActionListener(this);
        btn[1].addActionListener(this);
        add(pnl);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn[0]) {
            model.addRow(new Object[]{txt[0].getText(), txt[1].getText()});        //ใช้ model เพิ่มแถวข้อมูล คอลัมน์ที่0 และ 1 
            txt[0].setText("");
            txt[1].setText("");
        }
        if (e.getSource() == btn[1]) {
            model.removeRow(0);                      // ใช้ model ลบแถวข้อมูลที่กำหนดใน index
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        row = tbl.getSelectedRow();
        
        System.out.println(Objects.toString(model.getValueAt(row, 0)) +"  "+Objects.toString(model.getValueAt(row, 1)));     //เอาข้อมูลในตารางออกมาใช้

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
