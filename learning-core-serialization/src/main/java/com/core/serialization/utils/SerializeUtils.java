package com.core.serialization.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by summer.xia on 2019.1.17
 */
public class SerializeUtils {
	
	public static byte[] serialize(Object object) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ObjectOutputStream outputStream = new ObjectOutputStream(os);
		outputStream.writeObject(object);
		outputStream.flush();
		byte[] byteArray = os.toByteArray();
		outputStream.close();
		os.close();
		return byteArray;
	}

	public static Object deSerialize(byte[] buf) throws IOException, ClassNotFoundException {
		ByteArrayInputStream is = new ByteArrayInputStream(buf);
		ObjectInputStream inputStream = new ObjectInputStream(is);
		Object object = inputStream.readObject();
		inputStream.close();
		is.close();
		return object;
	}

	public static void write(String path, Object object) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
			out.writeObject(object);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object read(String path) {
		Object object = null;
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
			object = in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
}