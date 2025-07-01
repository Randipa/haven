package com.example.PostApet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileStorageService {
    private final Path rootLocation;

    @Autowired
    public FileStorageService(@Value("${file.upload-dir}") String uploadDir) {
        this.rootLocation = Paths.get(uploadDir);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage location", e);
        }
    }

    public String store(MultipartFile file, String subDirectory) {
        try {
            if (file.isEmpty()) throw new RuntimeException("Empty file");

            String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filename = "profile" + extension; // Consistent filename

            Path userDir = this.rootLocation.resolve(subDirectory);
            Files.createDirectories(userDir);

            // Delete existing profile image if exists
            Files.list(userDir)
                    .filter(path -> path.getFileName().toString().startsWith("profile"))
                    .forEach(path -> {
                        try { Files.delete(path); }
                        catch (IOException e) { /* Log warning */ }
                    });

            Path destinationFile = userDir.resolve(filename);
            Files.copy(file.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);

            return "/uploads/" + subDirectory + "/" + filename;
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    public void delete(String filePath) {
        try {
            if (filePath != null && !filePath.isEmpty()) {
                Path fileToDelete = rootLocation.resolve(filePath.replace("/uploads/", ""));
                Files.deleteIfExists(fileToDelete);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete file", e);
        }
    }
}