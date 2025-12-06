package latihan2;

public class DownloadApp {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new DownloadTask("File-1");
        Thread t2 = new DownloadTask("File-2");
        Thread t3 = new DownloadTask("File-3");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("\nDownloading...");

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Semua file selesai diunduh!");

        System.out.println("\nStatus akhir:");
        System.out.println(t1.getName() + ": " + t1.getState());
        System.out.println(t2.getName() + ": " + t2.getState());
        System.out.println(t3.getName() + ": " + t3.getState());
    }
}
