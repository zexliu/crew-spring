package wiki.zex.cloud.example.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import wiki.zex.cloud.example.entity.SyDict;
import wiki.zex.cloud.example.entity.SyDictEntry;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class SyDictTree extends SyDict{

    List<SyDictEntry> entries;

}
