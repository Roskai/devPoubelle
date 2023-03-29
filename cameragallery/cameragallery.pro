TARGET = cameragallery

CONFIG += sailfishapp
QT += qml quick multimedia

HEADERS += src/cameraconfigs.h

SOURCES += src/cameragallery.cpp \
           src/cameraconfigs.cpp

# The .desktop file
desktop.files = cameragallery.desktop
OTHER_FILES += \
    qml/*.qml \
    qml/cover/*.qml \
    qml/pages/*.qml \
    rpm/cameragallery.yaml \
    rpm/cameragallery.spec
