package chapter3.icecream;

public class IceCream {
    enum Flavor {
        VANILLA, CHOCOLATE, STRAWBERRY, FUDGERIPPLE, COFFEE, ROCKYROAD, MINTCHOCOLATECHIP, COOKIEDOUGH
    }

    public static void main(String[] args) {
        Flavor cone1, cone2, cone3;

        cone1 = Flavor.ROCKYROAD;
        cone2 = Flavor.CHOCOLATE;

        System.out.println("cone1 value: " + cone1);
        System.out.println("cone1 ordinal: " + cone1.ordinal());
        System.out.println("cone1 name: " + cone1.name());

        System.out.println();
        System.out.println("cone2 value: " + cone2);
        System.out.println("cone2 ordinal: " + cone2.ordinal());
        System.out.println("cone2 name: " + cone2.name());

        cone3 = cone1;

        System.out.println();
        System.out.println("cone3 value: " + cone3);
        System.out.println("cone3 ordinal: " + cone3.ordinal());
        System.out.println("cone3 name: " + cone3.name());
    }
}
