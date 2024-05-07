$(VERBOSE).SILENT:

all:
	echo "Please run \"make ex_XX\" where XX is a number from 0 to 5"

ex_00:
	javac ex00/Program.java
	java ex00.Program ex00.Temp

ex_01:
	javac ex01/Program.java
	java ex01.Program misc/temp.txt misc/temp1.txt

ex_02:
	javac ex02/Program.java
	java ex02.Program $(arg)

clean:
	rm **/*.class **/**/*.class **/**/**/*.class ex00/result.txt ex01/dictionary.txt

tempp:
	javac temp/Program.java
	java temp.Program 
