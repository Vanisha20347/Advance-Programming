import java.util.*;

public class A4_question2 {
    static Scanner scn = new Scanner(System.in);
    public static int g = 0;

    static ArrayList<Grey> greyimage = new ArrayList<>();

    public static class Grey {
        private int Image_Id = g++;
        private int[][] Matrix;
        private int row;
        private int columns;
        private int[][] negative;

        Grey(int[][] k, int m, int n) {
            row = m;
            columns = n;
            negative = new int[row][columns];
            Matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Matrix[i][j] = k[i][j];
                    negative[i][j] = 255 - k[i][j];
                }
            }

        }

        public int get_Image_Id() {
            return Image_Id;
        }

        public int get_rows() {
            return row;
        }

        public int get_columns() {
            return columns;
        }

        public int[][] get_matrix() {
            return Matrix;
        }

        public int[][] get_negative() {
            return negative;
        }
    }

    static ArrayList<RGB> RGBimage = new ArrayList<>();

    public static class RGB {
        private int Image_Id = g++;
        private int row;
        private int columns;
        private int[][] MatrixR;
        private int[][] MatrixG;
        private int[][] MatrixB;
        private int[][] negativeR;
        private int[][] negativeG;
        private int[][] negativeB;

        RGB(int[][] r, int[][] g, int[][] b, int m, int n) {
            row = m;
            columns = n;
            MatrixR = new int[row][columns];
            MatrixG = new int[row][columns];
            MatrixB = new int[row][columns];
            negativeR = new int[row][columns];
            negativeG = new int[row][columns];
            negativeB = new int[row][columns];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    MatrixR[i][j] = r[i][j];
                    MatrixG[i][j] = g[i][j];
                    MatrixB[i][j] = b[i][j];
                    negativeR[i][j] = 255 - r[i][j];
                    negativeG[i][j] = 255 - g[i][j];
                    negativeB[i][j] = 255 - b[i][j];
                }
            }

        }

        public int get_Image_Id() {
            return Image_Id;
        }

        public int get_rows() {
            return row;
        }

        public int get_columns() {
            return columns;
        }

        public int[][] get_matrixR() {
            return MatrixR;
        }

        public int[][] get_negativeR() {
            return negativeR;
        }

        public int[][] get_matrixG() {
            return MatrixG;
        }

        public int[][] get_negativeG() {
            return negativeG;
        }

        public int[][] get_matrixB() {
            return MatrixB;
        }

        public int[][] get_negativeB() {
            return negativeB;
        }
    }

    public static void Input_Image() {
        System.out.println("Input Image");
        System.out.println("1. Greyscale Image \n2. RGB Image");
        System.out.print("Enter Choice:- ");
        int n = scn.nextInt();
        if (n == 1) {
            // GreyScale Image
            System.out.println("GreyScale Image ");
            System.out.print("Enter the no of rows:- ");
            int r = scn.nextInt();
            System.out.print("Enter the no of column:- ");
            int c = scn.nextInt();
            int[][] mat = new int[r][c];
            for (int i = 0; i < r; i++) {
                System.out.println("Enter element of row " + (i + 1));
                for (int j = 0; j < c; j++) {
                    System.out.println("Column " + (j + 1));
                    System.out.print("Enter element:- ");
                    mat[i][j] = scn.nextInt();
                }
            }
            Grey g = new Grey(mat, r, c);
            System.out.println("Image Created With ID " + g.get_Image_Id());
            greyimage.add(g);
        } else if (n == 2) {
            // RGB Image
            System.out.println("RGB Image ");
            System.out.print("Enter the no of rows:- ");
            int r = scn.nextInt();
            System.out.print("Enter the no of column:- ");
            int c = scn.nextInt();
            int[][] matR = new int[r][c];
            int[][] matG = new int[r][c];
            int[][] matB = new int[r][c];
            for (int i = 0; i < r; i++) {
                System.out.println("Enter element of row " + (i + 1));
                for (int j = 0; j < c; j++) {
                    System.out.println("Column " + (j + 1));
                    System.out.print("Enter R value of the pixel:- ");
                    matR[i][j] = scn.nextInt();
                    System.out.print("Enter G value of the pixel:- ");
                    matG[i][j] = scn.nextInt();
                    System.out.print("Enter B value of the pixel:- ");
                    matB[i][j] = scn.nextInt();
                }
            }
            RGB g = new RGB(matR, matG, matB, r, c);
            System.out.println("Image Created With ID " + g.get_Image_Id());
            RGBimage.add(g);
        } else {
            System.out.println("Invalid Number !!");
        }
    }

    public static void Display_Image() {
        System.out.print("Enter the Image ID of the Image you want to display:- ");
        int h = scn.nextInt();
        for (int i = 0; i < greyimage.size(); i++) {
            if (greyimage.get(i).get_Image_Id() == h) {
                System.out.println("Image :- ");
                for (int y = 0; y < greyimage.get(i).get_rows(); y++) {
                    for (int z = 0; z < greyimage.get(i).get_columns(); z++) {
                        System.out.print(greyimage.get(i).get_matrix()[y][z] + " ");
                    }
                    System.out.println();
                }
                return;
            }
        }
        for (int i = 0; i < RGBimage.size(); i++) {
            if (RGBimage.get(i).get_Image_Id() == h) {
                System.out.println("Image :- ");
                System.out.println("Red Matrix ");
                for (int y = 0; y < RGBimage.get(i).get_rows(); y++) {
                    for (int z = 0; z < RGBimage.get(i).get_columns(); z++) {
                        System.out.print(RGBimage.get(i).get_matrixR()[y][z] + " ");
                    }
                    System.out.println();
                }
                System.out.println("Green Matrix ");
                for (int y = 0; y < RGBimage.get(i).get_rows(); y++) {
                    for (int z = 0; z < RGBimage.get(i).get_columns(); z++) {
                        System.out.print(RGBimage.get(i).get_matrixG()[y][z] + " ");
                    }
                    System.out.println();
                }
                System.out.println("Blue Matrix ");
                for (int y = 0; y < RGBimage.get(i).get_rows(); y++) {
                    for (int z = 0; z < RGBimage.get(i).get_columns(); z++) {
                        System.out.print(RGBimage.get(i).get_matrixB()[y][z] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void Negative_Image() {
        System.out.print("Enter the Image ID ");
        int h = scn.nextInt();
        for (int i = 0; i < greyimage.size(); i++) {
            if (greyimage.get(i).get_Image_Id() == h) {
                System.out.println("Image :- ");
                for (int y = 0; y < greyimage.get(i).get_rows(); y++) {
                    for (int z = 0; z < greyimage.get(i).get_columns(); z++) {
                        System.out.print(greyimage.get(i).get_negative()[y][z] + " ");
                    }
                    System.out.println();
                }
                return;
            }
        }
        for (int i = 0; i < RGBimage.size(); i++) {
            if (RGBimage.get(i).get_Image_Id() == h) {
                System.out.println("Image :- ");
                System.out.println("Red Matrix ");
                for (int y = 0; y < RGBimage.get(i).get_rows(); y++) {
                    for (int z = 0; z < RGBimage.get(i).get_columns(); z++) {
                        System.out.print(RGBimage.get(i).get_negativeR()[y][z] + " ");
                    }
                    System.out.println();
                }
                System.out.println("Green Matrix ");
                for (int y = 0; y < RGBimage.get(i).get_rows(); y++) {
                    for (int z = 0; z < RGBimage.get(i).get_columns(); z++) {
                        System.out.print(RGBimage.get(i).get_negativeG()[y][z] + " ");
                    }
                    System.out.println();
                }
                System.out.println("Blue Matrix ");
                for (int y = 0; y < RGBimage.get(i).get_rows(); y++) {
                    for (int z = 0; z < RGBimage.get(i).get_columns(); z++) {
                        System.out.print(RGBimage.get(i).get_negativeB()[y][z] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void Update_Image() {
        System.out.print("Enter the Image No:- ");
        int j = scn.nextInt();
        for (int i = 0; i < greyimage.size(); i++) {
            if (greyimage.get(i).get_Image_Id() == j) {
                System.out.println("Image :- ");
                for (int y = 0; y < greyimage.get(i).get_rows(); y++) {
                    for (int z = 0; z < greyimage.get(i).get_columns(); z++) {
                        System.out.print(greyimage.get(i).get_matrix()[y][z] + " ");
                    }
                    System.out.println();
                }
                int m = 0;
                while (m == 0) {
                    System.out.println("1. Update element\n2. Exit");
                    int k = scn.nextInt();
                    if (k == 1) {
                        System.out.print("Enter the row no:- ");
                        int xy = scn.nextInt();
                        System.out.print("Enter the column no:- ");
                        int yz = scn.nextInt();
                        System.out.print("Enter the new value that you want to update:- ");
                        greyimage.get(i).get_matrix()[xy-1][yz-1] = scn.nextInt();
                        greyimage.get(i).get_negative()[xy-1][yz-1] = 255 - greyimage.get(i).get_matrix()[xy-1][yz-1] ;
                        System.out.println("Image Updated");
                    } else if (k == 2) {
                        m = 7;
                    } else {
                        System.out.println("Invalid Number");
                    }
                }
                return;
            }
        }

        for (int i = 0; i < RGBimage.size(); i++) {
            if (RGBimage.get(i).get_Image_Id() == j) {
                System.out.println("Red Matrix :- ");
                for (int y = 0; y < RGBimage.get(i).get_rows(); y++) {
                    for (int z = 0; z < RGBimage.get(i).get_columns(); z++) {
                        System.out.print(RGBimage.get(i).get_matrixR()[y][z] + " ");
                    }
                    System.out.println();
                }
                System.out.println("Green Matrix :- ");
                for (int y = 0; y < RGBimage.get(i).get_rows(); y++) {
                    for (int z = 0; z < RGBimage.get(i).get_columns(); z++) {
                        System.out.print(RGBimage.get(i).get_matrixG()[y][z] + " ");
                    }
                    System.out.println();
                }
                System.out.println("Blue Matrix :- ");
                for (int y = 0; y < RGBimage.get(i).get_rows(); y++) {
                    for (int z = 0; z < RGBimage.get(i).get_columns(); z++) {
                        System.out.print(RGBimage.get(i).get_matrixB()[y][z] + " ");
                    }
                    System.out.println();
                }
                int m = 0;
                while (m == 0) {
                    System.out.println("1. Update element\n2. Exit");
                    int k = scn.nextInt();
                    if (k == 1) {
                        System.out.println("1. Update Red Matrix \n2. Update Green Matrix\n3. Update Blue Matrix");
                        int f = scn.nextInt();
                        if (f == 1) {
                            System.out.print("Enter the row no:- ");
                            int xy = scn.nextInt();
                            System.out.print("Enter the column no:- ");
                            int yz = scn.nextInt();
                            System.out.print("Enter the new value that you want to update:- ");
                            RGBimage.get(i).get_matrixR()[xy-1][yz-1] = scn.nextInt();
                            RGBimage.get(i).get_negativeR()[xy-1][yz-1] = 255 - RGBimage.get(i).get_matrixR()[xy-1][yz-1] ;
                            System.out.println("Image Updated");
                        } else if (f == 2) {
                            System.out.print("Enter the row no:- ");
                            int xy = scn.nextInt();
                            System.out.print("Enter the column no:- ");
                            int yz = scn.nextInt();
                            System.out.print("Enter the new value that you want to update:- ");
                            RGBimage.get(i).get_matrixG()[xy-1][yz-1] = scn.nextInt();
                            RGBimage.get(i).get_negativeG()[xy-1][yz-1] = 255 - RGBimage.get(i).get_matrixG()[xy-1][yz-1] ;
                            System.out.println("Image Updated");

                        } else if (f == 3) {
                            System.out.print("Enter the row no:- ");
                            int xy = scn.nextInt();
                            System.out.print("Enter the column no:- ");
                            int yz = scn.nextInt();
                            System.out.print("Enter the new value that you want to update:- ");
                            RGBimage.get(i).get_matrixB()[xy-1][yz-1] = scn.nextInt();
                            RGBimage.get(i).get_negativeB()[xy-1][yz-1] = 255 - RGBimage.get(i).get_matrixB()[xy-1][yz-1] ;
                            System.out.println("Image Updated");
                        }
                    } else if (k == 2) {
                        m = 7;
                    } else {
                        System.out.println("Invalid Number");
                    }
                }
            }
        }
    }

    public static void Create_Image() {
        System.out.println("Create Image ");
        System.out.println("1. Greyscale Image \n2. RGB Image");
        System.out.print("Enter Choice:- ");
        int n = scn.nextInt();
        if (n == 1) {
            System.out.print("Enter the no of rows:- ");
            int r = scn.nextInt();
            System.out.print("Enter the no of column:- ");
            int c = scn.nextInt();
            int[][] mat = new int[r][c];
            Grey g = new Grey(mat, r, c);
            System.out.println("Image Created With ID " + g.get_Image_Id());
            greyimage.add(g);

        } else if (n == 2) {
            System.out.print("Enter the no of rows:- ");
            int r = scn.nextInt();
            System.out.print("Enter the no of column:- ");
            int c = scn.nextInt();
            int[][] mat = new int[r][c];
            RGB g = new RGB(mat, mat, mat, r, c);
            System.out.println("Image Created With ID " + g.get_Image_Id());
            RGBimage.add(g);
        }
    }

    public static void main(String[] args) {
        System.out.println("MENU");
        int p = 0;
        while (p == 0) {
            System.out.println();
            System.out.println(
                    "1. Create Image \n2. Input Image\n3. Update Image \n4. Display Image\n5. Negative Image\n6. Exit");
            System.out.print("Enter your choice:- ");
            int u = scn.nextInt();
            switch (u) {
                case 1:
                    Create_Image();
                    break;
                case 2:
                    Input_Image();
                    break;
                case 3:
                    Update_Image();
                    break;
                case 4:
                    Display_Image();
                    break;
                case 5:
                    Negative_Image();
                    break;
                case 6:
                    p = 1;
                    break;
                default:
                    System.out.println("Invalid Choice!!");
                    break;
            }
        }
    }

}
