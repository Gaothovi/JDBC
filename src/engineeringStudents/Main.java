package engineeringStudents;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
	
	       // Create a new record
	List<Integer> Teacher_id = Arrays.asList(8204817, 4792037, 5038688, 8903768);
		List<String> First_Name = Arrays.asList("John", "Maria", "Ana", "Daniel");
		List<String> Last_Name = Arrays.asList("Doe", "Sánchez", "Aguado", "Rodríguez");
		List<String> Department = Arrays.asList("IT", "Accounting", "Geography", "Political history");
		List<String> Subject = Arrays.asList("Databases", "Auditing", "Climatology", "Modern history");
        CRUD.createRecord(Teacher_id, First_Name, Last_Name, Department, Subject);

        // Read records
        CRUD.readRecords();

        // Update a record
        int Teacher_id1 = 4792037;
        String First_Name_Updated = "Saul";
        String Last_Name__Updated = "Goodman";
        String Department__Updated = "Chemistry";
        String Subject__Updated = "Organic chemistry";
        CRUD.updateRecord(Teacher_id1, First_Name_Updated, Last_Name__Updated, Department__Updated, Subject__Updated);

        // Delete a record
        CRUD.deleteRecord(8903768);
    }
}

	
