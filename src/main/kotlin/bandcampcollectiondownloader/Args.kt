package bandcampcollectiondownloader

import picocli.CommandLine
import java.nio.file.Path
import java.nio.file.Paths

data class Args(
        @CommandLine.Parameters(arity = "1..1",
                description = ["The bandcamp user account from which all albums must be downloaded."])
        var bandcampUser: String = "",

        @CommandLine.Option(names = ["--cookies-file", "-c"], required = false,
                description = ["A JSON file with valid bandcamp credential cookies.", """"Cookie Quick Manager" can be used to obtain this file after logging into bandcamp.""", "(visit https://addons.mozilla.org/en-US/firefox/addon/cookie-quick-manager/).", "If no cookies file is provided, cookies from the local Firefox installation are used (Windows and Linux only)."])
        var pathToCookiesFile: Path? = null,

        @CommandLine.Option(names = ["--audio-format", "-f"], required = false,
                description = ["The chosen audio format of the files to download (default: \${DEFAULT-VALUE}).", "Possible values: flac, wav, aac-hi, mp3-320, aiff-lossless, vorbis, mp3-v0, alac."])
        var audioFormat: String = "vorbis",

        @CommandLine.Option(names = ["--download-folder", "-d"], required = false,
                description = ["The folder in which downloaded albums must be extracted.", "The following structure is considered: <pathToDownloadFolder>/<artist>/<year> - <album>.", "(default: current folder)"])
        var pathToDownloadFolder: Path = Paths.get("."),

        @CommandLine.Option(names = ["-h", "--help"], usageHelp = true, description = ["Display this help message."])
        var help: Boolean = false,

        @CommandLine.Option(names = ["-r", "--retries"], usageHelp = false, description = ["Amount of retries when downloading an album (default: 3)."])
        var retries: Int = 3,

        @CommandLine.Option(names = ["-t", "--timeout"], usageHelp = false, description = ["Timeout in ms before giving up an HTTP connection (default: 50000)."])
        var timeout: Int = 50000,

        @CommandLine.Option(names = ["-e", "--skip-failed-albums"], description = ["Skip albums that fail to download after the specified number of retries."])
        var ignoreFailedAlbums: Boolean = false

)