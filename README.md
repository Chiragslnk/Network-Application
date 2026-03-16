<h1 align="center">Java Network Application (MVC + Layered Architecture)</h1>

<p align="center">
A Java based <b>Client-Server Network Application</b> developed using 
<b>MVC Architecture</b> and <b>Layered Programming</b>.
</p>

<hr>

<h2>📌 Project Overview</h2>

<p>
This project implements a <b>Java Client-Server Network Application</b> designed with 
a <b>multi-layer architecture</b>. The system follows the <b>MVC design pattern</b> and 
separates responsibilities into different layers to improve maintainability and scalability.
</p>

<p>
The application integrates <b>MySQL database using JDBC</b> and supports 
<b>multithreaded request handling</b> on the server side.
</p>

<p>
<b>Special Feature:</b>  
Each layer is completely independent, allowing modifications in one layer 
without affecting other layers.
</p>

<hr>

<h2>🏗 Architecture</h2>

<p>The system follows a layered architecture consisting of:</p>

<ul>
<li><b>Presentation Layer</b> – User interface and client interaction</li>
<li><b>Business Layer</b> – Business logic and validation</li>
<li><b>Data Layer (DAO/DTO)</b> – Database communication using JDBC</li>
<li><b>Network Layer</b> – Client-Server communication using sockets</li>
</ul>

<hr>

<h2>⚙ Technologies Used</h2>

<ul>
<li>Java</li>
<li>Socket Programming</li>
<li>JDBC</li>
<li>MySQL</li>
<li>MVC Architecture</li>
<li>Layered Programming</li>
<li>Multithreading</li>
</ul>

<hr>

<h2>✨ Features</h2>

<ul>
<li>Client-Server Architecture</li>
<li>Layered Software Design</li>
<li>DAO / DTO pattern</li>
<li>Modular structure</li>
<li>Multithreaded request processing</li>
<li>MySQL database integration</li>
<li>Reusable libraries (JAR modules)</li>
<li>GUI based student management interface</li>
</ul>

<hr>

<h2>📂 Project Structure</h2>

<pre>
Network Application
│
├── Data Layer (amit2)
│   ├── dao
│   │   ├── StudentDAO
│   │   ├── DAOConnection
│   │   └── DatabaseConfiguration
│   │
│   ├── dto
│   │   └── StudentDTO
│   │
│   └── exceptions
│       └── DatabaseConfigurationException
│
├── Network-App
│
│   ├── Client-site
│   │   ├── dao
│   │   ├── dto
│   │   ├── exceptions
│   │   └── RequestSender
│   │
│   ├── Server-site
│   │   ├── SchoolAppServer
│   │   ├── RequestProcessor
│   │   └── StudentHandler
│   │
│   ├── Client-Server-Common
│   │   └── Protocol
│
│   └── learn
│       ├── RequestHandler
│       ├── StudentHandler
│       └── Protocol
│
├── Manager Layer
│   └── StudentManager
│
├── Application Layer
│   └── SchoolApplication
│
├── GUI
│   ├── StudentUI
│   └── StudentTableModel
│
└── Utility
    └── Keyboard Input Library
</pre>

<hr>

<h2>🔄 Request Flow</h2>

<p>The request flow of the application:</p>

<pre>
Client UI
   ↓
Client DAO
   ↓
Network Layer (RequestSender)
   ↓
Server
   ↓
Request Processor
   ↓
Student Handler
   ↓
Data Layer (DAO)
   ↓
MySQL Database
</pre>

<hr>

<h2>🚀 How to Run</h2>

<h3>1️⃣ Start MySQL</h3>

<p>Create the database and required table.</p>

<pre>
CREATE TABLE student(
    roll_number INT PRIMARY KEY,
    name VARCHAR(50),
    gender CHAR(1)
);
</pre>

<h3>2️⃣ Configure Database</h3>

Edit the <b>database.cfg</b> file:

<pre>
driver=com.mysql.cj.jdbc.Driver
connectionString=jdbc:mysql://localhost:3306/school
username=root
password=root
</pre>

<h3>3️⃣ Start Server</h3>

Run:

<pre>
start-server.bat
</pre>

<h3>4️⃣ Run Client Application</h3>

Execute the client or GUI application.

<hr>

<h2>🖥 GUI Interface</h2>

<p>The system also includes a graphical user interface for managing students.</p>

<ul>
<li>Add Student</li>
<li>Update Student</li>
<li>Delete Student</li>
<li>View Student List</li>
</ul>

<hr>

<h2>📚 Design Concepts Used</h2>

<ul>
<li>MVC Architecture</li>
<li>DAO Pattern</li>
<li>DTO Pattern</li>
<li>Socket Programming</li>
<li>Layered Architecture</li>
<li>Multithreaded Server</li>
</ul>

<hr>

<h2>👨‍💻 Author</h2>

<p>
Developed as a <b>Java Network Application Project</b> demonstrating
layered architecture, modular design, and client-server communication.
</p>

<hr>

<p align="center">
⭐ If you like this project, consider giving it a star on GitHub!
</p>
