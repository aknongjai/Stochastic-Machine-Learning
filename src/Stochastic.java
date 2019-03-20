import java.util.Scanner;
import static java.lang.Math.pow;
class data{
    public Scanner s=new Scanner(System.in);
    public double livArea,noBed,price;
    public void getVal(){
        System.out.println("Enter the Living area in square feet, no. of bedrooms and price in lacs respectively");
        livArea=s.nextDouble();
        noBed=s.nextDouble();
        price=s.nextDouble();
    }
}
public class Stochastic {
    private static double desiredError=0.001;
    private static double weight[]=new double[10];
    private static double hypothesis[]=new double[100];
    private static double cost;
    private static int m=5;
    private  static final double learnRate=0.0000001;
    private  static boolean flag=true;
    private  static int fff=999;
    private static void initialiseDataArray(data ex[]){
        for (int i=0;i<m;i++){
            ex[i]=new data();
        }
    }
    public static void getData(data ex[]){
        for(int i=0;i<m;i++){
            ex[i].getVal();
        }
    }
    public static void getWt(){
        weight[0]=0.01;weight[1]=0.009;weight[2]=0.03;
    }
    public static void cal(data ex[]){
        double ddd=0.5;
        hypothesis[0]=(weight[0]+(weight[1] * ex[0].livArea) + (weight[2] * ex[0].noBed));
        cost=(ddd*pow((hypothesis[0]-ex[0].price),2));
        System.out.println(cost+" cost");
        while (desiredError <=cost){
            for (int i=0;i<m;i++){
                hypothesis[i] = (weight[0] + (weight[1] * ex[i].livArea) + (weight[2] * ex[i].noBed));
                cost=(ddd*(pow(((ex[i].price)-hypothesis[i]),2)));
                if (desiredError >= cost){
                    fff=123;
                System.out.println("done");
                    System.out.println(" cost issss "+cost);
                    double boooo=(weight[0]+(weight[1]*517)+weight[2]);
                    System.out.println(boooo);
                for (int qw = 0; qw < 3; qw++) {
                    System.out.println("weights " + weight[qw]);
                }
                break;
                }
                else{
                    System.out.println(" cost issss "+cost);
                    weight[0]=(weight[0]+(learnRate*(ex[i].price-hypothesis[i])));
                    weight[1]=(weight[1]+(learnRate*(ex[i].price-hypothesis[i])*(ex[i].livArea)));
                    weight[2]=(weight[2]+(learnRate*(ex[i].price-hypothesis[i])*(ex[i].noBed)));
                    for (int qw = 0; qw < 3; qw++) {
                        System.out.println("weights " + weight[qw]);
                    }

                }
            }
            if(fff==123)
                break;
        }
    }

    public static void main(String[]args){
        data d[]=new data[100];
        initialiseDataArray(d);
        getData(d);
        getWt();
        cal(d);




    }
}
/*All Rights Reserved
Nongjaimayum Annas khan
Husband of Ph Tabasum Sahani
*/