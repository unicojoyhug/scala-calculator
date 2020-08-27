# scala-calculator

## Study Case
* User stories
    * As a user of the calculator, I want to
        * be able to provide input to the calculator
        * be able to see the results of my inputs
        * do basic arithmetic (addition, subtraction, multiplication, and division)

* Requirement
    * Use SBT, the most widespread build tool in Scala
    * Create an executable delivery in a suitable format:
        * Mac or Linux executable
        * Single main method (runnable via sbt run)
        * Docker image with descriptions on how to run (Not implemented yet)
  
## Setup of application
* requirement: in order to use the current scalafx, we need **java 11**.
    * open in intellij : import it as sbt project with java 11 to run it.
    * running the application locally:  ```sbt run```
    * move to docker folder and assemble or run jar
        * assemble jar and run it : 
        ```
         cd docker
          ./assembly_run.sh
        ```
        * running with jar: 
        ```
         cd docker
        ./run_jar.sh 
        ```



