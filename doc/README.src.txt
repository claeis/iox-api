iox-api - specification of a streaming API to objects

Features
- specifies a streaming API to objects
- leverages the processing from XML-elements to objects
- not limited to XML representations of objects
- pure specification
- not limited/bound to a specific domain
- no random access to objects
- no query language
- no depenency to a schema model or implementation, just (type) names
- not limited to XML-Schema defined objects
- doesn't define binding metadata

How to use it?
- see javadocs

License
iox-api is licensed under the MIT/X License.

Latest Version
The current version of iox-api can be found at
http://www.eisenhutinformatik.ch/iox/

System Configuration
In order to compile iox-api, a JAVA software development kit (JDK) version 1.4.1 or a more recent version must be installed on your system.
A free version of the JAVA software development kit (JDK) is available at the website http://java.sun.com/j2se/.
Also required is the build tool ant. Download it from http://ant.apache.org and install it as documented there.

How to compile it?
To compile the iox-api, change to the newly created directory and enter the following command at the commandline prompt

ant jar

To build a binary distribution, use

ant bindist

Dependencies
- None

Comments/Suggestions
Please send comments to ce@eisenhutinformatik.ch

