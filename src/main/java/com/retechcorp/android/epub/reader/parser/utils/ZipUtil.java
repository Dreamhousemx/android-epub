package com.retechcorp.android.epub.reader.parser.utils;

import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by mx on 14/12/17.
 * 解压zip包
 */
public class ZipUtil {

    public static void unzipEpub(String inputZip, String destinationDirectory, String desKey) throws Exception {
        //long start = System.currentTimeMillis();
        // DES加密工具类，传入加密的key
        FileDES fileDES = new FileDES(desKey);
        int BUFFER = 1024;
        List<String> zipFiles = new ArrayList<>();
        File sourceZipFile = new File(inputZip);
        File unzipDestinationDirectory = new File(destinationDirectory);
        unzipDestinationDirectory.mkdir();
        ZipFile zipFile;
        // 打开zip文件并读取
        zipFile = new ZipFile(sourceZipFile, ZipFile.OPEN_READ);
        // 创建一个Enumeration，保存zip文件中的条目
        Enumeration zipFileEntries = zipFile.entries();
        // 处理每个条目
        while (zipFileEntries.hasMoreElements()) {
            // 抓取一个zip文件条目
            ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
            String currentEntry = entry.getName();
            File destFile = new File(unzipDestinationDirectory, currentEntry);
            if (currentEntry.endsWith(".epub")) {
                zipFiles.add(destFile.getAbsolutePath());
            }
            // 获取文件的父目录结构
            File destinationParent = destFile.getParentFile();
            // 如果需要创建父目录结构
            destinationParent.mkdirs();
            try {
                // 如果不是一个目录，就提取文件
                if (!entry.isDirectory()) {
                    // 加密并保存加密后的文件
                    String target = URLDecoder.decode(destFile.getPath(), "UTF-8");
                    if (target.contains(".mp3") || target.contains(".mov") || target.contains(".mp4") || target.contains(".avi")
                            || target.contains(".3gp") || target.contains(".html") || target.contains(".htm") || target.contains(".xhtml")
                            || target.contains(".jpg") || target.contains(".jpeg") || target.contains(".png") || target.contains(".css")) {
                        BufferedInputStream is = new BufferedInputStream(zipFile.getInputStream(entry));
                        int currentByte;
                        // 建立缓冲区，写文件
                        byte data[] = new byte[BUFFER];
                        // 当前文件写入磁盘
                        FileOutputStream fos = new FileOutputStream(destFile);
                        BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
                        // 读和写,直到遇到最后一个字节
                        while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
                            dest.write(data, 0, currentByte);
                        }
                        dest.flush();
                        dest.close();
                        is.close();
                    } else {
                        fileDES.doEncryptFile(zipFile.getInputStream(entry), target);
                    }
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        zipFile.close();
        for (Iterator iter = zipFiles.iterator(); iter.hasNext(); ) {
            String zipName = (String) iter.next();
            ZipUtil.unzipEpub(zipName, destinationDirectory + File.separatorChar + zipName.substring(0, zipName.lastIndexOf(".epub")), desKey);
        }
    }
}