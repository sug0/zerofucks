# Zero Fucks

The name of this brainfuck interpreter. Just a pet project of mine to learn
the basics of java, and object oriented programming in general.

## Usage

```bash
# execute source from file
$ java -jar jar/ZeroFucks.jar tests/<someBrainFuckSource.bf>

# execute interpreter in interactive mode
$ java -jar jar/ZeroFucks.jar interactive
```

## Compile source

```bash
$ javac ZeroFucks.java
```

## Package jar

```bash
$ jar cvfm jar/ZeroFucks.jar jar/Manifest.txt *.class
```
