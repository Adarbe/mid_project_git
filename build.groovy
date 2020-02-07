node {
  def customImage = ""
      stage("pull code") {
        checkout scm
       	}
      stage('Docker build ') {
	app = docker.build( "adarbe/card_validation:${BUILD_NUMBER}", " --no-cache ." )
	withDockerRegistry(credentialsId: 'adarbe') {
        customImage.push()
		}
      }
      stage("build docker") {
        customImage = docker.build("dockerhub.adarbe")
        withDockerRegistry(credentialsId: 'dockerhub.adarbe') {
          }
        }
}
