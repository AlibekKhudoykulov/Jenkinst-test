pipeline {
    agent any
        tools {
        // Define the name of the Maven installation configured in Jenkins
        maven 'Maven-3.9.5'
    }
    

    stages{
         stage('Checkout') {
            steps {
                // Check out the Git repository
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], userRemoteConfigs: [[url: 'https://github.com/AlibekKhudoykulov/Jenkinst-test.git']]])
            }
        }
        stage('Run Tests') {
            steps {
                // Execute unit tests using Maven
                bat 'mvn test'
            }
        }
        stage('Build') {
            steps {
                // Compile and package the Maven project
                bat 'mvn clean package'
            }
        }
         stage('Publish Code Coverage') {
                    steps {
                        // Archive JaCoCo reports for display in Jenkins
                        publishHTML(target: [
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            keepAll: true,
                            reportDir: 'target/site/jacoco',
                            reportFiles: 'jacoco.csv',
                            reportName: 'JaCoCo Code Coverage'
                        ])
                    }
          }
    }
}
