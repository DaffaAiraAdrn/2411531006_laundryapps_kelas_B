package Tugas;

class multithreading implements Runnable {
    private String fileName;

    public multithreading(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        for (int i = 10; i <= 100; i += 10) {
            System.out.println(fileName + " progress: " + i + "%");
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(fileName + " selesai diunduh!");
    }
}

