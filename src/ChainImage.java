/**
 * Created by Andrew on 5/5/2018.
 */
public class ChainImage {
    public static void main(String[] args) {
        //Sets up image arrays
        int [][] imageOne = {{0,1,0,0,0,0,0,0},{0,1,0,0,0,1,0,0},{0,1,1,1,0,0,1,0},
                {0,0,0,1,1,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0}};

        int [][] imageTwo = {{0,0,0,0,0,0,0,0},{0,1,1,1,1,0,1,0},{0,0,0,0,1,0,1,0},
                {0,0,1,1,1,0,1,0},{0,0,1,0,0,0,1,0},{0,0,1,0,0,0,1,0},{0,0,0,0,0,0,1,1},
                {0,0,0,0,0,0,0,0}};
        int [][] imageOneTempOne = imageOne;
        int [][] imageOneTempTwo = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0}} ;
        int [][] imageOneTempThree = imageOne;
        int [][] imageTwoTempOne = imageTwo;
        int [][] imageTwoTempTwo = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0}} ;
        int[][] imageTwoTempThree = imageTwo;
        int imageOneSizeOne;
        int imageOneSizeTwo;
        int a = 0;
        int b = 0;

        //image
        System.out.println("This is the image");

        print(imageOne);

        //Separates Image into to arrays
        for(int i = 0; i < imageOneTempOne.length; i++)
        {
            for(int k = 0; k < imageOneTempOne.length; k++)
            {
                imageOneTempTwo[i][k] = imageOneTempOne[i][k];
                if (imageOneTempOne[i][k] == 1) {
                    imageOneTempThree[i][k] = 0;
                    if(imageOneTempOne[i][k+1] == 0) {
                        k = imageOneTempOne.length;
                    }
                }

            }

        }

        System.out.println();

        //Gets size of lines
        imageOneSizeOne = checkSize(imageOneTempTwo);
        imageOneSizeTwo = checkSize(imageOneTempThree);

        //Gets the results for the first line
        int [] imageOneResultOne = new int [imageOneSizeOne - 1];

        for(int i = 0; i < imageOneTempOne.length; i++)
        {
            for(int k = 0; k < imageOneTempOne.length; k++)
            {
                if (imageOneTempTwo[i][k] == 1) {
                    if (a < imageOneSizeOne-1) {
                        imageOneResultOne[a] = checkDirection(imageOneTempTwo, i, k);

                    }
                    a += 1;

                }

            }

        }

        System.out.println();

        //Prints result for first line
        System.out.println("Result: ");
        for (int j = 0; j < imageOneResultOne.length; j++) {
            if (j == imageOneResultOne.length-1) {
                System.out.print(imageOneResultOne[j]);
            } else {
                System.out.print(imageOneResultOne[j] + ", ");
            }
        }

        //Gets the results for second line
        int [] imageOneResultTwo = new int [imageOneSizeTwo - 1];

        for(int i = 0; i < imageOneTempThree.length; i++)
        {
            for(int k = 0; k < imageOneTempThree.length; k++)
            {
                if (imageOneTempThree[i][k] == 1) {
                    if (b < imageOneSizeTwo-1) {
                        imageOneResultTwo[b] = checkDirection(imageOneTempThree, i, k);
                    }
                    b += 1;

                }

            }

        }

        System.out.println();

        //Prints result for second line
        for (int m = 0; m < imageOneResultTwo.length; m++) {
            if (m == imageOneResultTwo.length-1) {
                System.out.print(imageOneResultTwo[m]);
            } else {
                System.out.print(imageOneResultTwo[m]+ ", ");
            }
        }


        for(int i = 0; i < imageTwoTempOne.length; i++)
        {
            for(int k = 0; k < imageTwoTempOne.length; k++)
            {
                //tempThree[i][k] = 0;
                imageTwoTempTwo[i][k] = imageTwoTempOne[i][k];
                if (imageTwoTempOne[i][k] == 1) {
                    imageTwoTempThree[i][k] = 0;
                    //tempOne[i][k] = 0;
                    if(k+1 < imageTwoTempOne.length) {
                        if (imageTwoTempOne[i][k + 1] == 0) {
                            k = imageTwoTempOne.length;
                        }
                    }
                }

            }

        }

        //print(imageTwoTempTwo);
        //print(imageTwoTempThree);

    }

    //Prints image
    public static void print(int[][] array)
    {
        for(int i = 0; i < array.length; i++) // print function for the array using incrementors
        {
            System.out.print("\n");

            for(int k = 0; k < array.length; k++)
            {
                System.out.print(array[i][k] + "    ");
            }
        }
        System.out.println();
    }

    //Gets size of image
    public static int checkSize(int[][] array) {
        int size = 0;
        for(int i = 0; i < array.length; i++) {
            for(int k = 0; k < array.length; k++) {
                if (array[i][k] == 1){
                    size += 1;
                }
            }
        }
        return size;
    }

    //Gets direction
    public static int checkDirection(int[][] array, int a, int b) {
        int x1;
        int x2 = -1;
        int y1;
        int y2 = -1;
        int result = 0;
        for(int i = a; i < array.length; i++) {
            for(int k = b; k < array.length; k++) {
                if (array[i][k] == 1) {
                    x1 = i;
                    y1 = k;
                    if (x2 >= 0 || y2 >= 0) {
                        if(x1 > x2 && y1 == y2) {
                            return 6;
                        } else if (x1 == x2 && y1 > y2 ) {
                            return 0;
                        } else if (x1 > x2 && y1 > y2) {
                            return 7;
                        }

                    } else {
                        x2 = x1;
                        y2 = y1;
                    }
                }
            }
        }
        return result;
    }



}