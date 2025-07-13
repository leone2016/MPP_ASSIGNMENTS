package final_exam;
/*
What code change is needed to make the method compile?

public static T identity(T t) {
	return t;
}
A. Add <T> after the public keyword.
B. Add <T> after the static keyword.
C. Add <T> after T.
D. Add <?> after the public keyword.
E. Add <?> after the static keyword.
F. No change required. The code already compiles.

 */
public class _17_wild_card_question {

    /*
B. Add <T> after the static keyword.

     */

    public static <T> T identity(T t) {

        return t;
    }
}
