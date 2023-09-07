package com.example.courseapi.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {


    String uploadImage(MultipartFile file);


    byte[] readImage(String id);
}
