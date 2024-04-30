package com.example.demo.smallMoney;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallMoneyOOP {
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key;

    String details = "-----------------零钱通明细-----------------";
    double blanace = 0;
    Date date;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public void mainMen(){
        do {
            System.out.println("==============零钱通(oop)==============");
            System.out.println("\t\t\t1 明细");
            System.out.println("\t\t\t2 收益");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");

            System.out.print("请输入：");
            key = scanner.next();

            switch (key) {
                case "1":
                    this.details();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("输入有误！");
            }

        } while (loop);
    }

    public void details(){
        System.out.println(details + "\n");
    }
    public void income(){
        System.out.print("请输入收益金额：");
        double sr = scanner.nextDouble();
        if(sr<=0){
            System.out.println("收益不能为负");
            return;
        }
        blanace += sr;
        date = new Date();
        details += "\n收益入账+"+"\t" + sr + "\t" + simpleDateFormat.format(date) + "\t" + blanace;

    }
    public void pay(){
        System.out.print("请输入消费金额：");
        double sf = scanner.nextDouble();
        if(sf<=0){
            System.out.println("消费不能为负");
            return;
        }
        if(sf>blanace){
            System.out.println("余额不足");
            return;
        }
        blanace -= sf;
        System.out.print("请输入消费说明：");
        String note = scanner.next();
        date = new Date();
        details += "\n" + note + "\t-" + sf + "\t" + simpleDateFormat.format(date) + "\t" + blanace;
    }
    public void exit(){
        String tc;
        while (true) {
            System.out.println("请输入y/n确定是否退出！");
            tc = scanner.next();
            if (tc.matches("y|n")) {
                break;
            }
        }
        if (tc.equals("y")){
            loop = false;
            return;
        }
    }

}
