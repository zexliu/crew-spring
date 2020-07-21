package wiki.zex.cloud.example.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum LeaveStatus implements IEnum<Integer> {

    PENDING(0),
    PASSED(1),
    REJECTED(2);
    LeaveStatus(int code) {
        this.value = code;
    }
    private final int value;

    @Override
    public Integer getValue() {
        return this.value;
    }

}