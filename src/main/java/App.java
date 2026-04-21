import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String fileName = "src/main/resources/" + "employees.csv";

        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufReader = new BufferedReader(reader);

            String input = bufReader.readLine();
            input = bufReader.readLine();

            while (input != null) {
                /*System.out.println("here's the line: " + input);*/
                String[] parts;

                parts = input.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String nameString = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);

                Employee newEmployee;

                newEmployee = new Employee();

                newEmployee.setId(id);
                newEmployee.setName(nameString);
                newEmployee.setHoursWorked(hoursWorked);
                newEmployee.setPayRate(payRate);
                newEmployee.calculateGrossPay();

                System.out.println("ID:  " + newEmployee.getId() + " Name: " + newEmployee.getName() + " Gross pay: " + newEmployee.calculateGrossPay());


                input = bufReader.readLine();

            }

        } catch (FileNotFoundException e) {
            System.err.println("I couldn't find the file named: " + fileName);
        } catch (IOException e) {
            System.err.println("IO Exception... I don't know what's is going on.");
        }
    }

}
