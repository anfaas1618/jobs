import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> jobs= new ArrayList<>();
        ArrayList<Integer> machine1= new ArrayList<>();
        ArrayList<Integer> machine2= new ArrayList<>();
        System.out.println("enter the number of jobs");
        Scanner sc = new Scanner(System.in);
        int job= sc.nextInt();

        for (int i = 0; i < job; i++) {
            jobs.add(i+1);
        }
        System.out.println("enter hours of machine 1");
        for (int i = 0; i < job; i++) {
            machine1.add(sc.nextInt());
        }
        System.out.println("enter hours of machine 2");
        for (int i = 0; i < job; i++) {
            machine2.add(sc.nextInt());
        }
        display(jobs,machine1,machine2);
        ArrayList<Integer> mach1=machine1;
        ArrayList<Integer> mach2=machine2;
        // loop to find minimum from ArrayList
       ArrayList<Integer> sequence =  findSequence(jobs,mach1,mach2);
        System.out.println("seqence is ");
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i)+" ");
        }
    }

    private static ArrayList<Integer> findSequence(ArrayList<Integer> jobs, ArrayList<Integer> mach1, ArrayList<Integer> mach2) {
        ArrayList<Integer> sequenceMACH1 = new ArrayList<>();
        Stack<Integer> sequenceMACH2 = new Stack<>();
        int x =1;
        while (x==1) {
            int index1 = min(mach1);
            int index2 = min(mach2);
            System.out.println("minimum machine 1 is " + mach1.get(index1));
            System.out.println("minimum machine 2 is " + mach2.get(index2));
            if (mach1.get(index1) > mach2.get(index2)) {
                sequenceMACH2.push(index2+1);
                mach1.set(index2, 999);
                mach2.set(index2, 999);
            } else {
                sequenceMACH1.add(index1+1);
                mach1.set(index1, 999);
                mach2.set(index1, 999);
            }
            if (mach1.get(index1) == 999 && mach2.get(index2) == 999)
                x = 3;
        }
        sequenceMACH2.sort(Collections.reverseOrder());
        sequenceMACH1.addAll(sequenceMACH2);
        return sequenceMACH1;
    }
    private static int min(ArrayList<Integer> machine1) {
        int minpos = 0;
        int min;
        min=machine1.get(0);
        for (int i = 1; i < machine1.size(); i++) {
            if (machine1.get(i) < min) {
                min = machine1.get(i);
                minpos = i;
            }
        }
        return minpos;
    }
    private static int max(ArrayList<Integer> machine1) {
        int maxpos = 0;
        int max;
        max=machine1.get(0);
        for (int i = 1; i < machine1.size(); i++) {
            if (machine1.get(i) > max) {
                max = machine1.get(i);
                maxpos = i;
            }
        }
        return maxpos;
    }

    private static void display(ArrayList<Integer> jobs, ArrayList<Integer> machine1, ArrayList<Integer> machine2) {
        System.out.print("jobs :");
        for (Integer job : jobs) {
            if (job<10)
                System.out.print(job + "  "+"|");
            else
                System.out.print(job + " "+"|");
        }
        System.out.println("");
        System.out.print("mach1:");
        for (Integer integer : machine1) {
            if (integer<10)
            System.out.print(integer + "  "+"|");
            else
                System.out.print(integer + " "+"|");
        }
        System.out.println("");
        System.out.print("mach2:");
        for (Integer integer : machine2) {
            if (integer<10)
                System.out.print(integer + "  "+"|");
            else
                System.out.print(integer + " "+"|");
        }
    }
}
