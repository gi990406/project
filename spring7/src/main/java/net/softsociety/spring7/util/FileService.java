package net.softsociety.spring7.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class FileService {
    public static String savedFile(MultipartFile upload, String uploadPath) {

        // 파일이 첨부됐으면 저장할 폴더가 있는지 확인
        if (!upload.isEmpty()) {
            File path = new File(uploadPath); // 설정 정보에서 업로드 경로를 읽어와야함.
            if (path.isDirectory())
                path.mkdirs();
        }
        // 원본 파일명
        String originalFilename = upload.getOriginalFilename();

        // Random 값 발생
        String uuid = UUID.randomUUID().toString(); // bts_asldfjsou.jpg

        // 원본 파일의 확장명과 파일명을 분리 bts.jpg
        String filename;        // 파일의 이름
        String ext;             // 파일의 확장명
        String savedFileName;   // 디스크에 저장할 이름

        int lastIndex = originalFilename.lastIndexOf(".");
        filename = originalFilename.substring(0, lastIndex);

        // 확장자가 없는 경우
        if (lastIndex == -1) ext = "";

            // 확장자가 있는 경우
        else {
            ext = "." + originalFilename.substring(lastIndex+1);
        }

        // 하드에 저장될 파일명 세팅
        savedFileName = filename + "_" + uuid + ext;

        // "저장하려는 경로 + 파일명"으로 실제 저장하는 작업
        File serverFile = null;
        serverFile = new File(uploadPath + "/" + savedFileName);

        try {
            upload.transferTo(serverFile);
        } catch (Exception e) {
            savedFileName = null;
            e.printStackTrace();
        }
        return savedFileName;
    }

    public static boolean deleteFile(String fullPath) {
        boolean result = false; // 삭제 여부를 반환할 변수

        File delFile = new File(fullPath);

        // 파일이 존재하면 삭제
        if (delFile.isFile()) {
            delFile.delete();
            result = true;
        }

        return result;
    }
}
