node {
  def app = ""
      stage("pull code") {
        checkout scm
       	}
      stage('Docker build ') {
	app = docker.build( "adarbe/card_validation:${BUILD_NUMBER}", " --no-cache ." )
	withDockerRegistry(credentialsId: 'adarbe') {
        app.push()
		}
      }
      stage("build docker") {
        app = docker.build("dockerhub.adarbe")
        withDockerRegistry(credentialsId: 'dockerhub.adarbe') {
          }
        }
}
