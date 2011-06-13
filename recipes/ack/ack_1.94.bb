DESCRIPTION = "Ack is a tool like grep, designed for programmers with large trees of heterogeneous source code."
HOMEPAGE = "http://betterthangrep.com"
PRIORITY = "optional"
LICENSE = "Artistic License 2.0"

RDEPENDS = "perl perl-modules"
PR = "r0"

SRCREV = "39cd1f31cc379b2df4b63ca6564c80b6b4caa929"
SRC_URI = "git://github.com/petdance/ack.git;protocol=git"
S = "${WORKDIR}/git"

do_install () {
    install -d ${D}${bindir}/
    install -m 0755 ${S}/ack ${D}${bindir}/
}
