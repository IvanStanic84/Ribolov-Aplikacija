/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import edunova.model.Operater;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.xsoup.Xsoup;

/**
 *
 * @author dell
 */
public class Pomocno {

    /**
     *
     */
    public static final String FORMAT_DATUMA = "dd. MMMM yyyy. HH:mm";
    public static final String NAZIV_APLIKACIJE = "RIBOLOV APP";
    public static Operater operater;
    
    public static boolean kontrolaOib(String oib) {
        if (oib == null) {
            return false;
        }
        if (oib.length() != 11) {
            return false;
        }

        char[] chars = oib.toCharArray();

        int a = 10;
        int asciiDigitsOffset = '0';
        for (int i = 0; i < 10; i++) {
            char c = chars[i];
            if (c < '0' || c > '9') {
                return false;
            }
            a = a + (c - asciiDigitsOffset);
            a = a % 10;
            if (a == 0) {
                a = 10;
            }
            a *= 2;
            a = a % 11;
        }
        int kontrolni = 11 - a;
        kontrolni = kontrolni % 10;

        return kontrolni == (chars[10] - asciiDigitsOffset);
    }

    public static String getPrimjerDatuma() {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATUMA);
        return df.format(new Date());
    }
    
   
    public static String getOib() {

        try {
            //https://stackoverflow.com/questions/8616781/how-to-get-a-web-pages-source-code-from-java
            URL url = new URL("http://oib.itcentrala.com/oib-generator/");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            url.openStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
            
             Document d = Jsoup.parse(sb.toString());
            return Xsoup.compile("/html/body/div[1]/div[1]/text()").evaluate(d).get();
            
            //System.out.println(sb.toString());
        } catch (Exception e) {
        }

        return "";

}}
