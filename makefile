JAVAC = javac
JAVA = java
JUNIT = junit
JAVADOC = javadoc
SRC = $(wildcard *.java)
TEST_SRC = test/CalcTest.java
CLASS_FILES = $(SRC:.java=.class)
TEST_CLASS = $(TEST_SRC:.java=.class)
JUNIT_JAR = lib/junit-4.13.2.jar
HAMCREST_JAR = lib/hamcrest-core-1.3.jar

.PHONY: test

test: $(CLASS_FILES) $(TEST_CLASS)
	$(JAVA) -cp .:$(JUNIT_JAR):$(HAMCREST_JAR) org.junit.runner.JUnitCore CalcTest

$(TEST_CLASS): $(TEST_SRC)
	$(JAVAC) -cp .:$(JUNIT_JAR) -d . $<

run: build
	$(JAVA) app

doc: $(SRC)
	$(JAVADOC) -d $(DOC_DIR) $(SRC)

clean:
	rm -f *.class
	rm -rf $(DOC_DIR)
