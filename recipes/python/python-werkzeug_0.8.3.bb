DESCRIPTION = "WSGI utility library for Python"
HOMEPAGE = "http://werkzeug.pocoo.org"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "werkzeug"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV = "0.8.3"
SRC_URI = "git://github.com/mitsuhiko/werkzeug.git;protocol=git;branch=master"

inherit setuptools

RDEPENDS_${PN} = "\
  python-core \
"

do_install_append() {
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.pyo
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.py
}

SRC_URI[md5sum] = "12aa03e302ce49da98703938f257347a"
SRC_URI[sha256sum] = "108c3d41fb701c4af4ef00e8ebbedc147632c82247beb798c8d8657a12810206"
