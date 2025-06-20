public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger l1=Logger.getInstance();
        Logger l2=Logger.getInstance();

        l1.log("app start");
        l2.log("doing something");

        if(l1==l2){
            System.out.println("same instance");
        }else{
            System.out.println("different");
        }
    }
}
