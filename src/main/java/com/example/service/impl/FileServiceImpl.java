package com.example.service.impl;

import com.example.entity.dto.response_entity.ResponseResult;
import com.example.utils.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl {
    @Value("${file.upload.url}")
    private String uploadFilePath;

    public String upload(MultipartFile file) throws IOException {
        try {
            String originalFileName = FileUtils.cleanFileName(file.getOriginalFilename());

            String newFileName = UUID.randomUUID() + "_" + originalFileName;

            Path path = Paths.get(uploadFilePath + File.separator + newFileName);

            Files.copy(file.getInputStream(), path);
            return newFileName;
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }
}
