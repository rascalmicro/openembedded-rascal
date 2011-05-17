DESCRIPTION = "Demonstration web interface for the Rascal, a small computer for art and science"
HOMEPAGE = "http://rascalmicro.com"
LICENSE = "GPLv3"
SRCNAME = "control-freak"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/rascalmicro/control-freak.git;protocol=git;branch=master"

FILES_${PN} = "/var"

do_configure () {
}

do_compile () {
}

do_install () {
	install -d ${D}/var/www
	cp -r ${S}/* ${D}/var/www/
}
