package tech.juniorlima.clickbus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import tech.juniorlima.clickbus.controller.PlaceController;
import tech.juniorlima.clickbus.model.PlaceModel;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClickbusApplication.class})
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class ClickbusApplicationTests {

	@Autowired
	public PlaceController placeController;

	@Test
	public void contextLoads() { }

	@Test
	public void createPlace(){
		PlaceModel place = new PlaceModel();
		place.setName("Praia");
		place.setCity("Ubatuba");
		place.setState("SP");
		place.setSlug("The best place in the World");
		placeController.createPlace(place);
	}

	@Test
	public void getAllPlaces(){
		String size = String.valueOf(placeController.getAllPlaces().size());
		assertThat(size.equals("1"));
	}
}
