import java.util.*;

abstract class common {
    abstract public int get_id();

    abstract public void set_id();

    abstract public String get_type();

    abstract public ArrayList<String> get_labels();

    abstract public void add_labels(String x);

    abstract public void set_size(int x, int y);

    abstract public int get_rows();

    abstract public int get_columns();

    abstract public float[][] get_values();

    public static ArrayList<common> matrix = new ArrayList<>();

    public static void add_matrix(common m) {
        matrix.add(m);
    }

    public static ArrayList<common> get_matrix() {
        return matrix;
    }
}

public class a {

    static public Scanner scn = new Scanner(System.in);

    public static int count = 0;

    public static class Rectangular_Matrix extends common {
        private int id;
        private String type = "Rectangular Matrix";
        private ArrayList<String> Labels = new ArrayList<>();
        private int rows;
        private int columns;
        private float[][] values;;

        @Override
        public int get_id() {
            return id;
        }

        @Override
        public void set_id() {
            id = count;
            count = count + 1;
        }

        @Override
        public String get_type() {
            return type;
        }

        @Override
        public void set_size(int x, int y) {
            this.rows = x;
            this.columns = y;

        }

        @Override
        public int get_rows() {
            return rows;
        }

        @Override
        public int get_columns() {
            return columns;
        }

        @Override
        public ArrayList<String> get_labels() {
            return Labels;
        }

        @Override
        public void add_labels(String x) {
            Labels.add(x);
        }

        public void set_values(float[][] x, int m, int n) {
            values = new float[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    values[i][j] = x[i][j];
                }
            }
        }

        public float[][] get_values() {
            return values;
        }

        Rectangular_Matrix() {
            set_id();
        }
    }

    public static class Row_Matrix extends Rectangular_Matrix {
        private String type = "Row Matrix";

        public String get_type() {
            return this.type;
        }

        Row_Matrix() {
            add_labels(type);
        }
    }

    public static class Column_Matrix extends Rectangular_Matrix {
        private String type = "Column Matrix";

        public String get_type() {
            return this.type;
        }

        Column_Matrix() {
            add_labels(type);
        }
    }

    public static class Square_Matrix extends Rectangular_Matrix {
        private String type = "Square Matrix";

        public String get_type() {
            return this.type;
        }

        Square_Matrix() {
            add_labels(type);
        }
    }

    public static class Symmetric_Matrix extends Square_Matrix {
        private String type = "Symmetric Matrix";

        public String get_type() {
            return this.type;
        }

        Symmetric_Matrix() {
            add_labels(type);
        }
    }

    public static class Skew_Symmetric_Matrix extends Square_Matrix {
        private String type = "Skew Symmetric Matrix";

        public String get_type() {
            return this.type;
        }

        Skew_Symmetric_Matrix() {
            add_labels(type);
        }
    }

    public static class Upper_Triangular_Matrix extends Square_Matrix {
        private String type = "Upper_Triangular Matrix";

        public String get_type() {
            return this.type;
        }

        Upper_Triangular_Matrix() {
            add_labels(type);
        }
    }

    public static class Lower_Triangular_Matrix extends Square_Matrix {
        private String type = "Lower Triangular Matrix";

        public String get_type() {
            return this.type;
        }

        Lower_Triangular_Matrix() {
            add_labels(type);
        }
    }

    public static class Singular_Matrix extends Square_Matrix {
        private String type = "Singular Matrix";

        public String get_type() {
            return this.type;
        }

        Singular_Matrix() {
            add_labels(type);
        }

    }

    public static class Diagonal_Matrix extends Square_Matrix {
        private String type = "Diagonal Matrix";

        public String get_type() {
            return this.type;
        }

        Diagonal_Matrix() {
            add_labels(type);
        }

    }

    public static class Scalar_Matrix extends Diagonal_Matrix {
        private String type = "Scalar Matrix";

        public String get_type() {
            return this.type;
        }

        Scalar_Matrix() {
            add_labels(type);
        }

    }

    public static class Identity_Matrix extends Scalar_Matrix {
        private String type = "Identity Matrix";

        public String get_type() {
            return this.type;
        }

        Identity_Matrix() {
            add_labels(type);
        }

    }

    public static class Singleton_Matrix extends Square_Matrix {
        private String type = "Singleton Matrix";

        public String get_type() {
            return this.type;
        }

        Singleton_Matrix() {
            add_labels(type);
        }
    }

    public static class Ones_Matrix extends Rectangular_Matrix {
        private String type = "Ones Matrix";

        public String get_type() {
            return this.type;
        }

        Ones_Matrix() {
            add_labels(type);
        }

    }

    public static class Null_Matrix extends Rectangular_Matrix {
        private String type = "Null Matrix";

        public String get_type() {
            return this.type;
        }

        Null_Matrix() {
            add_labels(type);
        }
    }

    public static void menu() {
        System.out.println(
                "Menu\n1. Create Matrix\n2. Create Matrix of requested type\n3. Change element of a matrix\n4. Display the matrix type of the matrix\n5. Perform operations like addition,subtraction,multiplication,divison\n6. Perform elementwise operations\n7. Transpose Matrix\n8. Inverse Matrix\n9. Computing means like row-wise mean, column-wise mean, mean of all the elements\n10. Compute determinants\n11. Use singleton matrices as scalars, if requested\n12. Compute A+AT for a matrix A\n13. Compute Eigen vectors and values\n14. Solve sets of linear equations using matrices\n15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels\n16. Exit   ");
    }

    public static void create_matrix() {
        System.out.println("Create Matrix ");
        System.out.println("Enter the no. of rows of the matrix");
        int rows = scn.nextInt();
        System.out.println("Enter no. of columns of the matrix");
        int columns = scn.nextInt();
        int count_of_zeroes = 0;
        int count_of_ones = 0;
        float[][] a = new float[rows][columns];
        System.out.println("Enter the elements of matrix");
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter element of row " + (i + 1));
            for (int j = 0; j < columns; j++) {
                a[i][j] = scn.nextFloat();
                if (a[i][j] == 0) {
                    count_of_zeroes++;
                }
                if (a[i][j] == 1) {
                    count_of_ones++;
                }
            }
        }
        int h = rows * columns;
        if (rows != columns) {
            // Rectangular,Row,Column, Null,Ones,

            if (h == count_of_zeroes) {
                // NULL MATRIX
                Null_Matrix n = new Null_Matrix();
                n.set_size(rows, columns);
                n.add_labels("Rectangular Matrix");
                if (rows == 1) {
                    n.add_labels("Row Matrix");
                }
                if (columns == 1) {
                    n.add_labels("Column Matrix");
                }
                common.add_matrix(n);
                System.out.println("Null Matrix Created with id " + n.get_id());
                return;
            }
            if (h == count_of_ones) {
                // ONES MATRIX
                Ones_Matrix o = new Ones_Matrix();
                o.set_size(rows, columns);
                o.add_labels("Rectangular Matrix");
                if (rows == 1) {
                    o.add_labels("Row Matrix");
                }
                if (columns == 1) {
                    o.add_labels("Column Matrix");
                }
                System.out.println("Ones Matrix Created with id" + o.get_id());
                common.add_matrix(o);
                return;
            }
            if (rows == 1) {
                // ROW MATRIX
                Row_Matrix r = new Row_Matrix();
                r.set_size(1, columns);
                r.add_labels("Rectangular Matrix");
                r.set_values(a, rows, columns);
                System.out.println("Row Matrix Created with id " + r.get_id());
                common.add_matrix(r);
                return;
            }
            if (columns == 1) {
                // COLUMN MATRIX
                Column_Matrix c = new Column_Matrix();
                c.set_size(rows, 1);
                c.add_labels("Rectangular Matrix");
                c.set_values(a, rows, columns);
                System.out.println("Column Matrix Created with id" + c.get_id());
                common.add_matrix(c);
                return;
            }
            // RECTANGULAR MATRIX
            Rectangular_Matrix r = new Rectangular_Matrix();
            r.set_size(rows, columns);
            r.add_labels("Rectangular Matrix");
            r.set_values(a, rows, columns);
            System.out.println("Rectangular Matrix Created with id" + r.get_id());
            common.add_matrix(r);
        } else {
            // Square,Symmetric Matrix,Skew-symmetric Matrix,Upper-triangular
            // Matrix,Lower-triangular Matrix,Singular Matrix,Diagonal Matrix,Scalar
            // Matrix,Identity Matrix,Singleton Matrix,Ones Matrix,Null Matrix
            if (rows == 1) {
                // Singleton Matrix
                Singleton_Matrix s = new Singleton_Matrix();
                s.add_labels("Square Matrix");
                s.add_labels("Symmetric Matrix");
                s.add_labels("Scalar Matrix");
                s.add_labels("Diagonal Matrix");
                if (count_of_zeroes == 1) {
                    s.add_labels("Null Matrix");
                    s.add_labels("Singular Matrix");
                    s.add_labels("Upper Triangular Matrix");
                    s.add_labels("Lower Triangular Matrix");
                }
                if (count_of_ones == 1) {
                    s.add_labels("Ones Matrix");
                    s.add_labels("Identity Matrix");
                }
                s.set_size(1, 1);
                s.set_values(a, rows, columns);
                System.out.println("Singleton Matrix Created with id " + s.get_id());
                common.add_matrix(s);
                return;
            }
            if (count_of_zeroes == h) {
                // NULL MATRIX
                Null_Matrix n = new Null_Matrix();
                n.set_size(rows, columns);
                n.add_labels("Square Matrix");
                n.add_labels("Singular Matrix");
                n.add_labels("Upper Triangular Matrix");
                n.add_labels("Lower Triangular Matrix");
                n.add_labels("Scalar Matrix");
                n.add_labels("Diagonal Matrix");
                n.add_labels("Symmetric Matrix");
                n.add_labels("Skew Symmetric Matrix");
                common.add_matrix(n);
                System.out.println("Null Matrix Created with id " + n.get_id());
                return;
            }
            if (count_of_ones == h) {
                // ONES MATRIX
                Ones_Matrix o = new Ones_Matrix();
                o.set_size(rows, columns);
                o.add_labels("Square Matrix");
                o.add_labels("Symmetric Matrix");
                o.add_labels("Singular Matrix");
                common.add_matrix(o);
                System.out.println("Ones Matrix Created witb id" + o.get_id());
                return;
            }
            if (rows == 2) {
                if (a[0][1] == a[1][0] && a[0][1] == 0) {
                    // Diagonal,Scalar,Identity
                    if (a[0][0] == a[1][1] && a[0][0] == 1) {
                        // Identity Matrix
                        Identity_Matrix i = new Identity_Matrix();
                        i.add_labels("Square Matrix");
                        i.add_labels("Diagonal Matrix");
                        i.add_labels("Scalar Matrix");
                        i.add_labels("Symmetric Matrix");
                        i.set_size(rows, rows);
                        common.add_matrix(i);
                        System.out.println("Identity Matrix Created with id" + i.get_id());
                        return;
                    }
                    if (a[0][0] == a[1][1]) {
                        // Scalar Matrix
                        Scalar_Matrix s = new Scalar_Matrix();
                        s.add_labels("Square Matrix");
                        s.add_labels("Diagonal Matrix");
                        s.add_labels("Symmetric Matrix");
                        s.set_size(rows, rows);
                        s.set_values(a, rows, rows);
                        ;
                        common.add_matrix(s);
                        System.out.println("Scalar Matrix Create with id" + s.get_id());
                        return;
                    }
                    // Diagonal Matrix
                    Diagonal_Matrix d = new Diagonal_Matrix();
                    d.add_labels("Square Matrix");
                    d.add_labels("Symmetric Matrix");
                    d.add_labels("Upper Triangular Matrix");
                    d.add_labels("Lower Triangular Matrix");
                    d.set_values(a, rows, columns);
                    float b = dettwo(a);
                    if (b == 0.0) {
                        d.add_labels("Singular Matrix");
                    }
                    d.set_size(rows, rows);
                    common.add_matrix(d);
                    System.out.println("Diagonal Matrix Created with id " + d.get_id());
                    return;
                }
                if (IsSymmetric(a, rows, columns)) {
                    Symmetric_Matrix s = new Symmetric_Matrix();
                    s.set_size(rows, rows);
                    s.add_labels("Square Matrix");
                    float b = dettwo(a);
                    if (b == 0.0) {
                        s.add_labels("Singular Matrix");
                    }
                    s.set_values(a, rows, columns);
                    common.add_matrix(s);
                    System.out.println("Symmetric Matrix Created with id" + s.get_id());
                    return;
                }
                if (IsSkewSymmetric(a, rows, columns)) {
                    Skew_Symmetric_Matrix s = new Skew_Symmetric_Matrix();
                    s.set_size(rows, rows);
                    s.add_labels("Square Matrix");
                    float b = dettwo(a);
                    if (b == 0.0) {
                        s.add_labels("Singular Matrix");
                    }
                    s.set_values(a, rows, columns);
                    common.add_matrix(s);
                    System.out.println("Skew Symmetric Matrix Created with id" + s.get_id());
                    return;
                }
            }
            if (rows == 3) {
                // Diagonal,Scalar,Identity
                if (IsIdentity(a)) {
                    // Identity Matrix
                    Identity_Matrix i = new Identity_Matrix();
                    i.add_labels("Square Matrix");
                    i.add_labels("Diagonal Matrix");
                    i.add_labels("Scalar Matrix");
                    i.add_labels("Symmetric Matrix");
                    i.set_size(rows, rows);
                    common.add_matrix(i);
                    System.out.println("Identity Matrix Created with id " + i.get_id());
                    return;
                }
                if (IsScalar(a)) {
                    // Scalar Matrix
                    Scalar_Matrix s = new Scalar_Matrix();
                    s.add_labels("Square Matrix");
                    s.add_labels("Diagonal Matrix");
                    s.add_labels("Symmetric Matrix");
                    s.set_size(rows, rows);
                    s.set_values(a, rows, rows);
                    ;
                    common.add_matrix(s);
                    System.out.println("Scalar Matrix Created with id" + s.get_id());
                    return;
                }
                // Diagonal Matrix
                if (IsDiagonal(a)) {
                    Diagonal_Matrix d = new Diagonal_Matrix();
                    d.add_labels("Square Matrix");
                    d.add_labels("Symmetric Matrix");
                    d.add_labels("Upper Triangular Matrix");
                    d.add_labels("Lower Triangular Matrix");
                    d.set_values(a, rows, columns);
                    float b = detthree(a);
                    if (b == 0.0) {
                        d.add_labels("Singular Matrix");
                    }
                    d.set_size(rows, rows);
                    common.add_matrix(d);
                    System.out.println("Diagonal Matrix Created with id" + d.get_id());
                    return;
                }
                if (IsSymmetric(a, rows, columns)) {
                    Symmetric_Matrix s = new Symmetric_Matrix();
                    s.set_size(rows, rows);
                    s.add_labels("Square Matrix");
                    float b = detthree(a);
                    if (b == 0.0) {
                        s.add_labels("Singular Matrix");
                    }
                    s.set_values(a, rows, columns);
                    common.add_matrix(s);
                    System.out.println("Symmetric Matrix Created with id" + s.get_id());
                    return;
                }
                if (IsSkewSymmetric(a, rows, columns)) {
                    Skew_Symmetric_Matrix s = new Skew_Symmetric_Matrix();
                    s.set_size(rows, rows);
                    s.add_labels("Square Matrix");
                    float b = detthree(a);
                    if (b == 0.0) {
                        s.add_labels("Singular Matrix");
                    }
                    s.set_values(a, rows, columns);
                    common.add_matrix(s);
                    System.out.println("Skew Symmetric Matrix Created with id " + s.get_id());
                    return;
                }
            }
            if (IsLowerTriangular(a, rows, columns)) {
                Lower_Triangular_Matrix l = new Lower_Triangular_Matrix();
                l.set_size(rows, rows);
                l.add_labels("Square Matrix");
                if (rows == 3) {
                    float b = detthree(a);
                    if (b == 0.0) {
                        l.add_labels("Singular Matrix");
                    }
                }
                if (rows == 2) {
                    float b = dettwo(a);
                    if (b == 0.0) {
                        l.add_labels("Singular Matrix");
                    }
                }
                l.set_values(a, rows, columns);
                System.out.println("Lower Triangular Matrix Created with id " + l.get_id());
                common.add_matrix(l);
                return;

            }
            if (IsUpperTriangular(a, rows, columns)) {
                Upper_Triangular_Matrix u = new Upper_Triangular_Matrix();
                u.set_size(rows, rows);
                u.add_labels("Square Matrix");
                if (rows == 3) {
                    float b = detthree(a);
                    if (b == 0.0) {
                        u.add_labels("Singular Matrix");
                    }
                }
                if (rows == 2) {
                    float b = dettwo(a);
                    if (b == 0.0) {
                        u.add_labels("Singular Matrix");
                    }
                }
                u.set_values(a, rows, columns);
                System.out.println("Upper Triangular Matrix Created with id" + u.get_id());
                common.add_matrix(u);
                return;

            }
            Square_Matrix s = new Square_Matrix();
            s.set_size(rows, rows);
            if (rows == 3) {
                float b = detthree(a);
                if (b == 0.0) {
                    s.add_labels("Singular Matrix");
                }
            }
            if (rows == 2) {
                float b = dettwo(a);
                if (b == 0.0) {
                    s.add_labels("Singular Matrix");
                }
            }
            s.set_values(a, rows, columns);
            System.out.println("Square Matrix Created with id" + s.get_id());
            common.add_matrix(s);
            return;
        }
    }

    public static boolean IsSymmetric(float[][] k, int r, int c) {
        float[][] b = new float[r][c];
        int jk = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                b[i][j] = k[j][i];
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (b[i][j] == k[i][j]) {
                    jk++;
                }
            }
        }
        int h = r * c;
        if (jk == h) {
            return true;
        }
        return false;
    }

    public static boolean IsSkewSymmetric(float[][] k, int r, int c) {
        float[][] b = new float[r][c];
        int jk = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                b[i][j] = k[j][i];
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (b[i][j] == -(k[i][j])) {
                    jk++;
                }
            }
        }
        int h = r * c;
        if (jk == h) {
            return true;
        }
        return false;
    }

    public static float dettwo(float[][] j) {
        float a = j[0][0] * j[1][1];
        float b = j[1][0] * j[0][1];
        float h = a - b;
        return h;
    }

    public static float detthree(float[][] j) {
        float a = j[0][0] * ((j[1][1] * j[2][2]) - (j[1][2] * j[2][1]));
        float b = -j[0][1] * ((j[1][0] * j[2][2]) - (j[1][2] * j[2][0]));
        float c = j[0][2] * ((j[1][0] * j[2][1]) - (j[1][1] * j[2][0]));
        float ans = a + b + c;
        return ans;
    }

    public static boolean IsIdentity(float[][] u) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    if (u[i][j] != 0) {
                        return false;
                    }
                }
                if (i == j) {
                    if (u[i][j] != 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean IsScalar(float[][] u) {
        float g = u[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    if (u[i][j] != 0) {
                        return false;
                    }
                }
                if (i == j) {
                    if (u[i][j] != g) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean IsDiagonal(float[][] u) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    if (u[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean IsUpperTriangular(float[][] u, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    if (u[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean IsLowerTriangular(float[][] u, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    if (u[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void Display_all_requested_type_labels() {
        System.out.println("Enter the id of the matrix");
        int n = scn.nextInt();
        ArrayList<common> y = common.get_matrix();
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                System.out.println("The Labels of The desired Matrix are :-");
                for (int j = 0; j < (y.get(i).get_labels()).size(); j++) {
                    System.out.println((y.get(i).get_labels()).get(j));
                }
            }
        }
    }

    public static float[][] Transpose(ArrayList<common> c, int h) {
        float[][] yt = new float[c.get(h).get_rows()][c.get(h).get_columns()];
        System.out.println("The Transpose Of The Matrix Is :-");
        if (c.get(h).get_type().equals("Ones Matrix") || c.get(h).get_type().equals("Null Matrix")) {
            for (int p = 0; p < c.get(h).get_rows(); p++) {
                for (int q = 0; q < c.get(h).get_columns(); q++) {
                    if (c.get(h).get_type().equals("Ones Matrix")) {
                        System.out.print("1 ");
                    }
                    if (c.get(h).get_type().equals("Null Matrix")) {
                        System.out.print("0 ");
                    }
                }
                System.out.println();
            }
            return yt;
        } else if (c.get(h).get_type().equals("Identity Matrix")) {
            if (c.get(h).get_rows() == 1) {
                System.out.println("1");
            }
            if (c.get(h).get_rows() == 2) {
                System.out.println("1 0\n0 1");
            }

            if (c.get(h).get_rows() == 3) {
                System.out.println("1 0 0\n0 1 0\n0 0 1");
            }
            return yt;
        }

        else if (c.get(h).get_type().equals("Row Matrix")) {
            float[][] v = c.get(h).get_values();
            for (int i = 0; i < c.get(h).get_columns(); i++) {
                System.out.println(v[0][i]);
            }
            return v;
        } else if (c.get(h).get_type().equals("Column Matrix")) {
            float[][] v = c.get(h).get_values();
            for (int i = 0; i < c.get(h).get_rows(); i++) {
                System.out.print(v[i][0] + " ");
            }
            System.out.println();
            return v;
        } else if (c.get(h).get_type().equals("Rectangular Matrix")) {
            float[][] v = c.get(h).get_values();
            for (int i = 0; i < c.get(h).get_columns(); i++) {
                for (int j = 0; j < c.get(h).get_rows(); j++) {
                    System.out.print(v[j][i] + " ");
                }
                System.out.println();
            }
            return v;
        } else {
            float[][] v = c.get(h).get_values();
            float[][] vt = new float[c.get(h).get_rows()][c.get(h).get_columns()];
            for (int p = 0; p < c.get(h).get_rows(); p++) {
                for (int q = 0; q < c.get(h).get_columns(); q++) {
                    System.out.print(v[q][p] + " ");
                    vt[p][q] = v[q][p];
                }
                System.out.println();
            }
            return vt;
        }
    }

    public static void Transpose_matrices() {
        System.out.println("Enter the id of the matrix you want to transpose");
        int n = scn.nextInt();
        ArrayList<common> y = common.get_matrix();
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                Transpose(y, i);
            }
        }
    }

    public static void create_matrix_of_specific_type() {
        System.out.println(
                "Various Types Of Matrix\n1. Rectangular Matrix\n2. Row Matrix\n3. Column Matrix\n4. Square Matrix\n5. Symmetric Matrix\n6. Skew-symmetric Matrix\n7. Upper-triangular Matrix\n8. Lower-triangular Matrix\n9. Singular Matrix\n10. Diagonal Matrix\n11. Scalar Matrix\n12. Identity Matrix\n13. Singleton Matrix\n14. Ones Matrix\n15. Null Matrix");
        System.out.println("Choice");
        int n = scn.nextInt();
        int y = 4;
        if (n == 1) {
            System.out.println("Creating Rectangular Matrix");
            System.out.println("Enter the no of rows");
            int r = scn.nextInt();
            System.out.println("Enter the no of column");
            int c = scn.nextInt();
            float[][] a = new float[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    a[i][j] = y++;
                }
            }
            Rectangular_Matrix re = new Rectangular_Matrix();
            re.set_size(r, c);
            re.add_labels("Rectangular Matrix");
            re.set_values(a, r, c);
            System.out.println("Rectangular Matrix Created with id " + re.get_id());
            common.add_matrix(re);
        }
        if (n == 2) {
            System.out.println("Creating Row Matrix");
            System.out.println("Enter the no of column");
            int c = scn.nextInt();
            float[][] a = new float[1][c];
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < c; j++) {
                    a[i][j] = y++;
                }
            }
            Row_Matrix r = new Row_Matrix();
            r.set_size(1, c);
            r.add_labels("Rectangular Matrix");
            r.set_values(a, 1, c);
            System.out.println("Row Matrix Created with id " + r.get_id());
            common.add_matrix(r);
            return;
        }
        if (n == 3) {
            System.out.println("Creating Column Matrix");
            System.out.println("Enter the no of rows");
            int r = scn.nextInt();
            float[][] a = new float[r][1];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < 1; j++) {
                    a[i][j] = y++;
                }
            }
            Column_Matrix c = new Column_Matrix();
            c.set_size(r, 1);
            c.add_labels("Rectangular Matrix");
            c.set_values(a, r, 1);
            System.out.println("Column Matrix Created with id " + c.get_id());
            common.add_matrix(c);
            return;
        }
        if (n == 4) {
            System.out.println("Creating Square Matrix");
            System.out.println("Enter the no of rows");
            int r = scn.nextInt();
            float[][] a = new float[r][r];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < r; j++) {
                    a[i][j] = y++;
                }
            }
            Square_Matrix s = new Square_Matrix();
            s.set_size(r, r);
            if (r == 3) {
                float b = detthree(a);
                if (b == 0.0) {
                    s.add_labels("Singular Matrix");
                }
            }
            if (r == 2) {
                float b = dettwo(a);
                if (b == 0.0) {
                    s.add_labels("Singular Matrix");
                }
            }
            s.set_values(a, r, r);
            System.out.println("Square Matrix Created with id " + s.get_id());
            common.add_matrix(s);
            return;
        }
        if (n == 5) {
            System.out.println("Creating Symmetric Matrix");
            int r = 3;
            float[][] a = new float[r][r];
            a[0][0] = 1;
            a[1][1] = 2;
            a[2][2] = 5;
            a[0][1] = 1;
            a[0][2] = -1;
            a[1][0] = 1;
            a[1][2] = 0;
            a[2][1] = -1;
            a[2][0] = 0;
            Symmetric_Matrix s = new Symmetric_Matrix();
            s.set_size(r, r);
            s.add_labels("Square Matrix");
            float b = detthree(a);
            if (b == 0.0) {
                s.add_labels("Singular Matrix");
            }
            s.set_values(a, r, r);
            common.add_matrix(s);
            System.out.println("Symmetric Matrix Created with id " + s.get_id());
            return;
        }
        if (n == 6) {
            System.out.println("Creating Skew Symmetric Matrix");
            int r = 3;
            float[][] a = new float[r][r];
            a[0][0] = 0;
            a[1][1] = 0;
            a[2][2] = 0;
            a[0][1] = 1;
            a[0][2] = -2;
            a[1][0] = -1;
            a[1][2] = 3;
            a[2][1] = 2;
            a[2][0] = -3;
            Skew_Symmetric_Matrix s = new Skew_Symmetric_Matrix();
            s.set_size(r, r);
            s.add_labels("Square Matrix");
            float b = detthree(a);
            if (b == 0.0) {
                s.add_labels("Singular Matrix");
            }
            s.set_values(a, r, r);
            common.add_matrix(s);
            System.out.println("Skew Symmetric Matrix Created with id " + s.get_id());
            return;
        }
        if (n == 7) {
            System.out.println("Creating Upper Triangular Matrix");
            int r = 3;
            float[][] a = new float[r][r];
            a[0][0] = 1;
            a[1][1] = 2;
            a[2][2] = 3;
            a[0][1] = 1;
            a[0][2] = -2;
            a[1][0] = 0;
            a[1][2] = 3;
            a[2][1] = 0;
            a[2][0] = 0;
            Upper_Triangular_Matrix u = new Upper_Triangular_Matrix();
            u.set_size(r, r);
            u.add_labels("Square Matrix");
            if (r == 3) {
                float b = detthree(a);
                if (b == 0.0) {
                    u.add_labels("Singular Matrix");
                }
            }
            u.set_values(a, r, r);
            System.out.println("Upper Triangular Matrix Created with id " + u.get_id());
            common.add_matrix(u);
            return;
        }
        if (n == 8) {
            System.out.println("Creating Lower Triangular Matrix");
            int r = 3;
            float[][] a = new float[r][r];
            a[0][0] = 1;
            a[1][1] = 2;
            a[2][2] = 3;
            a[0][1] = 0;
            a[0][2] = 0;
            a[1][0] = 5;
            a[1][2] = 0;
            a[2][1] = 7;
            a[2][0] = 8;
            Lower_Triangular_Matrix l = new Lower_Triangular_Matrix();
            l.set_size(r, r);
            l.add_labels("Square Matrix");
            if (r == 3) {
                float b = detthree(a);
                if (b == 0.0) {
                    l.add_labels("Singular Matrix");
                }
            }
            l.set_values(a, r, r);
            System.out.println("Lower Triangular Matrix Created with id " + l.get_id());
            common.add_matrix(l);
            return;
        }
        if (n == 9) {
            System.out.println("Creating Singular Matrix");
            int r = 2;
            float[][] a = new float[r][r];
            Singular_Matrix s = new Singular_Matrix();
            s.set_size(r, r);
            s.add_labels("Square Matrix");
            s.set_values(a, r, r);
            System.out.println("Singular Matrix Created with id " + s.get_id());
        }
        if (n == 10) {
            System.out.println("Creating Diagonal Matrix");
            int r = 2;
            float[][] a = new float[r][r];
            a[0][0] = 1;
            a[1][1] = 5;
            a[1][0] = 0;
            a[0][1] = 0;
            // Diagonal Matrix
            Diagonal_Matrix d = new Diagonal_Matrix();
            d.add_labels("Square Matrix");
            d.add_labels("Symmetric Matrix");
            d.add_labels("Upper Triangular Matrix");
            d.add_labels("Lower Triangular Matrix");
            d.set_values(a, r, r);
            float b = dettwo(a);
            if (b == 0.0) {
                d.add_labels("Singular Matrix");
            }
            d.set_size(r, r);
            common.add_matrix(d);
            System.out.println("Diagonal Matrix Created with id " + d.get_id());
            return;
        }
        if (n == 11) {
            System.out.println("Creating Scalar Matrix");
            int r = 2;
            float[][] a = new float[r][r];
            a[0][0] = 5;
            a[1][1] = 5;
            a[1][0] = 0;
            a[0][1] = 0;
            Scalar_Matrix s = new Scalar_Matrix();
            s.add_labels("Square Matrix");
            s.add_labels("Diagonal Matrix");
            s.add_labels("Symmetric Matrix");
            s.set_size(r, r);
            s.set_values(a, r, r);
            common.add_matrix(s);
            System.out.println("Scalar Matrix Created with id " + s.get_id());
            return;
        }
        if (n == 12) {
            System.out.println("Creating Identity Matrix");
            int r = 1;
            float[][] a = new float[r][r];
            a[0][0] = 1;
            // Identity Matrix
            Identity_Matrix i = new Identity_Matrix();
            i.add_labels("Square Matrix");
            i.add_labels("Diagonal Matrix");
            i.add_labels("Scalar Matrix");
            i.add_labels("Symmetric Matrix");
            i.set_size(r, r);
            common.add_matrix(i);
            System.out.println("Identity Matrix Created with id " + i.get_id());
            return;
        }
        if (n == 13) {
            System.out.println("Creating Singleton Matrix");
            int r = 1;
            float[][] a = new float[r][r];
            a[0][0] = 7;
            // Singleton Matrix
            Singleton_Matrix s = new Singleton_Matrix();
            s.add_labels("Square Matrix");
            s.set_values(a, r, r);
            s.add_labels("Symmetric Matrix");
            s.add_labels("Scalar Matrix");
            s.add_labels("Diagonal Matrix");
            System.out.println("Singleton Matrix Created with id " + s.get_id());
        }
        if (n == 14) {
            System.out.println("Creating Ones Matrix");
            Ones_Matrix o = new Ones_Matrix();
            o.set_size(1, 1);
            o.add_labels("Square Matrix");
            o.add_labels("Symmetric Matrix");
            o.add_labels("Singular Matrix");
            common.add_matrix(o);
            System.out.println("Ones Matrix Created with id " + o.get_id());
        }
        if (n == 15) {
            System.out.println("Creating Null Matrix");
            Null_Matrix g = new Null_Matrix();
            g.set_size(1, 1);
            g.add_labels("Square Matrix");
            g.add_labels("Row Matrix");
            g.add_labels("Column Matrix");
            common.add_matrix(g);
            System.out.println("Null Matrix Created with id " + g.get_id());
            return;
        }
    }

    public static void Compute_determinants() {
        System.out.println("Enter id whose determinant is to be caluculated");
        int n = scn.nextInt();
        ArrayList<common> y = common.get_matrix();
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                if (y.get(i).get_type().equals("Rectangular Matrix") || y.get(i).get_type().equals("Row Matrix")
                        || y.get(i).get_type().equals("Column Matrix")) {
                    System.out.println("Determinant cannot be calulated");
                    return;
                } else {
                    System.out.println(y.get(i).get_rows());
                    if (y.get(i).get_rows() == 1) {
                        System.out.println("Determinant of the matrix is :- " + y.get(i).get_values()[0][0]);
                    }
                    if (y.get(i).get_rows() == 2) {
                        System.out.println("Determinant of the matrix is :- " + dettwo(y.get(i).get_values()));
                    }
                    if (y.get(i).get_rows() == 3) {
                        System.out.println("Determinant of the matrix is :- " + detthree(y.get(i).get_values()));
                    }
                }
            }
        }
    }

    public static void Addition() {
        System.out.println("Addition");
        System.out.println("Enter the id of 1st Matrix");
        int n = scn.nextInt();
        System.out.println("Enter the id of 2nd Matrix");
        int m = scn.nextInt();
        ArrayList<common> y = common.get_matrix();
        int i;
        int j = 0;
        boolean flag = false;
        for (i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                for (j = 0; j < y.size(); j++) {
                    if (y.get(j).get_id() == m) {
                        if (y.get(i).get_rows() != y.get(j).get_rows()
                                || y.get(i).get_columns() != y.get(j).get_columns()) {
                            System.out.println("Matrix Cannot Be Added");
                            return;
                        } else {
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if (flag == true) {
                break;
            }
        }
        float[][] a = y.get(i).get_values();
        float[][] b = y.get(j).get_values();
        for (int p = 0; p < y.get(i).get_rows(); p++) {
            for (int q = 0; q < y.get(j).get_columns(); q++) {
                System.out.print((a[p][q] + b[p][q]) + " ");
            }
            System.out.println();
        }
    }

    public static void Subtraction() {
        System.out.println("Subtraction");
        System.out.println("Enter the id of 1st Matrix");
        int n = scn.nextInt();
        System.out.println("Enter the id of 2nd Matrix");
        int m = scn.nextInt();
        ArrayList<common> y = common.get_matrix();
        int i;
        int j = 0;
        boolean flag = false;
        for (i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                for (j = 0; j < y.size(); j++) {
                    if (y.get(j).get_id() == m) {
                        if (y.get(i).get_rows() != y.get(j).get_rows()
                                || y.get(i).get_columns() != y.get(j).get_columns()) {
                            System.out.println("Matrix Cannot Be Subtraction");
                            return;
                        } else {
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if (flag == true) {
                break;
            }
        }
        float[][] a = y.get(i).get_values();
        float[][] b = y.get(j).get_values();
        for (int p = 0; p < y.get(i).get_rows(); p++) {
            for (int q = 0; q < y.get(i).get_columns(); q++) {
                System.out.print((a[p][q] - b[p][q]) + " ");
            }
            System.out.println();
        }
    }

    public static void Multiplication() {
        System.out.println("Multiplication");
        System.out.println("Enter the id of 1st Matrix");
        int n = scn.nextInt();
        System.out.println("Enter the id of 2nd Matrix");
        int m = scn.nextInt();
        ArrayList<common> y = common.get_matrix();
        int i,g=0;
        int j = 0;
        int uy=0;
        boolean flag = false;
        for (i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                for (j = 0; j < y.size(); j++) {
                    if (y.get(j).get_id() == m) {
                        if (y.get(i).get_columns() != y.get(j).get_rows()) {
                            System.out.println("Matrix Cannot Be Multiplication");
                            return;
                        } else {
                            flag = true;
                            uy=j;
                            g=i;
                            break;
                        }
                    }
                }
            }
            if (flag == true) {
                break;
            }
        }
        float[][] a = y.get(g).get_values();
        float[][] b = y.get(uy).get_values();
        float[][] c = new float[y.get(g).get_rows()][y.get(uy).get_columns()];
        int s;
        for (int p = 0; p < y.get(g).get_rows(); p++) {
            for (int k = 0; k < y.get(uy).get_columns(); k++) {
                s = 0;
                for (int q = 0; q < y.get(uy).get_rows(); q++) {
                    s += a[p][q] * b[q][k];
                }
                c[p][k] = s;
            }
        }
        for (int h = 0; h < y.get(g).get_rows(); h++) {
            for (int o = 0; o < y.get(uy).get_columns(); o++) {
                System.out.print(c[h][o]+" ");
            }
            System.out.println();
        }
    }

    public static void Division() {
        System.out.println("Divison");
        System.out.println("Enter the id of 1st Matrix");
        int n = scn.nextInt();
        System.out.println("Enter the id of 2nd Matrix");
        int m = scn.nextInt();
        boolean f = false;
        int o = -1;
        ArrayList<common> y = common.get_matrix();
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == m) {
                if (y.get(i).get_labels().contains("Square Matrix")) {
                    if (y.get(i).get_labels().contains("Singular Matrix")) {
                        break;
                    } else {
                        f = true;
                        o = i;
                        break;
                    }
                }
            }
        }
        if (f == false) {
            System.out.println("Not a square non singualr matrix");
            return;
        } 
        
        int i,t=0,r=0;
        int j = 0;
        boolean flag = false;
        for (i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                for (j = 0; j < y.size(); j++) {
                    if (y.get(j).get_id() == m) {
                        if (y.get(i).get_columns() != y.get(j).get_rows()) {
                            System.out.println("Matrix Cannot Be Multiplication");
                            return;
                        } else {
                            flag = true;
                            t=i;
                            r=j;
                            break;
                        }
                    }
                }
            }
            if (flag == true) {

                break;
            }
        }
        float[][] a = y.get(t).get_values();
        //float[][] b = y.get(j).get_values();
        float[][] b = Inv(y,r);
        float[][] c = new float[y.get(t).get_rows()][y.get(r).get_columns()];
        int s;
        for (int p = 0; p < y.get(t).get_rows(); p++) {
            for (int k = 0; k < y.get(r).get_columns(); k++) {
                s = 0;
                for (int q = 0; q < y.get(r).get_rows(); q++) {
                    s += a[p][q] * b[q][k];
                }
                c[p][k] = s;
            }
        }
        System.out.println("Ans is:- ");
        for (int h = 0; h < y.get(t).get_rows(); h++) {
            for (int hj = 0; hj < y.get(r).get_columns(); hj++) {
                System.out.print(c[h][hj]+" ");
            }
            System.out.println();
        }
    }    

    public static void element_wise_operations() {
        System.out.println("Element Wise Multiplication");
        System.out.println("Enter the id of 1st Matrix");
        int n = scn.nextInt();
        System.out.println("Enter the id of 2nd Matrix");
        int m = scn.nextInt();
        ArrayList<common> y = common.get_matrix();
        int i;
        int j = 0;
        boolean flag = false;
        for (i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                for (j = 0; j < y.size(); j++) {
                    if (y.get(j).get_id() == m) {
                        if (y.get(i).get_rows() != y.get(j).get_rows()
                                || y.get(i).get_columns() != y.get(j).get_columns()) {
                            System.out.println("Matrix Cannot Be Element Wise Multiplied");
                            return;
                        } else {
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if (flag == true) {
                break;
            }
        }
        float[][] a = y.get(i).get_values();
        float[][] b = y.get(j).get_values();
        for (int p = 0; p < y.get(i).get_rows(); p++) {
            for (int q = 0; q < y.get(j).get_columns(); q++) {
                System.out.print((a[p][q] * b[p][q]) + " ");
            }
            System.out.println();
        }
    }

    public static void row_wise_mean() {
        System.out.println("Row Wise Mean");
        System.out.println("Enter the id of Matrix");
        int n = scn.nextInt();
        ArrayList<common> y = common.get_matrix();
        int i;
        for (i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                break;
            }
        }
        float[][] a = y.get(i).get_values();
        float sum;
        for (int h = 0; h < y.get(i).get_rows(); h++) {
            sum = 0;
            for (int g = 0; g < y.get(i).get_columns(); g++) {
                sum = sum + a[h][g];
            }
            System.out.println("Row Wise Mean Of Row " + (h + 1) + " is " + sum / y.get(i).get_columns());
        }
    }

    public static void column_wise_mean() {
        System.out.println("Column Wise Mean");
        System.out.println("Enter the id of Matrix");
        int n = scn.nextInt();
        ArrayList<common> y = common.get_matrix();
        int i;
        for (i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                break;
            }
        }
        float[][] a = y.get(i).get_values();
        float sum;
        for (int h = 0; h < y.get(i).get_columns(); h++) {
            sum = 0;
            for (int g = 0; g < y.get(i).get_rows(); g++) {
                sum = sum + a[g][h];
            }
            System.out.println("Column Wise Mean Of Column " + (h + 1) + " is " + sum / y.get(i).get_rows());
        }
    }

    public static void mean() {
        System.out.println("Mean");
        System.out.println("Enter the id of Matrix");
        int n = scn.nextInt();
        ArrayList<common> y = common.get_matrix();
        int i;
        for (i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                break;
            }
        }
        float[][] a = y.get(i).get_values();
        float sum = 0;
        for (int h = 0; h < y.get(i).get_rows(); h++) {
            for (int g = 0; g < y.get(i).get_columns(); g++) {
                sum = sum + a[h][g];
            }
        }
        int t = y.get(i).get_rows() * y.get(i).get_columns();
        System.out.println("Mean Of All Elements is " + (sum / t));
    }

    public static void singleton_matrices_as_scalars() {
        System.out.println("Singleton matrices as scalars");
        System.out.println("Enter the id of the singletom matrix you want to use as scalar");
        int n = scn.nextInt();
        boolean flag = false;
        float value = -1;
        ArrayList<common> y = common.get_matrix();
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                if (y.get(i).get_type().equals("Singleton Matrix")) {
                    value = y.get(i).get_values()[0][0];
                    flag = true;
                    break;
                }
            }
        }
        if (flag == false) {
            System.out.println("The matrix is not a singleton matrix");
            return;
        }
        System.out.println("Enter the id of matrix you want scalar to be multiplied with ");
        int m = scn.nextInt();
        int h = -1;
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == m) {
                h = i;
            }
        }
        if (h != -1) {
            float[][] a = y.get(h).get_values();
            for (int i = 0; i < y.get(h).get_rows(); i++) {
                for (int j = 0; j < y.get(h).get_columns(); j++) {
                    System.out.print(value * a[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix with this id doesnt exit");
        }
    }

    public static void compute_sum() {
        System.out.println("Compute A + A' ");
        System.out.println("Enter the id of a square matrix");
        int n = scn.nextInt();
        boolean flag = false;
        int f = -1;
        ArrayList<common> y = common.get_matrix();
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                if (y.get(i).get_labels().contains("Square Matrix")) {
                    f = i;
                    flag = true;
                    break;
                }
            }
        }

        if (flag == false) {
            System.out.println(
                    "The Entered Id contains matrix which is not square. Hence the computation cannot be performed");
            return;
        }
        float[][] a = y.get(f).get_values();
        float[][] b = Transpose(y, f);
        if (y.get(f).get_type().equals("Identity Matrix")) {
            System.out.println("Computing A + A'");
            if (y.get(f).get_rows() == 1) {
                System.out.println("2");
            }
            if (y.get(f).get_rows() == 2) {
                System.out.println("2 0\n0 2");
            }

            if (y.get(f).get_rows() == 3) {
                System.out.println("2 0 0\n0 2 0\n0 0 2");
            }
        } else if (y.get(f).get_type().equals("Ones Matrix") || y.get(f).get_type().equals("Null Matrix")) {
            System.out.println("Computing A + A'");
            for (int p = 0; p < y.get(f).get_rows(); p++) {
                for (int q = 0; q < y.get(f).get_columns(); q++) {
                    if (y.get(f).get_type().equals("Ones Matrix")) {
                        System.out.print("2 ");
                    }
                    if (y.get(f).get_type().equals("Null Matrix")) {
                        System.out.print("0 ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Computing A + A'");
            for (int p = 0; p < y.get(f).get_rows(); p++) {
                for (int q = 0; q < y.get(f).get_columns(); q++) {
                    System.out.print(a[p][q] + b[p][q] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void something(ArrayList<common> y, int i) {
        System.out.println("Matrix id " + y.get(i).get_id());
        for (int p = 0; p < y.get(i).get_rows(); p++) {
            for (int q = 0; q < y.get(i).get_columns(); q++) {
                System.out.print(y.get(i).get_values()[p][q] + " ");
            }
            System.out.println();
        }
    }

    public static void Retrieve() {
        System.out.println("Enter the label of matrix");
        System.out.println(
                "Various Types Of Matrix\n1. Rectangular Matrix\n2. Row Matrix\n3. Column Matrix\n4. Square Matrix\n5. Symmetric Matrix\n6. Skew-symmetric Matrix\n7. Upper-triangular Matrix\n8. Lower-triangular Matrix\n9. Singular Matrix\n10. Diagonal Matrix\n11. Scalar Matrix\n12. Identity Matrix\n13. Singleton Matrix\n14. Ones Matrix\n15. Null Matrix");
        System.out.println("Choice");
        int n = scn.nextInt();
        ArrayList<common> y = common.get_matrix();
        if (n == 1) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Rectangular Matrix")) {
                    something(y, i);
                }
            }
        } else if (n == 2) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Row Matrix")) {
                    something(y, i);
                }
            }
        } else if (n == 3) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Column Matrix")) {
                    something(y, i);
                }
            }
        } else if (n == 4) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Square Matrix")) {
                    something(y, i);
                }
            }
        } else if (n == 5) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Symmetric Matrix")) {
                    something(y, i);
                }
            }
        } else if (n == 6) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Skew Symmetric Matrix")) {
                    something(y, i);
                }
            }
        } else if (n == 7) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Upper Triangular Matrix")) {
                    something(y, i);
                }
            }
        } else if (n == 8) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Lower Triangular Matrix")) {
                    something(y, i);
                }
            }
        } else if (n == 9) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Singular Matrix")) {
                    something(y, i);
                }
            }
        } else if (n == 10) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Diagonal Matrix")) {
                    something(y, i);
                }
            }
        } else if (n == 11) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Scalar Matrix")) {
                    something(y, i);
                }
            }
        } else if (n == 12) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Identity Matrix")) {
                    if (y.get(i).get_rows() == 1) {
                        System.out.println("1");
                    }
                    if (y.get(i).get_rows() == 2) {
                        System.out.println("1 0\n0 1");
                    }

                    if (y.get(i).get_rows() == 3) {
                        System.out.println("1 0 0\n0 1 0\n0 0 1");
                    }
                }
            }
        } else if (n == 13) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Singleton Matrix")) {
                    something(y, i);
                }
            }
        } else if (n == 14) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Ones Matrix")) {
                    for (int p = 0; p < y.get(i).get_rows(); p++) {
                        for (int q = 0; q < y.get(i).get_columns(); q++) {
                            System.out.print("1 ");
                        }
                        System.out.println();
                    }
                }
            }
        } else if (n == 15) {
            for (int i = 0; i < y.size(); i++) {
                if (y.get(i).get_type().equals("Null Matrix")) {
                    for (int p = 0; p < y.get(i).get_rows(); p++) {
                        for (int q = 0; q < y.get(i).get_columns(); q++) {
                            System.out.print("0 ");
                        }
                        System.out.println();
                    }
                }
            }
        }

    }

    public static void Inverse() {
        System.out.println("Enter the id of the square non singualr matrix you want to inverse");
        int n = scn.nextInt();
        boolean f = false;
        int o = -1;
        ArrayList<common> y = common.get_matrix();
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                if (y.get(i).get_labels().contains("Square Matrix")) {
                    if (y.get(i).get_labels().contains("Singular Matrix")) {
                        break;
                    } else {
                        f = true;
                        o = i;
                        break;
                    }
                }
            }
        }
        if (f == false) {
            System.out.println("Not a square non singualr matrix");
        } else {
            System.out.println("Inverse Of the matrix is:-");
            int k = y.get(o).get_rows();
            float[][] a = y.get(o).get_values();
            if (k == 1) {
                float[][] b = new float[1][1];
                System.out.println(1 / a[0][0]);
                b[0][0] = 1 / a[0][0];

            } else if (k == 2) {
                float[][] b = new float[2][2];
                float d = dettwo(a);
                b[0][0] = a[1][1];
                b[1][1] = a[0][0];
                b[0][1] = -a[0][1];
                b[1][0] = -a[1][0];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print((b[i][j] / d) + " ");
                    }
                    System.out.print("\n");
                }
            } else if (k == 3) {
                float[][] b = new float[3][3];
                float d = detthree(a);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print((((a[(j + 1) % 3][(i + 1) % 3] * a[(j + 2) % 3][(i + 2) % 3])
                                - (a[(j + 1) % 3][(i + 2) % 3] * a[(j + 2) % 3][(i + 1) % 3])) / d) + " ");

                        b[i][j] = (((a[(j + 1) % 3][(i + 1) % 3] * a[(j + 2) % 3][(i + 2) % 3])
                                - (a[(j + 1) % 3][(i + 2) % 3] * a[(j + 2) % 3][(i + 1) % 3])) / d);
                    }
                    System.out.print("\n");
                }
            }
        }

    }

    public static float[][] Inv(ArrayList<common> y, int o) {
        System.out.println("Inverse Of the matrix is:-");
        int k = y.get(o).get_rows();
        float[][] a = y.get(o).get_values();
        if (k == 1) {
            float[][] b = new float[1][1];
            System.out.println(1 / a[0][0]);
            b[0][0] = 1 / a[0][0];
            return b;
        } else if (k == 2) {
            float[][] b = new float[2][2];
            float d = dettwo(a);
            b[0][0] = a[1][1];
            b[1][1] = a[0][0];
            b[0][1] = -a[0][1];
            b[1][0] = -a[1][0];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    System.out.print((b[i][j] / d) + " ");
                    b[i][j] = (b[i][j] / d);
                }
                System.out.print("\n");
            }
            return b;
        } else if (k == 3) {
            float[][] b = new float[3][3];
            float d = detthree(a);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print((((a[(j + 1) % 3][(i + 1) % 3] * a[(j + 2) % 3][(i + 2) % 3])
                            - (a[(j + 1) % 3][(i + 2) % 3] * a[(j + 2) % 3][(i + 1) % 3])) / d) + " ");

                    b[i][j] = (((a[(j + 1) % 3][(i + 1) % 3] * a[(j + 2) % 3][(i + 2) % 3])
                            - (a[(j + 1) % 3][(i + 2) % 3] * a[(j + 2) % 3][(i + 1) % 3])) / d);
                }
                System.out.print("\n");
            }
            return b;
        }
        return a;
    }

    public static void linear_equations() {
        System.out.println("Solve a set of linear equation");
        System.out.println("Enter the id of a square matrix");
        int n = scn.nextInt();
        boolean f = false;
        int o = -1;
        ArrayList<common> y = common.get_matrix();
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == n) {
                if (y.get(i).get_labels().contains("Square Matrix")) {
                    if (y.get(i).get_labels().contains("Singular Matrix")) {
                        break;
                    } else {
                        f = true;
                        o = i;
                        break;
                    }
                }
            }
        }
        if (f == false) {
            System.out.println("Not a square non singualr matrix");
            return;
        }
        int k = y.get(o).get_rows();
        float[][] a = y.get(o).get_values();
        System.out.println("Enter the id of a column matrix");
        int h = scn.nextInt();
        for (int i = 0; i < y.size(); i++) {
            if (y.get(i).get_id() == h) {
                if (y.get(i).get_columns() == 1 && y.get(i).get_rows() == k) {
                    float[][] l = y.get(i).get_values();
                    float[][] fg = Inv(y, o);
                    float[][] c = new float[k][1];
                    int s;
                    for (int p = 0; p < k; p++) {
                        for (int u = 0; u < 1; u++) {
                            s = 0;
                            for (int q = 0; q < k; q++) {
                                s += fg[p][q] * l[q][u];
                            }
                            c[p][u] = s;
                        }
                    }
                    System.out.println("Ans is :-");
                    for (int t = 0; t < y.get(i).get_rows(); t++) {
                        for (int r = 0; r < 1; r++) {
                            System.out.println(c[t][r]);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int p = 1;
        while (p != 0) {
            menu();
            int choice = scn.nextInt();
            switch (choice) {
            case 1:
                create_matrix();
                break;

            case 2:
                create_matrix_of_specific_type();
                break;

            case 3:
                break;

            case 4:
                Display_all_requested_type_labels();
                break;

            case 5:
                System.out.println("Perform Operations\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
                int h = scn.nextInt();
                switch (h) {
                case 1:
                    Addition();
                    break;
                case 2:
                    Subtraction();
                    break;
                case 3:
                    Multiplication();
                    break;
                case 4:
                    Division();
                    break;
                }
                break;

            case 6:
                element_wise_operations();
                break;

            case 7:
                Transpose_matrices();
                break;

            case 8:
                Inverse();
                break;

            case 9:
                System.out
                        .println("Compute means:\n1. row-wise mean\n2. column-wise mean\n3. mean of all the elements");
                int g = scn.nextInt();
                switch (g) {
                case 1:
                    row_wise_mean();
                    break;
                case 2:
                    column_wise_mean();
                    break;
                case 3:
                    mean();
                    break;
                }
                break;
            case 10:
                Compute_determinants();
                break;

            case 11:
                singleton_matrices_as_scalars();
                break;

            case 12:
                compute_sum();
                break;

            case 13:
                break;

            case 14:
                linear_equations();
                break;

            case 15:
                Retrieve();
                break;

            case 16:
                p = 0;
                break;

            default:
                System.out.println("Enter a valid number");
                break;
            }
        }
    }
}
