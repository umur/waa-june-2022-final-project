package alumnimanagement.entity;

import org.springframework.beans.factory.annotation.Value;

public class FileUpload {

    @Value("${file.upload-dir}")
    public String FILE_DIRECTORY;
}
