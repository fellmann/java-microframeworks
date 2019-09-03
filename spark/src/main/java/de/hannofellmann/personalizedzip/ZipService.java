package de.hannofellmann.personalizedzip;


import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipService {
    public void writePersonalizedZip(String name, OutputStream outputStream) throws IOException {
        ZipOutputStream out = new ZipOutputStream(outputStream);
        out.putNextEntry(new ZipEntry("greeting.txt"));
        out.write(("Hello, " + name + "!").getBytes());
        out.close();
    }
}
