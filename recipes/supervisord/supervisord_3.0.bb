DESCRIPTION = "A system for controlling process state under UNIX"
HOMEPAGE = "http://supervisord.org"
SECTION = "admin"
PRIORITY = "optional"
LICENSE = "BSD"
PR = "ml1"

SRC_URI = "https://pypi.python.org/packages/source/s/supervisor/supervisor-${PV}.tar.gz \
	   file://supervisord.conf"

S = "${WORKDIR}/supervisor-${PV}"

inherit setuptools

# Removed python-meld3 from RDEPENDS. Will probably need to post-install it with pip.

RDEPENDS_${PN} = "\
	python-setuptools \
	python-misc \
	python-html \
	python-unixadmin \
	python-xmlrpc \
	python-shell \
	python-resource"
		

PACKAGES = "${PN}"

site_packages="${libdir}/python2.*/site-packages"

FILES_${PN} = "\
	${sysconfdir}/* \
	${bindir}/* \
	${site_packages}/*.egg-info \
	${site_packages}/*.pth \
	${site_packages}/supervisor/*.pyo \
	${site_packages}/supervisor/*.txt \
	${site_packages}/supervisor/ui \
	${site_packages}/supervisor/medusa/*.pyo \
	${site_packages}/supervisor/medusa/*.txt \
	${site_packages}/supervisor/medusa/thread/*.pyo"

do_install_prepend() {
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/supervisor/conf.d

	install -m 0644 ${WORKDIR}/supervisord.conf ${D}${sysconfdir}/supervisord.conf
}

pkg_postinst() {
    update-rc.d supervisord defaults 90
}

pkg_postrm() {
    update-rc.d supervisord remove
}

SRC_URI[md5sum] = "94ff3cf09618c36889425a8e002cd51a"
SRC_URI[sha256sum] = "82aac54c5760b6a4f4c28dda203714e362a68b4a9ba8549fa65955998e3a2212"
