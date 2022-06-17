package helper;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/*
 * Siphiwe Edson Chauque -219084777
 * Application Development Practice 3
 * Due Date: 18 June 2022
 * ***Name*** entity
 */

@UtilityClass
@Slf4j
public class GenericHelper {

    public static boolean isEmpty(String str) {
        return !StringUtils.hasText(str);
    }

    public static String setEmptyIfNull(String str) {
        return isEmpty(str) ? "" : str;
    }

    public static void checkStringParam(String paramName, String paramValue) throws IllegalArgumentException {
        if (isEmpty(paramValue)) {
            String error = String.format("Invalid value for param: %s", paramName);
            log.error("{}", error);
            throw new IllegalArgumentException(error);
        }
    }
}