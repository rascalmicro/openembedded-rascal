DESCRIPTION = "Command-line tool for controlling blinkM leds over an I2C bus"
HOMEPAGE = "https://github.com/scottellis/overo-blinkm"
PRIORITY = "optional"
LICENSE = "BSD"
PR = "r0"

S = "${WORKDIR}/git"

SRCREV = "71fbc4860b40548acd31008db33ff2a57d2a333a"
SRC_URI = "git://github.com/scottellis/overo-blinkm.git;protocol=git \
           file://rascal-use-i2c-bus-0.patch"

do_compile () {
    ${CC} ${LDFLAGS} -o blinkm *.c
}

do_install () {
    install -d ${D}${bindir}/
    install -m 0755 ${S}/blinkm ${D}${bindir}/
}

PACKAGES = "${PN}"
FILES_${PN}-dbg = "${bindir}/*"
FILES_${PN} = "${bindir}/*"
FILES_${PN} += "${sysconfdir}/*"
