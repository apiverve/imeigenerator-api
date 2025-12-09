// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     IMEIGeneratorData data = Converter.fromJsonString(jsonString);

package com.apiverve.imeigenerator.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static IMEIGeneratorData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(IMEIGeneratorData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(IMEIGeneratorData.class);
        writer = mapper.writerFor(IMEIGeneratorData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// IMEIGeneratorData.java

package com.apiverve.imeigenerator.data;

import com.fasterxml.jackson.annotation.*;

public class IMEIGeneratorData {
    private long count;
    private String brand;
    private Imei[] imeis;

    @JsonProperty("count")
    public long getCount() { return count; }
    @JsonProperty("count")
    public void setCount(long value) { this.count = value; }

    @JsonProperty("brand")
    public String getBrand() { return brand; }
    @JsonProperty("brand")
    public void setBrand(String value) { this.brand = value; }

    @JsonProperty("imeis")
    public Imei[] getImeis() { return imeis; }
    @JsonProperty("imeis")
    public void setImeis(Imei[] value) { this.imeis = value; }
}

// Imei.java

package com.apiverve.imeigenerator.data;

import com.fasterxml.jackson.annotation.*;

public class Imei {
    private String imei;
    private String tac;
    private String manufacturer;
    private String model;
    private String serial;
    private String checksum;
    private boolean isValid;

    @JsonProperty("imei")
    public String getImei() { return imei; }
    @JsonProperty("imei")
    public void setImei(String value) { this.imei = value; }

    @JsonProperty("tac")
    public String getTac() { return tac; }
    @JsonProperty("tac")
    public void setTac(String value) { this.tac = value; }

    @JsonProperty("manufacturer")
    public String getManufacturer() { return manufacturer; }
    @JsonProperty("manufacturer")
    public void setManufacturer(String value) { this.manufacturer = value; }

    @JsonProperty("model")
    public String getModel() { return model; }
    @JsonProperty("model")
    public void setModel(String value) { this.model = value; }

    @JsonProperty("serial")
    public String getSerial() { return serial; }
    @JsonProperty("serial")
    public void setSerial(String value) { this.serial = value; }

    @JsonProperty("checksum")
    public String getChecksum() { return checksum; }
    @JsonProperty("checksum")
    public void setChecksum(String value) { this.checksum = value; }

    @JsonProperty("isValid")
    public boolean getIsValid() { return isValid; }
    @JsonProperty("isValid")
    public void setIsValid(boolean value) { this.isValid = value; }
}