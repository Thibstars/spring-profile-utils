# SpringProfileUtils [![](https://jitpack.io/v/Thibstars/spring-profile-utils.svg)](https://jitpack.io/#Thibstars/spring-profile-utils) [![](https://jitci.com/gh/Thibstars/spring-profile-utils/svg)](https://jitci.com/gh/Thibstars/spring-profile-utils) [![Dependabot Status](https://api.dependabot.com/badges/status?host=github&repo=Thibstars/spring-profile-utils)](https://dependabot.com)


Utilities enabling programmatic checks on Spring profiles.

## Usage
This library introduces the `SpringProfileUtils` class which comes with utility methods on Spring profiles such as 
`isProfileActive` and `areProfilesActive`.

## Installation
Import this library into your project via maven using the following snippets in your `pom.xml`:

````
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
````

````
	<dependency>
	    <groupId>com.github.Thibstars</groupId>
	    <artifactId>spring-profile-utils</artifactId>
	    <version>currentVersion</version>
	</dependency>
````