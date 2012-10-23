DESCRIPTION = "Modern and designer-friendly templating language for Python, modelled after Django’s templates"
HOMEPAGE = "http://jinja.pocoo.org/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "jinja2"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV = "2.6"
SRC_URI = "git://github.com/mitsuhiko/jinja2.git;protocol=git;branch=master"

inherit setuptools

RDEPENDS_${PN} = "\
  python-core \
"

do_install_append() {
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.pyo
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.py
}

SRC_URI[md5sum] = "1c49a8825c993bfdcf55bb36897d28a2"
SRC_URI[sha256sum] = ""85e185375db75c109f99ecde3d55415f035e7068a82252cf4f16c667ac38f49
