package hello.upload.controller;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ItemForm {

    private Long itemId;
    private String itemName;
    private MultipartFile attachFile; // 첨부파일
    private List<MultipartFile> imageFiles;
}
