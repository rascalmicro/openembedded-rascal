DESCRIPTION = "matplotlib is a python 2D plotting library which produces publication quality figures in a variety of hardcopy formats"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "PSF"
SRCNAME = "matplotlib"
PR = "r1"

DEPENDS += "python-numpy freetype libpng"
RDEPENDS_${PN} = "python-core python-distutils python-numpy freetype libpng"

SRC_URI = "${SOURCEFORGE_MIRROR}/matplotlib/matplotlib-${PV}.tar.gz \
           file://fix_setup.patch \
           file://fix_setupext.patch \
	  "

S = "${WORKDIR}/matplotlib-${PV}"

EXTRA_OECONF = "--disable-docs --with-python-includes=${STAGING_INCDIR}/../"

inherit distutils

do_compile_prepend() {
         BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
         ${STAGING_BINDIR_NATIVE}/python setup.py build ${DISTUTILS_BUILD_ARGS} || \
         true
}

# need to export these variables for python-config to work
export PYTHONPATH
export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR


SRC_URI[md5sum] = "57a627f30b3b27821f808659889514c2"
SRC_URI[sha256sum] = "be37e1d86c65ecacae6683f8805e051e9904e5f2e02bf2b7a34262c46a6d06a7"
