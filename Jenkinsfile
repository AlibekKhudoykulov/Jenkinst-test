pipeline {
    agent any
    stages{
        stage('Build') {
            steps {
                // Compile and package the Maven project
                sh 'mvn clean package'
            }
        }

        stage('Run Tests') {
            steps {
                // Execute unit tests using Maven
                sh 'mvn test'
            }
        }
    }
}