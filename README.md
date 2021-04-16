## Mars Rover ##
Resolution of Test Rover. \
The example of commands is included in root folder.

### Requirements ###
- JDK 1.8

### Libraries ###
- Lombok
- JUnit 5

### Usage example ###
Clone git repository
```
    $ git clone https://github.com/riicardofarias/mars-rover-test
    $ cd mars-rover-test
```

Install maven dependencies
```
    mvn clean install package
```

Run application
```
    java -jar target/mars-rover-1.0.jar "File location"
```

### Test input ###
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

### Expected output ###
```
1 3 N
5 1 E
```
