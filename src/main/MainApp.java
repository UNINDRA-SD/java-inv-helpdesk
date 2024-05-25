/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import view.Frame_Login;

/**
 *
 * @author dandy
 */
public class MainApp {
    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        Frame_Login loginView = new Frame_Login();
        loginView.pack();
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true);
    }
}
