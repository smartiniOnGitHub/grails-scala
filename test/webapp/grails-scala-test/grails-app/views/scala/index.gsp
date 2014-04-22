<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8">
		<meta name="layout" content="main"/>
		<title>Index Page for ScalaController</title>
	</head>
	<body>
		<div>
			<h2>Info on Scala available by the plugin Service:</h2><br/>

			<ul>
				<li>
					Version: ${scalaVersion}
				</li>
				<li>
					Suffix: ${scalaSuffixVersion}
				</li>
			</ul>
			<br/>
		</div>
		<hr/>
		<br/>
		
		<div>
			<h2>Sample values from test Scala classes:</h2><br/>

			<ul>
				<li>
					Scala Full Version: ${scalaObjVersionMsg} , <br/>
					Scala Version: ${scalaObjVersion} , 
					Scala Compiler Version: ${scalaObjCompilerVersion}
				</li>
				<li>
					Numbers: <br/>
					complex ${complex} , rational ${rationalHalf}
				</li>
				<li>
					Persons: <br/>
					person ${person} , 
					personWithBeanProperties ${personWithBeanProperties}, 
					first name of personWithBeanProperties (using its getter method): ${personWithBeanProperties.getFirstName()}, 
				</li>
				<li>
					Sample class with List, Map, utility methods, etc: <br/>
					sampleEmpty ${sampleEmpty} , 
					sampleEmptyListFiltered (using its dedicated method): ${sampleEmpty.filterListByFlag(0)}, 
					sampleNotExistentWithDefault (using its dedicated method): ${sampleEmpty.valueFromMap('not-existent')}, 
				</li>
				<li>
					Various: <br/>
					screenPoint with null color: ${screenPoint} , <br/>
					stringMsg: ${stringMsg} , <br/>
					counter: ${counter},
				</li>
			</ul>
			<br/>
		</div>
		<hr/>
		<br/>
		
	</body>
</html>
