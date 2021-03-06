[![Build Status](https://travis-ci.org/miso-lims/runscanner.svg)](https://travis-ci.org/miso-lims/runscanner)[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=ca.on.oicr.gsi.runscanner%3Arunscanner&metric=alert_status)](https://sonarcloud.io/dashboard?id=ca.on.oicr.gsi.runscanner:runscanner)

# Run Scanner
This is a web service that monitors directories on the file system containing
the output from sequencing instruments and serves metadata for runs.

Full instructions for the setup and use of Run Scanner can be found in the [Run Scanner User Manual](https://miso-lims.github.io/runscanner/).

## Prerequisites

* JDK 8
* Tomcat 8
* C++ build environment
* jsoncpp
* [Maven 3.0.5](http://maven.apache.org/download.html) or later
* git

<a id="latest-release" />

## Downloading the latest release
Use the GitHub interface to download the [latest release](https://github.com/miso-lims/runscanner/releases/latest).
Extract the `.zip` or `.tar.gz` file.

<a id="setup" />

## Setting Up Run Scanner

Please refer to [Installation & Setup](https://miso-lims.github.io/runscanner/pages/installation.html) in the Run Scanner User Manual for installation instructions.

## Debugging

### Retrieving run output
For troublesome runs, you can see the output for a particular run directory using:

    java -cp $RUN_SCANNER_HOME/WEB-INF/classes:$RUN_SCANNER_HOME/WEB-INF/lib/'*' ca.on.oicr.gsi.runscanner.scanner.ProcessRun

It will display instructions on how to use it. You will have to set the `RUN_SCANNER_HOME` to the path containing an unpacked version of the WAR.

### List observable runs
To troubleshoot whether a processor can observe a run, you can see a list of all the runs a processor will accept from the filesystem using:

    java -cp $RUN_SCANNER_HOME/WEB-INF/classes:$RUN_SCANNER_HOME/WEB-INF/lib/'*' ca.on.oicr.gsi.runscanner.scanner.FindRuns
    
It will display usage instructions. You will have to set the `RUN_SCANNER_HOME` to the path containing an unpacked version of the WAR.

Please refer to [Troubleshooting](https://miso-lims.github.io/runscanner/pages/troubleshooting.html) in the Run Scanner User Manual for more information.
