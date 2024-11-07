import java.io.*;
 
class LRU {
    public static void main(String[] args) throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
 
        System.out.print("Enter number of frames: ");
        int f = Integer.parseInt(obj.readLine());
 
        int[] frames = new int[f], a = new int[f], b = new int[f];
        for (int i = 0; i < f; i++) frames[i] = a[i] = b[i] = -1;
 
        System.out.print("Enter number of pages: ");
        int n = Integer.parseInt(obj.readLine());
        int[] pages = new int[n];
 
        System.out.println("Enter page numbers: ");
        for (int i = 0; i < n; i++) pages[i] = Integer.parseInt(obj.readLine());
 
        int pageFaults = 0, chn = 0;
 
        for (int pg = 0; pg < n; pg++) {
            int page = pages[pg];
            boolean flag = true;
            int replaceIdx = -1;
 
            for (int i = 0; i < f; i++) {
                if (frames[i] == page) {
                    flag = false;
                    break;
                } else if (frames[i] == a[f - 1]) {
                    replaceIdx = i;
                }
            }
 
            if (flag) {
                frames[replaceIdx] = page;
                pageFaults++;
            }
 
            System.out.print("Frames: ");
            for (int frame : frames) System.out.print(frame + " ");
            System.out.println();
 
            b[0] = page;
            int pos = 1;
            for (int i = 0; i < f && pos < f; i++) {
                if (a[i] != page) b[pos++] = a[i];
            }
            System.arraycopy(b, 0, a, 0, f);
 
            chn++;
        }
 
        int pageHits = n - pageFaults;
        System.out.println("Page faults: " + pageFaults);
        System.out.println("Page hits: " + pageHits);
    }
}
 
