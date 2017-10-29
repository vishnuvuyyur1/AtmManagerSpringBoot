package codebase.ingatmmanager.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import codebase.ingatmmanager.model.AtmDetailsForCity;
import codebase.ingatmmanager.model.IngAtms;

@Component
public class IngAtmManagerServiceImpl implements IngAtmManagerService{

	@Override
	public List<IngAtms> getIngAtmsList(String json) throws Exception {
		
		try {
		int i = json.indexOf("{");
		json = json.substring(i);
		String validJson = "[" + json + "]";
		ObjectMapper mapper = new ObjectMapper();
		List<IngAtms> ingAtms = mapper.readValue(validJson,
				TypeFactory.defaultInstance().constructCollectionType(List.class, IngAtms.class));
		HashSet st= new HashSet();
		ArrayList a= new ArrayList();
		a.equals("o");
		st.equals("o");
		st.add("s");
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

}
