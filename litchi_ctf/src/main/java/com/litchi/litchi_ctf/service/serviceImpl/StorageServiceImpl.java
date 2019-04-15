package com.litchi.litchi_ctf.service.serviceImpl;

import com.litchi.litchi_ctf.service.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service(value = "StorageService")
public class StorageServiceImpl implements StorageService{
    @Value("${litchi.file-location}")
    private static String fileLocation="./";
    // 文件保存的路径
    private final Path rootLocation = Paths.get(fileLocation);

    @Override
    public void init() {
        // 初始化目录, 保证目录存在
        try {
            if (!Files.exists(rootLocation)) {
                Files.createDirectory(rootLocation);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage", e);
        }
    }

    @Override
    public void store(MultipartFile file) {

        // 将文件保存到目录中
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file" + file.getOriginalFilename());
            }
            String dstFile = file.getOriginalFilename();
            Files.copy(file.getInputStream(), this.rootLocation.resolve(dstFile));
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file" + file.getOriginalFilename(), e);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        // 遍历目录下的文件
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read stored files", e);
        }
    }

    @Override
    public Path load(String filename) {
        // 读取指定文件的路径
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        // 读取指定路径的内容
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read file:" + filename);

            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file:" + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        // 删除目录
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

}
