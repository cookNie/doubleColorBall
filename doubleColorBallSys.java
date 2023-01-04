import java.util.Random;
import java.util.Scanner;

public class doubleColorBallSys {
    public static void main(String[] args) {
        int [] redBall = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
        int [] blueBall = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

        Scanner sc = new Scanner(System.in);

        int [] choseBall = new int[7];
        System.out.println("请输入投注的红色号码，范围为1至33，共六个且不重复");


       while(true){
           int[] temp = choseRedBall();
           if(compare(temp)){
               choseBall = temp;
               break;
           }else {
               System.out.println("数字重复，请重新输入红球数字");
           }
       }







        System.out.println("请输入一个蓝球号码，范围在1至16之间:");
       int blueNum = choseBlueBall();

       choseBall[6] = blueNum;
        System.out.println("你输入的数字是：");
        for (int i = 0; i < choseBall.length; i++) {
            System.out.print(choseBall[i]+" ");
        }
        System.out.println();


        Random r = new Random();
        int[] bouBall = new int[7];
        for (int i = 0; i < 6; ) {
            boolean flag = true;
            int num = r.nextInt(33);

            for (int j = 0; j < 6; j++) {
                if (redBall[num]==bouBall[j]){
                    flag = false;
                    break;
                }
            }

            if (flag){
                bouBall[i] = redBall[num];
                i++;
            }
        }

        int num = r.nextInt(16);
        bouBall[6] = blueBall[num];

        System.out.println("开奖数字是：");
        for (int i = 0; i < bouBall.length; i++) {
            System.out.print(bouBall[i] + " ");
        }
        System.out.println();

        int countRed = 0;
        int countBlue = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (choseBall[i]==bouBall[j]){
                    countRed++;
                }
            }
        }

        if(choseBall[6]==bouBall[6]){
            countBlue++;
        }
        System.out.println("中的红球数字为" + countRed + "个");
        System.out.println("中的蓝球数字为" + countBlue + "个");

        if (countRed==6&&countBlue==1){
            System.out.println("恭喜你获得一等奖，最高1000万奖金");
        } else if (countRed==6&&countBlue==0) {
            System.out.println("恭喜你获得二等奖，最高500万奖金");
        } else if (countRed==5&&countBlue==1) {
            System.out.println("恭喜你获得三等奖，最高3000奖金");
        } else if ((countRed==5&&countBlue==0)||(countRed==4&&countBlue==1)) {
            System.out.println("恭喜你获得四等奖，最高200奖金");
        } else if ((countRed==4&&countBlue==0)||(countRed==3&&countBlue==1)) {
            System.out.println("恭喜你获得五等奖，最高10奖金");
        } else if ((countRed==3&&countBlue==0)||(countRed==2&&countBlue==1)||(countRed==2&&countBlue==0)||(countRed==1&&countBlue==1)||(countRed==0&&countBlue==1)) {
            System.out.println("恭喜你获得六等奖，最高5奖金");
        }else {
            System.out.println("你没有中奖");
        }


    }

    public static int [] choseRedBall(){
        Scanner sc = new Scanner(System.in);
        int []arr = new int[7];

        for (int i = 0; i < 6; ) {
            System.out.println("请输入第" + (i + 1) + "个数");
            int num = sc.nextInt();
            if (num>=1&&num<=33){
                arr[i] = num;
                i++;

            }else {
                System.out.println("请重新输入第" + (i + 1) + "个数");
            }
        }

        return arr;
    }

    public static int choseBlueBall(){
        Scanner sc = new Scanner(System.in);
        int num1 = 0;
        while(true){
            int num = sc.nextInt();
            if(num>=1&&num<=16){
                num1 = num;
                break;
            }else {
                System.out.println("数字超出范围，请重新输入蓝球数字：");
            }
        }




        return num1;
    }

    public static boolean compare(int[] arr){
        boolean flag = true;
        for (int i = 0; i < 6; i++) {
            for (int j = i+1; j < 6; j++) {
                if(arr[i]==arr[j]){
                    flag = false;
                    break;

                }
            }
        }

        return flag;



    }

}
