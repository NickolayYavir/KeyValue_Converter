import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener {

    private JLabel keyTextLabel = new JLabel("Type here");
    private JLabel keyCharLabel = new JLabel("CHR code: ");
    private JLabel keyCodeLabel = new JLabel("DEC code: ");
    private JLabel keyBinaryLabel = new JLabel("BIN code: ");
    private JLabel keyHexadecimalLabel = new JLabel("HEX code: ");
    private JLabel keyOctalLabel = new JLabel("OCT code: ");

    private JLabel pressShiftLabel = new JLabel("Shift");
    private JLabel pressCtrlLabel = new JLabel("Ctrl");
    private JLabel pressAltLabel = new JLabel("Alt");
    private JLabel pressWinLabel = new JLabel("Win");
    private JLabel pressCapsLabel = new JLabel("CapsLock");

    private JLabel convertToStringInfoLabel = new JLabel("Convert numerical system to String");
    private JLabel convertFromStringInfoLabel = new JLabel("Convert String to numerical system");

    private JTextArea inputTextArea = new JTextArea(5, 5);
    private JScrollPane inputScrollPane = new JScrollPane(inputTextArea);

    private JTextArea outputTextArea = new JTextArea(5, 5);
    private JScrollPane outputScrollPane = new JScrollPane(outputTextArea);

    private JToggleButton convertToBinButton = new JToggleButton("BIN", false);
    private JToggleButton convertToOctButton = new JToggleButton("OCT", false);
    private JToggleButton convertToDecButton = new JToggleButton("DEC", false);
    private JToggleButton convertToHexButton = new JToggleButton("HEX", false);

    private JToggleButton convertBinToStringButton = new JToggleButton("BIN", false);
    private JToggleButton convertOctToStringButton = new JToggleButton("OCT", false);
    private JToggleButton convertDecToStringButton = new JToggleButton("DEC", false);
    private JToggleButton convertHexToStringButton = new JToggleButton("HEX", false);

    private JLabel colorLabel = new JLabel();

    MyPanel() {
        StringConverter converter = new StringConverter();

        this.setPreferredSize(new Dimension(455, 610));
        this.setLayout(null);
        this.setVisible(true);


        this.add(keyTextLabel);
        this.add(keyCharLabel);
        this.add(keyCodeLabel);
        this.add(keyBinaryLabel);
        this.add(keyHexadecimalLabel);
        this.add(pressShiftLabel);
        this.add(pressCtrlLabel);
        this.add(pressAltLabel);
        this.add(inputScrollPane);
        this.add(convertToBinButton);
        this.add(outputScrollPane);
        this.add(convertToOctButton);
        this.add(convertToDecButton);
        this.add(convertToHexButton);
        this.add(convertBinToStringButton);
        this.add(convertOctToStringButton);
        this.add(convertDecToStringButton);
        this.add(convertHexToStringButton);
        this.add(colorLabel);
        this.add(keyOctalLabel);
        this.add(pressWinLabel);
        this.add(convertToStringInfoLabel);
        this.add(convertFromStringInfoLabel);
        this.add(pressCapsLabel);

        keyTextLabel.setBounds(5, 10, 445, 85);
        keyTextLabel.setHorizontalAlignment(JLabel.CENTER);
        keyTextLabel.setOpaque(true);
        keyTextLabel.setBackground(Color.BLACK);
        keyTextLabel.setForeground(Color.GREEN);
        keyTextLabel.setFont(new Font("Consolas", Font.PLAIN, 28));

        keyCharLabel.setBounds(15, 110, 300, 25);
        keyCharLabel.setFont(new Font("Serif", Font.BOLD, 20));

        keyCodeLabel.setBounds(15, 135, 300, 25);
        keyCodeLabel.setFont(new Font("Serif", Font.BOLD, 20));

        keyBinaryLabel.setBounds(15, 160, 300, 25);
        keyBinaryLabel.setFont(new Font("Serif", Font.BOLD, 20));

        keyHexadecimalLabel.setBounds(15, 185, 300, 25);
        keyHexadecimalLabel.setFont(new Font("Serif", Font.BOLD, 20));

        keyOctalLabel.setBounds(15, 210, 300, 25);
        keyOctalLabel.setFont(new Font("Serif", Font.BOLD, 20));

        pressShiftLabel.setBounds(410, 110, 100, 25);
        pressShiftLabel.setOpaque(true);
        pressShiftLabel.setBackground(Color.LIGHT_GRAY);

        pressCtrlLabel.setBounds(410, 130, 100, 25);
        pressCtrlLabel.setOpaque(true);
        pressCtrlLabel.setBackground(Color.LIGHT_GRAY);

        pressAltLabel.setBounds(410, 150, 100, 25);
        pressAltLabel.setOpaque(true);
        pressAltLabel.setBackground(Color.LIGHT_GRAY);

        pressWinLabel.setBounds(410, 170, 100, 25);
        pressWinLabel.setOpaque(true);
        pressWinLabel.setBackground(Color.LIGHT_GRAY);

        pressCapsLabel.setBounds(390, 210, 100, 25);
        pressCapsLabel.setOpaque(true);

        if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
            pressCapsLabel.setBackground(Color.RED);
        } else pressCapsLabel.setBackground(Color.LIGHT_GRAY);

        inputTextArea.addKeyListener(this);
        inputTextArea.setLineWrap(true);
        inputScrollPane.setBounds(10, 250, 430, 100);

        convertFromStringInfoLabel.setBounds(10, 355, 430, 25);
        convertFromStringInfoLabel.setHorizontalAlignment(JLabel.CENTER);

        convertToStringInfoLabel.setBounds(10, 410, 430, 25);
        convertToStringInfoLabel.setHorizontalAlignment(JLabel.CENTER);


        outputTextArea.setLineWrap(true);
        outputTextArea.setEditable(false);
        outputTextArea.setText("Output info here...");
        outputScrollPane.setBounds(10, 470, 430, 100);


        convertToBinButton.setBounds(10, 380, 100, 25);
        convertToBinButton.setContentAreaFilled(false);
        convertToBinButton.setFocusable(false);
        convertToBinButton.addActionListener(e -> {
            try {
                outputTextArea.selectAll();
                outputTextArea.replaceSelection(converter.convertStringToBinary(inputTextArea.getText()));
            } catch (Exception e1) {
                outputTextArea.setText("Invalid input");
            }
        });

        convertToOctButton.setBounds(120, 380, 100, 25);
        convertToOctButton.setContentAreaFilled(false);
        convertToOctButton.setFocusable(false);
        convertToOctButton.addActionListener(e -> {
            try {
                outputTextArea.setText("");
                outputTextArea.setText(converter.convertStringToOctal(inputTextArea.getText()));
            } catch (Exception e1) {
                outputTextArea.setText("Invalid input");
            }
        });

        convertToDecButton.setBounds(230, 380, 100, 25);
        convertToDecButton.setContentAreaFilled(false);
        convertToDecButton.setFocusable(false);
        convertToDecButton.addActionListener(e -> {
            try {
                outputTextArea.setText("");
                outputTextArea.setText(converter.convertStringToDecimal(inputTextArea.getText()));
            } catch (Exception e1) {
                outputTextArea.setText("Invalid input");
            }
        });

        convertToHexButton.setBounds(340, 380, 100, 25);
        convertToHexButton.setContentAreaFilled(false);
        convertToHexButton.setFocusable(false);
        convertToHexButton.addActionListener(e -> {
            try {
                outputTextArea.setText("");
                outputTextArea.setText(converter.convertStringToHexadecimal(inputTextArea.getText()));
            } catch (Exception e1) {
                outputTextArea.setText("Invalid input");
            }
        });

        convertBinToStringButton.setBounds(10, 435, 100, 25);
        convertBinToStringButton.setContentAreaFilled(false);
        convertBinToStringButton.setFocusable(false);
        convertBinToStringButton.addActionListener(e -> {
            try {
                outputTextArea.setText("");
                outputTextArea.setText(converter.convertInputFormatToString(inputTextArea.getText(), 2));
            } catch (Exception e1) {
                outputTextArea.setText("Invalid input");
            }
        });

        convertOctToStringButton.setBounds(120, 435, 100, 25);
        convertOctToStringButton.setContentAreaFilled(false);
        convertOctToStringButton.setFocusable(false);
        convertOctToStringButton.addActionListener(e -> {
            try {
                outputTextArea.setText("");
                outputTextArea.setText(converter.convertInputFormatToString(inputTextArea.getText(), 8));
            } catch (Exception e1) {
                outputTextArea.setText("Invalid input");
            }
        });

        convertDecToStringButton.setBounds(230, 435, 100, 25);
        convertDecToStringButton.setContentAreaFilled(false);
        convertDecToStringButton.setFocusable(false);
        convertDecToStringButton.addActionListener(e -> {
            try {
                outputTextArea.setText("");
                outputTextArea.setText(converter.convertInputFormatToString(inputTextArea.getText(), 10));
            } catch (Exception e1) {
                outputTextArea.setText("Invalid input");
            }
        });

        convertHexToStringButton.setBounds(340, 435, 100, 25);
        convertHexToStringButton.setContentAreaFilled(false);
        convertHexToStringButton.setFocusable(false);
        convertHexToStringButton.addActionListener(e -> {
            try {
                outputTextArea.setText("");
                outputTextArea.setText(converter.convertInputFormatToString(inputTextArea.getText(), 16));
            } catch (Exception e1) {
                outputTextArea.setText("Invalid input");
            }
        });

        colorLabel.setBounds(10, 585, 430, 10);
        colorLabel.setBackground(Color.BLACK);
        colorLabel.setOpaque(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyAsciiResult = e.getKeyChar();

        try {
            colorLabel.setBackground(new Color(Integer.parseInt(keyAsciiResult + "00" + keyAsciiResult)));
        } catch (Exception e1) {
            colorLabel.setBackground(Color.BLACK);
        }

        switch (e.getKeyCode()) {
            case 16:
                pressShiftLabel.setBackground(Color.BLUE);
                break;
            case 17:
                pressCtrlLabel.setBackground(Color.BLUE);
                break;
            case 18:
                pressAltLabel.setBackground(Color.BLUE);
                break;
            case 524:
                pressWinLabel.setBackground(Color.BLUE);
                break;
        }

        if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
            pressCapsLabel.setBackground(Color.RED);
        }

        keyTextLabel.setText("Key pressed:  " + KeyEvent.getKeyText(e.getKeyCode()));

        if (keyAsciiResult == 65535) { // for shift, alt, etc...
            keyCharLabel.setText("CHR code:  Null");
            keyCodeLabel.setText("DEC code:   Null");
            keyBinaryLabel.setText("BIN code:  Null");
            keyHexadecimalLabel.setText("HEX code:  Null");
            keyOctalLabel.setText("OCT code:  Null");
        } else {
            keyCharLabel.setText("CHR code: " + e.getKeyChar());
            keyCodeLabel.setText("DEC code:  " + keyAsciiResult);
            keyBinaryLabel.setText("BIN code: " + Integer.toBinaryString(keyAsciiResult));
            keyHexadecimalLabel.setText("HEX code: " + Integer.toHexString(keyAsciiResult));
            keyOctalLabel.setText("OCT code: " + Integer.toOctalString(keyAsciiResult));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (!Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
            pressCapsLabel.setBackground(Color.LIGHT_GRAY);
        }

        switch (e.getKeyCode()) {
            case 16:
                pressShiftLabel.setBackground(Color.LIGHT_GRAY);
                break;
            case 17:
                pressCtrlLabel.setBackground(Color.LIGHT_GRAY);
                break;
            case 18:
                pressAltLabel.setBackground(Color.LIGHT_GRAY);
                break;
            case 524:
                pressWinLabel.setBackground(Color.LIGHT_GRAY);
                break;
        }
    }
}
