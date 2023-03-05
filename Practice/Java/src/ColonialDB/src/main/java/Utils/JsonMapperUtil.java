package Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonMapperUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonMapperUtil() throws IllegalAccessException {
        throw new IllegalAccessException("JsonMapperUtil can not be instantiated");
    }

    public static String objectToJson(final Object object) {
        try {
            return objectMapper
                    .writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Error occurred. Logging stacktrace...", e);
            throw new RuntimeException(e);
        }
    }

    public static <T> T jsonToObject(final String json, final Class<T> objectClass) {
        try {
            return objectMapper.readValue(json, objectClass);
        } catch (JsonProcessingException e) {
            log.error("Error occurred. Logging stacktrace...", e);
            throw new RuntimeException(e);
        }
    }
}
