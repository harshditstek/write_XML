package org.example.record;

public class NumToWords {
    public static String changeNumberToString(String phrase){
        Float num = new Float( phrase ) ;
        long n = Long.valueOf((int)Math.floor( num ) );
        String first = numberToWords(n);
        int cent = (int)Math.floor( ( num - n ) * 100.0f ) ;
        String second = numberToWords(cent);
        return first+"Dollars "+second+"Cents";
    }
    public static String numberToWords(long n) {
        long limit = 1000000000000L, curr_hun, t = 0;

        if (n == 0)
            return ("Zero");

        String multiplier[] = { "", "Trillion", "Billion",
                "Million", "Thousand" };

        String first_twenty[] = {
                "",        "one",       "two",      "three",
                "four",    "five",      "six",      "seven",
                "eight",   "nine",      "ten",      "eleven",
                "twelve",  "thirteen",  "Fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen"
        };

        String tens[] = { "",        "twenty", "thirty",
                "forty",   "fifty",  "sixty",
                "seventy", "eighty", "ninety" };

        if (n < 20L)
            return (first_twenty[(int)n]);
        String answer = "";
        for (long i = n; i > 0; i %= limit, limit /= 1000) {

            curr_hun = i / limit;

            while (curr_hun == 0) {
                i %= limit;
                limit /= 1000;
                curr_hun = i / limit;
                ++t;
            }

            if (curr_hun > 99)
                answer += (first_twenty[(int)curr_hun / 100]
                        + " hundred ");

            curr_hun = curr_hun % 100;

            if (curr_hun > 0 && curr_hun < 20)
                answer
                        += (first_twenty[(int)curr_hun] + " ");

            else if (curr_hun % 10 == 0 && curr_hun != 0)
                answer
                        += (tens[(int)curr_hun / 10 - 1] + " ");

            else if (curr_hun > 20 && curr_hun < 100)
                answer
                        += (tens[(int)curr_hun / 10 - 1] + " "
                        + first_twenty[(int)curr_hun % 10]
                        + " ");

            if (t < 4)
                answer += (multiplier[(int)++t] + " ");
        }
        return (answer);
    }

}
