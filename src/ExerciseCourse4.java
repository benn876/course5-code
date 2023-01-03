public class ExerciseCourse4 {
    public static void main(String[] args) {
        String[] names = {"Maria Clara Popescu", "George Mihailescu", "Ion Luca Caragiale"};
        for (String name : names) {
            System.out.println(abreviate(name));
        }
    }

    private static String abreviate(String input) {
        String[] splitArray = input.split("\\s+");
        if (splitArray.length != 3) {
            return input;
        }

        for (int i = 0; i < splitArray.length; i++) {
            if (i == 1) {
                splitArray[i] = splitArray[i].charAt(0) + ".";
            }
        }

        return String.join(" ", splitArray);
    }
}
