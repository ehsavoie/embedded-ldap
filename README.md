embedded-ldap
=============
This is some code to embed [OpenDJ](http://www.forgerock.com/opendj.html "OpenDJ") in order to test LDAP code with JUnit.
[JUnit] (http://www.junit.org "JUnit") 4.10 is required at least.


The content of the opendj directory in src/test/resources is the result of the minimal installation of OpenDJ 2.4.5.
This is were the connection parameters are defined and stored ( port, host, DN, root login and password).
