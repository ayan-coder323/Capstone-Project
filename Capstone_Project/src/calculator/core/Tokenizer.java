package calculator.core;

import java.util.*;
import java.util.regex.*;

public class Tokenizer {

    public static List<String> tokenize(String expr) {
        Matcher m = Pattern.compile(
            "\\d+(\\.\\d+)?|[a-zA-Z]+|[+\\-*/^()]"
        ).matcher(expr.replaceAll("\\s+", ""));

        List<String> tokens = new ArrayList<>();
        while (m.find()) tokens.add(m.group());
        return tokens;
    }
}