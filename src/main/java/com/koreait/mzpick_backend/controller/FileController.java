package com.koreait.mzpick_backend.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.mzpick_backend.service.file.FileService;

import lombok.RequiredArgsConstructor;

// REST API 컨트롤러 지정 //
@RestController
// API 경로 지정 //
@RequestMapping("/file")
// 의존성 주입을 위한 어노테이션 //
@RequiredArgsConstructor
public class FileController {
    // FileService 의존성 주입 //
    private final FileService travelFileService;

    // 파일 업로드 메서드 //
    @PostMapping("/upload")
    public String postMethodName(
        // MultipartFile 형식의 파일을 'file'이라는 이름으로 받음 //
        @RequestParam("file") MultipartFile file
    ) {
        // FileService를 통해 파일을 업로드하고 URL을 반환 //
        String url = travelFileService.upload(file);
        return url;
    }
    
    // 파일 다운로드 메서드 - JPEG 또는 PNG 이미지 파일 반환 //
    @GetMapping(value="{fileName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public Resource getFile(
        // URL 경로에서 파일 이름을 변수로 받음 //
        @PathVariable("fileName") String fileName
    ){
        // FileService를 통해 파일을 조회하고 Resource 객체로 반환 //
        Resource resource = travelFileService.getFile(fileName);
        return resource;
    }
    
}
