/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import GUI.DangNhap;

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            DangNhap dn = new DangNhap();
            dn.setLocationRelativeTo(null);
            dn.setVisible(true);
        }
    });
}
}
