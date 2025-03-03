JAVAC = javac
JAVA = java
SRC = $(wildcard *.java)
CLASS_FILES = $(SRC:.java=.class)

.PHONY: build run clean

build: $(CLASS_FILES)

%.class: %.java
	$(JAVAC) $<

run: build
	$(JAVA) app

clean:
	rm -f *.class