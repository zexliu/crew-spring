package wiki.zex.cloud.example.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum LeaveLogType implements IEnum<Integer> {

    CREATE(0),
    UPDATE(1),
    PASS(2),
    REJECT(3);
    LeaveLogType(int code) {
        this.value = code;
    }
    private final int value;

    @Override
    public Integer getValue() {
        return this.value;
    }

}