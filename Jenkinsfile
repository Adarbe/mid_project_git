node {
  def app = ""
      stage("pull code") {
	 repo = git "https://github.com/tsahiduek/flask-http.git"

      stage('Docker build ') {
	app = docker.build( "adarbe/mid_project:${repo.GIT_COMMIT}_${BUILD_NUMBER}")
	withDockerRegistry(credentialsId: 'dockerhub.adarbe') {
        app.push()
		}
    	  }
	}
}    
