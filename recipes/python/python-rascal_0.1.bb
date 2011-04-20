DESCRIPTION = "Hardware control library for the Rascal, a small computer for art and science"
HOMEPAGE = "http://rascalmicro.com"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPLv3"
SRCNAME = "rascal"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV = "0.1"
SRC_URI = "git://github.com/rascalmicro/hardware-api.git;protocol=git;branch=master"


inherit distutils

RDEPENDS_${PN} = "\
  python-core \
"

SRC_URI[md5sum] = "35726c7d0708a244a39faf93f82c3a24"
SRC_URI[sha256sum] = "ce3c88135d1c15a5d1e0f6dae6e171e77b15ec6ac6a3d6ad5a6ca37fcd2d0a8d"
