package com.zylear.spring.parse.base.classloader;

import java.util.Comparator;
import java.util.List;

public class LY {

	public static void main(String[] args) {
	}

	public static List<TroopItem> QuickSelectTroopList(int res_max, int march_size_max, List<TroopItem> own_troop_list) {
		//目前选择的士兵数量
		int current_march_size = 0;
		//目前能装载的资源数量
		int current_resource = 0;

		//按装载资源由大到小排序
		own_troop_list.sort((o1, o2) -> Integer.compare(o2.load, o1.load));
		for (TroopItem troop_item : own_troop_list) {

			int load_count = troop_item.load * troop_item.own_num;
			if (load_count + current_resource <= res_max
					&& troop_item.select_num + current_march_size <= march_size_max) {

				troop_item.select_num = troop_item.own_num;
				current_resource = load_count + current_resource;
				current_march_size = troop_item.select_num + current_march_size;
			} else if (load_count + current_resource <= res_max) {
				//出兵数量超过上限
				troop_item.select_num = march_size_max - current_march_size;
				break;
			} else if (troop_item.select_num + current_march_size <= march_size_max) {
				//装载资源超过上限
				int remain = res_max - current_resource;
				troop_item.select_num = remain / troop_item.load;
				break;
			} else {
				//出兵数量和装载资源都超过上限
				int remain = res_max - current_resource;
				//根据剩余资源选出来的最大出兵数
				int resource_choose_count = remain / troop_item.load;

				//根据出兵限制选出来的最大出兵数
				int march_choose_count = march_size_max - current_march_size;
				troop_item.select_num = Math.min(resource_choose_count, march_choose_count);
				break;
			}

		}

		return own_troop_list;
	}

	public static class TroopItem {
		int id;
		int type;
		int level;
		int load;
		int force;
		int own_num;
		int select_num;
	}


}
