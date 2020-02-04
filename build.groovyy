node {
  def customImage = ""
      stage("pull code") {
        checkout scm
       }

      stage("build docker") {
        customImage = docker.build("dockerhub.adarbe")
        withDockerRegistry(credentialsId: 'dockerhub.adarbe') {
        customImage.push()
          }
        }
    stage("verify dockers") {
      sh "docker images"
      }
    stage('Apply Kubernetes files') {
    withAWS(region: 'us-east-1', credentials: '<name>') {
    sh """
    aws eks update-kubeconfig --name <eks name>
    kubectl apply -f deploy.yml
    """
      }
    }
}
