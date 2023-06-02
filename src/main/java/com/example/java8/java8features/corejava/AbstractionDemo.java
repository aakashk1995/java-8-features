package com.example.java8.java8features.corejava;

interface Mobile{
    void calling(String mobileNo);
    void sendingMessage(String message);

}
class  Apple implements Mobile{


    @Override
    public void calling(String mobileNo) {
        System.out.println("Calling " + mobileNo);
    }

    @Override
    public void sendingMessage(String message) {

    }
}
public class AbstractionDemo {
    public static void main(String[] args) {
        Mobile mobile = new Apple();
        mobile.calling("21312312313");
    }
}
