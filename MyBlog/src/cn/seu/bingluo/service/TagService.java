package cn.seu.bingluo.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.seu.bingluo.dao.TagDAOImpl;
import cn.seu.bingluo.entity.Tag;

@Service
public class TagService {
	@Autowired
	private TagDAOImpl tagDAOImpl;

	public Tag getTagById(long id) {
		return tagDAOImpl.selectTagById(id);
	}

	private String tagToXml(Tag tag) {
		StringBuilder sb = new StringBuilder();
		String r = Integer.toHexString(new Double(Math.random() * 128)
				.intValue() + 128);
		String g = Integer.toHexString(new Double(Math.random() * 128)
				.intValue() + 128);
		String b = Integer.toHexString(new Double(Math.random() * 128)
				.intValue() + 128);
		sb.append("<a href='http://localhost/tag-blog/")
				.append(tag.getTagId())
				.append(".html' title='1 topics' rel='tag' style='font-size:30pt;' color='0x")
				.append(r).append(g).append(b).append("'>")
				.append(tag.getTagName()).append("</a>");
		return sb.toString();
	}

	public Map<String, Tag> getTagMap() {
		List<Tag> tags = tagDAOImpl.selectAllTags();
		HashMap<String, Tag> map = new HashMap<String, Tag>();
		for (Tag tag : tags) {
			map.put(tag.getTagName(), tag);
		}
		return map;
	}

	public List<Tag> getTagList() {
		List<Tag> tags = tagDAOImpl.selectAllTags();
		return tags;
	}

	/**
	 * 更新标签数据的XML
	 */
	public void constructTagXml() {
		List<Tag> list = tagDAOImpl.selectAllTags();
		StringBuilder sb = new StringBuilder();
		sb.append("<tags>\n");
		for (Tag tag : list) {
			sb.append(tagToXml(tag)).append("\n");
		}
		sb.append("</tags>");

		try {
			File f = new File("./webapp/static/swf/tagcloud.xml");
			if (!f.exists()) {
				f.createNewFile();
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(sb.toString());
			output.flush();
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
