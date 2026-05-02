# IV1350 – Repair Electric Bike

Object-Oriented Design, KTH IV1350  
Seminar 3 – Implementation

## Project Members

- Alena Arsalan Amir – aaamir@kth.se
- Oscar Granath – osgr@kth.se
- Emilia Lindqvist – emilia4@kth.se

## About

This project implements the basic flow of the **Repair Electric Bike** scenario in Java, based on the object-oriented design from Seminar 2. The program follows the MVC and Layer architectural patterns and is divided into the following packages:

| Package | Description |
|---|---|
| `startup` | Contains `Main`, which creates all objects and starts the application |
| `view` | Simulates the user interface with hard-coded calls to the controller |
| `controller` | Mediates between the view and lower layers |
| `model` | Contains domain entities such as `RepairOrder` and `DiagnosticReport` |
| `model.dto` | Data transfer objects: `CustomerDTO` and `RepairOrderDTO` |
| `integration` | Handles data storage via `CustomerRegistry`, `RepairOrderRegistry`, `RegistryCreator`, and `Printer` |

## Requirements

- Java JDK 17 or later
- JUnit 5 standalone JAR (for running tests)

Download the JUnit JAR and place it in the `lib/` folder:  
 [junit-platform-console-standalone-1.10.0.jar](https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.0/junit-platform-console-standalone-1.10.0.jar)

## How to Run

### Windows (PowerShell)

Run the program:
```powershell
.\run.ps1
```

Run the tests:
```powershell
.\runTests.ps1
```

### Mac/Linux

Run the program:
```bash
bash run.sh
```

## Project Structure

```
IV1350_sem3/
├── src/
│   └── se/kth/iv1350/repairelectricbike/
│       ├── controller/
│       │   └── Controller.java
│       ├── integration/
│       │   ├── CustomerRegistry.java
│       │   ├── Printer.java
│       │   ├── RegistryCreator.java
│       │   └── RepairOrderRegistry.java
│       ├── model/
│       │   ├── Bike.java
│       │   ├── Customer.java
│       │   ├── DiagnosticReport.java
│       │   ├── RepairOrder.java
│       │   ├── RepairTask.java
│       │   └── dto/
│       │       ├── CustomerDTO.java
│       │       └── RepairOrderDTO.java
│       ├── startup/
│       │   └── Main.java
│       └── view/
│           └── View.java
├── test/
│   └── se/kth/iv1350/repairelectricbike/
│       ├── controller/
│       │   └── ControllerTest.java
│       ├── integration/
│       │   ├── CustomerRegistryTest.java
│       │   └── RepairOrderRegistryTest.java
│       └── model/
│           └── RepairOrderTest.java
├── lib/
│   └── junit-platform-console-standalone-1.10.0.jar (download separately)
├── run.ps1
├── runTests.ps1
└── .gitignore
```

## Sample Output

```
1. Find customer
   Customer found: Oscar
2. Create repair order
   Repair order created.
3. Find all repair orders
   ID: 1, Date: 2026-05-02, Problem: Battery dead, State: NEWLY CREATED
4. Add diagnostic result
   Diagnostic result added.
5. Add repair task
   Repair task added.
6. Accept repair order
Repair Order ID: 1
Date: 2026-05-02
Problem: Battery dead
State: ACCEPTED
Repair Tasks: [Replace battery]
Diagnostic Results: [ID: 1 - Replace dead battery]
   Repair order accepted.
```

## Test Results

```
[        22 tests found           ]
[         0 tests skipped         ]
[        22 tests started         ]
[         0 tests aborted         ]
[        22 tests successful      ]
[         0 tests failed          ]
```
