package bai1;

import javax.print.DocFlavor;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("NHap duong dan ");
        String source = scanner.nextLine();
        System.out.println("nhap duong dan copy");
        String dest = scanner.nextLine();
        File sourcepath = new File(source);
        File destPath = new File(dest);
        try {
            copyFileUsingJava7Files(sourcepath,destPath);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void copyFileUsingJava7Files(File source,File dest) throws IOException {
        Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    private static void copyFileUsingStream(File source,File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            is.close();
            os.close();
        }
    }
}