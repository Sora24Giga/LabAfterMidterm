package compolab_07.compolab_07.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import compolab_07.compolab_07.util.CloudStorageHelper;
import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BucketController {
    final CloudStorageHelper cloudStorangHelper;

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestPart(value = "file") MultipartFile file)
            throws IOException, ServletException {
        return ResponseEntity.ok(this.cloudStorangHelper.getImageUrl(file, "imgup-23aa6.appspot.com"));
    }

    @PostMapping("/uploadImage")
    public ResponseEntity<?> uploadFileComponent(@RequestParam(value = "image") MultipartFile file) throws IOException, ServletException{
        return
        ResponseEntity.ok(this.cloudStorangHelper.getStorageFileDto(file, "imgup-23aa6.appspot.com"));
    }
}
