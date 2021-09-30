pipeline{
    agent any
    tools {
        maven 'Maven'
    }
    parameters {
        create_artifacts: booleanParam(name: 'create artifact', defaultValue: false, description: 'create Artifact')
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
                stage('test') {
                    stages('component test')  {
                        stage {
                            steps {
                                sh 'mvn test'
                            }
                        }
                    stage('integration test') {
                        steps {
                             sh 'mvn verify -P inttest'
                        }
                    }
                    }
                }
            }
        }
        stage('create artifact') {
           when {
               expression {
                   params.create_artifacts
               }
           }
            steps {
                sh 'mvn install'
            }
        }
    }
}
