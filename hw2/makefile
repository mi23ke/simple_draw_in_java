JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
				$(JC) $(JFLAGS) $*.java

CLASSES = \
        Controller.java \
				PanelView.java \
				PointsRepository.java \
				Shapes.java \
				Square.java \
				Circle.java \
				Text.java \
				Command.java \
				Undo.java \
				Redo.java \
				Clear.java \
				AddShape.java

default: classes

classes: $(CLASSES:.java=.class)

%.class : %.java
		$(JC) $(JFLAGS) *.java

clean:
				$(RM) *.class
