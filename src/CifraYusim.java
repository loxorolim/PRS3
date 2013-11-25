/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
public class CifraYusim {
    
    
    public static String cipher(String message, int rails) {
        
        if(rails == 0) {
            return message;
        }
        
        message = message.trim();
        
        message = message.replaceAll("\\s", "");
        
        String[][] railFence = new String[rails][message.length()];
        
        boolean desce = true;
        int linha = 0;
        
        for(int i = 0; i < message.length(); i++) {
            
            railFence[linha][i] = message.substring(i, i+1);
            
            if(desce) {
                if(linha%rails == rails-1) {
                    desce = false;
                    linha--;
                } else {
                    linha++;                    
                }
            } else {
                if(linha%rails == 0) {
                    desce = true;
                    linha++;
                } else {
                    linha--;
                }
            }
        }
        
        String cipheredText = "";
        
        for (int i = 0; i < railFence.length; i++) {
            for (int j = 0; j < railFence[0].length; j++) {
                if(railFence[i][j] != null) {
                    cipheredText += railFence[i][j];
                }
            }
        }
        
        printRailFence(railFence);
        
        System.out.println(cipheredText);
        
        return cipheredText;
    }
    
    public static void printRailFence(String[][] railFence) {
        for (int i = 0; i < railFence.length; i++) {
            for (int j = 0; j < railFence[0].length; j++) {
                System.out.print(railFence[i][j] + " | ");
            }
            System.out.println("");
        }
    }
    
    
}
