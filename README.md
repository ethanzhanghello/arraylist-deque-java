# 📦 ArrayDeque – Java Circular Array Deque

## 📌 Table of Contents

- [Project Title](#project-title)
- [Project Description](#project-description)
- [Technologies Used](#technologies-used)
- [Requirements](#requirements)
- [Installation Instructions](#installation-instructions)
- [Usage Instructions](#usage-instructions)
- [Documentation](#documentation)
- [Visuals](#visuals)
- [Support Information](#support-information)
- [Project Roadmap](#project-roadmap)
- [Project Status](#project-status)
- [Contribution Guidelines](#contribution-guidelines)
- [Acknowledgments](#acknowledgments)
- [License Information](#license-information)

---

## 🏷️ Project Title

**ArrayDeque – Java Circular Buffer Deque**  
A high-performance deque data structure implemented with a resizable circular array, offering constant-time add/remove operations at both ends.

---

## 📖 Project Description

This project recreates a double-ended queue (deque) using an array-based circular buffer structure in Java. It handles dynamic resizing efficiently and ensures constant-time operations at the front and back. This custom implementation mirrors the behavior of Java’s built-in `ArrayDeque` and is built entirely from scratch.

---

## 💻 Technologies Used

- Java 8+
- Circular Buffer Design
- Java Interfaces & Generics
- Manual Array Management

---

## 📋 Requirements

- Java JDK 8 or later
- Java IDE (e.g., IntelliJ IDEA, Eclipse)
- Basic knowledge of Java generics and arrays

---

## ⚙️ Installation Instructions

```bash
git clone https://github.com/your-username/arraydeque-java.git
cd arraydeque-java
```

Open in your IDE and compile `ArrayDeque61B.java`.

---

## 🕹️ Usage Instructions

```java
ArrayDeque61B<Integer> deque = new ArrayDeque61B<>();
deque.addFirst(10);
deque.addLast(20);
System.out.println(deque.removeFirst()); // Outputs: 10
```

Add more items to trigger resizing and test deque growth/shrinkage.

---

## 📚 Documentation

- `ArrayDeque61B.java` – Implements a double-ended queue using a circular array
- `Deque61B.java` – Interface defining common deque operations
- `Maximizer61B.java` – Optional utility for testing max values from deques

Inline JavaDocs describe all public methods and implementation details.

---

## 🖼️ Visuals

*(Consider adding a diagram of the circular array, showing how indices wrap around and resizing is handled.)*

---

## 🛟 Support Information

- Issues: [GitHub Issues](https://github.com/your-username/arraydeque-java/issues)
- Email: `your-email@example.com`

---

## 🗺️ Project Roadmap

- ✅ Implement circular array with dynamic resizing
- ✅ Add basic deque operations and tests
- 🔄 Add iterator support for enhanced usability
- 🔜 Compare runtime with LinkedListDeque and standard library

---

## 📈 Project Status

**Completed**  
Fully functional and verified through example usage. Expansion is possible for benchmarking and interface extensions.

---

## 🤝 Contribution Guidelines

Want to contribute?
1. Fork the repository
2. Create a feature branch
3. Document and test your feature
4. Open a pull request with context and reasoning

---

## 🙌 Acknowledgments

- Inspired by UC Berkeley’s CS 61B curriculum
- Thanks to Java open-source communities for examples and interface patterns
- Special thanks to test reviewers and debugging buddies

---

## 📜 License Information

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.
