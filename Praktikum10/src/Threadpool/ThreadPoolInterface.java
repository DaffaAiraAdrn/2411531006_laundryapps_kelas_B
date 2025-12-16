package Threadpool;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolInterface extends JFrame {

    private JTextField threadCountField;
    private JTextField taskCountField;
    private JTextArea logArea;
    private DefaultListModel<String> taskListModel;
    private ExecutorService threadPool;

    public ThreadPoolInterface() {
        setTitle("Aplikasi ThreadPool dengan GUI");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 6));

        controlPanel.add(new JLabel("Jumlah Thread:"));
        threadCountField = new JTextField("3");
        controlPanel.add(threadCountField);

        controlPanel.add(new JLabel("Jumlah Tugas:"));
        taskCountField = new JTextField("20");
        controlPanel.add(taskCountField);

        JButton startButton = new JButton("Mulai Proses");
        startButton.addActionListener(e -> startProcessing());
        controlPanel.add(startButton);

        JButton clearButton = new JButton("Bersihkan Log");
        clearButton.addActionListener(e -> clearLog());
        controlPanel.add(clearButton);

        add(controlPanel, BorderLayout.NORTH);

        taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);

        logArea = new JTextArea();
        logArea.setEditable(false);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new JScrollPane(taskList), new JScrollPane(logArea));

        add(splitPane, BorderLayout.CENTER);
    }

    private void startProcessing() {
        try {
            int threadCount = Integer.parseInt(threadCountField.getText());
            int taskCount = Integer.parseInt(taskCountField.getText());

            if (threadCount < 1 || taskCount < 1) {
                JOptionPane.showMessageDialog(this, "Input tidak valid!");
                return;
            }

            taskListModel.clear();
            for (int i = 0; i < taskCount; i++) {
                taskListModel.addElement("Task " + i + " - Waiting");
            }

            logArea.append("Memproses " + taskCount + " tugas dengan "
                    + threadCount + " worker threads...\n");

            threadPool = Executors.newFixedThreadPool(threadCount);

            for (int i = 0; i < taskCount; i++) {
                threadPool.execute(new Task(i, logArea, taskListModel));
            }

            new Thread(() -> {
                threadPool.shutdown();
                try {
                    threadPool.awaitTermination(1, TimeUnit.MINUTES);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SwingUtilities.invokeLater(() -> logArea.append("\nSemua tugas selesai!\n"));
            }).start();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Input tidak valid!");
        }
    }

    private void clearLog() {
        logArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ThreadPoolInterface().setVisible(true));
    }
}
