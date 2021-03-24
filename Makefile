#-----------------------------------------------------
MAIN=main
ICONSDIR=.
IMAGESDIR=images
#STYLE=/Users/bruel/Dropbox/Public/dev/asciidoc/stylesheets/golo-jmb.css
#STYLE=/Users/bruel/dev/asciidoctor/asciidoctor-stylesheet-factory/stylesheets/jmb.css
#ASCIIDOC=asciidoc -a icons -a iconsdir=$(ICONSDIR) -a stylesheet=$(STYLE) -a imagesdir=$(IMAGESDIR) -a data-uri
#HIGHLIGHT=coderay
#HIGHLIGHT=highlightjs
#HIGHLIGHT=prettify
HIGHLIGHT=pygments
#DOCTOR=asciidoctor -b html5 -a data-uri -a icons=font -a images=$(IMAGESDIR) -a source-highlighter=$(HIGHLIGHT)
DOCTOR=asciidoctor -b html5 -a icons=font -a images=$(IMAGESDIR) -a source-highlighter=$(HIGHLIGHT)
#BACKENDS=asciidoctor-deck.js
#DECKJS=$(BACKENDS)/templates/haml/
BACKENDS=../asciidoctor-backends
DECKJS=$(BACKENDS)/haml/
#DECK=web-2.0
DECK=swiss
#DECK=neon
#DECK=beamer
DZSLIDES=../asciidoctor-backends/slim/dzslides
EXT=adoc
PANDOC=pandoc
OUTPUT=.
DEP=definitions.txt 
DOCS = docs
DOC = doc
#-----------------------------------------------------

all: $(OUTPUT)/*.html
book: full.pdf

images/%.png: images/%.plantuml
	@echo '==> Compiling plantUML files to generate PNG'
	java -jar plantuml.jar $<

images/%.svg: images/%.plantuml
	@echo '==> Compiling plantUML files to generate SVG'
	java -jar plantuml.jar -t SVG $<

pattern/%.png: pattern/%.plantuml
	@echo '==> Compiling plantUML files to generate PNG'
	java -jar plantuml.jar $<

%.html: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate HTML'
	$(DOCTOR) -r asciidoctor-diagram -a toc2 -b html5 -a numbered -a eleve -a linkcss! $<

%.full.html: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate HTML'
	$(DOCTOR) -a toc2 -a data-uri -b html5 -a numbered -a eleve -o $@ $<

full.pdf: full.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate HTML'
	asciidoctor-pdf -a prof -a toc2 $<

#%.deckjs.html: %.$(EXT)  $(DEP)
#	@echo '==> Compiling asciidoc files to generate Deckjs'
#	$(DOCTOR) -T ../asciidoctor-deck.js/templates/haml/ -a slides -a linkcss! \
#	-a data-uri -a deckjs_theme=$(DECK) \
#	-a icons=font \
#	-a images=$(IMAGESDIR) -a prof -o $@ $<

%.deckjs.html: %.$(EXT)  $(DEP)
	@echo '==> Compiling asciidoc files to generate Deckjs'
	$(DOCTOR) -b deckjs \
	-T ../asciidoctor-deck.js/templates/haml/ -a slides \
	-a deckjs_theme=$(DECK) \
	-r asciidoctor-diagram \
	-a styledir=. \
	-a stylesheet=$(STYLE) \
	-a imagesdir=$(IMAGESDIR) \
	-a source-highlighter=$(HIGHLIGHT) \
	-a prof -o $@ $<

%.dzslides.html: %.$(EXT)
	@echo '==> Compiling asciidoc files to generate Dzslides'
	$(DOCTOR) -b dzslides \
	-T $(DZSLIDES) -E slim \
	-a slides -a dzslides \
	-r asciidoctor-diagram \
	-a styledir=. \
	-a stylesheet=$(STYLE) \
	-a imagesdir=$(IMAGESDIR) \
	-a source-highlighter=$(HIGHLIGHT) \
	-o $@ $<

%.reveal.html: %.$(EXT)  $(DEP)
	@echo '==> Compiling asciidoc files to generate reveal.js'
	$(DOCTOR) -T ../asciidoctor-backends/haml/reveal/ \
	-a slides -a data-uri -a deckjs_theme=$(DECK) -a icons=font \
	-a stylesheet=$(STYLE) -o $@ $<

%.xml: %.$(EXT)
	@echo '==> Compiling asciidoc files to generate DocBook'
	$(DOCTOR) -b docbook -a docbook $< -o $@

%.wiki: %.xml
	@echo '==> Compiling DocBook files with Pandoc to generate MediaWiki'
	$(PANDOC) -f docbook -t mediawiki -s $< -o $@

roadmap.html: $(MAIN).$(EXT)
	@echo '==> Compiling asciidoc files to generate standalone file for Google Drive'
	$(DOCTOR) -b html5 -a numbered -a data-uri $< -o $@

%-sujet.html: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate HTML'
	$(DOCTOR) -a compact -a theme=compact -b html5 -a numbered -a eleve \
	-a data-uri $< -o $@

%-sujet.pdf: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate PDF subject'
	asciidoctor-pdf  -a compact -a theme=compact  -a numbered -a eleve $< -o $@

%-sujet.pdf: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate PDF subject'
	asciidoctor-pdf  -a compact -a theme=compact  -a numbered -a eleve $< -o $@

%-prof.pdf: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate PDF subject'
	asciidoctor-pdf  -a compact -a theme=compact  -a numbered -a prof $< -o $@

%-prof.html: %.$(EXT) $(DEP)
	@echo '==> Compiling asciidoc files with Asciidoctor to generate HTML'
	$(DOCTOR) -a prof -a correction -a compact -a theme=compact -b html5 -a numbered \
	-a data-uri $< -o $@

README.html: README.adoc
	$(DOCTOR) -a toc2 -b html5 -a numbered -a stylesheet=$(STYLE) -a data-uri README.adoc

deploy: README.html
	cp README.html $(DOCS)/index.html
	git commit -am "🤖 DEPLOY: last updates"; git pull; git push
	git push

cours2:
	$(DOCTOR) -a toc2 -b html5 -a numbered -a stylesheet=$(STYLE) -a data-uri -o cours2.html wip.asc


test:
	$(DOCTOR) -a toc2 -b html5 -a numbered -a stylesheet=$(STYLE) -o wip2.html wip.asc
	$(DOCTOR) -T /Users/bruel/dev/asciidoctor-backends/haml/deckjs/ -a slides \
	-a data-uri -a deckjs_theme=$(DECK) -a icons -a iconsdir=$(ICONSDIR) \
	-a images=$(IMAGESDIR) -a prof -a stylesheet=$(STYLE) -o wip2.deckjs.html wip.asc

javadoc : $(CLASSFILES)
	javadoc -version -author -doclet org.asciidoctor.Asciidoclet -docletpath doclet/asciidoclet-1.5.0.jar -overview -d $(DOC) $(SOURCEFILES)
