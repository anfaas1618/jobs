import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class modimethod {

    List<Integer>c= new ArrayList<>();
  static   int alocated[][]={{1,1},
            {1,2},
            {2,2},
            {2,3},
            {2,4},{3,4}};
    static int pos=0;
    public static void mainasd(String[] args) {
        List<Integer> u = new ArrayList<>();
        List<Integer>v = new ArrayList<>();
        int arr [][] = new int[][]{
                {10,2,20,11},
                {12,7,9,20},
                {4 ,14,16,18}
        };

        System.out.println("enter the number of allocated cells");
        Scanner sc = new Scanner(System.in);
        int alloc= sc.nextInt();
//        System.out.println("enter the cordinates of allocated cells");
//        for (int i = 0; i < alloc; i++) {
//
//        }

        List<Integer> x= new ArrayList<>();
        for (int i = 0; i < alloc; i++) {
            u.add(i,999);
            v.add(i,999);
        }
        u.set(0,0);
        for (int i = 0; i < 4 ; i++) {
          calulate(u.get(alocated[i][0]),v.get(alocated[i][1]),arr[alocated[i][0]][alocated[i][1]],u,v);
      pos++;
        }
        for (int i = 0; i < alloc; i++) {
            System.out.println("u"+u.get(i));
            System.out.println("v"+v.get(i));
        }

    }

    private static void calulate(int ui, int vi, int cij, List<Integer> u, List<Integer> v) {
        if (ui==999)
        {
            ui = cij-vi;
            u.set(alocated[pos][0],ui);
        }
        if (vi==999)
        {
            vi = cij-ui;
            v.set(alocated[pos][1],ui);        }

    }
}
