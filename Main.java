

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String HTMLElements(String strParam) {
        List<String> openTags = List.of("<b>", "<i>", "<em>", "<div>", "<p>");
        List<String> closeTags = List.of("</b>", "</i>", "</em>", "</div>", "</p>");

        List<String> stack = new ArrayList<>();

        Pattern tagPattern = Pattern.compile("(<[^>]*>)");
        Matcher matcher = tagPattern.matcher(strParam);

        while (matcher.find()) {
            String tag = matcher.group();
            if (openTags.contains(tag)) {
                stack.add(tag);
            } else if (closeTags.contains(tag)) {
                int check = closeTags.indexOf(tag);
                if (!stack.isEmpty() && openTags.get(check).equals(stack.get(stack.size() - 1))) {
                    stack.remove(stack.size() - 1);
                }
            }
        }

        if (!stack.isEmpty()) {
            String lastTag = stack.get(stack.size() - 1);
            lastTag = lastTag.replace("<", "").replace(">", "");
            return lastTag;
        }

        return "True";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(HTMLElements(input));
    }
}