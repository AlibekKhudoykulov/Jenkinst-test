pipeline {
    agent any
        tools {
        // Define the name of the Maven installation configured in Jenkins
        maven 'Maven-3.9.5'
    }
    stages{
        stage('Build') {
            steps {
                // Compile and package the Maven project
                bat 'mvn clean package'
            }
        }

        stage('Run Tests') {
            steps {
                // Execute unit tests using Maven
                bat 'mvn test'
            }
        }
    }
}
