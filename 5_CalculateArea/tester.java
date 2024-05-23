import java.util.Scanner;

 class shape {
 

    int setarea(int side){
          return side*side;
    }
    
    float setarea(float radius){
        return 3.14F*radius * radius;
    }

    float setarea(int base,int height){
        return 0.5F * base* height;
    }
}

 class square extends shape{
    int side;
    void getdata(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value for side of square : ");
        side =sc.nextInt();

    }
}

class triangle extends shape{
    int base,height;
    void getdata(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value for base of triangle : ");
        base=sc.nextInt();
        System.out.println("Enter the value for height of triangle : ");
        height=sc.nextInt();

    }
}

class circle extends shape{
    float radius;
    void getdata(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value for radius of circle :");
        radius=sc.nextFloat();

    }
}

class tester {
    public static void main(String[] args) {
        
        circle c1 =new circle();
        square s1=new square();
        triangle t1= new triangle();

        c1.getdata();
        System.out.println("Area of circle "+ c1.setarea(c1.radius));

        s1.getdata();
        System.out.println("Area of square "+s1.setarea(s1.side));

        t1.getdata();
        System.out.println("Area of triangle "+ t1.setarea(t1.base,t1.height));
  }

}
