javac -sourcepath ./src/ -d ./out/ ./src/ru/noname070/lab3/Main.java
jar cmf META-INF/MANIFEST.MF lab3.jar -C out/ .
java -jar lab3.jar