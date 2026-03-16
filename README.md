
Network Application
Network Application:-This project is developed in Java using layered programming. 
Build a Java-based client-server network application using MVC architecture with presentation layer,business layer, 
data layer and network layer, Integrating MySQL through JDBC and supporting multithreaded request handling. 
Speciality of this project is that we can change any layer without affecting another layer.

-------------------------------------------------->>>>>>>>>>>>>> Folder structure <<<<<<<<<<<<<<<<<<<<<<------------------------------------------------------------

├── amit2/ (4400 tokens)            // ----------------------DataLayer---------------------------- //
    ├── testcases/ (300 tokens)
    │   ├── javac
    │   ├── DAOConnectionTestCase.class
    │   ├── database.cfg
    │   └── DAOConnectionTestCase.java
    ├── lib/ (300 tokens)
    │   ├── ThinkingMachine-dl.jar
    │   ├── mysql-connector-java-8.0.20.jar
    │   └── ThinkingMachine-dl-Interfaces.jar
    ├── dist/ (100 tokens)
    │   └── ThinkingMachine-dl-Interfaces.jar
    ├── dependencies/ (200 tokens)
    │   ├── mysql-connector-java-8.0.20.jar
    │   └── ThinkingMachine-dl-Interfaces.jar
    ├── classes/ (500 tokens)
    │   └── com/ (500 tokens)
    │   │   └── thinkingmachine/ (500 tokens)
    │   │       └── dl/ (500 tokens)
    │   │           ├── dao/ (300 tokens)
    │   │               ├── StudentDAO.class
    │   │               ├── DAOConnection.class
    │   │               └── DatabaseConfiguration.class
    │   │           ├── dto/ (100 tokens)
    │   │               └── StudentDTO.class
    │   │           └── exceptions/ (100 tokens)
    │   │               └── DatabaseConfigurationException.class
    └── src/ (3000 tokens)
    │   └── com/ (3000 tokens)
    │       └── thinkingmachine/ (3000 tokens)
    │           └── dl/ (3000 tokens)
    │               ├── exceptions/ (100 tokens)
    │                   └── DatabaseConfigurationException.java
    │               ├── dto/ (200 tokens)
    │                   └── StudentDTO.java (200 tokens)
    │               └── dao/ (2700 tokens)
    │                   ├── DatabaseConfiguration.java (300 tokens)
    │                   ├── DAOConnection.java (700 tokens)
    │                   └── StudentDAO.java (1700 tokens)
├── Network-App/ (14400 tokens)
    ├── Client-site/ (5700 tokens)
    │   ├── testcases/ (1900 tokens)--------------------------------Write TestCases--------------------------------------------------------------------------
    │   │   ├── javac
    │   │   ├── server.cfg
    │   │   ├── TestExists.class
    │   │   ├── TestAddStudent.class
    │   │   ├── TestGetStudents.class
    │   │   ├── TestRemoveStudent.class
    │   │   ├── TestUpdateStudent.class
    │   │   ├── TestGetByRollNumber.class
    │   │   ├── cmp.bat
    │   │   ├── TestRemoveStudent.java (200 tokens)
    │   │   ├── TestExists.java (200 tokens)
    │   │   ├── TestAddStudent.java (200 tokens)
    │   │   ├── TestUpdateStudent.java (200 tokens)
    │   │   ├── TestGetByRollNumber.java (200 tokens)
    │   │   └── TestGetStudents.java (200 tokens)
    │   ├── dependencies/ (200 tokens)
    │   │   ├── Client-Server-Common.jar
    │   │   └── ThinkingMachine-dl-Interfaces.jar
    │   ├── classes/ (600 tokens)
    │   │   └── com/ (600 tokens)
    │   │   │   └── thinkingmachine/ (600 tokens)
    │   │   │       ├── dl/ (500 tokens)
    │   │   │           ├── dao/ (300 tokens)
    │   │   │           │   ├── StudentDAO.class
    │   │   │           │   ├── ServerConnection.class
    │   │   │           │   └── ServerConfiguration.class
    │   │   │           ├── dto/ (100 tokens)
    │   │   │           │   └── StudentDTO.class
    │   │   │           └── exceptions/ (100 tokens)
    │   │   │           │   └── ServerConfigurationException.class
    │   │   │       └── net/ (100 tokens)
    │   │   │           └── RequestSender.class
    │   └── src/ (3000 tokens)
    │   │   └── com/ (3000 tokens)
    │   │       └── thinkingmachine/ (3000 tokens)
    │   │           ├── net/ (500 tokens)
    │   │               ├── cmp.bat
    │   │               └── RequestSender.java (400 tokens)
    │   │           └── dl/ (2500 tokens)
    │   │               ├── dao/ (1900 tokens)
    │   │                   ├── cmp.bat
    │   │                   ├── ServerConfiguration.java (200 tokens)
    │   │                   ├── ServerConnection.java (500 tokens)
    │   │                   └── StudentDAO.java (1100 tokens)
    │   │               ├── dto/ (400 tokens)
    │   │                   ├── cmp.bat
    │   │                   └── StudentDTO.java (300 tokens)
    │   │               └── exceptions/ (200 tokens)
    │   │                   ├── cmp.bat
    │   │                   └── ServerConfigurationException.java
    ├── learn/ (3900 tokens)  -------------------------->>>>>>>>>>  Modules(we can also write multiple modules)  <<<<<<<<<------------------------------------------------------
    │   ├── RequestHandler.java
    │   ├── Tester.class
    │   ├── Protocol.class
    │   ├── BabuHandler.class
    │   ├── RequestHandler.class
    │   ├── StudentHandler.class
    │   ├── database.cfg
    │   ├── BabuHandler.java
    │   ├── Protocol.java
    │   ├── Tester.java (200 tokens)
    │   └── StudentHandler.java (2800 tokens)
    ├── database.cfg
    ├── Server-site/ (4300 tokens)
    │   ├── dependencies/ (400 tokens)
    │   │   ├── Client-Server-Common.jar
    │   │   ├── ThinkingMachine-dl.jar
    │   │   ├── mysql-connector-java-8.0.20.jar
    │   │   └── ThinkingMachine-dl-Interfaces.jar
    │   ├── src/ (3500 tokens)
    │   │   └── com/ (3500 tokens)
    │   │   │   └── ThinkingMachine/ (3500 tokens)
    │   │   │       └── Server/ (3500 tokens)
    │   │   │           ├── RequestHandler.java
    │   │   │           ├── cmp.bat
    │   │   │           ├── SchoolAppServer.java (600 tokens)
    │   │   │           ├── RequestProcessor.java (600 tokens)
    │   │   │           └── StudentHandler.java (2100 tokens)
    │   └── classes/ (400 tokens)
    │   │   └── com/ (400 tokens)
    │   │       └── thinkingmachine/ (400 tokens)
    │   │           └── server/ (400 tokens)
    │   │               ├── RequestHandler.class
    │   │               ├── RequestProcessor.class
    │   │               ├── SchoolAppServer.class
    │   │               └── StudentHandler.class
    ├── Client-Server-Common/ (300 tokens)
    │   ├── dist/ (100 tokens)
    │   │   └── Client-Server-Common.jar
    │   ├── classes/ (100 tokens)
    │   │   └── com/ (100 tokens)
    │   │   │   └── client/ (100 tokens)
    │   │   │       └── server/ (100 tokens)
    │   │   │           └── protocol/ (100 tokens)
    │   │   │               └── Protocol.class
    │   └── src/ (100 tokens)
    │   │   └── com/ (100 tokens)
    │   │       └── client/ (100 tokens)
    │   │           └── server/ (100 tokens)
    │   │               └── protocol/ (100 tokens)
    │   │                   └── Protocol.java
    └── start-server.bat
├── DataView.png
├── Bobby/ (2100 tokens)
    ├── lib/ (300 tokens)
    │   ├── io-utils.jar
    │   ├── ThinkingMachine-dl.jar
    │   └── ThinkingMachine-dl-Interfaces.jar
    ├── dist/ (100 tokens)
    │   └── School-Manager.jar
    ├── classes/ (100 tokens)
    │   └── com/ (100 tokens)
    │   │   └── thinkingmachine/ (100 tokens)
    │   │       └── manager/ (100 tokens)
    │   │           └── StudentManager.class
    └── src/ (1600 tokens)
    │   └── com/ (1600 tokens)
    │       └── thinkingmachine/ (1600 tokens)
    │           └── manager/ (1600 tokens)
    │               └── StudentManager.java (1600 tokens)
├── Chetan/ (900 tokens)
    ├── dist/ (100 tokens)
    │   └── School.jar
    ├── lib/ (400 tokens)
    │   ├── io-utils.jar
    │   ├── School-Manager.jar
    │   ├── ThinkingMachine-dl.jar
    │   └── ThinkingMachine-dl-Interfaces.jar
    ├── classes/ (100 tokens)
    │   └── com/ (100 tokens)
    │   │   └── thinkingmachine/ (100 tokens)
    │   │       └── SchoolApplication.class
    └── src/ (300 tokens)
    │   └── com/ (300 tokens)
    │       └── thinkingmachine/ (300 tokens)
    │           └── SchoolApplication.java (300 tokens)
├── Yogesh/ (3600 tokens)
    ├── dist/ (100 tokens)
    │   └── io-utils.jar
    ├── classes/ (200 tokens)
    │   └── com/ (200 tokens)
    │   │   └── io/ (200 tokens)
    │   │       └── util/ (200 tokens)
    │   │           ├── Keyboard.class
    │   │           └── KeyboardInputException.class
    ├── src/ (1700 tokens)
    │   └── com/ (1700 tokens)
    │   │   └── io/ (1700 tokens)
    │   │       └── util/ (1700 tokens)
    │   │           ├── KeyboardInputException.java
    │   │           └── Keyboard.java (1600 tokens)
    └── DocYog..txt (1600 tokens)
├── maa/ (4900 tokens)-----------------------------------------Application user-------------------------------------------------------------------------------
    ├── SchoolApp/ (700 tokens)
    │   ├── School.jar
    │   ├── io-utils.jar
    │   ├── School-Manager.jar
    │   ├── ThinkingMachine-dl.jar
    │   ├── mysql-connector-java-8.0.20.jar
    │   ├── ThinkingMachine-dl-Interfaces.jar
    │   └── database.cfg
    ├── database.cfg
    └── Bobby,Chetan&maa.txt (4100 tokens)
├── GUI/ (2400 tokens)-----------------------------------------------------user interface---------------------------------------------------------------------
    ├── testcases/ (300 tokens)
    │   ├── StudentUITestCase.class
    │   ├── database.cfg
    │   └── StudentUITestCase.java
    ├── dependencies/ (300 tokens)
    │   ├── ThinkingMachine-dl.jar
    │   ├── mysql-connector-java-8.0.20.jar
    │   └── ThinkingMachine-dl-Interfaces.jar
    ├── src/ (1400 tokens)
    │   └── com/ (1400 tokens)
    │   │   └── thinkingmachine/ (1400 tokens)
    │   │       ├── icons/ (100 tokens)
    │   │           └── Student.jpg
    │   │       ├── StudentTableModel.java (500 tokens)
    │   │       └── StudentUI.java (800 tokens)
    └── classes/ (400 tokens)
    │   └── com/ (400 tokens)
    │       └── thinkingmachine/ (400 tokens)
    │           ├── StudentUI.class
    │           ├── StudentUI$1.class
    │           ├── icons/ (100 tokens)
    │               └── Student.jpg
    │           └── StudentTableModel.class
└── superman/ (7000 tokens)
    ├── dist/ (100 tokens)
        └── ThinkingMachine-dl-Interfaces.jar
    ├── classes/ (300 tokens)
        └── com/ (300 tokens)
        │   └── thinkingmachine/ (300 tokens)
        │       └── dl/ (300 tokens)
        │           ├── exceptions/ (100 tokens)
        │               └── DAOException.class
        │           └── interfaces/ (200 tokens)
        │               ├── dao/ (100 tokens)
        │                   └── StudentDAOInterface.class
        │               └── dto/ (100 tokens)
        │                   └── StudentDTOInterface.class
    ├── src/ (400 tokens)
        └── com/ (400 tokens)
        │   └── thinkingmachine/ (400 tokens)
        │       └── dl/ (400 tokens)
        │           ├── exceptions/ (100 tokens)
        │               └── DAOException.java
        │           └── interfaces/ (300 tokens)
        │               ├── dto/ (100 tokens)
        │                   └── StudentDTOInterface.java
        │               └── dao/ (200 tokens)
        │                   └── StudentDAOInterface.java (200 tokens)
