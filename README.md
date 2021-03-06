<p align="center">
  <a href="" rel="noopener">
 <img width=200px height=200px src="https://i.imgur.com/6wj0hh6.jpg" alt="Project logo"></a>
</p>

<h3 align="center">Second exercise</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![GitHub Issues](https://img.shields.io/github/issues/laguileraab/secondex.svg)](https://github.com/laguileraab/secondex/issues)
[![GitHub Pull Requests](https://img.shields.io/github/issues-pr/laguileraab/secondex.svg)](https://github.com/laguileraab/secondex/pulls)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

---

<p align="center"> This is a project for reading a public leak file that is necessary to process to be able to ingest that information into a system. The program consume a text file and return output to STDOUT. The input file represents a list of places and people at different times.
    <br> 
</p>

## 📝 Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Deployment](#deployment)
- [Usage](#usage)
- [Built Using](#built_using)
- [Contributing](../CONTRIBUTING.md)
- [Authors](#authors)
- [Acknowledgments](#acknowledgement)

## 🧐 About <a name = "about"></a>

Nothing to say here.

## 🏁 Getting Started <a name = "getting_started"></a>

There are two distinct formats mixed in the same file

Format details:

Each line starts with F or D.
  - If F, this is a "format" line and two formats can be provided (F1 or F2) 
  - If D, this is a "data" line whose format is defined by the closest above format line. 
  - If "F1" is specified, you can expect these fields separated with a comma:
  
  1. D defining a data line

  2. Name and surname

  3. City

  4. ID formatted as "12345678Z"


- If "F2" is specified, you can expect these fields separated with space-semicolon-space:

1. D defining a data line

2. Name and surname

3. City

4. ID formatted as "12345678-Z"

### Prerequisites

Is necessary to have installed Java >= 17 and Maven

[Java](https://www.java.com)
```bash
java --version
```

[Maven](https://maven.apache.org)
```bash
mvn --version
```

### Installing

The next steps are for generating Jar file inside the folder of the projects where is pom.xml file.

First we clean mvn for old target classes
```bash
mvn clean
```

And then make the package .jar

```bash
mvn package
```

And everything is ready.

## 🔧 Running the tests <a name = "tests"></a>

This project was made with Java and BDD, I use [Gherkin](https://cucumber.io/docs/gherkin) with [Cucumber](https://cucumber.io)

### We need a feature file

Gherkin is written using a feature file and can be written in almost any natural language like English, Spanish, French, etc.

```bash
Feature: Java Code Test


  @Public_leak_file
  Scenario Outline: This scenario will test for correct format in a text file
    Given this "input" with an extension ".txt" in the path "C:/"
    When found "<format>"
    Then divider is "<separator>"
    And ID format must be like "<IDF>"

    Examples:
      | format | separator | IDF                                            |
      | f1     |  ,        | [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-Z]  |
      | f2     |  ;        | [0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z] |

```

### Perform test scenarios

We can run this test with Gradle , Ant, etc but we use maven in this case like below.

```bash
mvn clean test
```

## 🎈 Usage of the app<a name="usage"></a>

The system can take 3 parameters.

-Input file, necessary only the first time, then we keep track of the Folder Path with a Temp file, we only keep track of one file.

-FilterType, this can be the City, Name or Id (case insensitive), if not set there's no output.

-Filter, this can be the City, Name or Id, necessary to specified the filterType.


```bash
java -jar .\target\secondex-1.0.0-SNAPSHOT.jar input.txt City barcelona
```

### Output

```bash
Rhonda Hopkins,54315871Z
Erica Burns,93654902Y
Renee Anderson,44340637H
Lowell Miles,04217040J
Russell Pope,69429384C
Shelley Payne,54808168L
Johnathan Cooper,10863096N
Peter Daniel,58204706D
Ruben Daniels,84604786E
Emilio Warner,23803975X
```

## ⛏️ Built Using <a name = "built_using"></a>

- [Java](https://www.java.com/) - Programming language
- [Cucumber](https://www.cucumber.io/) - BDD Framework
- [Gherkin](https://www.cucumber.io/docs/gherkin) - DSL programming language

## ✍️ Authors <a name = "authors"></a>

- [@laguileraab](https://github.com/laguileraab) - Idea & Initial work


<!--
## 🎉 Acknowledgements <a name = "acknowledgement"></a>
- References

-->
