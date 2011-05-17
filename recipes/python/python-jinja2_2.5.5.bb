DESCRIPTION = "Modern and designer-friendly templating language for Python, modelled after Django’s templates"
HOMEPAGE = "http://jinja.pocoo.org/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "jinja2"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV = "2.5.5"
SRC_URI = "git://github.com/mitsuhiko/jinja2.git;protocol=git;branch=master"

inherit setuptools

RDEPENDS_${PN} = "\
  python-core \
"

do_install_append() {
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.pyo
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.py
}

SRC_URI[md5sum] = "e5209ee12f5e984b9963086f936621fb"
SRC_URI[sha256sum] = "aaac90088c957cad4272dcf38aee1736889bbc568ef1a25d3d75310526f616ba"
