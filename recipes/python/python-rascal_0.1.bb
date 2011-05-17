DESCRIPTION = "Hardware control library for the Rascal, a small computer for art and science"
HOMEPAGE = "http://rascalmicro.com"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPLv3"
SRCNAME = "rascal"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/rascalmicro/hardware-api.git;protocol=git;branch=master"

inherit distutils

RDEPENDS_${PN} = "\
  python-core \
"
