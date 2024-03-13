package com.zyc.download4j.core.web;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.net.URLConnection;
import java.nio.file.Files;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * Content-type
 */
public class ContentType {

    public static class Application {
        public static final String OCTET_STREAM = "application/octet-stream";
        public static final String X_ZIP_COMPRESSED = "application/x-zip-compressed";
    }

    public static class Text {
        public static final String PLAIN = "text/plain";
    }

    public static String file(File file) {
        try {
            String contentType = Files.probeContentType(file.toPath());
            if (contentType != null) {
                return contentType;
            }
        } catch (Throwable ignore) {
        }
        try {
            String contentType = new MimetypesFileTypeMap().getContentType(file);
            if (contentType != null) {
                return contentType;
            }
        } catch (Throwable ignore) {
        }
        try {
            String contentType = URLConnection.getFileNameMap().getContentTypeFor(file.getAbsolutePath());
            if (contentType != null) {
                return contentType;
            }
        } catch (Throwable ignore) {
        }
        return null;
    }
}
