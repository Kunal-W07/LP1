import java.io.*;
 
class FIFO {
    public static void main(String[] args) throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
 
        System.out.print("Enter number of frames: ");
        int f = Integer.parseInt(obj.readLine());
        int[] frames = new int[f];
        for (int i = 0; i < f; i++) frames[i] = -1;
 
        System.out.print("Enter number of pages: ");
        int n = Integer.parseInt(obj.readLine());
        int[] pages = new int[n];
        System.out.println("Enter page numbers: ");
        for (int i = 0; i < n; i++) pages[i] = Integer.parseInt(obj.readLine());
 
        int pt = 0, pageFaults = 0;
 
        for (int page : pages) {
            boolean flag = true;
            for (int frame : frames) {
                if (frame == page) {
                    flag = false;
                    break;
                }
            }
 
            if (flag) {
                frames[pt] = page;
                pt = (pt + 1) % f;
                pageFaults++;
            }
 
            // Print current state of frames
            System.out.print("Frame: ");
            for (int frame : frames) System.out.print(frame + " ");
            System.out.println();
        }
 
        System.out.println("Page fault: " + pageFaults);
        System.out.println("Page hit: " + (n - pageFaults));
    }
}
 
