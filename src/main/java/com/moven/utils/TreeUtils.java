package com.moven.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.moven.configration.BaseStringConfig;
import com.moven.model.Menu;
import com.moven.model.Tree;

public class TreeUtils {
	public static List<Tree> getTree(List<Menu> menuList){
		List<Tree> treeList = new ArrayList<Tree>();
		Map<Integer, Tree> treeTemp = new HashMap<Integer, Tree>();
		if(null != menuList && menuList.size() > 0){
			for(Menu menu : menuList){
				if(null == menu.getParentId()){
					// 定义父节点
					Tree tree = new Tree();
					tree.setId(menu.getId());
					tree.setText(menu.getTitle());
					tree.setIconCls(BaseStringConfig.ICON_FOLDER);
					tree.setUrl(menu.getUrl());
					treeTemp.put(tree.getId(), tree);
				} else {
					Tree parent = treeTemp.get(menu.getParentId());
					List<Tree> children = parent.getChildren();
					if(null == children){
						children = new ArrayList<Tree>();
					}
					// 定义子节点
					Tree tree = new Tree();
					tree.setId(menu.getId());
					tree.setText(menu.getTitle());
					tree.setIconCls(BaseStringConfig.ICON_STAR);
					tree.setUrl(menu.getUrl());
					children.add(tree);
					parent.setChildren(children);
				}
			}
		}
		Set<Integer> keys = treeTemp.keySet();
		for(Integer key : keys){
			Tree tree = treeTemp.get(key);
			treeList.add(tree);
		}
		return treeList;
	}
}
