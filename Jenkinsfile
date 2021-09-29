pipeline{
    agent any
    parameters {
        booleanParam(name: 'CREATE_ARTIFACT', defaultValue: false, description: 'create Artifact')
    }
    stages {
        stage('build code') {
            steps {
                echo 'build code'
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
                        echo 'component test'
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
                env.CREATE_ARTIFACT
            }
            steps {
                echo 'create artifact'
            }
        }
    }
}
