# MuteCamera
Turn the camera shutter sound off on Japanese android phone.

You can enable and disable using quick setting.  
This repository is for custom rom.  

## Integration
Add the following to local_manifests  
```
<remote name="tk823" fetch="https://github.com/tk823" />
<project path="packages/apps/MuteCamera" name="app_MuteCamera" remote="tk823" revision="main"/>
```

Add the following to `build/make/target/product/base_system.mk`  
```
PRODUCT_PACKAGES += \  
    MuteCamera
```
