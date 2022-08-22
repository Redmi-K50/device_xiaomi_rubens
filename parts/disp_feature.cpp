#include <iostream>
#include <unistd.h>
#include <fcntl.h>
#include <sys/ioctl.h>

#include <drm/mi_disp.h>

#define DISP_FEATURE_DEV_PATH "/dev/mi_display/disp_feature"

int main(int argc, char **argv) {
    if(argc != 3) {
        fprintf(stderr, "Usage: %s <feature id> <0|1>\n", argv[0]);
        return -1;
    }

    __u64 feature_id = atoi(argv[1]);
    __s32 enabled = atoi(argv[2]);

    if (!isSupportDispFeatureId(feature_id)) {
        fprintf(stderr, "Unsupported feature id.\n");
        return -1;
    }

    if (enabled != 0 && enabled != 1) {
        fprintf(stderr, "Enabled should be 0 or 1\n");
        return -1;
    }

    int fd = open(DISP_FEATURE_DEV_PATH, O_RDWR);

    struct disp_base base = {
        MI_DISP_PRIMARY, MI_DISP_FLAG_BLOCK
    };

    struct disp_feature_req req = {
        base, feature_id, enabled, 0, 0, 0, 0
    };
    
    ioctl(fd, MI_DISP_IOCTL_SET_FEATURE, &req);

    close(fd);
}
