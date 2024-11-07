import java.io.*;
 
class Optimal {
    public static void main(String[] args) throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
 
        System.out.print("Enter the number of frames: ");
        int f = Integer.parseInt(obj.readLine());
        int[] frames = new int[f];
        for (int i = 0; i < f; i++) frames[i] = -1;
 
        System.out.print("Enter the number of pages: ");
        int n = Integer.parseInt(obj.readLine());
        int[] pages = new int[n];
        System.out.println("Enter the page numbers: ");
        for (int i = 0; i < n; i++) pages[i] = Integer.parseInt(obj.readLine());
 
        int pageFaults = 0, pt = 0;
 
        for (int pg = 0; pg < n; pg++) {
            int page = pages[pg];
            boolean flag = true;
 
            for (int i = 0; i < f; i++) {
                if (frames[i] == page) {
                    flag = false;
                    break;
                }
            }
 
            if (flag) {
                if (pt < f) {
                    frames[pt++] = page;
                } else {
                    int farthest = -1, indexToReplace = -1;
                    for (int i = 0; i < f; i++) {
                        int nextUse = -1;
                        for (int k = pg + 1; k < n; k++) {
                            if (frames[i] == pages[k]) {
                                nextUse = k;
                                break;
                            }
                        }
                        if (nextUse == -1) {
                            indexToReplace = i;
                            break;
                        }
                        if (nextUse > farthest) {
                            farthest = nextUse;
                            indexToReplace = i;
                        }
                    }
                    frames[indexToReplace] = page;
                }
                pageFaults++;
            }
 
            // Print the current state of frames
            System.out.print("Frame: ");
            for (int frame : frames) System.out.print(frame + " \t ");
            System.out.println();
        }
 
        System.out.println("Page fault: " + pageFaults);
        System.out.println("Page hit: " + (n - pageFaults));
    }
}
