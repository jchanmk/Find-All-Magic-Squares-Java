public class findMagicSquare {
    public static void main (String [] args){
        int n = 3;
        int [][]magicsquare = new int [n][n]; // (n^2)! possible squares
        int [] compare = new int [n+1];
        int [] values = new int [n*n];
        int factorial = 1;
        int [] array = new int[n];
        boolean cont = true;
        boolean magic;
        int foundMagicSquares = 0;
        int pointer1, pointer2, p;
        int count = 0;

        for(int i = 0; i < (n*n); i++){
            values[i] = i+1;                // 1 ... n^2
        }

        for(int i = 1; i < (n*n)+1; i++){
            factorial *= i;
        }

        while(count < factorial-1) {
            //////  PERMUTATION //////

            pointer1 = (n * n) - 1;
            pointer2 = (n * n) - 1;
            p = (n * n) - 1;
            magic = true;
            count++;

            while (cont) {    //first pointer
                if (values[pointer1] > values[p - 1]) {
                    pointer1 = p - 1;
                    cont = false;
                }
                else {
                    pointer1--;
                    p--;
                }
            }
            cont = true;

            while (cont) {    //second pointer
                if (values[pointer2] > values[pointer1]) {
                    int temp;
                    temp = values[pointer1];
                    values[pointer1] = values[pointer2];
                    values[pointer2] = temp;
                    cont = false;
                } else
                    pointer2--;
            }

            if (pointer1 < (n * n) - 2 || pointer2 < (n * n) - 2) {
                if (pointer1 < pointer2) {
                    int add = 0;


                    for (int k = pointer1 + 1; k < values.length - 1; k++) {// reverse numbers after pointer 1
                        for (int i = pointer1 + 2; i < values.length - add; i++) {
                            int tempVariable = values[i];
                            values[i] = values[i - 1];
                            values[i - 1] = tempVariable;
                        }

                        add++;
                    }
                } else {
                    for (int k = pointer2; k < values.length - 1; k++) { // reverse numbers after pointer 1
                        for (int i = pointer2 + 1; i < values.length - (k - pointer2); i++) {
                            int tempVariable = array[i];
                            values[i] = values[i - 1];
                            values[i - 1] = tempVariable;
                        }
                    }
                }
            }

            System.out.println();
            cont = true;
//////////////////

            int numbers = 0;
            for (int i = 0; i < n; i++) {       // Initialize permutations into a square
                for (int j = 0; j < n; j++) {
                    magicsquare[i][j] = values[numbers];
                    numbers++;
                }
            }
//            for (int i = 0; i < n; i++) {     // print out magic squares
//                for (int j = 0; j < n; j++) {
//                    System.out.print(magicsquare[i][j]);
//                }
//            }

                /////// Check if it is a magic square /////////
            for(int i = 0; i < n; i++){
                compare[i] = 0;
            }

            for(int i = 0; i < n; i++) {
                compare[0] += magicsquare[0][i];
            }

            for(int i = 0; i < n; i++){       // columns
                for(int j = 0; j < n; j++){
                    compare[i+1] += magicsquare[j][i];
                }
                if(compare[0] != compare[i+1]){
                    //System.out.println("Not a Magic Square");
                    magic = false;
                }
            }

            for(int i = 0; i < n; i++){
                compare[i+1] = 0;
            }

            if(magic) {
                for (int i = 1; i < n; i++) {       // rows
                    for (int j = 0; j < n; j++) {
                        compare[i + 1] += magicsquare[i][j];
                    }
                    if (compare[0] != compare[i + 1]) {
                        //System.out.println("Not a Magic Square");
                        magic = false;
                    }
                }
            }

            for(int i = 0; i < n; i++){
                compare[i+1] = 0;
            }

            if(magic) {
                    for (int j = 0; j < n; j++) {     // diagonal 1
                        compare[1] += magicsquare[j][j];
                    }
                    if (compare[0] != compare[1]) {
                        //System.out.println("Not a Magic Square");
                        magic = false;
                    }
                }

                int h = 2;

                if(magic){
                    for(int j = 0; j < n; j++){       // diagonal 2
                        compare[2] += magicsquare[j][h];
                        h--;
                    }
                    if (compare[0] != compare[2]) {
                        //System.out.println("Not a Magic Square");
                        magic = false;
                    }
                }

            if(magic) {
               // System.out.println(" This is a magic square");
                foundMagicSquares++;
                // break; // Include the break for question 2e (finding exactly 1 magic square)
                          // If want to find all magic squares (question 2g) comment out the break
            }
        }
        System.out.println("Number of magic squares found = " + foundMagicSquares);
    }
}

