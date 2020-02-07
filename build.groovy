node {
  def app = ""
      stage("pull code") {
	 git "https://github.com/Adarbe/card_validation.git"
      stage('Docker build ') {
	app = docker.build( "adarbe/card_validation:${getProjectName()} ${BUILD_NUMBER}")
	withDockerRegistry(credentialsId: 'dockerhub.adarbe') {
        app.push()
		}
      }
      stage("build docker") {
        app = docker.build("dockerhub.adarbe")
        withDockerRegistry(credentialsId: 'dockerhub.adarbe') {
          }
        }
}
}
