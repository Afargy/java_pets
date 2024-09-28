package edu.school21.smartcalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
  private JButton ButtonPlus;

  private JPanel MainPanel;
  private JPanel Display;
  private JButton Button7;
  private JButton Button4;
  private JButton Button1;
  private JButton Button0;
  private JButton Button9;
  private JButton Button6;
  private JButton Button3;
  private JButton ButtonEq;
  private JButton Button8;
  private JButton Button5;
  private JButton Button2;
  private JButton ButtonDot;
  private JButton ButtonMinus;
  private JButton ButtonSin;
  private JButton ButtonAsin;
  private JButton ButtonLn;
  private JButton ButtonDiv;
  private JButton ButtonCos;
  private JButton ButtonAcos;
  private JButton ButtonLog;
  private JButton ButtonMod;
  private JButton ButtonTan;
  private JButton ButtonAtan;
  private JButton ButtonSqrt;
  private JButton ButtonPow;
  private JButton ButtonMul;
  private JButton ButtonAdd;
  private JButton ButtonRightBracket;
  private JButton ButtonLeftBracket;
  private JButton ButtonAc;
  private JPanel Keypad;
  private JTextField Input;
  private JTextArea UserInput;

  public View() {
    Button7.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent actionEvent) {
            Input.setText(actionEvent.getActionCommand());
          }
        });
  }
}
