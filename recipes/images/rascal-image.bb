require recipes/images/minimal-image.bb

IMAGE_INSTALL += "\
        avahi-daemon \
        binutils \
        control-freak \
        cpp \
        cpp-symlinks \
        gcc \
        gcc-symlinks \
        git \
        i2c-tools \
        iperf \
        libgcc-dev \
        libxml2 \
        make \
        nano \
        nginx \
        ntpdate \
        openssh \
        python \
        python-daemon \
        python-flask \
        python-jinja2 \
        python-misc \
        python-modules \
        python-pyserial \
        python-rascal \
        python-werkzeug \
        ruby \
        usbutils \
        usb-gadget-mode \
        uwsgi \
        vim \
        vim-vimrc \
    "

export IMAGE_BASENAME = "rascal-image"
