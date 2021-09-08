import javax.swing.*;

class MyFrame{

    MyFrame() {

        ImageIcon icon = new ImageIcon("icon.jpg");

        JFrame frame = new JFrame ("Key Value + Converter");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(icon.getImage());
        frame.getContentPane().add (new MyPanel());
        frame.pack();
        frame.setVisible (true);
        frame.setResizable(false);
    }

}



