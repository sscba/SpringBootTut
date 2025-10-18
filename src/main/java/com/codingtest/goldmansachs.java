package com.codingtest;

public class goldmansachs {
    // Complete the secureChannel function below.
    static String secureChannel(int operation, String message, String key) {
        if (operation != 1 && operation != 2) return "-1";
        if (message == null || message.isEmpty() || key == null || key.isEmpty()) return "-1";

        StringBuilder ans = new StringBuilder();
        int keyIndex = 0;
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (keyIndex < key.length()) {
                char keyChar = key.charAt(keyIndex);
                if (!Character.isDigit(keyChar)) return "-1";
                int repeat = keyChar - '0';
                if (operation == 1) {
                    for (int r = 0; r < repeat; r++) {
                        ans.append(ch);
                    }
                } else {
                    ans.append(ch);
                    i += repeat - 1;
                    if (i >= message.length()) return "-1";

                }
                keyIndex++;
            } else {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}
