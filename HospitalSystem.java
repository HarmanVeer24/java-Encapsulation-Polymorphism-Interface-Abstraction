// Main Class
public class HospitalSystem {
    public static void main(String[] args) {
        // Create a list of patients
        Patient[] patients = {
                new InPatient("P001", "Harman", 35, 5),
                new OutPatient("P002", "Anish", 45, "temprature"),
                new InPatient("P003", "Deepanshu", 28, 3),
                new OutPatient("P004", "Rahul", 60, "common cold")
        };

        // Process each patient and calculate their bill
        for (Patient patient : patients) {
            // Display patient details
            System.out.println(patient.getPatientDetails());

            // Calculate and display the bill for the patient
            System.out.println("Bill: $" + patient.calculateBill());

            // Demonstrating polymorphism with MedicalRecord interface
            if (patient instanceof MedicalRecord) {
                MedicalRecord medicalRecord = (MedicalRecord) patient;
                medicalRecord.viewRecords();
                medicalRecord.addRecord("Patient visited for checkup.");
            }
            System.out.println("-".repeat(40)); // Print separator
        }
    }
}

// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    // Constructor
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getter and setter methods (Encapsulation)
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Concrete method to get patient details
    public String getPatientDetails() {
        return "Patient ID: " + patientId + "\nName: " + name + "\nAge: " + age;
    }

    // Abstract method to calculate the bill
    public abstract double calculateBill();
}

// InPatient subclass
class InPatient extends Patient implements MedicalRecord {
    private static final double DAILY_ROOM_CHARGE = 200.0; // Room charge per day
    private int daysInHospital;

    // Constructor
    public InPatient(String patientId, String name, int age, int daysInHospital) {
        super(patientId, name, age);
        this.daysInHospital = daysInHospital;
    }

    @Override
    public double calculateBill() {
        return DAILY_ROOM_CHARGE * daysInHospital; // Only room charges for in-patients
    }

    @Override
    public void addRecord(String record) {
        System.out.println("Adding medical record: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Viewing medical records for " + getName());
    }

    // Getter and setter for days in hospital
    public int getDaysInHospital() {
        return daysInHospital;
    }

    public void setDaysInHospital(int daysInHospital) {
        this.daysInHospital = daysInHospital;
    }
}

// OutPatient subclass
class OutPatient extends Patient implements MedicalRecord {
    private static final double CONSULTATION_FEE = 100.0; // Consultation fee
    private String diagnosis;

    // Constructor
    public OutPatient(String patientId, String name, int age, String diagnosis) {
        super(patientId, name, age);
        this.diagnosis = diagnosis;
    }

    @Override
    public double calculateBill() {
        return CONSULTATION_FEE; // Out-patient has only consultation fee
    }

    @Override
    public void addRecord(String record) {
        System.out.println("Adding outpatient medical record: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Viewing outpatient medical records for " + getName());
    }

    // Getter and setter for diagnosis
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}

// MedicalRecord interface
interface MedicalRecord {
    void addRecord(String record); // Method to add a medical record
    void viewRecords(); // Method to view medical records
}

//output
// Patient ID: P001
//Name: Harman
//Age: 35
//Bill: $1000.0
//Viewing medical records for Harman
//Adding medical record: Patient visited for checkup.
//----------------------------------------
//Patient ID: P002
//Name: Anish
//Age: 45
//Bill: $100.0
//Viewing outpatient medical records for Anish
//Adding outpatient medical record: Patient visited for checkup.
//----------------------------------------
//Patient ID: P003
//Name: Deepanshu
//Age: 28
//Bill: $600.0
//Viewing medical records for Deepanshu
//Adding medical record: Patient visited for checkup.
//----------------------------------------
//Patient ID: P004
//Name: Rahul
//Age: 60
//Bill: $100.0
//Viewing outpatient medical records for Rahul
//Adding outpatient medical record: Patient visited for checkup.
//----------------------------------------