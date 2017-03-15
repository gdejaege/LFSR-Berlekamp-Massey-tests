sourcefiles = \
			  Berlekamp_Massey.java \
			  LFSR.java \
			  Main.java

classfiles = $(patsubst %.java,$(classpath)/%.class,$(sourcefiles))

ifndef classpath
export classpath = $(PWD)/../../class
endif
ifndef srcpath
export srcpath = $(PWD)/../
endif
 
.PHONY:
	all clean 

all: $(classfiles)

$(classpath)/%.class: %.java
	@mkdir -p $(classpath)
	javac -sourcepath $(srcpath) -d $(classpath) -classpath $(classpath)  $<
 
clean:
	rm -f $(classpath)/*.class
