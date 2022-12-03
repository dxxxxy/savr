package studio.dreamys.savr.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class FileUtils {
    public static String loadUncompressed() {
        String data;

        try {
            //open file
            Path path = Paths.get("text.savr");

            //init
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ByteArrayInputStream bais = new ByteArrayInputStream(Files.readAllBytes(path));
            GZIPInputStream gis = new GZIPInputStream(bais);
            byte[] buffer = new byte[256];
            int n;

            //decompress
            while ((n = gis.read(buffer)) >= 0) {
                baos.write(buffer, 0, n);
            }

            //read
            data = baos.toString(String.valueOf(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }

    public static void saveCompressed(String data) {
        try {
            //open file
            Path path = Paths.get("text.savr");

            //init
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            GZIPOutputStream gos = new GZIPOutputStream(baos);

            //compress
            gos.write(data.getBytes(StandardCharsets.UTF_8));
            gos.close();

            //write
            Files.write(path, baos.toByteArray());

            //print size
            System.out.println(Files.size(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}