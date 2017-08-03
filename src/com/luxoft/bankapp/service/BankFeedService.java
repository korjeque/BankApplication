package com.luxoft.bankapp.service;

import com.luxoft.bankapp.commands.BankCommander;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BankFeedService {

    public void loadFeed(String folder) {
        File dir = new File(folder);
        if (dir.isDirectory()) {
            for (File feedFile : dir.listFiles(f -> !f.isDirectory())) {
                loadFeed(feedFile);
            }
        }
    }

    public void loadFeed(File file) {
        Map<String, String> clientMap = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                for (String clientProps : line.split(";")) {
                    String[] prop = clientProps.split("=");
                    clientMap.put(prop[0], prop[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BankCommander.currentBank.parseFeed(clientMap);

    }

}
