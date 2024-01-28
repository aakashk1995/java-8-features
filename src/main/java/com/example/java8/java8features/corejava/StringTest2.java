package com.example.java8.java8features.corejava;

import java.util.Optional;

public class StringTest2 {
    public static void main(String[] args) {
         String modelName = "a";
         String modelTypeName = null;
         Boolean sourceSystem = null;

         if(modelName!=null  && !"".equals(modelName) )
             System.out.println("add modelname");
         if(modelTypeName!=null)
             System.out.println("add modeltypename");
         if(sourceSystem!=null)
             System.out.println("add source system");

        Optional<Integer> op = Optional.empty();
        if(!op.isPresent())
            System.out.println("present");
        // print supplier
        System.out.println("Optional: " + op);

        // orElseGet supplier
        System.out.println("Value by orElseGet (Supplier) method: " + op.orElseGet(() -> (int)(Math.random() * 10)));

    }
}
