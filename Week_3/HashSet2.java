package Week_3;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HashSet2 {
    public static void main(String[] args) {
        Set<String> students = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the names of students who have attended the course (enter 'q' to quit):");
        while (true) {
            System.out.print("Name: ");
            String name = sc.nextLine();
            if (name.equals("None")) {
                break;
            }
            students.add(name);
        }

        Set<String> sortedStudents = new TreeSet<>(students);

        System.out.println("\nStudents who have attended the course:");
        for (String name : sortedStudents) {
            System.out.println(name);
        }
        System.out.println("\nTotal number of students: " + sortedStudents.size());
    }
}
