import java.io.*;

public class App {
    public static void main(String[] args) {
        String fileName = "src/main/resources/" + "employees.csv";

        FileWriter fileWriter;

        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufReader = new BufferedReader(reader);

            String input = bufReader.readLine();
            input = bufReader.readLine();
            fileWriter = new FileWriter("src/main/resources/payroll.csv");
            fileWriter.write("id|name|gross pay"+"\n");
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


                fileWriter.write(newEmployee.getId()+ "|"+ newEmployee.getName()+ "|" + newEmployee.calculateGrossPay() + "\n"  );


            }
        fileWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("I couldn't find the file named: " + fileName);
        } catch (IOException e) {
            System.err.println("IO Exception... I don't know what's is going on.");
        }
    }

}
