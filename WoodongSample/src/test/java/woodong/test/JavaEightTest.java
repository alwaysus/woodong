package woodong.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import org.junit.Test;

import woodong.test.bean.Employee;

public class JavaEightTest {

	@Test
	public void employeeTest() {
		List<Employee> emps = Arrays.asList(new Employee[] {new Employee("woo", 10000), new Employee("lee", 8000), new Employee("kim", 6000)});

		OptionalDouble avgOpt = emps.stream()
												.filter(emp -> emp.getSalary() > 4000)
												.mapToInt(emp -> emp.getSalary())
												.average();

		System.out.println(avgOpt.getAsDouble());
	}

	@Test
	public void employeeFileTest() {
		Path path = Paths.get("src/test/resources/employees.txt");

		try (Stream<String> lines = Files.lines(path)) {
			OptionalDouble avgOpt = lines
													.map(line -> new Employee(line.split("/")[0], Integer.valueOf(line.split("/")[1])))
													.filter(emp -> emp.getSalary() > 6000)
													.mapToInt(emp -> emp.getSalary())
													.average();

			System.out.println(avgOpt.getAsDouble());

			Stream<Employee> emps = Files.lines(path)
														.map(line -> new Employee(line.split("/")[0], Integer.valueOf(line.split("/")[1])))
														.filter(emp -> emp.getSalary() > 6000);

			emps.forEach(emp -> {System.out.println(emp.getName() + " / " + emp.getSalary());});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}