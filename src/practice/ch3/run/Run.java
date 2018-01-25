package practice.ch3.run;

import org.junit.Test;
import practice.ch3.source.*;

import javax.imageio.stream.ImageOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Run {
    @Test
    public void q1And2Hq() {
        Measurable employee1 = new Employee("test1", 111.11);
        Measurable employee2 = new Employee("test2", 222.22);
        Measurable employee3 = new Employee("test3", 333.33);

        Measurable[] employees = { employee1, employee2, employee3 };

        HQ hq = new HQ();
        assertThat(hq.average(employees), is(222.22));
        assertThat(((Employee)hq.largest(employees)).getName(), is("test3"));
    }

    @Test
    public void q3GetSuperType() {
        System.out.println("String super class");
        System.out.println("\t" + String.class.getSuperclass());
        System.out.println("String stringInterfaces");
        Class<?>[] stringInterfaces = String.class.getInterfaces();
        Arrays.asList(stringInterfaces).forEach(c -> System.out.println("\t" + c.getName()));

        System.out.println();

        System.out.println("Scanner super class");
        System.out.println("\t" + Scanner.class.getSuperclass());
        System.out.println("Scanner  interfaces");
        Class<?>[] scannerInterfaces = Scanner.class.getInterfaces();
        Arrays.asList(scannerInterfaces).forEach(c -> System.out.println("\t" + c.getName()));

        System.out.println();

        System.out.println("ImageOutputStream super class");
        System.out.println("\t" + ImageOutputStream.class.getSuperclass());
        System.out.println("ImageOutputStream interfaces");
        Class<?>[] imageOutputStreamInterfaces = Scanner.class.getInterfaces();
        Arrays.asList(imageOutputStreamInterfaces).forEach(c -> System.out.println("\t" + c.getName()));
    }

    @Test
    public void q4Sequence() {
        Sequence sequence = IntSequenceObject.of(3, 1, 4, 1, 5, 9);

        while(sequence.hasNext()) {
            System.out.print(sequence.next() + " ");
        }
    }

    @Test
    public void q5InfinityConstantSequence() {
        InfinityConstantSequence sequence = IntSequenceObject.constant(10);
        int count = 0;
        while(sequence.hasNext()) {
            System.out.print(sequence.next());

            if(count++ == 100) break;
        }
    }

    @Test
    public void q6DigitSequence() {
        DigitSequence digitSequence = new DigitSequence(412332);
        digitSequence.remove();
        while (digitSequence.hasNext()) {
            System.out.print(digitSequence.next() + " ");
        }
    }

    @Test
    public void q7ShuffleSort() {
        ArrayList<String> numberStringList = new ArrayList<>();
        numberStringList.add("3");
        numberStringList.add("5");
        numberStringList.add("1");
        numberStringList.add("7");
        numberStringList.add("4");

        ShuffleSort.luckSort(numberStringList, String::compareTo);

        numberStringList.forEach(System.out::println);
    }

    @Test
    public void q8Greeter() {
        Greeter greeter1 = new Greeter(5, "test1");
        Greeter greeter2 = new Greeter(5, "test2");

        Thread thread1 = new Thread(greeter1);
        Thread thread2 = new Thread(greeter2);
        thread1.start();
        thread2.start();
    }

    @Test
    public void q9RunTask() {
        Runnable runnable1 = () -> System.out.println(1);
        Runnable runnable2 = () -> System.out.println(2);
        Runnable runnable3 = () -> System.out.println(3);
        Runnable runnable4 = () -> System.out.println(4);
        Runnable runnable5 = () -> System.out.println(5);

        System.out.println("/////////////// run together ///////////////");
        RunTask.runTogether(runnable1, runnable2, runnable3, runnable4, runnable5);

        System.out.println("/////////////// run in order ///////////////");
        RunTask.runInOrder(runnable1, runnable2, runnable3, runnable4, runnable5);
    }

    @Test
    public void q10SearchDirectory() {
        File[] subDirectoryList = FileUtils.searchAllSubDirectory("/Users/chori");
        System.out.println(subDirectoryList.length);

        for(File subDirectory : subDirectoryList) {
            System.out.println((subDirectory.isDirectory() ? "Directory : " : "File : ") + subDirectory.toString());
        }
    }

    @Test
    public void q11SearchFileForExtension() {
        String[] fileNames = FileUtils.searchFileForExtension("/Users/chori/IdeaProjects/algorithm/src", "java");

        System.out.println(fileNames.length);
        for (String name : fileNames) {
            System.out.println(name);
        }
    }

    @Test
    public void q12SortFile() {
        File current = new File("/Users/chori/IdeaProjects/algorithm");
        File[] files = current.listFiles();

        File[] shuffleFiles = new File[files.length];
        shuffleFiles[0] = files[1];
        shuffleFiles[1] = files[4];
        shuffleFiles[2] = files[6];
        shuffleFiles[3] = files[2];
        shuffleFiles[4] = files[3];
        shuffleFiles[5] = files[5];
        shuffleFiles[6] = files[0];

        for(File file : shuffleFiles) {
            System.out.println((file.isDirectory() ? "Directory : " : "File : ") + file.toString());
        }

        System.out.println("//////////// after sorting ////////////");
        FileUtils.sortFile(shuffleFiles);

        for(File file : shuffleFiles) {
            System.out.println((file.isDirectory() ? "Directory : " : "File : ") + file.toString());
        }
    }

    @Test
    public void q13GetRunTasks() {
        Runnable runnable1 = () -> System.out.println(1);
        Runnable runnable2 = () -> System.out.println(2);
        Runnable runnable3 = () -> System.out.println(3);
        Runnable runnable4 = () -> System.out.println(4);
        Runnable runnable5 = () -> System.out.println(5);

        Runnable runnable = RunTask.getRunTasks(new Runnable[]{runnable1, runnable2, runnable3, runnable4, runnable5});
        runnable.run();
    }

    @Test
    public void q14EmployeeSort() {
        Employee employee1 = new Employee("test1", 400.0);
        Employee employee2 = new Employee("test2", 320.1);
        Employee employee3 = new Employee("test3", 380.5);
        Employee employee4 = new Employee("test4", 320.1);
        Employee employee5 = new Employee("test5", 330.0);
        Employee employee6 = new Employee("test6", 380.5);

        Employee[] employees = new Employee[] {employee1, employee2, employee3, employee4, employee5, employee6};
        Employee[] sortedEmployees = new Employee[]{employee1, employee3, employee6, employee5, employee2, employee4};
        Employee[] reversSortedEmployees = new Employee[]{employee4, employee2, employee5, employee6, employee3, employee1};

        EmployeeSort.sortAsc(employees);
        assertArrayEquals(employees, sortedEmployees);


        EmployeeSort.sortDesc(employees);
        assertArrayEquals(employees, reversSortedEmployees);
    }

    @Test
    public void q15RandomNumberGenerator() {
        IntSequence generator = RandomNumberGenerator.randomInts(10, 100);

        int count = 0;
        while(generator.hasNext()) {
            count++;
            System.out.println(generator.next());

            if(count == 100) break;
        }
    }
}
