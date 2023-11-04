pipeline {
    agent any
    tools {
        maven 'Maven-3.9.5'
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], userRemoteConfigs: [[url: 'https://github.com/AlibekKhudoykulov/Jenkinst-test.git']]])
            }
        }
        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube-10.2.1') {
                    bat 'mvn sonar:sonar'
                }
            }
        }
        stage('Deploy to Tomcat') {
            steps {
               script {
                        def container = findContainerForContext([Tomcat10xAdapter.class], '/', 'http://localhost:8081', 'root', 'target/*.war')
                        container.get().deploy(['target/*.war'])
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
