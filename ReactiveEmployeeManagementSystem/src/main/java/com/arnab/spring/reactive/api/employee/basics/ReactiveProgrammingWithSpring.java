/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.spring.reactive.api.employee.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.util.FileCopyUtils;

class Synchronous {
	@SuppressWarnings("unused")
	public void read(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		byte[] data = new byte[FileCopyUtils.BUFFER_SIZE];
		int res;
		while((res = is.read(data, 0, data.length)) != -1) {
			Synchronous.print(data);
		}
		is.close();
	}

	private static void print(byte[] chars) {
		String data = new String(chars);
		System.out.println(data);
	}
}

class Asynchronous {
	
	public void read() {
		
	}
	
}

public class ReactiveProgrammingWithSpring {

	public static void main(String[] args) {
		Synchronous synch = new Synchronous();
		try {
			synch.read(new File("src/main/java/sample.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}


