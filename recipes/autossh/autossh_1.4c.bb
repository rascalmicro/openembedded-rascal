DESCRIPTION = "Automatically restart SSH sessions and tunnels"
HOMEPAGE = "http://www.harding.motd.ca/autossh/"
SECTION = "net"
PRIORITY = "optional"
LICENSE = "BSD"
PR = "r0"

SRC_URI = "http://www.harding.motd.ca/autossh/autossh-${PV}.tgz"

RDEPENDS = "openssh"

EXTRA_OECONF = "--bindir=${D}/usr/bin --datadir=${D}/usr/share --mandir=${D}/usr/share/man --exec_prefix=${D}/usr --prefix=${D}/usr"
TARGET_CC_ARCH += "${LDFLAGS}"

inherit autotools

SRC_URI[md5sum] = "26520eea934f296be0783dabe7fcfd28"
SRC_URI[sha256sum] = "6fcaba6a409a46bdf832086736bb8f09d245ebce11027f41d39588a95dc7fd1d"
