package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysHomeArticle;
import com.ruoyi.system.service.ISysHomeArticleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 主页详情Controller
 * 
 * @author ruoyi
 * @date 2022-05-08
 */
@RestController
@RequestMapping("/system/article")
public class SysHomeArticleController extends BaseController
{
    @Autowired
    private ISysHomeArticleService sysHomeArticleService;

    /**
     * 查询主页详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:article:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysHomeArticle sysHomeArticle)
    {
        startPage();
//        List<SysHomeArticle> list = sysHomeArticleService.selectSysHomeArticleList(sysHomeArticle);
        List<SysHomeArticle> list = sysHomeArticleService.selectSysHomeArticleListAndPDF(sysHomeArticle);
        return getDataTable(list);
    }

    /**
     * 导出主页详情列表
     */
    @PreAuthorize("@ss.hasPermi('system:article:export')")
    @Log(title = "主页详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysHomeArticle sysHomeArticle)
    {
        List<SysHomeArticle> list = sysHomeArticleService.selectSysHomeArticleList(sysHomeArticle);
        ExcelUtil<SysHomeArticle> util = new ExcelUtil<SysHomeArticle>(SysHomeArticle.class);
        util.exportExcel(response, list, "主页详情数据");
    }

    /**
     * 获取主页详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:article:query')")
    @GetMapping(value = "/{articleId}")
    public AjaxResult getInfo(@PathVariable("articleId") Long articleId)
    {
        return AjaxResult.success(sysHomeArticleService.selectSysHomeArticleByArticleId(articleId));
    }

    /**
     * 新增主页详情
     */
    @PreAuthorize("@ss.hasPermi('system:article:add')")
    @Log(title = "主页详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysHomeArticle sysHomeArticle)
    {
        return toAjax(sysHomeArticleService.insertSysHomeArticle(sysHomeArticle));
    }

    /**
     * 修改主页详情
     */
    @PreAuthorize("@ss.hasPermi('system:article:edit')")
    @Log(title = "主页详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysHomeArticle sysHomeArticle)
    {
        return toAjax(sysHomeArticleService.updateSysHomeArticle(sysHomeArticle));
    }

    /**
     * 删除主页详情
     */
    @PreAuthorize("@ss.hasPermi('system:article:remove')")
    @Log(title = "主页详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{articleIds}")
    public AjaxResult remove(@PathVariable Long[] articleIds)
    {
        return toAjax(sysHomeArticleService.deleteSysHomeArticleByArticleIds(articleIds));
    }
}
