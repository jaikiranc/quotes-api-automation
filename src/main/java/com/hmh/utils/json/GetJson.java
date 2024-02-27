package com.hmh.utils.json;

/**
 *
 * @author Ranjeet
 *
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class GetJson {

    private static final Logger logger = LogManager.getLogger(GetJson.class);

    public String readFile(String fileName) {
		StringBuilder sb = new StringBuilder();

		String file = getClass().getClassLoader().getResource(fileName).getFile();
		try {
            try (FileInputStream is = new FileInputStream(file)) {
                try (InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8)) {
                    try (BufferedReader br = new BufferedReader(isr)) {

                        String line = br.readLine();

                        while (line != null) {
                            sb.append(line);
                            sb.append("\n");
                            line = br.readLine();
                        }
                    }
                }
            }
		} catch (IOException e) {
			logger.info("Error while reading json file");
			logger.error(e);

		} 
		return sb.toString();
	}
	
	public String readFileUsingPath(String filePath) {
		StringBuilder sb = new StringBuilder();

		String file = filePath;
		try {
            try (FileInputStream is = new FileInputStream(file)) {
                try (InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8)) {
                    try (BufferedReader br = new BufferedReader(isr)) {

                        String line = br.readLine();

                        while (line != null) {
                            sb.append(line);
                            sb.append("\n");
                            line = br.readLine();
                        }
                    }
                }
            }
		} catch (IOException e) {
			logger.info("Error while reading json file");
			logger.error(e);

		} 
		return sb.toString();
	}
}
