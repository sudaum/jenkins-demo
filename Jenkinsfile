pipeline{
    agent any
    tools {
        maven 'Maven'
    }
    parameters {
        booleanParam(name: 'CREATE_ARTIFACT', defaultValue: false, description: 'create Artifact')
    }
    stages {
        stage('build code') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('quality check') {
            parallel {
                stage('sonar') {
                    steps {
                        echo 'build code'
                    }
                }
                stage('component test') {
                    steps {
                        sh 'mvn test'
                    }
                }
                stage('integration test') {
                    steps {
                        echo 'integration test'
                    }
                }
            }
        }
        stage('create artifact') {
           when {
               expression {
                   env.CREATE_ARTIFACT
               }
           }
            steps {
                sh 'mvn install'
            }
        }
    }
}
