pipeline {
    agent any
        tools {
        // Define the name of the Maven installation configured in Jenkins
        maven 'Maven-3.9.5'
        sonarqube 'sonarqube-10.2.1'
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
        post {
            always {
                junit allowEmptyResults: true, testResults: '**/site/jacoco/jacoco.xml'
                publishCoverage(adapters: [jacocoAdapter('**/site/jacoco/jacoco.xml')])
            }
        }
    
    post {
    success {
        script {
            // Define SonarQube properties
            def sonarqubeScannerHome = tool 'SonarQubeScanner' // Use the tool name from Global Tool Configuration
            withSonarQubeEnv('SonarQubeServer') {
                bat "${sonarqubeScannerHome}/bin/sonar-scanner" // Execute the SonarQube analysis
            }
        }
    }
}
}
