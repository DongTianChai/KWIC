package �����ϵ�ṹ;

import �����ϵ�ṹ.�������ӳ��������ϵ�ṹ.demo1;
import �����ϵ�ṹ.������������ϵ�ṹ.Main;

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
        setTitle("�ļ��������");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputTextArea = new JTextArea(10, 40);
        // ����༭
        inputTextArea.setEditable(true);

        outputTextArea = new JTextArea(10, 40);
        outputTextArea.setEditable(false);

        add(new JScrollPane(inputTextArea), BorderLayout.WEST);
        add(new JScrollPane(outputTextArea), BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        methodOneButton = new JButton("������-�ӳ��������ϵ�ṹ");
        methodTwoButton = new JButton("������������ϵ�ṹ");
        methodThreeButton = new JButton("�¼�ϵͳ�����ϵ�ṹ");
        methodFourButton = new JButton("�ܵ�-���������ϵ�ṹ");
        saveButton = new JButton("���������ļ�");

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

        // ��������ʱ����Ĭ�ϵ������ļ�
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
            JOptionPane.showMessageDialog(this, "�޷���ȡĬ�������ļ�");
        }
    }

    private void loadDefaultOutputFile() {
        File outputFile = new File("E:\\output.txt");
        try {
            String content = new String(Files.readAllBytes(outputFile.toPath()));
            outputTextArea.setText(content);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "�޷���ȡĬ������ļ�");
        }
    }

    private void saveInputFile() {
        try {
            String content = inputTextArea.getText();
            Files.write(Paths.get("E:\\input.txt"), content.getBytes());
            JOptionPane.showMessageDialog(this, "�����ļ��ѱ���");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "���������ļ�ʱ����");
        }
    }

    private void processFile() {
        // ʹ��inputTextArea�е����ݽ��д���
        String inputContent = inputTextArea.getText();
        demo1 demo1 = new demo1();
        // ����demo1.main����һ��String������Ϊ����
        demo1.main(new String[]{inputContent});
        loadDefaultOutputFile();
    }
    private void processFile2() {
        // ʹ��inputTextArea�е����ݽ��д���
        String inputContent = inputTextArea.getText();
        Main.main(new String[]{inputContent});
        loadDefaultOutputFile();
    }
    private void processFile3() {
        // ʹ��inputTextArea�е����ݽ��д���
        String inputContent = inputTextArea.getText();
        �����ϵ�ṹ.�¼�ϵͳ�����ϵ�ṹ.Main.main(new String[]{inputContent});
        loadDefaultOutputFile();
    }
    private void processFile4() {
        // ʹ��inputTextArea�е����ݽ��д���
        String inputContent = inputTextArea.getText();
        try {
            �����ϵ�ṹ.�ܵ����������ϵ�ṹ.Main.main(new String[]{inputContent});
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