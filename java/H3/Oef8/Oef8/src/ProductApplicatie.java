import java.util.Scanner;

import domein.*;
public class ProductApplicatie {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Product p1 = new Product("Pannenkoek", 0.125, 21, 5);
        Product p2 = new Product("Pannenkoek met suiker", 2, 6, 10);
        Product p3 = new Product("Pannenkoek", 2.2, 6, 15);
        double sum = 0;

        sum += p1.berekenPrijs(vraag(p1.getNaam()));
        sum += p2.berekenPrijs(vraag(p2.getNaam()));
        sum += p3.berekenPrijs(vraag(p3.getNaam()));

        System.out.printf("Aan de kassa zal u %.2f EURO moeten betalen", sum);

    }

    static int vraag(String product){
        System.out.printf("Hoeveel stuk wilt u van \'%s\'? ",product);
        return sc.nextInt();
    }
}
