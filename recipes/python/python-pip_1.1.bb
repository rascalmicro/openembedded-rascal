DESCRIPTION = "Web microframework for Python based on Werkzeug, Jinja 2 and good intentions"
HOMEPAGE = "http://flask.pocoo.org/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
SRCNAME = "pip"
PR = "r0"

SRC_URI = "http://cheeseshop.python.org/packages/source/p/pip/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} = "\
  python-core \
"

do_install_append() {
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.pyo
    rm -f ${D}${PYTHON_SITEPACKAGES_DIR}/site.py
}

SRC_URI[md5sum] = "62a9f08dd5dc69d76734568a6c040508"
SRC_URI[sha256sum] = "993804bb947d18508acee02141281c77d27677f8c14eaa64d6287a1c53ef01c8"
