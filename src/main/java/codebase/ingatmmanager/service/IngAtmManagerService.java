package codebase.ingatmmanager.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import codebase.ingatmmanager.model.AtmDetailsForCity;
import codebase.ingatmmanager.model.IngAtms;

public interface IngAtmManagerService {

	public List<IngAtms> getIngAtmsList(String jason)throws Exception;
	public AtmDetailsForCity createAtmDetailForCity(AtmDetailsForCity atmDetailsForCity);
	public void storeUploadedFile(MultipartFile file);
}
