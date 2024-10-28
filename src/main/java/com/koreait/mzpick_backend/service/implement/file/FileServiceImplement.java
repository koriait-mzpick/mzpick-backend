package com.koreait.mzpick_backend.service.implement.file;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.mzpick_backend.service.file.FileService;

//service 파일 업로드 미리보기 관련 서비스 //
@Service
public class FileServiceImplement implements FileService { 
    
    //! 업로드 폴더 경로 및 URL 
    @Value("${file.path}")
    private String filePath;
    @Value("${file.url}")
    private String fileUrl;

    //Post 파일 업로드  //
    @Override
    public String upload(MultipartFile file) {
        if (file.isEmpty()) return null;

        String originalFileName = file.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String saveFileName = uuid + extension;
        String saveFilePath = filePath + saveFileName;

        try {
            file.transferTo(new File(saveFilePath));
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        String url = fileUrl + saveFileName;
        return url;
    }

    //Get 파일 미리보기 //
    @Override
    public Resource getFile(String fileName) {
        Resource resource = null;
        try {
            resource = new UrlResource("file:" + filePath + fileName);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return resource;
    }

}
