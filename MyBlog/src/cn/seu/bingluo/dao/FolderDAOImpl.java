package cn.seu.bingluo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Component;

import cn.seu.bingluo.entity.Folder;
import cn.seu.bingluo.entity.FolderPojo;

import com.ibatis.sqlmap.client.SqlMapClient;

@Component
public class FolderDAOImpl extends SqlMapClientDaoSupport implements FolderDAO {

	@Autowired(required = true)
	public void setSqlMapClientTemp(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}

	@Override
	public int insertFolder(Folder folder) {
		return (Integer) getSqlMapClientTemplate().insert(
				"FOLDERS.insertFolder", folder);
	}

	@Override
	public void deleteFolderByIdAndUser(int id, int userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("folderId", id);
		map.put("userId", userId);
		getSqlMapClientTemplate()
				.delete("FOLDERS.deleteFolderByIdAndUser", map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FolderPojo> selectAllFoldersByUserId(int userId) {
		return getSqlMapClientTemplate().queryForList(
				"FOLDERS.selectAllFoldersByUserId", userId);
	}

	@Override
	public FolderPojo selectFolderById(int folderId) {
		return (FolderPojo) getSqlMapClientTemplate().queryForObject(
				"FOLDERS.selectFolderById", folderId);
	}

	@Override
	public FolderPojo selectFolderByNameAndUserId(String folderName, int userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("folderName", folderName);
		map.put("userId", userId);
		return (FolderPojo) getSqlMapClientTemplate().queryForObject(
				"FOLDERS.selectFolderByNameAndUserId", map);
	}
}
