package cn.seu.bingluo.dao;

import java.util.List;

import cn.seu.bingluo.entity.Folder;
import cn.seu.bingluo.entity.FolderPojo;

public interface FolderDAO {
	/**
	 * 插入文件夹(归档)
	 * 
	 * @param folder
	 */
	long insertFolder(Folder folder);

	/**
	 * 删除文件夹
	 * 
	 * @param id
	 */
	void deleteFolderById(long id);

	/**
	 * 获取所有归档
	 * 
	 * @return
	 */
	List<FolderPojo> selectAllFolders();

	/**
	 * 根据归档ID获取归档
	 * 
	 * @param folderId
	 * @return
	 */

	FolderPojo selectFolderById(long folderId);

	/**
	 * 根据分类名获取归档
	 * 
	 * @param name
	 * @return
	 */
	FolderPojo selectFolderByName(String name);
}
