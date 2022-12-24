package geo;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;


public class GeoServiceImplByIpTestArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext)  {
        return Stream.of(
                Arguments.of(new Location("Moscow", Country.RUSSIA, "Lenina", 15),
                        "172.0.32.11"),
                Arguments.of(new Location(null, null, null, 0),"" +
                        "127.0.0.1"),
                Arguments.of(new Location("New York", Country.USA, " 10th Avenue", 32),
                        "96.44.183.149"),
                Arguments.of(new Location("Moscow", Country.RUSSIA, null, 0),
                        "172."),
                Arguments.of(new Location("New York", Country.USA, null,  0), "96.")
                );
    }
}
