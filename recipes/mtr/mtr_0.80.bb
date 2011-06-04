DESCRIPTION = "mtr combines the functionality of the 'traceroute' and 'ping' programs in a single network diagnostic tool."
HOMEPAGE = "http://www.bitwizard.nl/mtr/"
LICENSE = "GPLv2"
SRC_URI = "ftp://ftp.bitwizard.nl/mtr/mtr-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--without-gtk"

do_configure() {
	oe_runconf
}

SRC_URI[md5sum] = "fa68528eaec1757f52bacf9fea8c68a9"
SRC_URI[sha256sum] = "76bbdd97faf3b805933a50858549ddba895911d6891c6cc51db472567cff0ec0"
