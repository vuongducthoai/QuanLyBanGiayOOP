/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.Normalizer;

/**
 *
 * @author Asus
 */
public class VietnameseNormalizer {
    public static String removeVietnameseAccents(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        return normalized.replaceAll("[^\\p{ASCII}]", "");  // Loại bỏ dấu
    }
    
    public static void main(String[] args) {
        String input = "Nguyễn Văn A";
        String result = removeVietnameseAccents(input);
        System.out.println(result);  // In ra "Nguyen Van A"
    }
}
