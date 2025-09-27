package com.striver.dsa.string;

import java.util.HashMap;
import java.util.Map;

public class RomanNumberConvertor {
    //        I             1
    //        V             5        IV - 4
    //        X             10       IX - 9
    //        L             50       XL - 40
    //        C             100      XC - 90
    //        D             500      CD - 400
    //        M             1000     CM - 900

    public static int romanToInt(String s) {

        int num = 0;

        Map<Character,Integer> charNumMapping = new HashMap<>();
        charNumMapping.put('I',1);
        charNumMapping.put('V',5);
        charNumMapping.put('X',10);
        charNumMapping.put('L',50);
        charNumMapping.put('C',100);
        charNumMapping.put('D',500);
        charNumMapping.put('M',1000);

        int n = s.length();

        for (int i =0;i<n;i++){
            char c = s.charAt(i);
            if(c == 'C'){
                if(i<n-1 && s.charAt(i+1)=='M'){
                    num += 900;
                    i++;
                    continue;
                }
                else if(i<n-1 && s.charAt(i+1) == 'D'){
                    num += 400;
                    i++;
                    continue;
                }
            }
            else if(c == 'X'){
                if(i<n-1 && s.charAt(i+1)=='C'){
                    num += 90;
                    i++;
                    continue;
                }
                else if(i<n-1 && s.charAt(i+1) == 'L'){
                    num += 40;
                    i++;
                    continue;
                }
            }
            else if(c == 'I'){
                if(i<n-1 && s.charAt(i+1)=='X'){
                    num += 9;
                    i++;
                    continue;
                }
                else if(i<n-1 && s.charAt(i+1) == 'V'){
                    num += 4;
                    i++;
                    continue;
                }
            }
            num += charNumMapping.get(c);

        }

        return num;
    }

    public static void main(String[] args) {
        String s = "MCMXCVII";
        int ans = romanToInt(s);
        System.out.println(ans);

    }
}
