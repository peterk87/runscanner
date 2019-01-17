package ca.on.oicr.gsi.runscanner.rs.dto.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import ca.on.oicr.gsi.runscanner.dto.IlluminaNotificationDto;
import ca.on.oicr.gsi.runscanner.dto.NotificationDto;
import ca.on.oicr.gsi.runscanner.dto.type.HealthType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDateTime;
import org.junit.Test;

public class IlluminaNotificationDtoTest {

  @Test
  public void testPartiallyPopulatedIlluminaNotificationRoundTrip() throws Exception {
    IlluminaNotificationDto notificationDto = new IlluminaNotificationDto();
    notificationDto.setSequencerName("Coffee");
    notificationDto.setCompletionDate(LocalDateTime.of(2017, 2, 23, 0, 0));
    notificationDto.setHealthType(HealthType.RUNNING);

    ObjectMapper mapper = new ObjectMapper();
    mapper
        .registerModule(new JavaTimeModule())
        .setDateFormat(new ISO8601DateFormat())
        .enable(SerializationFeature.INDENT_OUTPUT);
    String serialized = mapper.writeValueAsString(notificationDto);

    NotificationDto deSerialized = mapper.readValue(serialized, NotificationDto.class);
    assertThat("Round trip of", notificationDto, is(deSerialized));
  }

  @Test
  public void testFullyPopulatedIlluminaNotificationRoundTrip() throws Exception {
    IlluminaNotificationDto notificationDto = fullyPopulatedIlluminaNotificationDto("RUN_B");
    ObjectMapper mapper = new ObjectMapper();
    mapper
        .registerModule(new JavaTimeModule())
        .setDateFormat(new ISO8601DateFormat())
        .enable(SerializationFeature.INDENT_OUTPUT);
    String serialized = mapper.writeValueAsString(notificationDto);

    NotificationDto deSerialized = mapper.readValue(serialized, NotificationDto.class);
    assertThat("Round trip of", notificationDto, is(deSerialized));
  }

  static IlluminaNotificationDto fullyPopulatedIlluminaNotificationDto(String sequencerName) {
    IlluminaNotificationDto notificationDto = new IlluminaNotificationDto();
    notificationDto.setRunAlias("TEST_RUN_NAME");
    notificationDto.setSequencerFolderPath("/sequencers/TEST_RUN_FOLDER");
    notificationDto.setContainerSerialNumber("CONTAINER_ID");
    notificationDto.setSequencerName(sequencerName);
    notificationDto.setLaneCount(8);
    notificationDto.setHealthType(HealthType.RUNNING);
    notificationDto.setStartDate(LocalDateTime.of(2017, 2, 23, 0, 0));
    notificationDto.setCompletionDate(LocalDateTime.of(2017, 2, 27, 0, 0));
    notificationDto.setPairedEndRun(true);
    notificationDto.setSoftware("Fido Opus SEAdog Standard Interface Layer");
    notificationDto.setRunBasesMask("y151,I8,y151");
    notificationDto.setNumCycles(20);
    notificationDto.setImgCycle(19);
    notificationDto.setScoreCycle(18);
    notificationDto.setCallCycle(17);
    return notificationDto;
  }
}
