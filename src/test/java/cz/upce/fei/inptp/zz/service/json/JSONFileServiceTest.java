package cz.upce.fei.inptp.zz.service.json;

import cz.upce.fei.inptp.zz.entity.Password;
import cz.upce.fei.inptp.zz.exception.JsonConversionException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JSONFileServiceTest {

    private JSONService jsonService = new JSONFileService();
    private String exampleJsonFormat;
    private List<Password> examplePasswordsList;

    @Before
    public void setUp() {
        exampleJsonFormat = "[" +
                "{\"id\":0,\"password\":\"sdfghjkl\",\"parameters\":null,\"category\":null}," +
                "{\"id\":1,\"password\":\"ASDSAFafasdasdasdas\",\"parameters\":null,\"category\":null}," +
                "{\"id\":2,\"password\":\"aaa-aaaa-\",\"parameters\":null,\"category\":null}" +
                "]";

        examplePasswordsList = new ArrayList<>();
        examplePasswordsList.add(new Password.PasswordBuilder()
                .setId(0)
                .setPassword("sdfghjkl")
                .createPassword());
        examplePasswordsList.add(new Password.PasswordBuilder()
                .setId(1)
                .setPassword("ASDSAFafasdasdasdas")
                .createPassword());
        examplePasswordsList.add(new Password.PasswordBuilder()
                .setId(2)
                .setPassword("aaa-aaaa-")
                .createPassword());
    }

    @Test
    public void toJson() throws JsonConversionException {
        String converted = jsonService.toJson(examplePasswordsList);
        Assert.assertEquals(exampleJsonFormat, converted);
    }

    @Test
    public void fromJson() throws JsonConversionException {
        List<Password> convertedPasswords = jsonService.fromJson(exampleJsonFormat);
        Assert.assertEquals(examplePasswordsList, convertedPasswords);
    }
}
