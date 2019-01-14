import java.util.Scanner;

public class BoxTester {

    private final Box box3;
    private final Box box5;

    public BoxTester() {
        box3 = new Box3(23,14,13);
        box5 = new Box5(39.5f,27.5f,23);
    }

    public static void main(String[] args) {

        BoxTester boxTester = new BoxTester();

        System.out.println("Post Box Checking System, type -1 to exit");
        System.out.println("=============================================");

        int exitCode=0;

        try {

            while(exitCode!=-1) {

                System.out.println("New Item");

                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter object's length");
                float length = scanner.nextInt();
                    if(length==-1)
                        break;

                System.out.println("Please enter object's width");
                float width = scanner.nextInt();
                    if(width==-1)
                        break;

                System.out.println("Please enter object's height");
                float height = scanner.nextInt();
                    if(height==-1)
                        break;

                if (boxTester.box3.validate(length, width, height)) {
                    System.out.println("Box3");
                } else if (boxTester.box5.validate(length, width, height)) {
                    System.out.println("Box5");
                } else {
                    System.out.println("You Item is too big to fit into our box");
                }

                System.out.println("---------------------------------");
            }


        }catch (Exception e){

            System.out.println("Please Enter a valid number");

        }
    }




}
