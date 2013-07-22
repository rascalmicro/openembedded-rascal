DESCRIPTION = "The BLAS (Basic Linear Algebra Subprograms) are routines that provide standard building blocks for performing basic vector and matrix operations."
HOMEPAGE = "http://www.netlib.org/blas/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "Attribution requested"
PR = "r0"

SRC_URI = "http://www.netlib.org/blas/blas.tgz \
           "

inherit autotools

SRC_URI[md5sum] = "5e99e975f7a1e3ea6abcad7c6e7e42e6"
SRC_URI[sha256sum] = "ea87df6dc44829ee0a1733226d130c550b17a0bc51c8dbfcd662fb15520b23b5"
