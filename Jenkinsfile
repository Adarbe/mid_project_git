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
      // stage("build docker") {
      //   app = docker.build("dockerhub.adarbe")
      //   withDockerRegistry(credentialsId: 'dockerhub.adarbe') {
      //     }
      //   }
#      stage('Apply Kubernetes files') {
#	      withAWS(region: 'us-east-1', credentials: "adarb" ) {
#		    sh """
#	        aws eks update-kubeconfig --name opsSchool-eks-png1TYK2
#          sed -i "s?IMAGE_PLA?adarbe/mid_project:${repo.GIT_COMMIT}_${BUILD_NUMBER}?" app.yml
#	        kubectl apply -f app.yml
#	        """
#    	      }
#      	}
#}
}    
