package tech.juniorlima.clickbus;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import java.io.IOException;
import java.net.URL;

public class TestUtils {
  public static String loadFileJson(String fileName) {
    URL url = Resources.getResource(fileName);
    String text = null;
    try {
      text = Resources.toString(url, Charsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    return text;
  }
}
