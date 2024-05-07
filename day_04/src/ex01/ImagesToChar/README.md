## Getting Started

Welcome to Java code World!

Please run from the current folder:

``` 
javac -d target src/**/*.java ;
cp -r src/resources target ;
jar cmf src/manifest.txt  my.jar -C target .  ;
java -jar my.jar $(WHITE) $(BLACK) ;
```

where 
```
WHITE - white color symbol
BLACK - black color symbol
```

Enjoy!
