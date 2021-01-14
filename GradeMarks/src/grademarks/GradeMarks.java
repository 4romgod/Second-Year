
package grademarks;


import java.util.*;
public class GradeMarks {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
        String name, surname;
        String studentNo;       //this can also be digits
        String grade;
        
        int mark;
        
        System.out.print("Enter your name: ");
        name=input.nextLine();
        System.out.print("Enter your surname: ");
        surname=input.nextLine();
        System.out.print("Enter your student number: ");
        studentNo=input.nextLine();
        
        System.out.println();
        
        System.out.print("Enter your mark: ");
        mark=input.nextInt();
        
        System.out.println();
        
        if(mark>=75){
            grade="A";
        }
        else if((mark>60)&&(mark<75)){
            grade="B";
        }
        else if ((mark>=50)&&(mark<60)){
            grade="C";
        }
        else{
            grade="D";
        }
        
        System.out.printf("Full name: %s %s\nStudent No: %s\nYour grade for your %d mark is %s",name, surname, studentNo, mark, grade);
        System.out.println();
    }
    
}
