package com.example.streams;

/**
 * Example Output:
 * <pre>
 * 1) [Apple, Banana, Orange, Peach, Pear, Tomato]
 * 2) [Banana, Orange, Peach, Pear, Tomato]
 * 3) [Apple, Banana]
 * 4) Apple, Banana, Orange, Peach, Pear, Tomato
 * 5) [Tomato, Potato, Pea, Corn, Carrot]
 * 6) [TOMATO, POTATO, PEA, CORN, CARROT]
 * 7) [1000, 1000, 999, 999, 995, 995, 994, 993, 991, 990] *
 * 8) [1000, 999, 995, 994, 993, 991, 990, 989, 987, 986] *
 * 9) [999, 995, 993, 991, 989, 987, 985, 983, 981, 979] *
 * 10) 498.461 *
 *
 *     * These values will be different every run
 * </pre>
 */
public class RowRowRowYourBoat {

    public static void main(String[] args) {

        GentlyDownTheStream stream = new GentlyDownTheStream();

        System.out.println("1) " + stream.sortedFruits());
        System.out.println("2) " + stream.sortedFruitsException());
        System.out.println("3) " + stream.sortedFruitsFirstTwo());
        System.out.println("4) " + stream.commaSeparatedListOfFruits());
        System.out.println("5) " + stream.reverseSortedVeggies());
        System.out.println("6) " + stream.reverseSortedVeggiesInUpperCase());
        System.out.println("7) " + stream.topTen());
        System.out.println("8) " + stream.topTenUnique());
        System.out.println("9) " + stream.topTenUniqueOdd());
        System.out.println("10) " + stream.average());
    }
}
