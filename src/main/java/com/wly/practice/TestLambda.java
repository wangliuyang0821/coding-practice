package com.wly.practice;

import com.wly.beans.Employee;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author W.L.Y
 * @用途:
 * @版本时间:2021/7/13
 * @备注:
 */
public class TestLambda {
    public static void main(String[] args) {

    }

    public void test1(){
        Runnable r = () -> System.out.println("h");
        r.run();
    }

    public void Test(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    public void Test1(){
        Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //获取当前age>35
    List<Employee> list = Arrays.asList(
            new Employee("张三",18,9998),
            new Employee("李四",38,79),
            new Employee("王五",50,99),
            new Employee("赵六",16,9),
            new Employee("田七",8,9995)
    );

    public List<Employee> filterEmployee(List<Employee> list){
        List<Employee> employees = new ArrayList<>();

        for(Employee e : list){
            if(e.getAge() > 35){
                employees.add(e);
            }
        }
        return employees;
    }

    public void Test2(){
        list.stream().filter((e) -> e.getSalary() < 35).forEach(System.out::println);

        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("11");
    }

    public void Test3(){

        Comparator<Integer> com = (Integer x,Integer y) -> {
            System.out.println("3242");
            return Integer.compare(x,y);
        };
    }

}
