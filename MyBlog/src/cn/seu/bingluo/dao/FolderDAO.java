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
	int insertFolder(Folder folder);

	/**
	 * 删除文件夹
	 * 
	 * @param id
	 */
	void deleteFolderByIdAndUser(int id, int userId);

	/**
	 * 获取用户所有归档
	 * 
	 * @return
	 */
	List<FolderPojo> selectAllFoldersByUserId(int userId);

	/**
	 * 根据归档ID获取归档
	 * 
	 * @param folderId
	 * @return
	 */
	FolderPojo selectFolderById(int folderId);

	/**
	 * 根据归档名、用户ID获取归档
	 * 
	 * @param folderName
	 * @param userId
	 * @return
	 */
	FolderPojo selectFolderByNameAndUserId(String folderName, int userId);
}
