package alumnimanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;

@RestController
@AllArgsConstructor
@RequestMapping("/files")
@CrossOrigin
public class FileController {
    @PostMapping("/uploadFile")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam String type,@RequestParam long id)
            throws IOException {

        var currentLocation = System.getProperty("user.dir");
        Path path = Paths.get(currentLocation);
        //   Path FILE_DIRECTORY = Paths.get(currentLocation,"alumni_app","public");
        String FILE_DIRECTORY = path.getParent()+ "/alumni_app/public/";

        File newDirectory = new File(FILE_DIRECTORY, type);

        if(!newDirectory.exists())
        {
            newDirectory.mkdir();
            String folder = id +"/";
            File newDirectory2 = new File(FILE_DIRECTORY+"/"+type+"/",folder );
            if(!newDirectory2.exists())
            {
                newDirectory2.mkdir();
            }
        }
        String fullPath = FILE_DIRECTORY+"/"+type+"/"+id+"/"+file.getOriginalFilename();
        File myFile = new File(fullPath);
        myFile.createNewFile();
        FileOutputStream fos =new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        return new ResponseEntity<Object>("/alumni_app/public/"+file.getOriginalFilename(), HttpStatus.OK);
    }
}
