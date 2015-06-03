
package com.retechcorp.android.epub.utils;

import java.io.*;

public class FileUtil {

    /**
     * 读二进制文件
     *
     * @throws IOException
     */
    public static byte[] readFileByBytes(String fileName) throws IOException {
        File file = new File(fileName);
        InputStream in = null;
        ByteArrayOutputStream bos = null;
        byte[] buffer;
        try {
            in = new FileInputStream(file);
            bos = new ByteArrayOutputStream();
            byte[] buf = new byte[10240 * 4]; //40k
            int len = 0;
            while ((len = in.read(buf)) > 0) {
                bos.write(buf, 0, len);
            }
            buffer = bos.toByteArray();
        } catch (IOException e) {
            throw e;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                }
            }
        }
        return buffer;
    }

}

    