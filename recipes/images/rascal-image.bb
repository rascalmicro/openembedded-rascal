require recipes/images/minimal-image.bb

IMAGE_INSTALL += "\
        gcc \
        gcc-symlinks \
        git \
        i2c-tools \
        iperf \
        libgcc-dev \
        nano \
        python \
        python-daemon \
        python-modules \
        python-pyserial \
        ruby \
        usbutils \
        usb-gadget-mode \
        vim \
    "

PREFERRED_VERSION_gcc = "4.5"
PREFERRED_PROVIDER_virtual/libgcc-dev = "gcc"

export IMAGE_BASENAME = "rascal-image"
