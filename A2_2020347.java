import java.util.*;

public class A2_2020347 {
    static public Scanner scn = new Scanner(System.in);

    interface common_function {
        public void View_lecture_materials();

        public void View_assessments();

        public void View_comments();

        public void Add_comments(String h);

    }

    public static class Instructor implements common_function {
        private String Instrutor_id;

        public String getid() {
            return Instrutor_id;
        }

        Instructor(String h) {
            Instrutor_id = h;
        }

        @Override
        public void View_lecture_materials() {
            for (int i = 0; i < added_slides.size(); i++) {
                System.out.println("Title: " + added_slides.get(i).title);
                for (int j = 1; j <= added_slides.get(i).No_of_slides; j++) {
                    System.out.println("Slides " + j + ": " + added_slides.get(i).get_content().get(j - 1));
                }
                System.out.println("Number of slides:" + added_slides.get(i).No_of_slides);
                System.out.println("Date of upload:" + added_slides.get(i).get_date());
                System.out.println("Uploaded by:" + added_slides.get(i).get_ins());
            }
            for (int i = 0; i < added_videos.size(); i++) {
                System.out.println("Title of video:" + added_videos.get(i).get_title());
                System.out.println("Video file:" + added_videos.get(i).get_file());
                System.out.println("Date of upload:" + added_videos.get(i).get_date());
                System.out.println("Uploaded by:" + added_videos.get(i).get_ins());
            }
        }

        @Override
        public void View_assessments() {
            int i = 0;
            for (i = 0; i < Assignment.size(); i++) {
                System.out.println("ID: " + i + " Assignment:" + Assignment.get(i).get_problem() + " Max Marks: "
                        + Assignment.get(i).get_max());
                System.out.println("----------------");
            }
            for (int j = 0; j < Quiz.size(); j++) {
                System.out.println("ID: " + i + " Question: " + Quiz.get(j).get_problem());
                i++;
                System.out.println("----------------");
            }
        }

        @Override
        public void Add_comments(String f) {
            System.out.print("Enter comment: ");
            String s = scn.nextLine();
            comments c = new comments(f, s);
            Add_Comments.add(c);
        }

        @Override
        public void View_comments() {
            for (int i = 0; i < Add_Comments.size(); i++) {
                System.out.println(Add_Comments.get(i).get_comment() + " - " + Add_Comments.get(i).get_person());
                System.out.println(Add_Comments.get(i).get_date());
                System.out.println();
            }
        }
    }

    static ArrayList<comments> Add_Comments = new ArrayList<>();

    public static class comments {
        private String person;
        private String com;
        private Date d;

        comments(String i, String c) {
            person = i;
            com = c;
            d = new java.util.Date();
        }

        public String get_person() {
            return person;
        }

        public String get_comment() {
            return com;
        }

        public Date get_date() {
            return d;
        }

        public void set_date(Date h) {
            d = h;
        }

    }

    static ArrayList<lec_slides> added_slides = new ArrayList<>();

    public static void slides(int n) {
        String t;
        System.out.print("Enter topic of slides:");
        t = scn.nextLine();
        System.out.print("Enter number of slides:");
        int s = Integer.parseInt(scn.nextLine());
        System.out.println("Enter content of slides");
        ArrayList<String> content = new ArrayList<>();
        for (int i = 1; i <= s; i++) {
            System.out.print("Content of slide " + i + ":");
            String h = scn.nextLine();
            content.add(h);
        }
        String id = "I" + n;
        lec_slides l = new lec_slides(t, s, id, content);
        added_slides.add(l);
    }

    static ArrayList<lec_videos> added_videos = new ArrayList<>();

    public static void video(int n) {
        System.out.print("Enter topic of video:");
        String t = scn.nextLine();
        System.out.print("Enter filename of video:");
        String h = new String();
        h = scn.nextLine();
        int j = 0;
        for (int i = 0; i < h.length(); i++) {
            if (h.charAt(i) == '.') {
                break;
            } else {
                j++;
            }
        }

        if (h.substring(j).equals(".mp4")) {
            String c = "I" + n;
            lec_videos k = new lec_videos(t, h, c);
            added_videos.add(k);
        } else {
            System.out.println("Video uploaded in not in mp4 extension");
        }
    }

    interface common_lec_material {
        public String get_ins();

        public String get_title();

        public Date get_date();

        public void set_date(Date j);
    }

    public static class lec_slides implements common_lec_material {
        private String title;
        private int No_of_slides;
        private ArrayList<String> content;
        private Date d;
        private String ins;

        lec_slides(String t, int n, String i, ArrayList<String> m) {
            title = t;
            No_of_slides = n;
            content = m;
            ins = i;
            d = new java.util.Date();
        }

        @Override
        public String get_ins() {
            return ins;
        }

        @Override
        public String get_title() {
            return title;
        }

        @Override
        public Date get_date() {
            return d;

        }

        @Override
        public void set_date(Date h) {
            d = h;
        }

        public ArrayList<String> get_content() {
            return content;
        }

    }

    public static class lec_videos implements common_lec_material {
        private String title;
        private String file;
        private String ins;
        private Date d;

        lec_videos(String a, String b, String c) {
            title = a;
            file = b;
            ins = c;
            d = new java.util.Date();
        }

        public String get_file() {
            return file;
        }

        @Override
        public String get_ins() {
            return ins;
        }

        @Override
        public String get_title() {
            return title;
        }

        @Override
        public Date get_date() {
            return d;
        }

        @Override
        public void set_date(Date h) {
            d = h;
        }

    }

    static ArrayList<Assignment> Assignment = new ArrayList<>();
    static ArrayList<Quiz> Quiz = new ArrayList<>();

    interface common_between_assignment_quiz {
        public String get_problem();

        public String get_status();

        public void set_status();
    }

    public static class Assignment implements common_between_assignment_quiz {
        private String problem;
        private int max;
        private String x = "OPEN";

        Assignment(int n, String p) {
            max = n;
            problem = p;
        }

        @Override
        public String get_problem() {
            return problem;
        }

        public int get_max() {
            return max;
        }

        @Override
        public String get_status() {
            return x;
        }

        @Override
        public void set_status() {
            x = "CLOSED";
        }
    }

    public static class Quiz implements common_between_assignment_quiz {
        private String x = "OPEN";
        private String problem;
        private int max = 1;

        Quiz(String g) {
            problem = g;
        }

        @Override
        public String get_status() {
            return x;
        }

        @Override
        public String get_problem() {
            return problem;
        }

        @Override
        public void set_status() {
            x = "CLOSED";
        }

        public int get_max() {
            return max;
        }

        public void set_max(int b) {
            max = b;
        }

    }

    public static class Student implements common_function {
        private String Student_id;

        public String getid() {
            return Student_id;
        }

        Student(String h) {
            Student_id = h;
        }

        @Override
        public void View_lecture_materials() {
            for (int i = 0; i < added_slides.size(); i++) {
                System.out.println("Title: " + added_slides.get(i).title);
                for (int j = 1; j <= added_slides.get(i).No_of_slides; j++) {
                    System.out.println("Slides " + j + ": " + added_slides.get(i).get_content().get(j - 1));
                }
                System.out.println("Number of slides:" + added_slides.get(i).No_of_slides);
                System.out.println("Date of upload:" + added_slides.get(i).get_date());
                System.out.println("Uploaded by:" + added_slides.get(i).get_ins());
                System.out.println();
            }
            for (int i = 0; i < added_videos.size(); i++) {
                System.out.println("Title of video:" + added_videos.get(i).get_title());
                System.out.println("Video file:" + added_videos.get(i).get_file());
                System.out.println("Date of upload:" + added_videos.get(i).get_date());
                System.out.println("Uploaded by:" + added_videos.get(i).get_ins());
                System.out.println();
            }
        }

        @Override
        public void View_assessments() {
            int i = 0;
            for (i = 0; i < Assignment.size(); i++) {
                System.out.println("ID: " + i + " Assignment: " + Assignment.get(i).get_problem() + " Max Marks: "
                        + Assignment.get(i).get_max());
                System.out.println("----------------");
            }
            for (int j = 0; j < Quiz.size(); j++) {
                System.out.println("ID: " + i + " Question: " + Quiz.get(j).get_problem());
                i++;
                System.out.println("----------------");
            }
        }

        @Override
        public void Add_comments(String f) {
            System.out.print("Enter comment: ");
            String s = scn.nextLine();
            comments c = new comments(f, s);
            Add_Comments.add(c);
        }

        @Override
        public void View_comments() {
            for (int i = 0; i < Add_Comments.size(); i++) {
                System.out.println(Add_Comments.get(i).get_comment() + " - " + Add_Comments.get(i).get_person());
                System.out.println(Add_Comments.get(i).get_date());
                System.out.println();
            }
        }
    }

    static ArrayList<Submission> Sub = new ArrayList<>();

    public static class Submission {

        private String id;
        private ArrayList<String> assign = new ArrayList<String>(Assignment.size());
        private ArrayList<String> qui = new ArrayList<String>(Quiz.size());;
        private ArrayList<Integer> amarks = new ArrayList<Integer>(Assignment.size());
        private ArrayList<Integer> qmarks = new ArrayList<Integer>(Quiz.size());;
        private ArrayList<String> file = new ArrayList<String>(Assignment.size());
        private ArrayList<String> ans = new ArrayList<String>(Quiz.size());;
        private ArrayList<String> a_ins = new ArrayList<String>(Assignment.size());;
        private ArrayList<String> q_ins = new ArrayList<String>(Quiz.size());;

        Submission(String j) {
            id = j;
            for (int i = 0; i < Assignment.size(); i++) {
                amarks.add(-1);
            }

            for (int i = 0; i < Quiz.size(); i++) {
                qmarks.add(-1);
            }

            for (int i = 0; i < Assignment.size(); i++) {
                assign.add("UNSUBMITTED");
            }
            for (int i = 0; i < Quiz.size(); i++) {
                qui.add("UNSUBMITTED");
            }

            for (int i = 0; i < Assignment.size(); i++) {
                file.add("null");
            }

            for (int i = 0; i < Assignment.size(); i++) {
                a_ins.add("null");
            }
            for (int i = 0; i < Quiz.size(); i++) {
                ans.add("null");
            }
            for (int i = 0; i < Quiz.size(); i++) {
                q_ins.add("null");
            }

        }

        public ArrayList<String> get_assign() {

            return assign;
        }

        public ArrayList<String> get_qui() {
            return qui;
        }

        public String get_id() {
            return id;
        }

        public void set_assign(int j) {
            assign.set(j, "SUBMITTED");
        }

        public void set_qui(int j) {
            qui.set(j, "SUBMITTED");
        }

        public ArrayList<Integer> get_amarks() {
            return amarks;
        }

        public void set_amarks(int k, int h) {
            amarks.set(k, h);
        }

        public ArrayList<Integer> get_qmarks() {
            return qmarks;
        }

        public void set_qmarks(int k, int h) {
            qmarks.set(k, h);
        }

        public ArrayList<String> get_file() {
            return file;
        }

        public void set_file(int m, String k) {
            file.set(m, k);
        }

        public ArrayList<String> get_ans() {
            return ans;
        }

        public void set_ans(int m, String k) {
            ans.set(m, k);
        }

        public ArrayList<String> get_ains() {
            return a_ins;
        }

        public void set_ains(int m, String k) {
            a_ins.set(m, k);
        }

        public ArrayList<String> get_qins() {
            return q_ins;
        }

        public void set_qins(int m, String k) {
            q_ins.set(m, k);
        }

    }

    public static void Submision(String h) {

        boolean l = false;
        for (int j = 0; j < Sub.size(); j++) {
            if (Sub.get(j).get_id().equals(h)) {
                l = true;
            }
        }

        if (l == false) {
            Submission s = new Submission(h);

            Sub.add(s);
        }

        int gh = 0;
        for (int v = 0; v < Assignment.size(); v++) {
            if (Assignment.get(v).get_status().equals("OPEN")) {
                gh++;
            }
        }

        int t = 0;
        for (int v = 0; v < Quiz.size(); v++) {
            if (Quiz.get(v).get_status().equals("OPEN")) {
                t++;
            }
        }

        int gm = 0;
        int u = 0;

        for (int j = 0; j < Sub.size(); j++) {
            if (Sub.get(j).get_id().equals(h)) {

                for (int yt = 0; yt < Assignment.size(); yt++) {

                    if ((Assignment.get(yt).get_status().equals("OPEN"))
                            && Sub.get(j).get_assign().get(yt).equals("SUBMITTED")) {
                        gm++;

                    }
                }
                for (int yt = 0; yt < Quiz.size(); yt++) {

                    if ((Quiz.get(yt).get_status().equals("OPEN"))
                            && Sub.get(j).get_qui().get(yt).equals("SUBMITTED")) {
                        u++;
                    }
                }
            }
        }

        if ((gm == gh) && (t == u)) {
            System.out.println("No pending assessments");
            return;
        }
        ArrayList<String> tem = new ArrayList<>();
        System.out.println("Pending assessments");
        int as = 0;
        int d = 0;
        for (int j = 0; j < Sub.size(); j++) {
            if (Sub.get(j).get_id().equals(h)) {
                for (int yt = 0; yt < Assignment.size(); yt++) {
                    if ((Assignment.get(yt).get_status().equals("OPEN"))
                            && Sub.get(j).get_assign().get(yt).equals("UNSUBMITTED")) {
                        System.out.println("ID: " + d + " Assignment:" + Assignment.get(yt).get_problem()
                                + " Max Marks:" + Assignment.get(yt).get_max());
                        tem.add(Assignment.get(yt).get_problem());
                        as++;
                        d++;
                    }
                }
                for (int yt = 0; yt < Quiz.size(); yt++) {

                    if ((Quiz.get(yt).get_status().equals("OPEN"))
                            && (Sub.get(j).get_qui().get(yt).equals("UNSUBMITTED"))) {
                        System.out.println("ID: " + d + " Question: " + Quiz.get(yt).get_problem());
                        tem.add(Quiz.get(yt).get_problem());
                        d++;
                    }
                }
            }
        }

        System.out.print("Enter ID of assessment:");
        int p = Integer.parseInt(scn.nextLine());
        String k = tem.get(p);
        if (p < as) {
            System.out.print("Enter filename of assignment:");
            String hj = scn.nextLine();
            int j = 0;
            for (int i = 0; i < hj.length(); i++) {
                if (hj.charAt(i) == '.') {
                    break;
                } else {
                    j++;
                }
            }

            if (hj.substring(j).equals(".zip")) {
                for (int x = 0; x < Sub.size(); x++) {
                    if (Sub.get(x).get_id().equals(h)) {
                        for (int yt = 0; yt < Assignment.size(); yt++) {
                            if (Assignment.get(yt).get_problem().equals(k)) {
                                Sub.get(x).set_assign(yt);
                                Sub.get(x).set_file(yt, hj);
                                Sub.get(x).set_ains(yt, h);
                            }
                        }
                    }
                }
            } else {
                System.out.println("File uploaded is not a zip file");
            }
        } else {
            System.out.print(k + " ");
            String lk = scn.nextLine();
            for (int x = 0; x < Sub.size(); x++) {
                if (Sub.get(x).get_id().equals(h)) {
                    for (int yt = 0; yt < Quiz.size(); yt++) {
                        if (Quiz.get(yt).get_problem().equals(k)) {
                            Sub.get(x).set_qui(yt);
                            Sub.get(x).set_ans(yt, lk);
                            Sub.get(x).set_qins(yt, h);
                        }
                    }
                }
            }

        }

    }

    public static void grade(String k) {
        System.out.println("List of assessments");
        int i;
        int y = 0;
        for (i = 0; i < Assignment.size(); i++) {
            System.out.println("ID: " + i + " Assignment: " + Assignment.get(i).get_problem() + " Max Marks: "
                    + Assignment.get(i).get_max());
            System.out.println("----------------");
            ;
            y++;
        }
        for (int l = 0; l < Quiz.size(); l++) {
            System.out.println("ID: " + i + " Question: " + Quiz.get(l).get_problem());
            System.out.println("----------------");
            i++;
        }
        System.out.print("Enter ID of assessment to view submissions:");
        int jk = Integer.parseInt(scn.nextLine());
        int yu = 0;
        boolean vf=false;
        if (jk < y) {
            ArrayList<String> f = new ArrayList<>();
            System.out.println("Choose ID from these ungraded submissions");
            for (int u = 0; u < Sub.size(); u++) {
                if ((Sub.get(u).assign.get(jk).equals("SUBMITTED")) && (Sub.get(u).amarks.get(jk) == -1)) {
                    System.out.println(yu + "." + Sub.get(u).get_id());
                    f.add(Sub.get(u).get_id());
                    yu++;
                    vf=true;
                }
            }
            if(vf==false){
                return;
            }

            int l = Integer.parseInt(scn.nextLine());
            for (int t = 0; t < Sub.size(); t++) {
                if (Sub.get(t).get_id() == f.get(l)) {
                    System.out.println("Submission:" + Sub.get(t).get_file().get(jk));
                    System.out.println("-------------------------------");
                    System.out.println("Max Marks:" + Assignment.get(jk).get_max());
                    System.out.print("Marks scored:");
                    int m = Integer.parseInt(scn.nextLine());
                    Sub.get(t).set_amarks(jk, m);
                    Sub.get(t).set_ains(jk, k);
                }
            }
        } else {
            jk = jk - y;
            
            ArrayList<String> f = new ArrayList<>();
            System.out.println("Choose ID from these ungraded submissions");
            for (int u = 0; u < Sub.size(); u++) {
                if ((Sub.get(u).get_qui().get(jk).equals("SUBMITTED")) && (Sub.get(u).get_qmarks().get(jk) == -1) ) {
                    System.out.println();
                    System.out.println(yu + "." + Sub.get(u).get_id());
                    f.add(Sub.get(u).get_id());
                    yu++;
                    vf = true;
                }
            }
            if(vf==false){
                return;
            }
            int l = Integer.parseInt(scn.nextLine());
            for (int t = 0; t < Sub.size(); t++) {
                if (Sub.get(t).get_id() == f.get(l)) {
                    System.out.println("Submission:" + Sub.get(t).get_ans().get(jk));
                    System.out.println("-------------------------------");
                    System.out.println("Max Marks:" + Quiz.get(jk).get_max());
                    System.out.print("Marks scored:");
                    int m = Integer.parseInt(scn.nextLine());
                    Sub.get(t).set_qmarks(jk, m);
                    Sub.get(t).set_qins(jk, k);
                    
                }
            }
        }
    }

    public static void view_grades(String h) {
        System.out.println("Graded submissions");
        for (int j = 0; j < Sub.size(); j++) {
            if (Sub.get(j).get_id().equals(h)) {
                for (int i = 0; i < Sub.get(j).get_amarks().size(); i++) {
                    if (Sub.get(j).get_amarks().get(i) != -1) {
                        System.out.println("Submission:" + Sub.get(j).get_file().get(i));
                        System.out.println("Marks scored:" + Sub.get(j).get_amarks().get(i));
                        System.out.println("Graded by:" + Sub.get(j).get_ains().get(i));
                    }
                }
                for (int i = 0; i < Sub.get(j).get_qmarks().size(); i++) {
                    if (Sub.get(j).get_qmarks().get(i) != -1) {
                        System.out.print("Submission:" + Sub.get(j).get_ans().get(i));
                        System.out.println("Marks scored:" + Sub.get(j).get_qmarks().get(i));
                        System.out.println("Graded by:" + Sub.get(j).get_qins().get(i));
                    }
                }
            }
        }
        System.out.println("----------------------------");
        System.out.println("Ungraded submissions");
        for (int j = 0; j < Sub.size(); j++) {
            if (Sub.get(j).get_id().equals(h)) {
                for (int i = 0; i < Sub.get(j).get_amarks().size(); i++) {
                    if ((Sub.get(j).get_amarks().get(i) == -1)
                            && (Sub.get(j).get_assign().get(i).equals("SUBMITTED"))) {
                        System.out.println("Submission:" + Sub.get(j).get_file().get(i));

                    }
                }

                for (int i = 0; i < Sub.get(j).get_qmarks().size(); i++) {
                    if ((Sub.get(j).get_qmarks().get(i) == -1) && (Sub.get(j).get_qui().get(i).equals("SUBMITTED"))) {
                        System.out.println("Submission:" + Sub.get(j).get_ans().get(i));
                    }
                }
            }

        }
        System.out.println("-----------------");
    }

    public static void main(String[] args) {
        int m = 0;
        while (m != 3) {
            System.out.println("Welcome to Backpack");
            System.out.println("1. Enter as instructor \n2. Enter as student \n3. Exit");
            int ch = Integer.parseInt(scn.nextLine());
            Instructor I0 = new Instructor("I0");
            Instructor I1 = new Instructor("I1");
            Student S0 = new Student("S0");
            Student S1 = new Student("S1");
            Student S2 = new Student("S2");
            switch (ch) {

                case 1: // Instructor
                    System.out.println("Instructors:\n0 - I0\n1 - I1");
                    System.out.print("Choose id:");
                    int id = Integer.parseInt(scn.nextLine());
                    int j = 0;
                    String s = "I" + id;
                    while (j != 9) {
                        System.out.println("Welcome I" + id);
                        System.out.println(
                                "INSTRUCTOR MENU \n1. Add class material\n2. Add assessments\n3. View lecture materials\n4. View assessments\n5. Grade assessments\n6. Close assessment\n7. View comments\n8. Add comments\n9. Logout");
                        j = Integer.parseInt(scn.nextLine());
                        switch (j) {
                            case 1:
                                System.out.println("1. Add Lecture Slide \n2. Add Lecture Video");
                                int y = Integer.parseInt(scn.nextLine());
                                if (y == 1) {
                                    slides(id);
                                } else if (y == 2) {
                                    video(id);
                                }
                                break;
                            case 2:
                                System.out.println("1. Add Assignment\n2. Add Quiz");
                                int c = Integer.parseInt(scn.nextLine());
                                if (c == 1) {
                                    System.out.print("Enter problem statement:");
                                    String h = scn.nextLine();
                                    System.out.print("Enter max marks:");
                                    int u = Integer.parseInt(scn.nextLine());
                                    Assignment a = new Assignment(u, h);
                                    Assignment.add(a);
                                } else if (c == 2) {
                                    System.out.print("Enter quiz question:");
                                    String b = scn.nextLine();
                                    Quiz jh = new Quiz(b);
                                    Quiz.add(jh);
                                }
                                break;
                            case 3:
                                I0.View_lecture_materials();
                                break;
                            case 4:
                                I0.View_assessments();
                                break;
                            case 5:
                                grade(s);

                                break;
                            case 6:
                                ArrayList<String> temp = new ArrayList<>();
                                System.out.println("List of Open Assignments:");
                                int i;
                                for (i = 0; i < Assignment.size(); i++) {
                                    if (Assignment.get(i).get_status().equals("OPEN")) {
                                        System.out.println("ID: " + i + "Assignment: " + Assignment.get(i).get_problem()
                                                + " Max Marks: " + Assignment.get(i).get_max());
                                        System.out.println("----------------");
                                        temp.add(Assignment.get(i).get_problem());
                                    }
                                }
                                for (int l = 0; l < Quiz.size(); l++) {
                                    if (Quiz.get(l).get_status().equals("OPEN")) {
                                        System.out.println("ID: " + i + "Question: " + Quiz.get(l).get_problem());
                                        System.out.println("----------------");
                                        temp.add(Quiz.get(l).get_problem());
                                        i++;
                                    }
                                }
                                System.out.print("Enter id of assignment to close:");
                                int h = Integer.parseInt(scn.nextLine());
                                String k = temp.get(h);
                                for (i = 0; i < Assignment.size(); i++) {
                                    if (Assignment.get(i).get_problem().equals(k)) {
                                        Assignment.get(i).set_status();
                                    }
                                }
                                for (i = 0; i < Quiz.size(); i++) {
                                    if (Quiz.get(i).get_problem().equals(k)) {
                                        Quiz.get(i).set_status();
                                    }
                                }
                                break;
                            case 7:
                                I0.View_comments();
                                break;
                            case 8:
                                I0.Add_comments(s);
                                break;
                            case 9:
                                j = 9;
                                break;
                            default:
                        }
                    }

                    break;

                case 2: // Student
                    System.out.println("Students:\n0 - S0\n1 - S1\n2 - S2");
                    System.out.print("Choose id:");
                    int u = Integer.parseInt(scn.nextLine());
                    String g = "S" + u;
                    int k = 0;
                    while (k != 7) {
                        System.out.println("Welcome " + g);
                        System.out.println(
                                "STUDENT MENU\n1. View lecture materials\n2. View assessments\n3. Submit assessment\n4. View grades\n5. View comments\n6. Add comments\n7. Logout");
                        int f = Integer.parseInt(scn.nextLine());
                        switch (f) {

                            case 1:
                                S0.View_lecture_materials();
                                break;
                            case 2:
                                S0.View_assessments();
                                break;
                            case 3:
                                Submision(g);
                                break;
                            case 4:
                                view_grades(g);
                                break;
                            case 5:
                                S0.View_comments();
                                break;
                            case 6:
                                S0.Add_comments(g);
                                break;
                            case 7:
                                k = 7;
                                break;
                            default:
                                System.out.println("Enter a Valid Number");
                        }
                    }

                    break;

                case 3:
                    // m=3;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Number");
            }

        }
    }
}
