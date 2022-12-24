package geo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

public class GeoServiceImplTest {
    @ParameterizedTest
    @ArgumentsSource(GeoServiceImplByIpTestArgumentsProvider.class)
    public void byIp_test(Location expected, String ip) {
        GeoServiceImpl geoService = new GeoServiceImpl();


       assertThat(expected, samePropertyValuesAs(geoService.byIp(ip)));
    }
}
