package com.xworkz.smash.configuration;

import org.springframework.cglib.core.Transformer;
import org.springframework.context.annotation.Bean;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.xml.parsers.*;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.PathMatcher;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmashConfig3 {

    public SmashConfig3(){
        System.out.println(" SmashConfig3 created..........");
    }
    @Bean
    public Base64.Decoder decoder(){
        System.out.println("-----------------------------------------------------------");
        System.out.println("Running bean method decoder");
        return Base64.getDecoder();
    }

    @Bean
    public Pattern pattern(){
        System.out.println("Running bean method pattern");
        return Pattern.compile(".*");
    }
    @Bean
    public Matcher matcher(){
        System.out.println("Running bean method matcher");
        return Pattern.compile("X").matcher("x");
    }
//    @Bean
//    public FileInputStream inputStream() throws FileNotFoundException {
//        System.out.println("Running bean method inputStream");
//        return new FileInputStream(" ");
//    }
//    @Bean
//    public FileOutputStream outputStream() throws FileNotFoundException {
//        System.out.println("Running bean method outputStream");
//        return new FileOutputStream(" ");
//    }
//    @Bean
//    public PrintStream printStream() throws FileNotFoundException {
//        System.out.println("Running bean method printStream");
//        return new PrintStream("log.txt");
//    }
    @Bean
    public BufferedReader bufferedReader(){
        System.out.println("Running bean method bufferedReader");
        return new BufferedReader(new InputStreamReader(System.in));
    }
    @Bean
    public InputStreamReader inputStreamReader(){
        System.out.println("Running bean method inputStreamReader");

        return new InputStreamReader(System.in);
    }
    @Bean
    public BufferedWriter bufferedWriter(){
        System.out.println("Running bean method bufferedWriter");
        return new BufferedWriter(new OutputStreamWriter(System.out));
    }
    @Bean
    public OutputStreamWriter outputStreamWriter(){
        System.out.println("Running bean method outputStreamWriter");
        return new OutputStreamWriter(System.out);
    }
    @Bean
    public DataInputStream dataInput(){
        System.out.println("Running bean method dataInput");
        return new DataInputStream(System.in);
    }
    @Bean
    public DataOutputStream dataOutputStream(){
        System.out.println("Running bean method dataOutputStream");
        return new DataOutputStream(System.out);
    }
    @Bean
    public ObjectOutputStream outputStream() throws IOException {
        System.out.println("Running bean method outputStream");
        return new ObjectOutputStream(System.out);
    }

}
