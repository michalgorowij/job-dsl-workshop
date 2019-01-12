job('sample-gradle-build') {
    steps {
        scm {git('https://github.com/solidsoft-training/sample1-gradle-ci.git', master, poll: false)}
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