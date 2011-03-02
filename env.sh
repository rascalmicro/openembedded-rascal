export OE_DIR=${PWD}
export PATH=${OE_DIR}/bitbake/bin:$PATH
export BBPATH=${OE_DIR}/build:${OE_DIR}
export BBFILES=${OE_DIR}/recipes/*/*.bb

if [ -z ${ORG_PATH} ] ; then
	ORG_PATH=${PATH}
	export ORG_PATH
fi

if [ -z ${ORG_LD_LIBRARY_PATH} ] ; then
	ORG_LD_LIBRARY_PATH=${LD_LIBRARY_PATH}
	export ORG_LD_LIBRARY_PATH
fi

LD_LIBRARY_PATH=
export PATH LD_LIBRARY_PATH BBPATH
export LANG=C
export BB_ENV_EXTRAWHITE="MACHINE DISTRO ANGSTROM_MODE"
