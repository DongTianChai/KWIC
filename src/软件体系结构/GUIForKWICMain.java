package 软件体系结构;

import 软件体系结构.主程序子程序软件体系结构.demo1;
import 软件体系结构.面向对象软件体系结构.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GUIForKWICMain extends JFrame {

    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton methodOneButton;
    private JButton methodTwoButton;
    private JButton methodThreeButton;
    private JButton methodFourButton;
    private JButton saveButton;

    public GUIForKWICMain() {
        setTitle("文件处理程序");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputTextArea = new JTextArea(10, 40);
        // 允许编辑
        inputTextArea.setEditable(true);

        outputTextArea = new JTextArea(10, 40);
        outputTextArea.setEditable(false);

        add(new JScrollPane(inputTextArea), BorderLayout.WEST);
        add(new JScrollPane(outputTextArea), BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        methodOneButton = new JButton("主程序-子程序软件体系结构");
        methodTwoButton = new JButton("面向对象软件体系结构");
        methodThreeButton = new JButton("事件系统软件体系结构");
        methodFourButton = new JButton("管道-过滤软件体系结构");
        saveButton = new JButton("保存输入文件");

        buttonPanel.add(methodOneButton);
        buttonPanel.add(methodTwoButton);
        buttonPanel.add(methodThreeButton);
        buttonPanel.add(methodFourButton);
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);

        ActionListener processOne = e -> processFile();
        ActionListener processTwo = e -> processFile2();
        ActionListener processTwoThree = e -> processFile3();
        ActionListener processFour = e -> processFile4();
        methodOneButton.addActionListener(processOne);
        methodTwoButton.addActionListener(processTwo);
        methodThreeButton.addActionListener(processTwoThree);
        methodFourButton.addActionListener(processFour);
        saveButton.addActionListener(e -> saveInputFile());

        // 程序启动时加载默认的输入文件
        loadDefaultInputFile();

        pack();
        setLocationRelativeTo(null);
    }

    private void loadDefaultInputFile() {
        File inputFile = new File("E:\\input.txt");
        try {
            String content = new String(Files.readAllBytes(inputFile.toPath()));
            inputTextArea.setText(content);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "无法读取默认输入文件");
        }
    }

    private void loadDefaultOutputFile() {
        File outputFile = new File("E:\\output.txt");
        try {
            String content = new String(Files.readAllBytes(outputFile.toPath()));
            outputTextArea.setText(content);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "无法读取默认输出文件");
        }
    }

    private void saveInputFile() {
        try {
            String content = inputTextArea.getText();
            Files.write(Paths.get("E:\\input.txt"), content.getBytes());
            JOptionPane.showMessageDialog(this, "输入文件已保存");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "保存输入文件时出错");
        }
    }

    private void processFile() {
        // 使用inputTextArea中的内容进行处理
        String inputContent = inputTextArea.getText();
        demo1 demo1 = new demo1();
        // 假设demo1.main接收一个String参数作为输入
        demo1.main(new String[]{inputContent});
        loadDefaultOutputFile();
    }
    private void processFile2() {
        // 使用inputTextArea中的内容进行处理
        String inputContent = inputTextArea.getText();
        Main.main(new String[]{inputContent});
        loadDefaultOutputFile();
    }
    private void processFile3() {
        // 使用inputTextArea中的内容进行处理
        String inputContent = inputTextArea.getText();
        软件体系结构.事件系统软件体系结构.Main.main(new String[]{inputContent});
        loadDefaultOutputFile();
    }
    private void processFile4() {
        // 使用inputTextArea中的内容进行处理
        String inputContent = inputTextArea.getText();
        try {
            软件体系结构.管道过滤软件体系结构.Main.main(new String[]{inputContent});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loadDefaultOutputFile();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUIForKWICMain gui = new GUIForKWICMain();
            gui.setVisible(true);
        });
    }
}