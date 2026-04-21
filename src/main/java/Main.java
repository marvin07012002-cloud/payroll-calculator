public class Main {

    public static void main(String[] args) {

        String line = "30|Brittany Thibbs|40|16.50";
        String[] parts= line.split("\\|");

        int id = Integer.parseInt(parts[0]);
        String nameString = parts[1];
        double hoursWorked = Double.parseDouble(parts[2]);
        double payRate = Double.parseDouble(parts[3]);

        Employee newEmployee1;

        newEmployee1 = new Employee();

        newEmployee1.setId(id);
        newEmployee1.setName(nameString);
        newEmployee1.setHoursWorked(hoursWorked);
        newEmployee1.setPayRate(payRate);

        System.out.println(newEmployee1.getName());









    }
}
