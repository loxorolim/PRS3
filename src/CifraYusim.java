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
        
        if(rails == 0 || rails > message.length() || rails == 1) {
            return message;
        }
        
//        message = message.trim();
//        
//        message = message.replaceAll("\\s", "");
        
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
        
        return cipheredText;
    }
    
    public static String decipher(String message, int rails) {
        
        if(rails == 0 || rails > message.length() || rails == 1) {
            return message;
        }
        
        String[][] railFence = new String[rails][message.length()];
        
        boolean desce = true;
        
        int linha = 0;
        
        //Preparando matriz railFence.
        for(int i = 0; i < message.length(); i++) {
            
            railFence[linha][i] = "---";
            
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
        
        linha = 0;
        int posChar = 0;
        
        
        //Escrevendo na matriz a mensagem cifrada
        for (int i = 0; i < railFence.length; i++) {
            for (int j = 0; j < railFence[0].length; j++) {
                if(i == linha && railFence[i][j] != null && railFence[i][j].equals("---")) {
                    railFence[i][j] = message.substring(posChar, posChar+1);
                    posChar++;
                }
            }
            linha++;
        }
        
        String decipheredMessage = "";
        
        linha = 0;
        
        desce = true;
        
        //Lendo texto decifrado.
        for(int i = 0; i < message.length(); i++) {
            
            decipheredMessage += railFence[linha][i];
            
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
        
        return decipheredMessage;
        
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
