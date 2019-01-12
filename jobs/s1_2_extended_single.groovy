job('sample-gradle-build') {
    steps {
        wrappers {
            timestamps()
        }
        scm {
            git('https://github.com/michalgorowij/sample1-gradle-ci.git', "master") {
            }
        }
    }
    steps {
        triggers {
            scm("@midnight")
            scm("0 5 * * 1")
        }
        gradle {
            tasks("clean")
            tasks("check")
            useWrapper(true)
        }
    }
    publishers {
        archiveJunit('**/target/surefire-reports/*.xml'){
            allowEmptyResults(true)
        }
    }
}