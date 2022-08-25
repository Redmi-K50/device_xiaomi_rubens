# Device tree for Redmi K50 (rubens) - Prebuilt

The Redmi K50 (codenamed _"rubens"_) is a high-end, mid-range smartphone from Xiaomi.

It was released in March 2022.

## Device Specifications

|                   Basic | Spec Sheet                                              |
| ----------------------: | :------------------------------------------------------ |
|                     CPU | Octa-core CPU with 4x Arm Cortex-A78 up to 2.85GHz      |
|                 Chipset | Mediatek Dimensity 8100                                 |
|                     GPU | Mali-G610 MC6                                           |
|                  Memory | 8/12 GB RAM (LPDDR5 6400Mbps)                           |
| Shipped Android Version | 12 with MIUI 13                                         |
|                 Storage | 128/256/512 GB (UFS 3.1)                                |
|                 Battery | Non-removablem, Li-Po 5500 mAh                          |
|                 Display | 1440 x 3200 pixels, 6.67 inches, 120 Hz, AMOLED, HDR10+ |
|                  Camere | 48MP(Primary) 8MP(Ultra-wide) 2MP(Telephoto-macro)      |

## Device Picture
![Redmi K50](https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1653381863.47942179.png)

## Patches

### Telephony
> https://gerrit.pixelexperience.org/c/frameworks_opt_telephony/+/15476

### Ims
> https://gerrit.pixelexperience.org/c/frameworks_opt_net_ims/+/15318

> https://gerrit.pixelexperience.org/c/frameworks_opt_net_ims/+/15317

## Building

### Complete zip
> Needed: [device/xiaomi/rubens](https://github.com/YuKongA/device_xiaomi_rubens-prebuilt); [vendor/xiaomi/rubens](https://github.com/YuKongA/vendor_xiaomi_rubens-prebuilt); [kernel/xiaomi/mt6895](https://github.com/wbs306/kernel_xiaomi_mt6895)

> Added by yourself: device/xiaomi/rubens/prebuilts/<b>vendor.img</b>; device/xiaomi/rubens/prebuilts/<b>odm.img</b>

> Patch: [Patches Needed](#Patches)

> lunch acme_rubens-userdebug

> mka bacon

### DSU sideloader
> Needed: [device/xiaomi/rubens](https://github.com/YuKongA/device_xiaomi_rubens-prebuilt); [vendor/xiaomi/rubens](https://github.com/YuKongA/vendor_xiaomi_rubens-prebuilt); [kernel/xiaomi/mt6895](https://github.com/wbs306/kernel_xiaomi_mt6895)

> Patch: [Patches Needed](#Patches), [Drop import prebuilt vendor/odm image](https://github.com/YuKongA/device_xiaomi_rubens-prebuilt/commit/96060cfb8e85fa1a1e6728c68d08b36db233fa5d)

> lunch acme_rubens-userdebug

> mka systemimage && mka productimage && cd $OUT && zip dsu.zip system.img product.img

## Credits
This tree based on Redmi Note 11T Pro+(xaga) of @wbs306
