node {
  def customImage = ""
      stage("pull code") {
        checkout scm
       	}
      stage('Docker build & push') {
	app = docker.build( "adarbe/card_validation:${BUILD_NUMBER}", " --no-cache ." )
	app.run("-p 80:8888")
	app.push()
	sh(script: "docker rmi ${app.id}")
	}
      stage("build docker") {
        customImage = docker.build("dockerhub.adarbe")
        withDockerRegistry(credentialsId: 'dockerhub.adarbe') {
        customImage.push()
          }
        }
}
