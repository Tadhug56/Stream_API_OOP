//JAKOB HUTTER

import java.util.*;
import java.util.stream.*;
import java.util.Random;  //for Bonus


public class StreamCalculator_solution {

    //Q1.
    List <Integer> list;
    public StreamCalculator_solution(List <Integer> inputList) {
        this.list = inputList;
    }
    //Q1.2
    public Stream<Integer> getStream() {
        return list.stream();
    }
    public List<Integer> getList() {
        return list;
    }
    //Q1.3
    public List<Integer> streamToList (Stream<Integer> inputStream) {
        return inputStream.collect(Collectors.toList());
    }

    //Q2.1
    public void sort() {
        // list = list.stream().sorted().collect(Collectors.toList());
        list = streamToList(getStream().sorted());
    }
    //Q2.2
    public void filter(Integer start, Integer end) {
        //list = list.stream().filter(x -> x >= start && x <= end).collect(Collectors.toList());
        list = streamToList(getStream().filter(x -> x >= start && x <= end));
    }

    //Q2.3
    public void add(Integer value) {
        //list = list.stream().map(x -> x + value).collect(Collectors.toList());
        list = streamToList(getStream().map(x -> x + value));
    }

    //Q3
    public void print (String separator) {
        getStream().forEach(s -> System.out.print(s + separator));
        System.out.println();
    }

    //Q4.1
    public Integer sum() {
        // list.stream()
        return getStream().reduce(0, (x, y) -> x + y);
    }
    //Q4.2
    public Integer product() {
        // list.stream()
        return getStream().reduce(1, (x,y)-> x*y);
    }

    //Q5
    public Integer addAndSum(Integer value) {
        return list.stream()
                .map(x -> x + value)
                .reduce(0, (x, y) -> x + y);
    }

    //Bonus:
    // Parallel Stream Example: Calculate the sum using a parallel stream
    public Integer sumParallel() {
        return list.parallelStream().reduce(0, Integer::sum);
    }


    public  static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(17, 11, 19, 13, 43, 37, 41, 31, 29, 97, 5, 3, 7, 23);

        StreamCalculator_solution calc = new StreamCalculator_solution(numbers);
        if (calc.streamToList(calc.getStream()).equals(numbers)) {
            System.out.println("getStream and streamToList work as intended");
        } else {
            System.out.println("getStream and streamToList failed");
        }

        calc.filter(2,30);
        System.out.println(calc.getList());

        calc.print(", ");

        System.out.println(calc.sum());

        calc.filter(2,10);
        System.out.println(calc.product());

        System.out.println(calc.addAndSum(20));
        calc.print("\n");

        List<Integer> randomNumbers = new ArrayList<>();

        //Bonus
        Random random = new Random();
        // Loop to generate 100 random numbers between 1 and 99
        for (int i = 0; i < 100; i++) {
            // Generate a random number in the range [1, 99]
            int number = random.nextInt(99) + 1; // nextInt(99) generates a number from 0 to 98
            // Add the number to the list
            randomNumbers.add(number);
        }
        StreamCalculator_solution calcBonus = new StreamCalculator_solution(randomNumbers);
        if (calcBonus.sum().equals(calcBonus.sumParallel())) {
            System.out.println("sum parallel work as intended");
        } else {
            System.out.println("sum parallel failed");
        }
    }
}
