class StringConverter {

    String convertStringToBinary(String s) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            returnString.append(Integer.toBinaryString(s.charAt(i))).append(" ");
        return returnString.toString();
    }

    String convertStringToDecimal(String s) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            returnString.append((int) (s.charAt(i))).append(" ");

        return returnString.toString();
    }

    String convertStringToHexadecimal(String s) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            returnString.append(Integer.toHexString(s.charAt(i))).append(" ");

        return returnString.toString();
    }

    String convertStringToOctal(String s) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            returnString.append(Integer.toOctalString(s.charAt(i))).append(" ");

        return returnString.toString();
    }

    String convertInputFormatToString(String s, int radix) {
        StringBuilder returnString = new StringBuilder();
        StringBuilder holder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) != 32) {
                holder.append(s.charAt(i));
            } else {
                int charCode = Integer.parseInt(holder.toString(), radix);
                returnString.append(((char) charCode));
                holder.delete(0, holder.length());
            }
        }
        return returnString.toString();
    }

}