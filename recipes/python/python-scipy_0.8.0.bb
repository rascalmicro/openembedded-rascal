DESCRIPTION = "SciPy is an Open Source library of scientific tools for Python."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/scipy/scipy-${PV}.tar.gz \
	   file://libblas.so\
	   file://liblapack.a \
	   file://umfpack.so \
	  "

S = "${WORKDIR}/scipy-${PV}"

export BLAS = ${WORKDIR}/libblas.so
export LAPACK = ${WORKDIR}/liblapack.a
export UMFPACK = ${WORKDIR}/umfpack.so

export LDFLAGS = "-L${STAGING_LIBDIR}"

inherit distutils

do_compile() {
         ${STAGING_BINDIR_NATIVE}/python setup.py build --compiler arm-gnueabi-gcc
}

SRC_URI[md5sum] = "f0bfc6141b90e6a31555b31486602251"
SRC_URI[sha256sum] = "b12937bd3a71ace8d7d6b7e19f8f220630969c2822e6248fc0bbc8f2cc18d825"
