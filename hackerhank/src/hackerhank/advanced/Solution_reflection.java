package hackerhank.advanced;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_reflection {
	public static void main(String[] args){
        Class<Add> student = Add.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method methodName : methods){
            methodList.add(methodName.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}
