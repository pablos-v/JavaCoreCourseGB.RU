public class Main {

    public static String caesarCrypto(String st, boolean decode, int shift) {
        if (decode) shift = -shift;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            ch = (char) (ch + shift);
            res.append(ch);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String s = "Privet";
        String coded = caesarCrypto(s, false, 3);
        String decoded = caesarCrypto(coded, true, 3);
        System.out.println(coded);
        System.out.println(decoded);

    }
}