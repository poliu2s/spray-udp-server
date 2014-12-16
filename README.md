Spray UDP Server
================

Template for getting up and running with a simple asynchronous UDP service that listens on port 8000. Build on Spray and Akka.

To run use `sbt run`.

You can use the following command to send a basic datagram to the service
```
echo -n "{ \"h\": \"ello\" }" | nc -4u -w1 localhost 8000
```
