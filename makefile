JAVAC = javac
JAVA = java
JAVADOC = javadoc
SRC = $(wildcard *.java)
CLASS_FILES = $(SRC:.java=.class)
DOC_DIR = doc

.PHONY: build run clean doc

build: $(CLASS_FILES)

%.class: %.java
	$(JAVAC) $<

run: build
	$(JAVA) app

doc: $(SRC)
	$(JAVADOC) -d $(DOC_DIR) $(SRC)

clean:
	rm -f *.class
	rm -rf $(DOC_DIR)
