import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class jobs {
    public static void main(String[] args) {
        int n;
        Scanner sc= new Scanner(System.in);
        System.out.println("enter no of jobs");
        n= sc.nextInt();
        int mach1[] = new int[n];
        int mach2[] = new int[n];
        int[] mach1Tin= new int[n];
        int[] mach1Tout= new int[n];
        int[] mach2Tin= new int[n];
        int[] mach2Tout= new int[n];
        List<Integer> idle1= new ArrayList<>();
        List<Integer> idle2= new ArrayList<>();
        System.out.println("enter the values of mach 1 in sequnce");
        for (int i = 0; i < n; i++) {
        mach1[i]=sc.nextInt();
        }
        System.out.println("enter the values of mach 2 in sequnce");
        for (int i = 0; i < n; i++) {
            mach2[i]=sc.nextInt();
        }



        mach1Tin[0] = 0;
        mach1Tout[0]= mach1Tin[0]+mach1[0];//0+1 =1
        mach2Tin[0] = mach1Tout[0];//1
        mach2Tout[0]=mach2Tin[0]+mach2[0];//
        System.out.println("idle time machine 2 ="+mach1Tout[0]+"at pos 1");
        idle2.add(mach1Tout[0]);

        for (int i = 1  ; i <n ; i++) {
            mach1Tin[i]=mach1Tout[i-1];
            mach1Tout[i]=mach1Tin[i]+mach1[i];
            if (mach2Tout[i-1]>=mach1Tout[i])
            {
                mach2Tin[i]=mach2Tout[i-1];
                mach2Tout[i]=mach2Tin[i]+mach2[i];
            }
            else {
                int i1 = mach1Tout[i] - mach2Tout[i - 1];
                System.out.println("idle time machine 2 ="+ i1 +"at pos "+(i+1));
                idle2.add(i1);
                mach2Tin[i]=mach1Tout[i];
          mach2Tout[i]=mach2Tin[i]+mach2[i];
            }

        }
            display(mach1Tin,mach1Tout,mach2Tin,mach2Tout,idle1,idle2,n);
    }

    private static void display(int[] mach1Tin, int[] mach1Tout, int[] mach2Tin, int[] mach2Tout, List<Integer> idle1, List<Integer> idle2, int n) {
        System.out.print("Tin value for machine 1 time in ");
        for (int i = 0; i <n ; i++) {
            System.out.print(" "+mach1Tin[i]);
        }
        System.out.println("");
        System.out.print("Tin value for machine 1 time out");
        for (int i = 0; i <n ; i++) {
            System.out.print(" "+mach1Tout[i]);
        }
        System.out.println("");
        System.out.print("Tin value for machine 2 time in");
        for (int i = 0; i <n ; i++) {
            System.out.print(" "+mach2Tin[i]);
        }
        System.out.println("");
        System.out.print("Tin value for machine 2 time out");
        for (int i = 0; i <n ; i++) {
            System.out.print(" "+mach2Tout[i]);
        }
        System.out.println("\n idle time machine 1 "+(mach2Tout[n-1]-mach1Tout[n-1])+"at pos "+(n));
        idle1.add((mach2Tout[n-1]-mach1Tout[n-1]));
        int i1 = 0;
        for (int i = 0; i < idle1.size(); i++) {
            i1+=idle1.get(i);
        }
        System.out.println(i1);
        System.out.print("total idel time of machine 2 ");
        int i2 = 0;
        for (int i = 0; i < idle2.size(); i++) {
            i2+=idle2.get(i);
        }
        System.out.println(i2);
        System.out.println("total ellapsed time "+mach2Tout[n-1]);


    }
}
