package get_request;

public class Url01 {
    public static void main(String[] args) {

        /*Given two temperatures, return true if one is less than 0 and the other is greater than 100.
        icyHot(120, -1) → true
        icyHot(-1, 120) → true
        icyHot(2, 120) → false
        */



        System.out.println(icyHot(-2,200));

    }
    public static boolean icyHot(int a1, int b2){
        if (a1<0 && b2>100 || a1<0 && b2>100){
            return true;
        }
        else {
            return false;
        }
    }
}
