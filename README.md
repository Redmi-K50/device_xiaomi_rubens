Copyright (C) 2022 LineageOS
# Android device tree for Redmi K50 (rubens)

The Redmi K50 (codenamed _"rubens"_) is a high-end, mid-range smartphone from Xiaomi.

It was released in March 2022.

## Device specifications

|                   Basic | Spec Sheet                                         |
| ----------------------: | :------------------------------------------------- |
|                     CPU | Octa-core CPU with 4x Arm Cortex-A78 up to 2.85GHz |
|                 Chipset | Mediatek Dimensity 8100                            |
|                     GPU | Mali-G610 MC6                                      |
|                  Memory | 8/12 GB RAM (LPDDR5 6400Mbps)                      |
| Shipped Android Version | 12                                                 |
|                 Storage | 128/256/512 GB (UFS 3.1)                           |
|                 Battery | 5500 mAh                                           |
|                 Display | 1440 x 3200 pixels, 6.67 inches, 60/120 hz         |

![Redmi K50](https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1653381863.47942179.png)

This tree based on work of @wbs306 - all credits belong to him.

## Dependencies
### Vibrator
> https://github.com/phhusson/platform_frameworks_native/commit/59d3ecc59bf95963dfd88f842de66d9f477f2fa2
### SkSurface
> https://github.com/PixelExperience/frameworks_native/commit/bdc6b69c97a2c07c64b3ebae7d410e886924fd6e
### Telephony
> https://github.com/PixelExperience/frameworks_opt_telephony/commit/538afb21007e0497bde131b1ef327fb93ee37031
### Ims
> https://github.com/PixelExperience/frameworks_opt_net_ims/commit/ddacb4ba5ec943a410bb74ea31ea7b32003ce708
> https://github.com/PixelExperience/frameworks_opt_net_ims/commit/9de68f4da30fc61d95bdbdfbd400f8080ea00cec