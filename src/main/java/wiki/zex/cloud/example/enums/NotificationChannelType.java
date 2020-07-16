package wiki.zex.cloud.example.enums;


import com.baomidou.mybatisplus.core.enums.IEnum;

public enum NotificationChannelType implements IEnum<Integer> {

    SYSTEM(0),
    EMAIL(1),
    SMS(2),
    APP(3);

    NotificationChannelType(int code) {
        this.value = code;
    }

    private final int value;

    @Override
    public Integer getValue() {
        return this.value;
    }


}
