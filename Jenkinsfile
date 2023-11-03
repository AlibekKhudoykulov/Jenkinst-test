pipeline {
    agent any
        tools {
        // Define the name of the Maven installation configured in Jenkins
        maven 'Maven-3.9.5'
        SonarQube scanner 'Sonarqube-5.0.1.3006'
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
        stage('SonarQube Analysis'){
            steps{
             withSonarQubeEnv('sonarqube-10.2.1'){
                 bat 'mvn sonar:sonar'
             }   
        }
       }
    }
        post {
            always {
                junit allowEmptyResults: true, testResults: '**/site/jacoco/jacoco.xml'
                publishCoverage(adapters: [jacocoAdapter('**/site/jacoco/jacoco.xml')])
            }
        }
    }

