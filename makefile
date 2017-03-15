# If the first argument is "run"...
#   # use the rest as arguments for "run"

ifeq (run,$(firstword $(MAKECMDGOALS)))
    RUN_ARGS := $(wordlist 2,$(words $(MAKECMDGOALS)),$(MAKECMDGOALS))
    $(eval $(RUN_ARGS):;@:)
endif

# Test to do a simple makefile for java projects
#

JC = javac
JFLAGS = -g

SRCDIR = ./src
ifndef classpath
export classpath = $(PWD)/class
endif

.PHONY : all clean subdir run

all : subdirs

subdirs :
	cd $(SRCDIR); make

run :
	@java -classpath $(classpath) $(RUN_ARGS)/Main

clean :
	rm -f $(classpath)/*.class
