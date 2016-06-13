package com.edeal.frontline;

import org.apache.tika.config.TikaConfig;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class run {


	public static void main(String[] args) {
		File file = new File("C:\\Users\\a.bernard\\Desktop\\test\\docx");

/*		AutoDetectParser parser = new AutoDetectParser();
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();
		try {
			InputStream stream = new FileInputStream(file);
			parser.parse(stream, handler, metadata);
			handler.toString();
		}catch(Exception ex){
			ex.printStackTrace();
		}*/

		/*TikaConfig tika = new TikaConfig();

			Metadata metadata = new Metadata();
			metadata.set(Metadata.RESOURCE_NAME_KEY, "tete");
			MediaType mimetype = tika.getDetector().detect(
					TikaInputStream.get(new FileInputStream(file)), metadata);
			System.out.println("File is " + mimetype.toString());
*/


		try {
			TikaConfig tika = new TikaConfig();
			Metadata metadata = new Metadata();
			metadata.set(Metadata.RESOURCE_NAME_KEY, file.toString());
			MediaType mimetype = tika.getDetector().detect(
					TikaInputStream.get(file), metadata);
			System.out.println("File " + file + " is " + mimetype);
		} catch (Exception e) {
			e.printStackTrace();
		}



	}
}
