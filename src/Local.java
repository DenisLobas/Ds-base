public class Local {

    public static void main(String[] args) {

        double price = 10.5;
        double wallet = 100;
        int unit = 3;


        if (price * unit > wallet) {
            System.out.println("Не достаточно денег");
        } else if (price * unit < wallet || price * unit == wallet) {
            System.out.println("Товар успешно приобретен");
        }




    }
}
