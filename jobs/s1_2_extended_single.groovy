job('sample-gradle-build') {
    steps {
        scm {
            git('https://github.com/michalgorowij/job-dsl-workshop', "master") {
            }
        }
    }
    steps {
        /*triggers {
            scm("@midnight")
            scm("0 5 * * 1")
        }*/
        gradle {
            tasks("clean")
            tasks("check")
            useWrapper(true)
        }
    }
}