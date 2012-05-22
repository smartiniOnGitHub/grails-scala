class ScalaGrailsPlugin {
	def version = "0.6.5-SNAPSHOT" // added by set-version
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.2 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/**",
			"web-app/css/**",
			"web-app/images/**",
			"web-app/js/**",
			"web-app/WEB-INF/**"
    ]

    def author = "Vaclav Pech, Domingo Suarez Torres"
    def authorEmail = ""
    def title = "Scala Plugin"
    def description = '''\\
Compiles Scala sources located under src/scala and src-java before grails kicks in with the grails compilation
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/Scala+Plugin"
    def license = "APACHE"
    def organization = [ name: "", url: "" ]
    def developers = [
        [ name: "Vaclav Pech", email: "" ],
        [ name: "Domingo Suarez Torres", email: "domingo.suarez@gmail.com" ]
    ]
    def issueManagement = [ system: "GITHUB", url: "https://github.com/vaclav/grails-scala/issues" ]
    def scm = [ url: "https://github.com/vaclav/grails-scala" ]
}
