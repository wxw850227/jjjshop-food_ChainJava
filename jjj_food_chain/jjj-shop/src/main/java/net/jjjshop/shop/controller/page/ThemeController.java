

package net.jjjshop.shop.controller.page;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.jjjshop.common.enums.SettingEnum;
import net.jjjshop.common.util.SettingUtils;
import net.jjjshop.framework.common.api.ApiResult;
import net.jjjshop.framework.log.annotation.OperationLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(value = "setting", tags = {"主题设置"})
@RestController
@RequestMapping("/shop/page/page/theme")
public class ThemeController {

    @Autowired
    private SettingUtils settingUtils;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @RequiresPermissions("/page/page/theme/index")
    @OperationLog(name = "index")
    @ApiOperation(value = "index", response = String.class)
    public ApiResult<JSONObject> index() throws Exception{
        JSONObject vo = settingUtils.getShopSetting(SettingEnum.THEME.getKey(), null);
        return ApiResult.ok(vo);
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @RequiresPermissions("/page/page/theme/index")
    @OperationLog(name = "index")
    @ApiOperation(value = "index", response = String.class)
    public ApiResult<String> index(@RequestBody JSONObject jsonData) throws Exception{
        settingUtils.saveShopSetting(SettingEnum.THEME.getKey(), jsonData);
        return ApiResult.ok("保存成功");
    }
}
