SRC_DIR = src
OUT_DIR = out

JC = javac
JCFLAGS = -g -d $(OUT_DIR) -cp $(SRC_DIR)

SRCS = $(wildcard $(SRC_DIR)/*.java)
CLS = $(patsubst $(SRC_DIR)/%.java, $(OUT_DIR)/%.class, $(SRCS))

MAIN = Aplicacao

.PHONY: default clean run

default: $(CLS)

$(OUT_DIR)/%.class: $(SRC_DIR)/%.java
	$(JC) $(JCFLAGS) $<

run:
	java -cp $(OUT_DIR) $(MAIN)

clean:
	rm $(OUT_DIR)/*.class
