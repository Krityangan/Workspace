package com.customer.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import com.customer.datamodel.ImageFile;
import com.customer.exception.MyFileNotFoundException;
import com.customer.repository.ImageFileRepository;

@Service
public class ImageFileService {

	@Autowired
	private ImageFileRepository imageRepo;
	
	public ImageFile storeFile(MultipartFile file)
	{
		// Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try
        {
        	if(fileName.contains(".."))
        	{
        		throw new IOException("Sorry! Filename contains invalid path sequence " + fileName);
        	}
        	ImageFile imageFile=new ImageFile();
//        	imageFile.setFileName(fileName);
//        	imageFile.setData(file.getBytes());
//        	imageFile.setFileType(file.getContentType());
        	
        	return imageRepo.save(imageFile);
        }
        catch(IOException ex)
        {
       
        	ex.printStackTrace();
        }
		return null;
	}
	
	 public Object getFile(Long fileId) {
		 
	        return imageRepo.findById(fileId);
	    }
}
