package codebase.ingatmmanager.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import codebase.ingatmmanager.model.AtmDetailsForCity;
import codebase.ingatmmanager.model.IngAtms;

@Service
public class IngAtmManagerServiceImpl implements IngAtmManagerService{
	
	private final Path rootLocation =Paths.get("uploads");

 
	@Override
	public List<IngAtms> getIngAtmsList(String json) throws Exception {
		
		try {
		int i = json.indexOf("{");
		json = json.substring(i);
		String validJson = "[" + json + "]";
		ObjectMapper mapper = new ObjectMapper();
		List<IngAtms> ingAtms = mapper.readValue(validJson,
				TypeFactory.defaultInstance().constructCollectionType(List.class, IngAtms.class));
		return ingAtms;
		} catch (IOException e) {
			throw new Exception("Error parsing Json: " +  e);
	 }
	}

	@Override
	public AtmDetailsForCity createAtmDetailForCity(AtmDetailsForCity atmDetailsForCity) {
		// can have call to SO/DAO/DB to process and store to database
		// I could include DB as well, you have to run ddl and create table and stuff so skipping
		//Simply returning the entered details back to confirm the enty is success
		return atmDetailsForCity;
	}

	@Override
	public void storeUploadedFile(MultipartFile file) {
		 String filename = StringUtils.cleanPath(file.getOriginalFilename());
	        try {
	            if (file.isEmpty()) {
	                throw new IngAtmManagerServiceException("Failed to store empty file " + filename);
	            }
	            if (filename.contains("..")) {
	                // This is a security check
	                throw new IngAtmManagerServiceException(
	                        "Cannot store file with relative path outside current directory "
	                                + filename);
	            }
	            Files.copy(file.getInputStream(), this.rootLocation.resolve(filename),
	                    StandardCopyOption.REPLACE_EXISTING);
	        }
	        catch (IOException e) {
	            throw new IngAtmManagerServiceException("Failed to store file " + filename, e);
	        }
		
	}

}
