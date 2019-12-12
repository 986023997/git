package com.ScientificItem.model;

public class Depart {

		private  int Depart_id;//部门id
		private String Depart_name;//部门名称
		public int getDepart_id() {
			return Depart_id;
		}
		public void setDepart_id(int depart_id) {
			Depart_id = depart_id;
		}
		public String getDepart_name() {
			return Depart_name;
		}
		public void setDepart_name(String depart_name) {
			Depart_name = depart_name;
		}
		public Depart(int depart_id, String depart_name) {
			super();
			Depart_id = depart_id;
			Depart_name = depart_name;
		}
		
		
}
