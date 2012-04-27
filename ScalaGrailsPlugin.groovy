class ScalaGrailsPlugin {
	def version = "0.6.4" // added by set-version
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
}
