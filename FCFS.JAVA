//FCFS- Assignment-5
import java.util.Scanner;

public class FCFS {
    public static void main(String[] args) {

        System.out.println("Enter the number of process");
        Scanner in = new Scanner(System.in);
        int numberOfProcesses = in.nextInt();

        int pid[] = new int[numberOfProcesses];
        int bt[] = new int[numberOfProcesses];
        int ar[] = new int[numberOfProcesses];
        int ct[] = new int[numberOfProcesses];
        int ta[] = new int[numberOfProcesses];
        int wt[] = new int[numberOfProcesses];

        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.println("Enter process " + (i+1) + " arrival time: ");
            ar[i] = in.nextInt();
            System.out.println("Enter process " + (i+1) + " brust time: ");
            bt[i] = in.nextInt();
            pid[i] = i+1;
        }
        int temp;
        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = i+1; j < numberOfProcesses; j++) {

                if(ar[i] > ar[j]) {
                    temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;

                    temp = pid[i];
                    pid[i] = pid[j];
                    pid[j] = temp;
                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;
                }
            }
        }

        System.out.println();
        ct[0] = bt[0] + ar[0];
        for(int i = 1; i < numberOfProcesses; i++) {
            ct[i] = ct[i - 1] + bt[i];
        }
        for(int i = 0; i < numberOfProcesses; i++) {
            ta[i] = ct[i] - ar[i];
            wt[i] = ta[i] - bt[i];
        }
        System.out.println("Process\t\tAT\t\tBT\t\tCT\t\tTAT\t\tWT");
        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.println(pid[i]+"\t\t\t" + ar[i] + "\t\t" + bt[i]+ "\t\t" + ct[i]
            + "\t\t" + ta[i]+ "\t\t" + wt[i]);
        }

        System.out.println("gantt chart: ");
        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.print("P" + pid[i] +" ");
        }
    }

}


----------OUTPUT-------------
Ex.1
Enter the number of process
4
Enter process 1 arrival time: 
1
Enter process 1 brust time: 
4
Enter process 2 arrival time: 
2
Enter process 2 brust time: 
2
Enter process 3 arrival time: 
0
Enter process 3 brust time: 
8
Enter process 4 arrival time: 
3
Enter process 4 brust time: 
3
_________________________________________________
   Process|  AT |  BT	|  CT	|  TAT	| WT	|
__________|_____|_______|_______|_______|_______|
     1	  |   1	|  4	| 12	|  11	| 7     |
     2	  |   2	|  2	| 14	|  12	| 10	|
     3    |   0	|  8	| 8	|  8	| 0	|
     4	  |   3	|  3	| 17	|  14	| 11	|
__________|_____|_______|_______|_______|_______|

gantt chart: 
P3 P1 P2 P4 
=== Code Execution Successful ===


Ex.2
Enter no of process:
4
enter process 1 arrival time:
3
enter process 1 burst time:
2
enter process 2 arrival time:
5
enter process 2 burst time:
6
enter process 3 arrival time:
4
enter process 3 burst time:
3
enter process 4 arrival time:
6
enter process 4 burst time:
8
_________________________________________________
   Process|  AT |  BT	|  CT	|  TAT	| WT	|
__________|_____|_______|_______|_______|_______|
     1	  |   3	|  2	| 25	| 22	| 20	|
     2	  |   5	|  6	| 20	| 15	| 9	|
     3    |   4	|  3	| 23	| 19	| 16	|
     4	  |   6	|  8	| 14	|  8	| 0	|
__________|_____|_______|_______|_______|_______|

gantt chart
p4 p2 p3 p1
=== Code Execution Successful ===

Ex.3
Enter no of process:
3
enter process 1 arrival time:
2
enter process 1 burst time:
3
enter process 2 arrival time:
4
enter process 2 burst time:
1
enter process 3 arrival time:
3
enter process 3 burst time:
4
_________________________________________________
   Process|  AT |  BT	|  CT	|  TAT	| WT	|
__________|_____|_______|_______|_______|_______|
     1	  |   2	|  3	| 12	| 10	| 7	|
     2	  |   4	|  1	| 5	| 1	| 0	|
     3    |   3	|  4	| 9	| 6	| 2	|
__________|_____|_______|_______|_______|_______|

gantt chart
p2 p3 p1
=== Code Execution Successful ===

 
