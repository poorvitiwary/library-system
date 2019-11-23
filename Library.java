import java.util.Scanner;
public class Library 
{
public static void main(String[] args) 
{

    Scanner sc = new Scanner(System.in);
    Books obj = new Books();
    Students std = new Students();
    int choice;
    int searchC=1;
    int s;
    try
    {
    do
    {
     System.out.println("Enter 1 to Add new Book.");
     System.out.println("Enter 2 to Upgrade Quantity of a Book.");
     System.out.println("Enter 3 to Search a Book.");
     System.out.println("Enter 4 to Show All Books.");
     System.out.println("Enter 5 to Register Student.");
     System.out.println("Enter 6 to Show All Registered Students.");
     System.out.println("Enter 7 to Check out  ");
     System.out.println("Enter 8 to Check In ");
     System.out.println("Enter 9 to exit");
        choice = sc.nextInt();
    
        switch(choice)
        {
             case 1:
                Book b = new Book();
                obj.addBook(b);
                break;

            case 2:
                obj.upgrade();
                break;

            case 3:
                System.out.println("Enter 1 for serial no or 0 for author name  ");
                s = sc.nextInt();
                if(s==1)
                {
                    obj.searchno();
                }
                else
                {
                    obj.searchname();
                }
                break;

            case 4:
                obj.showAllBooks();
                break;
            case 5:
                Student sm = new Student();
                std.addStudent(sm);
                break;
            case 6:
                std.showAllStudents();
                break;
            case 7:
                std.checkOutBook(obj);
                break;
            case 8:
                std.checkInBook(obj);
                break;
                case 9:
                return;
            default:
                System.out.println("wrong choice");

        }

    }
    while (searchC==1);
}
catch(Exception e)
{
    System.out.println("Error");
}
}
}


abstract class variable
{
    int serialno;
    String bookname;
    String authorname;
    int bookqty;
}
 class Book extends variable
 {

 
 int bookqtycopy;

Scanner sc = new Scanner(System.in);

 Book(){
    System.out.println("Enter Book Name:");
    this.bookname = sc.nextLine();
    System.out.println("Enter Author Name:"); 
    this.authorname = sc.nextLine();
    System.out.println("Enter Serial");
    this.serialno = sc.nextInt();
    System.out.println("Enter Quantity");
    this.bookqty = sc.nextInt();
    bookqtycopy = this.bookqty;

}
}

 class Books {

Book bk[] = new Book[10];    
 static int c;    

Scanner sc = new Scanner(System.in);




 int compareBook(Book b1, Book b2){

    if (b1.bookname.equals(b2.bookname)){

        System.out.println("Book Already Exists.");
        return 0;

    }
    if (b1.serialno==b2.serialno){

        System.out.println("Book Already Exists.");
        return 0;
    }
    return 1;
}

void addBook(Book b){

    for (int i=0; i<c; i++){

        if (this.compareBook(b, this.bk[i]) == 0)
            return;

    }

    if (c<10){

        bk[c] = b;
        c++;

    }
    else{

        System.out.println("No Space");

    }

}

public void searchno(){
    int sNo;
    System.out.println("Enter Serial No of Book:");
    sNo = sc.nextInt();
    int flag = 0;
    for (int i=0; i<c; i++){

        if (sNo == bk[i].serialno)
        {
            System.out.println("found");
            System.out.println(bk[i].serialno + "\t\t" + bk[i].bookname + "\t\t" + bk[i].authorname + "\t\t" + bk[i].bookqty);
            flag++;
            return;
        }

    }
    if (flag == 0)
        System.out.println("No Book for Serial No " + sNo + " Found.");
}

public void searchname()
{
    System.out.println("Enter Author Name:");
    String authorname = sc.nextLine();
    int flag = 0;
    for (int i=0; i<c; i++){

        if (authorname.equals(bk[i].authorname))
        {
            System.out.println("found");
            System.out.println("SERIAL NO       BOOK NAME       AUTHOR NAME       BOOK QTY");
            System.out.println("-------------------------------------------------------------------");
            System.out.println(bk[i].serialno + "\t\t" + bk[i].bookname + "\t\t" + bk[i].authorname + "\t\t" + bk[i].bookqty);
            flag++;
            return;
        }

    }
    if (flag == 0)
        System.out.println("No Books of " + authorname + " Found.");
}


public void showAllBooks(){

    System.out.println("books");
    System.out.println("SERIAL NO       BOOK NAME       AUTHOR NAME       BOOK QTY");
    System.out.println("-------------------------------------------------------------------");
    for (int i=0; i<c; i++){

        System.out.println(bk[i].serialno + "\t\t" + bk[i].bookname + "\t\t" + bk[i].authorname + "\t\t" + bk[i].bookqty);


    }

}

public void upgrade()
{
    int sNo;
    System.out.println("Enter Serial No of Book");
     sNo = sc.nextInt();
    for (int i=0; i<c; i++){

        if (sNo == bk[i].serialno){

            System.out.println("Enter No of Books to be Added:");
            int add = sc.nextInt();
            bk[i].bookqty += add;
            bk[i].bookqtycopy += add;
            return;

        }

    }

}
public int isAvailable(int sNo){

    



    for (int i=0; i<c; i++){

        if (sNo == bk[i].serialno){
            if(bk[i].bookqtycopy > 0){

                System.out.println("Book is Available.");
                return i;

            }
            System.out.println("Book is Unavailable");
            return -1;

        }

    }
    return -1;


}

public Book checkOutBook(){

    System.out.println("Enter Serial No of Book to be Checked Out.");
    int sNo = sc.nextInt();

    int bookIndex =isAvailable(sNo);

    if (bookIndex!=-1){
        bk[bookIndex].bookqty--;

        return bk[bookIndex];
    }

    return null;

}

public void checkInBook(Book b){

    for (int i=0; i<c; i++){

        if (b.equals(bk[i]) ){

            bk[i].bookqty++;
            return;

        }

    }

}

}

class Student {

String studentName;
String regNum;

Book borrowedBooks[] = new Book[3];
public int booksCount = 0;

Scanner sc = new Scanner(System.in);

Student(){

    System.out.println("Enter Student Name:");
    this.studentName = sc.nextLine();

    System.out.println("Enter Reg Number:");
    this.regNum = sc.nextLine();

}
}


 class Students {

Scanner sc = new Scanner(System.in);

Student theStudents[] = new Student[50];
public static int count = 0;

public void addStudent(Student s){

    for (int i=0; i<count; i++){

        if(s.regNum.equalsIgnoreCase(theStudents[i].regNum)){

            System.out.println("Student of Reg Num " + s.regNum + " is Already Registered.");
            return;
        }

    }

    if (count<50){

        theStudents[count] = s;
        count++;

    }

}
public void showAllStudents(){

    System.out.println("Student Name\t\tReg Number");
    System.out.println("-----------------------------------------------");
    for (int i=0; i<count; i++){

        System.out.println(theStudents[i].studentName + "\t\t         " + theStudents[i].regNum);

    }


}

public int isStudent(){

    System.out.println("Enter Reg Number:");
    String regNum = sc.nextLine();

    for (int i=0; i<count; i++){

        if (theStudents[i].regNum.equalsIgnoreCase(regNum)){

            return i;

        }

    }
    System.out.println("Student is not Registered.");
    System.out.println("Get Registered First.");


    return -1;

}
 void checkOutBook(Books book){
    int studentIndex =this.isStudent();

    if (studentIndex!=-1){
  

        book.showAllBooks();
        Book b = book.checkOutBook();
        System.out.println("checking out");
        if (b!= null){

            if (theStudents[studentIndex].booksCount<=3){
                System.out.println("adding book");
                theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount] = b;
                theStudents[studentIndex].booksCount++;
                
                return;

            }
            else {

                System.out.println("Student Can not Borrow more than 3 Books.");
                return;

            }
        }
        System.out.println("Book is not Available.");

    }

}

public void checkInBook(Books book){

    int studentIndex = this.isStudent();
    if (studentIndex != -1){
        System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");
        Student s = theStudents[studentIndex];
        for (int i=0; i<s.booksCount; i++){

            System.out.println(s.borrowedBooks[i].serialno+ "\t\t\t" + s.borrowedBooks[i].bookname + "\t\t\t"+
                    s.borrowedBooks[i].authorname);

        }
        System.out.println("Enter Serial Number of Book to be Checked In:");
        int sNo = sc.nextInt();
        for (int i=0; i<s.booksCount; i++){

            if (sNo == s.borrowedBooks[i].serialno){

                book.checkInBook(s.borrowedBooks[i]);
                s.borrowedBooks[i]=null;
                return;

            }


        }
        System.out.println("Book of Serial No "+sNo+"not Found");

    }



}


}