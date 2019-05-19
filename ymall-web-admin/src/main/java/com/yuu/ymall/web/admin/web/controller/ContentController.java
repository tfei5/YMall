package com.yuu.ymall.web.admin.web.controller;

import com.yuu.ymall.commons.dto.BaseResult;
import com.yuu.ymall.domain.TbPanelContent;
import com.yuu.ymall.web.admin.commons.dto.PageInfo;
import com.yuu.ymall.web.admin.service.ContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname ContentController
 * @Date 2019/5/16 23:51
 * @Created by Yuu
 */
@RestController
@Api(description = "内容列表信息")
@RequestMapping("content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    /**
     * 通过 panelId 获取板块内容列表
     *
     * @param panelId 板块 id
     * @return
     */
    @GetMapping("list/{panelId}")
    @ApiOperation("通过 panelId 获取板块内容列表")
    public PageInfo<TbPanelContent> getContentByCid(@PathVariable int panelId) {
        PageInfo<TbPanelContent> pageInfo = contentService.getPanelContentListByPanelId(panelId);
        return pageInfo;
    }

    /**
     * 编辑板块内容
     *
     * @param tbPanelContent 板块内容
     * @return
     */
    @PostMapping("update")
    @ApiOperation(value = "编辑板块内容")
    public BaseResult updateContent(@ModelAttribute TbPanelContent tbPanelContent) {
        contentService.updateContent(tbPanelContent);
        return BaseResult.success();
    }

    /**
     * 删除板块内容
     *
     * @param ids 板块内容的 id 数组
     * @return
     */
    @DeleteMapping("delete/{ids}")
    @ApiOperation(value = "删除板块内容")
    public BaseResult deleteContent(@PathVariable int[] ids) {
        contentService.deletePanelContent(ids);
        return BaseResult.success("删除成功!");
    }

    /**
     * 添加板块内容
     *
     * @param tbPanelContent 板块内容
     * @return
     */
    @PostMapping("add")
    @ApiOperation(value = "添加板块内容")
    public BaseResult addContent(@ModelAttribute TbPanelContent tbPanelContent) {
        contentService.addPanelContent(tbPanelContent);
        return BaseResult.success("添加成功！");
    }

}