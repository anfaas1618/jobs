import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class jobs3 {
    public static void main(String[] args) {
        int n;
        Scanner sc= new Scanner(System.in);
        List<Integer> idle1= new ArrayList<>();
        List<Integer> idle2= new ArrayList<>();
        List<Integer> idle3= new ArrayList<>();
        System.out.println("enter no of jobs");
        n= sc.nextInt();
        int mach1[] = new int[n]
            ;
        int mach2[] = new int[n];

        int mach3[] = new int[n];
        int[] mach1Tin= new int[n];
        int[] mach1Tout= new int[n];
        int[] mach2Tin= new int[n];
        int[] mach2Tout= new int[n];
        int[] mach3Tin= new int[n];
        int[] mach3Tout= new int[n];
        System.out.println("enter the values of mach 1 in sequnce");
        for (int i = 0; i < n; i++) {
            mach1[i]=sc.nextInt();
        }
        System.out.println("enter the values of mach 2 in sequnce");
        for (int i = 0; i < n; i++) {
            mach2[i]=sc.nextInt();
        }
        System.out.println("enter the values of mach 3 in sequnce");
        for (int i = 0; i < n; i++)
        {
            mach3[i]=sc.nextInt();
        }
        mach1Tin[0] = 0;
        mach1Tout[0]= mach1Tin[0]+mach1[0];//0+1 =1
        mach2Tin[0] = mach1Tout[0];//1
        mach2Tout[0]=mach2Tin[0]+mach2[0];//
        mach3Tin[0] = mach2Tout[0];//1
        mach3Tout[0]=mach3Tin[0]+mach3[0];//
        System.out.println(mach1Tin[0]+" "+ mach1Tout[0]+" "+mach2Tin[0]+" "+ mach2Tout[0]+" "+mach3Tin[0]+" "+ mach3Tout[0]+" ");

        System.out.println("idle time machine 2 ="+mach1Tout[0]+"at pos 1");
        idle2.add(mach1Tout[0]);
        System.out.println("idle time machine 3 ="+mach2Tout[0]+"at pos 1");
        idle3.add(mach2Tout[0]);

        for (int i = 1  ; i <n ; i++) {
            mach1Tin[i]=mach1Tout[i-1];//50
            mach1Tout[i]=mach1Tin[i]+mach1[i];//50+40
            if (mach2Tout[i-1]>=mach1Tout[i])//
            {
                mach2Tin[i]=mach2Tout[i-1]; //90
                mach2Tout[i]=mach2Tin[i]+mach2[i];
            }
            else {
                int i1 = mach1Tout[i] - mach2Tout[i - 1];
                System.out.println("idle time machine 2 ="+ i1 +"at pos "+(i+1));
                idle2.add(i1);
                mach2Tin[i]=mach1Tout[i];
                mach2Tout[i]=mach2Tin[i]+mach2[i];
            }
            if (mach3Tout[i-1]>mach2Tout[i])
            {
                mach3Tin[i]=mach3Tout[i-1];
                mach3Tout[i]=mach3Tin[i]+mach3[i];
            }
            else {
                int i1 = mach2Tout[i] - mach3Tout[i - 1];
                System.out.println("idle time machine 3 ="+ i1 +"at pos "+(i+1));
                idle3.add(i1);
                mach3Tin[i]=mach2Tout[i];
                mach3Tout[i]=mach3Tin[i]+mach3[i];
            }

        }
        display(mach1Tin,mach1Tout,mach2Tin,mach2Tout,mach3Tin,mach3Tout,idle1,idle2,idle3,n);
    }

    private static void display(int[] mach1Tin, int[] mach1Tout, int[] mach2Tin, int[] mach2Tout, int[] mach3Tin, int[] mach3Tout, List<Integer> idle1, List<Integer> idle2, List<Integer> idle3, int n) {
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
        System.out.println("");
        System.out.print("Tin value for machine 3 time in");
        for (int i = 0; i <n ; i++) {
            System.out.print(" "+mach3Tin[i]);
        }
        System.out.println("");
        System.out.print("Tin value for machine 3 time out");
        for (int i = 0; i <n ; i++) {
            System.out.print(" "+mach3Tout[i]);
        }
        System.out.println("\n idle time machine 1 "+(mach3Tout[n-1]-mach1Tout[n-1])+"at pos "+(n));
        idle1.add((mach3Tout[n-1]-mach1Tout[n-1]));
        System.out.println("\n idle time machine 2 "+(mach3Tout[n-1]-mach2Tout[n-1])+"at pos "+(n));
        idle2.add((mach3Tout[n-1]-mach2Tout[n-1]));
        System.out.print("total idel time of machine 1 ");
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
        System.out.print("total idel time of machine 3 ");
        int i3 = 0;
        for (int i = 0; i < idle3.size(); i++) {
            i3+=idle3.get(i);
        }
        System.out.println(i3);
        System.out.println("total ellapsed time "+mach3Tout[n-1]);
    }
}
