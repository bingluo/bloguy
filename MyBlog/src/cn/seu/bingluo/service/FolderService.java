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

	public List<FolderPojo> getAllFolders() {
		return folderDAOImpl.selectAllFolders();
	}

	public FolderPojo getFolderById(long folderId) {
		return folderDAOImpl.selectFolderById(folderId);
	}

	public boolean isExistFolderName(String name) {
		return folderDAOImpl.selectFolderByName(name) == null;
	}

	public long createFolder(Folder folder) {
		return folderDAOImpl.insertFolder(folder);
	}
}
