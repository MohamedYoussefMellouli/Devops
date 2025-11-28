pipeline {
    agent any
    
    stages {
        stage('Git Clone') {
            steps {
                git branch: 'chahine_saadellaoui', 
                    url: 'https://github.com/MohamedYoussefMellouli/Devops.git'
                sh 'echo "Code source recupere avec succes"'
            }
        }

        stage('Certification et Verification') {
            steps {
                echo 'Verification des outils...'
                sh 'ls -la'
                sh 'mvn --version'
                sh 'docker --version'
                sh 'java -version'
                sh 'echo "Tous les outils sont installes"'
            }
        }

        stage('Build Application') {
            steps {
                echo 'Compilation du projet...'
                sh 'mvn clean compile'
                sh 'echo "Application compilee avec succes"'
            }
        }

        stage('Package Application') {
            steps {
                echo 'Creation du package JAR...'
                sh 'mvn package -DskipTests'
                
                echo 'Verification des artefacts...'
                sh 'ls -la target/*.jar'
                sh 'echo "JAR cree avec succes"'
            }
        }

        stage('Docker Container Trace') {
            steps {
                echo 'Trace des conteneurs Docker...'
                sh '''
                    echo "=== LISTE DES CONTENEURS ==="
                    docker ps -a
                    echo ""
                    echo "=== LISTE DES IMAGES ==="
                    docker images
                    echo ""
                    echo "=== STATUT DOCKER ==="
                    docker info | head -10
                    echo "Trace Docker terminee"
                '''
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline execution terminee'
        }
        success {
            echo 'SUCCES! Pipeline CI complete avec succes!'
            archiveArtifacts 'target/*.jar'
            sh 'echo "JAR archive - Pret pour le deploiement futur"'
        }
        failure {
            echo 'ECHEC du pipeline!'
        }
        cleanup {
            sh 'echo "Nettoyage termine"'
        }
    }
}

