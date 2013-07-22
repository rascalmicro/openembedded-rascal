DESCRIPTION = "Red, the Rascal editor, is the web-based editor that is built into every Rascal, a small computer for art and science"
HOMEPAGE = "http://rascalmicro.com"
LICENSE = "GPLv3"
SRCNAME = "red"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/rascalmicro/red.git;protocol=git;branch=master"

FILES_${PN} = "/var"

do_configure () {
}

do_compile () {
}

do_install () {
	install -d ${D}/var/www
	install -d ${D}/var/www/editor
	cp -r ${S}/* ${D}/var/www/editor/
}
