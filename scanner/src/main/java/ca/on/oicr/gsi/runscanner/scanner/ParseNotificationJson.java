package ca.on.oicr.gsi.runscanner.scanner;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ca.on.oicr.gsi.runscanner.dto.NotificationDto;
import ca.on.oicr.gsi.runscanner.scanner.processor.RunProcessor;

/**
 * Parses a notification DTO stored in a file and outputs it to the console, for debugging purposes.
 *
 */
public class ParseNotificationJson {

  public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
    ObjectMapper mapper = RunProcessor.createObjectMapper();

    List<NotificationDto> dtos = Arrays.stream(args).map(File::new).map(f -> {
      try {
        return mapper.readValue(f, NotificationDto.class);
      } catch (IOException e) {
        e.printStackTrace();
        return null;
      }
    }).filter(Objects::nonNull).collect(Collectors.toList());
    mapper.writeValue(System.out, dtos);
  }

}