pipeline {
    agent any
        tools {
        // Define the name of the Maven installation configured in Jenkins
        maven 'Maven-3.9.5'
    }
        triggers {
        pollSCM('*/15 * * * *') // Poll the SCM (Git) every 5 minutes
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
    }
}
