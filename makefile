.PHONY: mkdirs clear c

# Forcing bash shell
SHELL := /bin/bash

# Base variables
SRC := src/
BIN := bin/
MNF := $(BIN)META-INF/

# Java compiler options
JC := javac
JFLAGS := -d $(BIN) -sourcepath $(SRC) -cp ".:$(JUN)" -Xlint:deprecation

# Finding all java files in the project
OBJJ := $(patsubst ./%,%,$(patsubst %.java,%.class,$(shell find src -type f -name '*.java')))

######################
# Source compilation #
######################

# Default Java compiling target
%.class: %.java
	@echo Compiling $^...
	@mkdir -p $(BIN)$(dir $(patsubst $(SRC)%,%,$^))
	@$(JC) $(JFLAGS) $^

# Jar creation
build b: mkdirs $(MNF)MANIFEST.MF $(OBJJ) $(BIN)resources/
	@echo Generating Jar file...
	@cd $(BIN); jar cvmf META-INF/MANIFEST.MF DayOfAdvent2020.jar $(patsubst $(SRC)%,%,$(patsubst %.class,%*.class,$(OBJJ))) resources/*; cd ..

# Clean jar creation
clean-build cb: c b

# Creating build directories
mkdirs:
	@echo Creating binaries\' directories...
	@mkdir -p $(BIN)
	@mkdir -p $(MNF)

# Creating Manifest file
$(MNF)MANIFEST.MF:
	@echo Generating META-INF/MANIFEST.MF...
	@echo "Manifest-Version: 1.0" > $(MNF)MANIFEST.MF
	@echo "Main-Class: io.github.enlithamster.Main" >> $(MNF)MANIFEST.MF

# Coping resources
$(BIN)resources/:
	@echo Copying resources...
	@cp -r $(SRC)resources/ $(BIN)resources/

# Deleting all product files
clear c:
	@echo Clearing all binaries...
	@rm -rf $(BIN)*
