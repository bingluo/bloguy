package cn.seu.bingluo.dao;

import java.util.List;

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
	public long insertFolder(Folder folder) {
		return (Long) getSqlMapClientTemplate().insert("FOLDERS.insertFolder",
				folder);
	}

	@Override
	public void deleteFolderById(long id) {
		getSqlMapClientTemplate().delete("FOLDERS.deleteFolderById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FolderPojo> selectAllFolders() {
		return getSqlMapClientTemplate().queryForList(
				"FOLDERS.selectAllFolders");
	}

	@Override
	public FolderPojo selectFolderById(long folderId) {
		return (FolderPojo) getSqlMapClientTemplate().queryForObject(
				"FOLDERS.selectFolderById", folderId);
	}

	@Override
	public FolderPojo selectFolderByName(String name) {
		return (FolderPojo) getSqlMapClientTemplate().queryForObject(
				"FOLDERS.selectFolderByName", name);
	}
}
