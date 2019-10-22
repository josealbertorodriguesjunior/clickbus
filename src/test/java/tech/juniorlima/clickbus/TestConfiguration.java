package tech.juniorlima.clickbus;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import tech.juniorlima.clickbus.model.PlaceModel;

@org.springframework.boot.test.context.TestConfiguration
public class TestConfiguration {
  @Autowired
  private ObjectMapper mapper;

  @Bean
  public PlaceModel mockedPlace() throws IOException {
    String place = TestUtils.loadFileJson("payload.json");
    return mapper.readValue(place, PlaceModel.class);
  }
}
