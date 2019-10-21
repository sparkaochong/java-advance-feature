package com.ac.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/21
 *
 * @author aochong
 * @version 1.0
 */
public class TestPrimitiveTypeWriter {
    public static void main(String[] args) {
        String path = "." + File.separator + "data" + File.separator + "primitive.txt";
        // 使用 PrintStream 输出基本类型
        try(PrintStream printStream =
                new PrintStream(new FileOutputStream(path))){
            long temp = 100L;
            printStream.println(temp);

            printStream.println(true);
        }catch (IOException e){
            e.printStackTrace();
        }

        try(PrintWriter printWriter =
                new PrintWriter(new FileOutputStream(path))) {
            long temp = 10000000000L;
            printWriter.println(temp);
            printWriter.println(false);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
