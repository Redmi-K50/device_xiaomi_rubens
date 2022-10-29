# Device tree for Redmi K50 (rubens) - OSS

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


## Building

### Complete zip
> Needed: [device/xiaomi/rubens](https://github.com/Redmi-K50/device_xiaomi_rubens); [vendor/xiaomi/rubens](https://github.com/Redmi-K50/vendor_xiaomi_rubens); [kernel/xiaomi/mt6895](https://github.com/wbs306/kernel_xiaomi_mt6895); [device/xiaomi/mt6895-common](https://github.com/Redmi-K50/device_xiaomi_mt6895-common); [vendor/xiaomi/mt6895-common](https://github.com/Redmi-K50/vendor_xiaomi_mt6895-common)

> Patch: [Patches Needed](#Patches)

> lunch arrow_rubens-userdebug

> m bacon

### DSU sideloader
> [device/xiaomi/rubens](https://github.com/Redmi-K50/device_xiaomi_rubens); [vendor/xiaomi/rubens](https://github.com/Redmi-K50/vendor_xiaomi_rubens); [kernel/xiaomi/mt6895](https://github.com/wbs306/kernel_xiaomi_mt6895); [device/xiaomi/mt6895-common](https://github.com/Redmi-K50/device_xiaomi_mt6895-common); [vendor/xiaomi/mt6895-common](https://github.com/Redmi-K50/vendor_xiaomi_mt6895-common)

> lunch arrow_rubens-userdebug

> m systemimage && m productimage && m odmimage && m vendorimage cd $OUT && zip dsu.zip system.img product.img odm.img vendor.img

## Credits
This tree based on Redmi Note 11T Pro+(xaga) of @wbs306
