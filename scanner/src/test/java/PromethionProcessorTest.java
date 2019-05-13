import ca.on.oicr.gsi.runscanner.dto.NotificationDto;
import ca.on.oicr.gsi.runscanner.dto.OxfordNanoporeNotificationDto;
import ca.on.oicr.gsi.runscanner.dto.type.Platform;
import ca.on.oicr.gsi.runscanner.scanner.processor.PromethionProcessor;
import ca.on.oicr.gsi.runscanner.scanner.processor.RunProcessor.Builder;
import java.io.File;
import java.io.IOException;
import java.util.TimeZone;

public class PromethionProcessorTest extends AbstractProcessorTest {
  private final PromethionProcessor instance =
      new PromethionProcessor(new Builder(Platform.OXFORDNANOPORE, "promethion", null), "unittest");

  public PromethionProcessorTest() {
    super(OxfordNanoporeNotificationDto.class);
  }

  @Override
  protected NotificationDto process(File directory) throws IOException {
    return instance.process(directory, TimeZone.getTimeZone("America/Toronto"));
  }

  @Override
  public void testGoldens() throws IOException {
    checkDirectory("/oxfordnanopore/promethion");
  }
}