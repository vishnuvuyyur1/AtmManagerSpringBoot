package codebase.ingatmmanager.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import codebase.ingatmmanager.model.Address;
import codebase.ingatmmanager.model.AtmDetailsForCity;
import codebase.ingatmmanager.model.GeoLocation;
import codebase.ingatmmanager.model.IngAtms;
import codebase.ingatmmanager.service.IngAtmManagerService;

@RunWith(MockitoJUnitRunner.class)
public class IngAtmManagerSvcControllerTest {

	@InjectMocks 
	private IngAtmManagerSvcController ignAtmManagerSvcController;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	IngAtmManagerService mockIngAtmManagerService;
	
	private RestTemplate restTemplateException;
	
	
	@Before
	public void setup(){
		
		restTemplateException = new RestTemplate(){
		
			@Override
			public <T> ResponseEntity<T> getForEntity(String url, 
					Class<T> responseType, Object... urlVariables) throws RestClientException{
		             throw new RestClientException(url);
			}
		};
		
	};
	
	@Test
	public void getIngAtmsListTest() throws Exception{
		List<IngAtms> ingAtmsList= new ArrayList<IngAtms>();
		ingAtmsList.add( new IngAtms(new Address("street1","h1","pc1","c1",new GeoLocation(1,2)),10,"chase"));
		ingAtmsList.add( new IngAtms(new Address("street2","h2","pc2","c2",new GeoLocation(3,4)),20,"ING"));
		ResponseEntity<String> response= new ResponseEntity<String>(constructJson(),HttpStatus.OK);
		when(restTemplate.getForEntity(Mockito.anyString(), eq(String.class))).thenReturn(response);
		when(mockIngAtmManagerService.getIngAtmsList(Mockito.anyString())).thenReturn(ingAtmsList);
		List<IngAtms> result=ignAtmManagerSvcController.getIngAtmsList();
		assertEquals(2,result.size());
		
	}
	
	@Test(expected = Exception.class)
	public void getIngAtmsListExceptionTest() throws Exception{
		ResponseEntity<String> response= new ResponseEntity<String>("",HttpStatus.OK);
		when(restTemplate.getForEntity(Mockito.anyString(), eq(String.class))).thenReturn(response);
		when(mockIngAtmManagerService.getIngAtmsList(Mockito.anyString())).thenThrow(new Exception());
		List<IngAtms> ingAtmsList=ignAtmManagerSvcController.getIngAtmsList();	
	}
	
	@Test(expected = Exception.class)
	public void getIngAtmsListRestClientExceptionTest() throws Exception{
		ReflectionTestUtils.setField(ignAtmManagerSvcController, "restTemplate", restTemplateException);
		ignAtmManagerSvcController.getIngAtmsList();
		
	}
	
	@Test
	public void createAtmDetailForCityTest() throws Exception{
		AtmDetailsForCity atmDetailsFromService= new AtmDetailsForCity();
		List<Address> addressList = new  ArrayList<Address>();
		addressList.add(new Address("street3","h3","pc3","c3",new GeoLocation(3,2)));
		addressList.add(new Address("street4","h4","pc4","c4",new GeoLocation(4,2)));
		addressList.add(new Address("street5","h5","pc5","c5",new GeoLocation(5,2)));
		atmDetailsFromService.setAddress(addressList);
		atmDetailsFromService.setCity("Dayton");
		when(mockIngAtmManagerService.createAtmDetailForCity(Mockito.any(AtmDetailsForCity.class))).thenReturn(atmDetailsFromService);
		AtmDetailsForCity atmDetailsForCityResult=ignAtmManagerSvcController.createAtmDetailForCity(new AtmDetailsForCity());
		assertEquals("Dayton",atmDetailsForCityResult.getCity());
		assertEquals(3,atmDetailsForCityResult.getAddress().size());
	}
	
	public String constructJson() throws JsonProcessingException{
		List<IngAtms> ingAtmsList= new ArrayList<IngAtms>();
		ingAtmsList.add( new IngAtms(new Address("street1","h1","pc1","c1",new GeoLocation(1,2)),10,"chase"));
		ingAtmsList.add( new IngAtms(new Address("street2","h2","pc2","c2",new GeoLocation(3,4)),20,"ING"));
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(ingAtmsList);
		
	}
}
