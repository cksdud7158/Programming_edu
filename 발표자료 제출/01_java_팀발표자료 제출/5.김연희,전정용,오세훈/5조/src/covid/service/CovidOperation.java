package covid.service;

import java.util.ArrayList;

import covid.util.Fever;
import covid.vo.parent.Visitor;

public interface CovidOperation {
		public boolean checkVisitor(String name);
		public void addVisitor(Visitor v);
		public ArrayList<Visitor> getAllVisitors();
		public void deleteVistor(String name);
		public void checkMask(String name);
		public void overTemperature(double temperature);
		public void updateCondition(String name, Fever fever);
		public void updateCondition(String name, String symptom);
		public void printVisitors();
		public void printVistiors(ArrayList<Visitor> v);
}
