package com.kh021j.travelwithpleasurehub.service;

import com.kh021j.travelwithpleasurehub.model.Property;
import com.kh021j.travelwithpleasurehub.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Service
public class PropertyPhotoService {

    @Autowired
    private PropertyRepository propertyRepository;

    public String savePhotos(MultipartFile[] files, Integer[] ids){
        int i = 0;
        String result = null;
        for(MultipartFile file : files) {
            save(file, ids[i]);
            i++;
        }
        result = "saved";
        return result;
    }

    public String save(MultipartFile file, Integer id) {
        String result = null;
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("src\\main\\resources\\file.properties"));
            String pathToStorage = props.getProperty("path_to_storage");
            byte[] bytes = file.getBytes();
            System.out.println(file.getOriginalFilename());
            Path path = Paths.get(pathToStorage + file.getOriginalFilename());
            Files.write(path, bytes);
            Property property = propertyRepository.findById(id).get();
            property.setPathToPhoto(path.toString());
            result = "saved";
        } catch (IOException e) {
            result = "error";
            e.printStackTrace();
        }
        return result;
    }

    public ResponseEntity<byte[][]> getPropertyPhotos(Integer[] ids) {
        Property[] properties = new Property[ids.length];
        Path[] paths = new Path[ids.length];
        byte[][] content = null;
        for (int i = 0; i < ids.length; i++) {
            content = new byte[ids.length][];
            Property property = propertyRepository.findById(ids[i]).orElse(null);
            if(property != null) {
                paths[i] = Paths.get(property.getPathToPhoto());
            }
            try {
                content[i] = Files.readAllBytes(paths[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("image/png"));
        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }

    public ResponseEntity<byte[]> getPropertyPhoto(Integer id) {
        Property property = propertyRepository.findById(id).orElse(null);
        Path path;
        if(property != null) {
            path = Paths.get(property.getPathToPhoto());
        } else return null;

        byte[] content = new byte[0];
        try {
            content = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("image/png"));
        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }
}
