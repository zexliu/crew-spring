package wiki.zex.cloud.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import wiki.zex.cloud.example.entity.SbStaff;
import wiki.zex.cloud.example.req.Pageable;
import wiki.zex.cloud.example.req.SbStaffReq;
import wiki.zex.cloud.example.resp.SbStaffDetailsResp;
import wiki.zex.cloud.example.resp.SbStaffResp;
import wiki.zex.cloud.example.resp.SimpleResp;
import wiki.zex.cloud.example.service.ISbStaffService;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zex
 * @since 2020-06-29
 */
@RestController
@RequestMapping("/api/v1/staffs")
@Api(tags = "人员管理")
public class SbStaffController {

    @Autowired
    private ISbStaffService iSbStaffService;

    @GetMapping
    public IPage<SbStaffResp> list(Pageable pageable, String mobile,String realName, String workNo,Long teamId,Long groupId,Integer jobTitle){
        return iSbStaffService.list(pageable.convert(),mobile,realName,workNo,teamId,groupId,jobTitle);
    }

    @PostMapping
    public SbStaff create(@RequestBody @Valid SbStaffReq req){
        return iSbStaffService.create(req);
    }


    @GetMapping("/{id}")
    public SbStaffDetailsResp getById(@PathVariable Long id ){
        return iSbStaffService.getDetailsById(id);
    }



    @PutMapping("/{id}")
    public SbStaff update(@PathVariable Long id ,@RequestBody @Valid SbStaffReq req){
        return iSbStaffService.update(id,req);
    }

    @DeleteMapping("/{id}")
    public SimpleResp delete(@PathVariable Long id ){
         iSbStaffService.delete(id);

        return SimpleResp.SUCCESS;
    }


}
