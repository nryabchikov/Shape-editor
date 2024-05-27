package by.ryabchikov.lab1.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileArchiver {
    public static void main(String[] args) {
        String filename = "shapes.xml";
        String archiveName = "xml.zip";
        zip(filename, archiveName);
        unzip(archiveName);
        String filename1 = "shapes.bin";
        String archiveName1 = "bin.zip";
        zip(filename1, archiveName1);
        unzip(archiveName1);
    }

    public static void zip(String filename, String archiveName) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(archiveName));
             FileInputStream fis = new FileInputStream(filename)) { 
            ZipEntry entry1 = new ZipEntry(filename);
            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            // добавляем содержимое к архиву
            zout.write(buffer);
            // закрываем текущую запись для новой записи
            zout.closeEntry();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void unzip(String archiveName) {
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(archiveName)))
        {
            ZipEntry entry;
            String name;
            while((entry=zin.getNextEntry())!=null){

                name = entry.getName(); // получим название файла
                FileOutputStream fout = new FileOutputStream("unzip" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
