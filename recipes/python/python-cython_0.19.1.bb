DESCRIPTION = "Cython is a language specially designed for writing Python extension modules. \
It's designed to bridge the gap between the nice, high-level, easy-to-use world of Python \
and the messy, low-level world of C."
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e23fadd6ceef8c618fc1c65191d846fa"
SRCNAME = "Cython"
BBCLASSEXTEND = "native"
PR = "r3"

SRC_URI = "http://www.cython.org/release/${SRCNAME}-${PV}.tar.gz"

S = "${WORKDIR}/${SRCNAME}-${PV}"

SRC_URI[md5sum] = "df4cfb2b8e3345272e3fc451b76bd630"
SRC_URI[sha256sum] = "0b90aaa286acdd1bf75a6dd144dfc45192f011f2c2401cf5f80ed6ab5f8bf778"

inherit distutils
