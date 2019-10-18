package tech.juniorlima.clickbus;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import tech.juniorlima.clickbus.controller.PlaceController;
import tech.juniorlima.clickbus.model.PlaceModel;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ClickbusApplication.class})
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@ContextConfiguration(classes = TestConfiguration.class)
public class ClickbusApplicationTests {

	@Autowired
	private PlaceController placeController;

	@Autowired
	private PlaceModel place;

	@Test
	public void contextLoads() { }

	@Test
	public void createPlace(){
		placeController.createPlace(place);
	}

	@Test
	public void getAllPlaces(){
		String size = String.valueOf(placeController.getAllPlaces().size());
		assertThat(size.equals("1"));
	}

	@Test
	public void getPlaceName() {
		List<PlaceModel> places = placeController.getPlacesFilteredByName("Ubatuba");
		assertThat(places.get(0).getName().equals("Ubatuba"));
	}
}
