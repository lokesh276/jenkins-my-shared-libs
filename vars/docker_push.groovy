def call(String credId, String, imageName){
     withCredentials([
                    usernamePassword(
                        credentialsId: "S{credId}",
                        usernameVariable: "dockerUser",
                        passwordVariable: "dockerPass"
                    )
                ]) {
                    sh "docker login -u ${dockerUser} -p ${dockerPass}"
                    sh "docker tag ${imageName} ${dockerUser}/${imageName}"
                    sh "docker push ${dockerUser}/${imageName}"
                }
            }
}
