version = "1.1.0" // Plugin version. Increment this to trigger the updater
description = "Create Unicode fractions with any numerator and denominator" // Plugin description that will be shown to user

aliucord {
	// Changelog of your plugin
	changelog.set("""
		1.0.0

		Initial release
		First release of Unicode Fractions

		1.1.0

		First actual official release
		Fix datatype errors that didn't exist in js
	""".trimIndent())
	// Image or Gif that will be shown at the top of your changelog page
	changelogMedia.set("https://img.youtube.com/vi/4SkLOOm_a4M/0.jpg")

	// Add additional authors to this plugin
	author("DavidNyan10#8581", 592228909052067865)
	// author("Name", 0)

	// Excludes this plugin from the updater, meaning it won't show up for users.
	// Set this if the plugin is unfinished
	// excludeFromUpdaterJson.set(true)
}