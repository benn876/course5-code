import java.util.Arrays;

public class ConfidentialScript {
    public static void main(String[] args) {
        //1
        int count = countCharInString("testatre", 't');
        System.out.println(count);
        //2
        String redactedString = redact("string");
        System.out.println(redactedString);

        //3
        String[] arrayOfString = {"Ana", "are", "mere"};
        boolean isInArray = contains(arrayOfString, "caine");
        System.out.println(isInArray);

        //4
        String[] splitedString = splitString("Ana are mere Merele sunt multe");
        Arrays.stream(splitedString).forEach(System.out::println);
        for (String word : splitedString) {
            System.out.println(word);
        }
        //5
        String[] sensitiveWords = {"mere", "Ana"};
        System.out.println(confidential("Ana are mere multe mere bune", sensitiveWords));
    }

    private static String confidential(String phrase, String[] sensitiveWords) {
        if (phrase == null || phrase.length() == 0) {
            return phrase;
        }
        String[] words = splitString(phrase);
        for (int index = 0; index<words.length; index++) {
            if(contains(sensitiveWords,words[index])){
                words[index] = redact(words[index]);
            }
        }
        return String.join(" ",words);
    }

    private static String[] splitString(String input) {
        return input.split("\\s+");
    }

    private static boolean contains(String[] arrayOfString, String contained) {
        for (String word : arrayOfString) {
            if (word.equals(contained)) {
                return true;
            }
        }
        return false;
    }

    private static String redact(String stringToRedact) {
        return stringToRedact.replaceAll(".", "*");
    }

    private static int countCharInString(String entryString, char foundChar) {
        int count = 0;
        for (int index = 0; index < entryString.length(); index++) {
            if (entryString.charAt(index) == foundChar) {
                count++;
            }
        }
        return count;
    }

    private static long countCharInStringJava8(String entryString, char foundChar) {
        return entryString.chars().filter(letter -> letter == foundChar).count();
    }

    public static void showSomething() {
        System.out.println("Hello from the othre side");
    }
}
