package cn.seu.bingluo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.seu.bingluo.dao.FolderDAOImpl;
import cn.seu.bingluo.entity.Folder;
import cn.seu.bingluo.entity.FolderPojo;

@Service
public class FolderService {
	@Autowired
	private FolderDAOImpl folderDAOImpl;

	public List<FolderPojo> getAllFolders(int userId) {
		return folderDAOImpl.selectAllFoldersByUserId(userId);
	}

	public FolderPojo getFolderById(int folderId) {
		return folderDAOImpl.selectFolderById(folderId);
	}

	public boolean isExistFolderName(String folderName, int userId) {
		return folderDAOImpl.selectFolderByNameAndUserId(folderName, userId) == null;
	}

	public long createFolder(Folder folder) {
		return folderDAOImpl.insertFolder(folder);
	}
}
