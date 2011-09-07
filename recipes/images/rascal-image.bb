require recipes/images/minimal-image.bb

IMAGE_INSTALL += "\
        ack \
        avahi-daemon \
        binutils \
        control-freak \
        cpp \
        cpp-symlinks \
        curl \
        gcc \
        gcc-symlinks \
        git \
        htop \
        i2c-tools \
        iotop \
        iperf \
        libgcc-dev \
        libxml2 \
        make \
        mtr \
        nano \
        nginx \
        ntpdate \
        openssh \
        perl \
        perl-modules \
        python \
        python-daemon \
        python-flask \
        python-jinja2 \
        python-misc \
        python-modules \
        python-pyserial \
        python-pytronics \
        python-werkzeug \
        ruby \
        sysstat \
        usbutils \
        usb-gadget-mode \
        uwsgi \
        vim \
        vim-vimrc \
    "

export IMAGE_BASENAME = "rascal-image"
