DESCRIPTION = "Modern and designer-friendly templating language for Python, modelled after Django’s templates"
HOMEPAGE = "http://jinja.pocoo.org/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "jinja2"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV = "2.7"
SRC_URI = "git://github.com/mitsuhiko/jinja2.git;protocol=git;branch=master"

inherit setuptools

RDEPENDS_${PN} = "\
  python-core \
"

do_install_append() {
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.pyo
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.py
}
