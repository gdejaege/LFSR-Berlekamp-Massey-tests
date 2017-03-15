ifndef classpath
export classpath = $(PWD)/../class
endif
 
.PHONY:
	all clean subblocks

all: subdirs

subdirs:
	cd lfsr; make
 
clean:
	rm -f $(classpath)/*.class
