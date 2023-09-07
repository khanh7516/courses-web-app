package com.example.courseapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;


@Service
public class ImageServiceImpl implements ImageService{
    // folder lưu tru file
    // .../course-app/uploads
    private static String uploadDir = System.getProperty("user.dir")
            .concat(File.separator)
            .concat("uploads");

    public ImageServiceImpl() {
        createFolder(uploadDir);
    }

    private void createFolder(String filePath) {
        File file = new File(filePath);
        if(!file.exists()) {
            file.mkdirs();
        }
    }

    @Override
    public String uploadImage(MultipartFile file) {
        // .../course-app/uploads/hdkdkdkdk
        String fileId = UUID.randomUUID().toString();
        File fileServer = new File(uploadDir.concat(File.separator).concat(fileId));

        try {
            file.transferTo(fileServer);
            return "/api/v1/files/".concat(fileId);
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi upload file");
        }
    }

    @Override
    public byte[] readImage(String id) {
        File fileServer = new File(uploadDir.concat(File.separator).concat(id));
        if(!fileServer.exists()) {
            throw new RuntimeException("Lỗi khi đọc file");
        }
        try {
            return Files.readAllBytes(fileServer.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Lỗi khi đọc file");
        }
    }
}
