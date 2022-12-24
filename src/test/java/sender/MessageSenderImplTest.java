package sender;

import org.apache.tika.language.LanguageIdentifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplTest {

    @ParameterizedTest
    @ArgumentsSource(MessageSenderImplRussianTextTestArgumentProvider.class)
    public void send_russian_text_test(String ip,Location location) {
        String expected = "ru";


        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        Mockito.when(localizationService.locale(Country.BRAZIL)).thenReturn("Welcome");
        Mockito.when(localizationService.locale(Country.GERMANY)).thenReturn("Welcome");

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);


        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);



        LanguageIdentifier language = new LanguageIdentifier(messageSender.send(headers));
        String result = language.getLanguage();

        Assertions.assertEquals(expected, result);
    }
    @ParameterizedTest
    @ArgumentsSource(MessageSenderImplEnglishTextTestArgumentProvider.class)
    public void send_english_text_test(String ip,Location location) {
        String expected = "en";


        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("����� ����������");
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        Mockito.when(localizationService.locale(Country.BRAZIL)).thenReturn("Welcome");
        Mockito.when(localizationService.locale(Country.GERMANY)).thenReturn("Welcome");

        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp(ip)).thenReturn(location);


        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, ip);



        LanguageIdentifier language = new LanguageIdentifier(messageSender.send(headers));
        String result = language.getLanguage();

        Assertions.assertEquals(expected, result);
    }


}
