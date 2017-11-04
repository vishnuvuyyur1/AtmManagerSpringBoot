package codebase.ingatmmanager.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class IngAtmManagerAppControllerTest {

	@InjectMocks 
	IngAtmManagerAppController mockIgnAtmManagerAppController;
	
	@Test
	public void homePageTest(){
		Model model= new ExtendedModelMap();
		String result=mockIgnAtmManagerAppController.homePage(model);
		assertEquals(true,model.containsAttribute("message"));
		//assertEquals("IngAtmManagerHomePage",result);
	}
}
