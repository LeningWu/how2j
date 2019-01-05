package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompoundRateCalculator {

    //复利计算器
    public static void main(String[] args){
        JFrame f=new JFrame("复利计算器");
        f.setSize(800,600);
        f.setLocation(200,200);
        f.setLayout(null);

        JPanel pInput=new JPanel();
        pInput.setLayout(new GridLayout(4,6,10,10));
        pInput.setBounds(10,10,375,120);

        JLabel LInit=new JLabel("起始资金");
        JLabel LReat=new JLabel("每年收益");
        JLabel LYear=new JLabel("复利年数");
        JLabel LInverst=new JLabel("每年追加资金");

        JTextField txInit=new JTextField("");
        txInit.setText("");
        //txInit.setPreferredSize(new Dimension(120,140));

        JTextField txReat=new JTextField("");
        txReat.setText("");
        //txReat.setPreferredSize(new Dimension(120,140));

        JTextField txYear=new JTextField("");
        txYear.setText("");
        //txYear.setPreferredSize(new Dimension(120,140));

        JTextField txInverst=new JTextField("");
        txInverst.setText("");
        //txInverst.setPreferredSize(new Dimension(120,140));

        JLabel lInitSign =new JLabel("￥");
        JLabel lRateSign =new JLabel("%");
        JLabel lYearSign =new JLabel("年");
        JLabel lInvestSign =new JLabel("￥");

        pInput.add(LInit);
        pInput.add(txInit);
        pInput.add(lInitSign);

        pInput.add(LReat);
        pInput.add(txReat);
        pInput.add(lRateSign);

        pInput.add(LYear);
        pInput.add(txYear);
        pInput.add(lYearSign);

        pInput.add(LInverst);
        pInput.add(txInverst);
        pInput.add(lInvestSign);

        JPanel pResult=new JPanel();
        pResult.setLayout(new GridLayout(4,6,10,10));

        JLabel lBaseSum =new JLabel("本金和");
        JLabel lInterestSum =new JLabel("利息和");
        JLabel lTotalSum =new JLabel("本息和");

        JTextField tfBaseSum = new JTextField();
        JTextField tfInterestSum = new JTextField();
        JTextField tfTotalSum = new JTextField();

        JLabel lBaseSumSign =new JLabel("￥");
        JLabel lInterestSumSign =new JLabel("￥");
        JLabel lTotalSumSign =new JLabel("￥");

        pResult.add(lBaseSum);
        pResult.add(tfBaseSum);
        pResult.add(lBaseSumSign);

        pResult.add(lInterestSum);
        pResult.add(tfInterestSum);
        pResult.add(lInterestSumSign);

        pResult.add(lTotalSum);
        pResult.add(tfTotalSum);
        pResult.add(lTotalSumSign);

        JButton b=new JButton("计算");
        b.setBounds(150,120+30,80,30);
        pResult.setBounds(10,150+60,375,120);

        f.add(pInput);
        f.add(b);
        f.add(pResult);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            boolean checkedPass=true;
            @Override
            public void actionPerformed(ActionEvent e) {
                check(txInit,"起始资金");
                check(txYear,"复利年数");
                check(txInverst,"每年追加资金");
                check(txReat,"每年收益");

                if (checkedPass){
                    int Init=Integer.parseInt(txInit.getText());
                    int Year=Integer.parseInt(txYear.getText());
                    int Inverst=Integer.parseInt(txInverst.getText());
                    int Reat=Integer.parseInt(txReat.getText());

                    int basesum=Init+Inverst*(Year-1);
                    int totalsum=(int) (Inverst* fuli(  (1+(double)Reat/100),(Year-1)) + Init* Math.pow((1+(double)Reat/100) ,Year));
                    int interestsum=totalsum-basesum;

                    tfBaseSum.setText(String.format("%,d",basesum));
                    tfInterestSum.setText(String.format("%,d",interestsum));
                    tfTotalSum.setText(String.format("%,d",totalsum));
                }

            }

            private int fuli(double rate, int year) {
                int result=0;
                for (int i = year; i>0; i--){
                    result= (int) (result+Math.pow(rate,i));
                }
                return result;
            }

            private void check(JTextField tf, String msg) {
                if (!checkedPass){
                    return;
                }
                String value=tf.getText();
                if (value.length()==0){
                    JOptionPane.showMessageDialog(f,msg+"不能为空");
                    checkedPass=false;
                    return;
                }
                try {
                    Integer.parseInt(value);
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(f,msg+"必须是整数");
                    checkedPass=false;
                }
            }
        });
    }
}