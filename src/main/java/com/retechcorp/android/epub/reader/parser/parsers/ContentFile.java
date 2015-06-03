package com.retechcorp.android.epub.reader.parser.parsers;

import com.retechcorp.android.epub.reader.parser.utils.DebugLog;
import com.retechcorp.android.epub.reader.parser.utils.FileDES;
import com.retechcorp.android.epub.reader.parser.utils.ZipUtil;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by mx on 14/12/17.
 * 解压缩、解析
 */
public class ContentFile extends ADocument {

    //protected static String FULLPATH = "/OEBPS/";
    private static final String CONTAINER_FILE = "/META-INF/container.xml";
    //private static final String CONTAINER_FILE_MEDIA_TYPE = "application/oebps-package+xml";
    private String opfPath;
    // 内容文件集合(opf文件)

    @Override
    protected void parser() throws Exception {
        parserFile(this.source, this.target);
    }

    public ContentFile(String source, String target, String desKey) throws Exception {
        super(source, target,desKey);
    }

    /**
     * 返回opf文件路径
     */
    public String getOpf() {
        return opfPath;
    }

    /**
     * 解压epub到target目录
     *
     * @param source 原文件路径
     * @param target 解压后的文件路径
     */
    public void unzip(String source, String target) throws Exception {
        ZipUtil.unzipEpub(source, target, this.desKey);
    }

    /**
     * 解析解压后的epub目录
     */
    public void parserFile(String source, String target) throws Exception {
        if (!new File(target).exists()) {
            DebugLog.e("文件", "不存在");
            DebugLog.e("解压文件", "解压文件");
            // 解压文件
            unzip(source, target);
        }
        parseContainer(target);
    }

    /**
     * 解析容器文件(container.xml)
     */
    private void parseContainer(String target) throws Exception {
        String container = target + CONTAINER_FILE;
        if (new File(container).exists()) {
            DebugLog.e("container file", container);
            SAXReader reader = new SAXReader();
            // 解密文件
            FileDES fileDES = new FileDES(this.desKey);
            InputStream fileInput = new FileInputStream(new File(container));
            InputStream inputStream = fileDES.doDecryptFile(fileInput);

            Document document = reader.read(inputStream);
            Element root = document.getRootElement();
            Element rootfiles = root.element("rootfiles");
            Element rootfile = rootfiles.element("rootfile");
            // 关闭解密流
            inputStream.close();
            fileInput.close();
            opfPath = target + File.separator + rootfile.attributeValue("full-path");
            DebugLog.e("container file:", "文件名称：" + opfPath);
        } else {
            DebugLog.e("container file:", "文件不存在");
        }
    }
}
