package i18n;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LocalizationServiceImplLocaleTest {
    @ParameterizedTest
    @ArgumentsSource(LocalizationServiceImplLocaleTestArgumentProvider.class)
    public void locale_test(Country country, String expected){
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();

        assertThat(localizationService.locale(country), equalTo(expected));
    }
}
