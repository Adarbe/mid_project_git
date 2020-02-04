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
    withAWS(region: "us-east-1", redentialsId: "aws-key", usernameVariable: "AWS_ACCESS_KEY_ID", passwordVariable: "AWS_SECRET_ACCESS_KEY") {
    sh """
    aws eks update-kubeconfig --name opsSchool-eks-sOuM9kEi
    kubectl apply -f deploy.yml
    """
      }
    }
}
