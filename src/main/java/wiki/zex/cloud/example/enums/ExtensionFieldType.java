package wiki.zex.cloud.example.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum ExtensionFieldType implements IEnum<Integer> {

    LONG_VALUE(1),
    DOUBLE_VALUE(2),
    TEXT_VALUE(3);
    ExtensionFieldType(int code) {
        this.value = code;
    }
    private final int value;

    @Override
    public Integer getValue() {
        return this.value;
    }

}