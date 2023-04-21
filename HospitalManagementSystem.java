package HospitalManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create multiple hospitals
        Hospital[] hospitals = new Hospital[3];
        hospitals[0] = new Hospital("Hospital A", "Mukherjee Hospital", "Siliguri", "WB");
        hospitals[1] = new Hospital("Hospital B", "Apollo Hospital", "Kolkata", "WB");
        hospitals[2] = new Hospital("Hospital C", "Maharaja Hospital", "Jalpaiguri", "WB");

        // Create patients with their personal details
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter patient details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("City: ");
            String city = scanner.nextLine();
            System.out.print("State: ");
            String state = scanner.nextLine();
            System.out.print("Department (Oncology/Neurology/Cardiology/Gynecology): ");
            Department department = Department.valueOf(scanner.nextLine().toUpperCase());

            // Assign patient to a hospital
            Patient patient = new Patient(name, age, phoneNumber, city, state, department);
            int randomIndex = (int) (Math.random() * hospitals.length);
            Hospital hospital = hospitals[randomIndex];
            hospital.addPatient(patient);
        }

        // Display hospital details with patients
        for (Hospital h : hospitals) {
            System.out.println(h);
        }

        scanner.close();
    }

}

enum Department {
    ONCOLOGY,
    NEUROLOGY,
    CARDIOLOGY,
    GYNECOLOGY
}

class Hospital {

    private String name;
    private String address;
    private String city;
    private String state;
    private List<Patient> patients;

    public Hospital(String name, String address, String city, String state) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.patients = new ArrayList<>();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public String toString() {
        String patientList = "";
        for (Patient p : patients) {
            patientList += "\n" + p;
        }
        return "Hospital Name: " + name + "\nAddress: " + address + "\nCity: " + city + "\nState: " + state
                + "\nPatient List:" + patientList + "\n";
    }

}

class Patient {

    private String name;
    private int age;
    private String phoneNumber;
    private String city;
    private String state;
    private Department department;

    public Patient(String name, int age, String phoneNumber, String city, String state, Department department) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
        this.department = department;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Phone Number: " + phoneNumber + ", City: " + city + ", State: "
                + state + ", Department: " + department;
    }

}
