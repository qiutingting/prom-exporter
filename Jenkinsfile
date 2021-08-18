pipeline{
    agent { label 'tech' }
    stages{

        stage('代码扫描'){
          steps{
              sh """
                   mvn sonar:sonar \
  -Dsonar.projectKey=tech \
  -Dsonar.host.url=http://k8s.testing-studio.com:9000 \
  -Dsonar.login=52358eb3e1c840ae03abbd18275023eed92f6d9e
              """
          }
        }

        stage('执行单侧'){
            steps{
                sh """
                    mvn clean test -Dmaven.test.failure.ignore=true
                """
                }
        }

        stage('打包推送'){
            steps{
                  sh """
                  mvn package deploy
                  """
            }
        }

        stage('编译镜像'){
            steps{
                sh """
                    sudo docker build -t localhost:5000/java-exporter .
                    sudo docker push localhost:5000/java-exporter
                """
                }
        }


        stage('部署环境'){
            steps{
                sh """
                    sudo docker pull localhost:5000/java-exporter
                    sudo docker rm -f java-exporter || echo 'There is no java-exporter running'
                    sudo docker run --name java-exporter -d -p 8999:1234 localhost:5000/java-exporter
                """
                }
            }
    }
    post{
        always{
            sh 'echo 111'
        }
    }
}
