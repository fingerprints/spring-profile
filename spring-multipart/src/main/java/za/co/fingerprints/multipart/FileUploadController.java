package za.co.fingerprints.multipart;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "multipart")
public class FileUploadController {

    @RequestMapping(
            value = "{path}/invoice",
            method = RequestMethod.POST
    )
    @ResponseBody
    public HttpEntity invoice(
            @PathVariable String path,
            @MatrixVariable(value = "refNo", pathVar = "path") String referenceNumber,
            @RequestParam(value = "image", required = true) List<MultipartFile> files
    ) throws IOException {
        System.out.println(path);
        System.out.println(files);
        return ResponseEntity.ok("{\"state\": \"All Well\"}");
    }

}
