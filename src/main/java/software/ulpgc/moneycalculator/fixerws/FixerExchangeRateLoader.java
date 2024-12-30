package software.ulpgc.moneycalculator.fixerws;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.moneycalculator.io.ExchangeRateLoader;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.model.ExchangeRate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class FixerExchangeRateLoader implements ExchangeRateLoader {
    private final Map<String, Double> rates = new HashMap<>();

    @Override
    public ExchangeRate load(Currency to) {
        try {
            load(loadJson());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ExchangeRate(to, rates.get(to.code()));
    }

    private void load(String json) {
        this.rates.clear();
        Map<String, JsonElement> jsonRates = new Gson().fromJson(json, JsonObject.class).get("rates").getAsJsonObject().asMap();
        for (String rate : jsonRates.keySet())
            this.rates.put(rate, jsonRates.get(rate).getAsDouble());
    }

    private String loadJson() throws IOException {
        URL url = new URL("http://data.fixer.io/api/latest?access_key=" + FixerAPI.key);
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes());
        }
    }
}
