package com.example.pleasesendhelpgodplease;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetQuote {
    public static void main(String[] args) throws Exception {


    }
    public String getString() throws Exception {
        URL url = new URL("http://cswebcat.swansea.ac.uk/puzzle");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        if (con.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String input;
        StringBuffer response = new StringBuffer();

        while ((input = in.readLine()) != null) {
            response.append(input);
        }
        in.close();

        return response.toString();


    }
    public String send() throws Exception {
        String sol = decrypt(getString());
        StringBuffer response = null;
        try {
            URL url = new URL("http://cswebcat.swansea.ac.uk/message?solution=" + sol);

            //Open connection to the URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            //Set the request method to GET
            con.setRequestMethod("GET");

            //Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String input;
            response = new StringBuffer();

            while ((input = in.readLine()) != null) {
                response.append(input);
            }
            in.close();
            //System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }



    private final int ALPHABET_SIZE = 26;

    public String decrypt(String cipherText) {
        int newIndex;
        cipherText = cipherText.toUpperCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            char ch = cipherText.charAt(i);
            if (Character.isLetter(ch)) {
                int index = (int) ch - (int) 'A';

                if ((i + 1) %2 == 0){
                    newIndex = (index + ( i + 1) + ALPHABET_SIZE) % ALPHABET_SIZE;
                }
                else if ((i + 1) %2 == 1){
                    newIndex = (index - ( i + 1) + ALPHABET_SIZE) % ALPHABET_SIZE;
                }
                else {
                    System.out.println("error" + ( i % 2) + i);

                    newIndex = 0;
                }
                plainText += (char) (newIndex + (int) 'A');
            } else {
                plainText += ch;
            }
        }
        plainText += "CS-230";
        plainText = Integer.toString(plainText.length()) + plainText;
        return plainText;
    }


}