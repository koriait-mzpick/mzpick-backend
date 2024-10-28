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


@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class  FileController {
    private final FileService travelFileService;

    // controller 사진 파일 업로드 컨트롤러 //
    @PostMapping("/upload")
    public String postMethodName(
        @RequestParam("file") MultipartFile file
    ) {
        String url = travelFileService.upload(file);
        return url;
    }
    
    // controller 사진 파일 불러오기 컨트롤러 //
    @GetMapping(value="{fileName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public Resource getFile(
        @PathVariable("fileName") String fileName
    ){
        Resource resource = travelFileService.getFile(fileName);
        return resource;
    }
    
}
