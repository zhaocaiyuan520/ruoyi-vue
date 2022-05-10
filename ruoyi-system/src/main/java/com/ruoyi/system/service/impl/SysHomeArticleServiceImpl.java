package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysHomeArticleMapper;
import com.ruoyi.system.domain.SysHomeArticle;
import com.ruoyi.system.service.ISysHomeArticleService;

/**
 * 主页详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-08
 */
@Service
public class SysHomeArticleServiceImpl implements ISysHomeArticleService 
{
    @Autowired
    private SysHomeArticleMapper sysHomeArticleMapper;

    /**
     * 查询主页详情
     * 
     * @param articleId 主页详情主键
     * @return 主页详情
     */
    @Override
    public SysHomeArticle selectSysHomeArticleByArticleId(Long articleId)
    {
        return sysHomeArticleMapper.selectSysHomeArticleByArticleId(articleId);
    }

    /**
     * 查询主页详情列表
     * 
     * @param sysHomeArticle 主页详情
     * @return 主页详情
     */
    @Override
    public List<SysHomeArticle> selectSysHomeArticleList(SysHomeArticle sysHomeArticle)
    {
        return sysHomeArticleMapper.selectSysHomeArticleList(sysHomeArticle);
    }
    /**
     * 查询主页详情列表
     *
     * @param sysHomeArticle 主页详情
     * @return 主页详情
     */
    @Override
    public List<SysHomeArticle> selectSysHomeArticleListAndPDF(SysHomeArticle sysHomeArticle)
    {
        return sysHomeArticleMapper.selectSysHomeArticleListAndPDF(sysHomeArticle);
    }
    /**
     * 新增主页详情
     * 
     * @param sysHomeArticle 主页详情
     * @return 结果
     */
    @Override
    public int insertSysHomeArticle(SysHomeArticle sysHomeArticle)
    {
        sysHomeArticle.setCreateTime(DateUtils.getNowDate());
        return sysHomeArticleMapper.insertSysHomeArticle(sysHomeArticle);
    }

    /**
     * 修改主页详情
     * 
     * @param sysHomeArticle 主页详情
     * @return 结果
     */
    @Override
    public int updateSysHomeArticle(SysHomeArticle sysHomeArticle)
    {
        sysHomeArticle.setUpdateTime(DateUtils.getNowDate());
        return sysHomeArticleMapper.updateSysHomeArticle(sysHomeArticle);
    }

    /**
     * 批量删除主页详情
     * 
     * @param articleIds 需要删除的主页详情主键
     * @return 结果
     */
    @Override
    public int deleteSysHomeArticleByArticleIds(Long[] articleIds)
    {
        return sysHomeArticleMapper.deleteSysHomeArticleByArticleIds(articleIds);
    }

    /**
     * 删除主页详情信息
     * 
     * @param articleId 主页详情主键
     * @return 结果
     */
    @Override
    public int deleteSysHomeArticleByArticleId(Long articleId)
    {
        return sysHomeArticleMapper.deleteSysHomeArticleByArticleId(articleId);
    }
}
