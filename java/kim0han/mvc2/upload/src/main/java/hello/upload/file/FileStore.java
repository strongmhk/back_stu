package hello.upload.file;

import hello.upload.domain.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Component
public class FileStore {

    @Value("${file.dir}")
    private String fileDir;

    public String getFullPath(String fileName){
        return fileDir + fileName;
    }

    // 파일 여러개 업로드
    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFile> storeFileResult = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()){
                storeFileResult.add(storeFile(multipartFile));
            }
        }
        return storeFileResult;
    }


    // 파일 1개 업로드 하는 경우
    public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()){
            return null;
        }

        // image.png
        String originalFilename = multipartFile.getOriginalFilename();

        // 서버에 저장하는 파일명
        String storeFileName = createStoreFileName(originalFilename);

        // 파일 저장
        multipartFile.transferTo(new File(getFullPath(storeFileName)));

        return new UploadFile(originalFilename, storeFileName);

    }

    private String createStoreFileName(String originalFilename) {
        String uuid = UUID.randomUUID().toString();
        // "qwwe213-j3kn3"

        // "qwwe213-j3kn3.png"처럼 uuid에 확장자를 붙여 저장할 것 -> 파일이 종류가 무엇인지 구분하기 위해
        String ext = extractExt(originalFilename);
        return uuid + "." + ext;
    }

    // 확장자 추출 함수
    private String extractExt(String originalFilename) {
        int pos = originalFilename.indexOf(".");
        return originalFilename.substring(pos + 1);
    }


}
