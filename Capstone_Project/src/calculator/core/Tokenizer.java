package calculator.core;

import java.util.*;
import java.util.regex.*;

public class Tokenizer {

    public static List<String> tokenize(String expr) {  //The Tokenizer performs lexical analysis by converting the input expression into a list of tokens such as numbers, operators, functions, and variables using regular expressions.
        Matcher m = Pattern.compile(
            "\\d+(\\.\\d+)?|[a-zA-Z]+|[+\\-*/^()]"
        ).matcher(expr.replaceAll("\\s+", ""));

        List<String> tokens = new ArrayList<>();
        while (m.find()) tokens.add(m.group());  //Breaks the tokens then returns the matched tokens
        return tokens;
    }
}