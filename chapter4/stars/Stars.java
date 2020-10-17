package chapter4.stars;

public class Stars {
    public static void main(String[] args){
        final int MAX_ROWS = 10;
        for(int row = MAX_ROWS; row >= 1; row--){
            for(int star=1; star <= row; star++){
                System.out.print("*");
                // a star prints out as long as its less than per row
                // so as row goes up, more stars print out
            }
            System.out.println();
                // go to the next line.
        }  
    }
}
