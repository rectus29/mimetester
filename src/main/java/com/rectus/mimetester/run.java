package com.edeal.frontline;

import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.ContainerAwareDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

import java.io.File;
import java.io.IOException;

public class run {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\a.bernard\\Desktop\\test\\");
		try {
			TikaConfig tika = TikaConfig.getDefaultConfig();;
			for (File temp : file.listFiles()) {




				MediaType mediaType;
				Metadata md = new Metadata();
				md.set(Metadata.RESOURCE_NAME_KEY, temp.getName());
				Detector detector = new ContainerAwareDetector(tika.getMimeRepository());

				try {
					mediaType = detector.detect(TikaInputStream.get(temp), md);
					String mimeType = mediaType.toString();
					System.out.println(mimeType);
				} catch (IOException ioe) {
					System.out.println("yolo");
				}


/*				String mimeType = mediaType.getSubtype();

				Metadata metadata = new Metadata();
				metadata.set(Metadata.RESOURCE_NAME_KEY, file.toString());
				Parser parser = new AutoDetectParser();

				ContentHandler contenthandler = new BodyContentHandler();
				parser.parse(TikaInputStream.get(temp),contenthandler,  metadata);
				System.out.println("Mime: " + metadata.get(Metadata.CONTENT_TYPE));*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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
	}
}
