package codebase.ingatmmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import codebase.ingatmmanager.model.AtmDetailsForCity;
import codebase.ingatmmanager.model.IngAtms;
import codebase.ingatmmanager.service.IngAtmManagerService;

/**
 * @author Vishnu
 *
 */

@RestController
public class IngAtmManagerSvcController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	IngAtmManagerService ingAtmManagerService;

	private static final String EXTERNAL_SERVICE_LINK = "https://www.ing.nl/api/locator/atms/";

	@PostMapping(value = "/api/createAtmDetailForCity")
	public AtmDetailsForCity createAtmDetailForCity(@RequestBody AtmDetailsForCity atmDetailsForCity) {
		return ingAtmManagerService.createAtmDetailForCity(atmDetailsForCity);
	}

	@GetMapping("/api/getAllAtmDetails")
	public List<IngAtms> getIngAtmsList() throws Exception {

		try {
			ResponseEntity<String> response = restTemplate.getForEntity(EXTERNAL_SERVICE_LINK, String.class);
			return ingAtmManagerService.getIngAtmsList(response.getBody());
		} catch (RestClientException e) {
			throw new Exception("Error Communicating with the servce: " + e);
		}

	}

}
