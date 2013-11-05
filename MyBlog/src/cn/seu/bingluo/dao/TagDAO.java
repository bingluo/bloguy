package cn.seu.bingluo.dao;

import java.util.List;

import cn.seu.bingluo.entity.Tag;

public interface TagDAO {
	/**
	 * 根据Id获取tag
	 * 
	 * @param tagId
	 * @return
	 */
	Tag selectTagById(long tagId);

	/**
	 * 增加tag
	 * 
	 * @param tagName
	 */
	void insertTag(String tagName);

	/**
	 * 相应tag下blog数+1
	 * 
	 * @param tagId
	 */
	void addTagCount(long tagId);

	/**
	 * 获取所有tag
	 * 
	 * @return
	 */
	List<Tag> selectAllTags();

	/**
	 * 根据tagName获取tag
	 * 
	 * @param tagName
	 * @return
	 */
	Tag selectTagByName(String tagName);
}
