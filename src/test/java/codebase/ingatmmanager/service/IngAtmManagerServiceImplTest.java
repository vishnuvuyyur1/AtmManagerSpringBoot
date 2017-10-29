package codebase.ingatmmanager.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import codebase.ingatmmanager.model.Address;
import codebase.ingatmmanager.model.AtmDetailsForCity;
import codebase.ingatmmanager.model.GeoLocation;
import codebase.ingatmmanager.model.IngAtms;

@RunWith(MockitoJUnitRunner.class)
public class IngAtmManagerServiceImplTest {

	@InjectMocks 
	private IngAtmManagerServiceImpl ingAtmManagerServiceImpl;
	
	@Test
	public void createAtmDetailForCityTest() throws Exception{
		AtmDetailsForCity atmDetailsForCity= new AtmDetailsForCity();
		List<Address> addressList = new  ArrayList<Address>();
		addressList.add(new Address("street3","h3","pc3","c3",new GeoLocation(3,2)));
		addressList.add(new Address("street4","h4","pc4","c4",new GeoLocation(4,2)));
		addressList.add(new Address("street5","h5","pc5","c5",new GeoLocation(5,2)));
		atmDetailsForCity.setAddress(addressList);
		atmDetailsForCity.setCity("Dayton");
		AtmDetailsForCity atmDetailsForCityResult=ingAtmManagerServiceImpl.createAtmDetailForCity(atmDetailsForCity);
		assertEquals("Dayton",atmDetailsForCityResult.getCity());
		assertEquals(3,atmDetailsForCityResult.getAddress().size());
	}
	
	@Test
	public void getIngAtmsListTest() throws Exception{
		List<IngAtms> ingAtmsList=ingAtmManagerServiceImpl.getIngAtmsList(constructJson());
		assertEquals(2,ingAtmsList.size());	
	}
	
	@Test(expected = Exception.class)
	public void getIngAtmsListExceptionTest() throws Exception{
		List<IngAtms> ingAtmsList=ingAtmManagerServiceImpl.getIngAtmsList("{kk[hello//]");	
	}
	
	public String constructJson() throws JsonProcessingException{
		List<IngAtms> ingAtmsList= new ArrayList<IngAtms>();
		ingAtmsList.add( new IngAtms(new Address("street1","h1","pc1","c1",new GeoLocation(1,2)),10,"chase"));
		ingAtmsList.add( new IngAtms(new Address("street2","h2","pc2","c2",new GeoLocation(3,4)),20,"ING"));
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(ingAtmsList);
		
	}
	
}
