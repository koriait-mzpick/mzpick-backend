package com.koreait.mzpick_backend.service.file;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
//service 파일 관련 서비스 //
public interface FileService {
    
    String upload(MultipartFile file);
    Resource getFile(String fileName);
}
