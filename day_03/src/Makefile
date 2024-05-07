$(VERBOSE).SILENT:

all:
	echo "Please run \"make ex_XX\" where XX is a number from 0 to 5"

ex_00:
	javac ex00/Program.java
	java ex00.Program $(arg)

ex_01:
	javac ex01/Program.java
	java ex01.Program $(arg)

ex_02:
	javac ex02/Program.java
	java ex02.Program $(arg1) $(arg2)

ex_03:
	javac ex03/Program.java
	java ex03.Program $(arg1) $(arg2)

clean:
	rm **/*.class **/**/*.class **/**/**/*.class ex00/result.txt ex01/dictionary.txt

tempp:
	javac temp/Program.java
	java temp.Program 
