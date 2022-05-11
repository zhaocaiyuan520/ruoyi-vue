package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysHomeArticle;

/**
 * 主页详情Service接口
 * 
 * @author ruoyi
 * @date 2022-05-08
 */
public interface ISysHomeArticleService 
{
    /**
     * 查询主页详情
     * 
     * @param articleId 主页详情主键
     * @return 主页详情
     */
    public SysHomeArticle selectSysHomeArticleByArticleId(Long articleId);

    /**
     * 查询主页详情列表
     * 
     * @param sysHomeArticle 主页详情
     * @return 主页详情集合
     */
    public List<SysHomeArticle> selectSysHomeArticleList(SysHomeArticle sysHomeArticle);
    /**
     * 查询主页详情列表
     *
     * @param sysHomeArticle 主页详情
     * @return 主页详情集合
     */
    public List<SysHomeArticle> selectSysHomeArticleListAndPDF(SysHomeArticle sysHomeArticle);

    /**
     * 新增主页详情
     * 
     * @param sysHomeArticle 主页详情
     * @return 结果
     */
    public int insertSysHomeArticle(SysHomeArticle sysHomeArticle);

    /**
     * 修改主页详情
     * 
     * @param sysHomeArticle 主页详情
     * @return 结果
     */
    public int updateSysHomeArticle(SysHomeArticle sysHomeArticle);

    /**
     * 批量删除主页详情
     * 
     * @param articleIds 需要删除的主页详情主键集合
     * @return 结果
     */
    public int deleteSysHomeArticleByArticleIds(Long[] articleIds);

    /**
     * 删除主页详情信息
     * 
     * @param articleId 主页详情主键
     * @return 结果
     */
    public int deleteSysHomeArticleByArticleId(Long articleId);

    List<SysHomeArticle> selectSysArticleListByIds(Long[] articleIds);
}
