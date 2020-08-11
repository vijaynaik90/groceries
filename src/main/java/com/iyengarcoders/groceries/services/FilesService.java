package com.iyengarcoders.groceries.services;

import com.iyengarcoders.groceries.entity.Files;
import com.iyengarcoders.groceries.entity.Product;
import com.iyengarcoders.groceries.exceptions.FileStorageException;
import com.iyengarcoders.groceries.repositories.FileRepository;
import com.iyengarcoders.groceries.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class FilesService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private ProductRepository productRepository;

    public Files storeFile(MultipartFile file, UUID productId, boolean isDefault) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Files dbFile = new Files(fileName, file.getContentType(), isDefault, file.getBytes());
            Optional<Product> optionalProduct = productRepository.findById(productId);
            if(!optionalProduct.isPresent()) {
                System.out.println("Error Product not Present:" + productId);
            }
//            product.getImages().add(dbFile);
            dbFile.setProduct(optionalProduct.get());

            return fileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Files getFile(UUID fileId) {
        return fileRepository.findById(fileId)
                .orElseThrow(() -> new IllegalArgumentException("File not found with id " + fileId));
    }


}
