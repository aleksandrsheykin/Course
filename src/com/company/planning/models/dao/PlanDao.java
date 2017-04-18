package com.company.planning.models.dao;

import com.company.planning.models.pojo.Plan;
import com.company.planning.models.pojo.Product;

import java.util.List;

/**
 * Created by admin on 18.04.2017.
 */
public interface PlanDao {
    public List<Plan> getAll();
    public Plan get(int id);
    public boolean update(Plan plan);
    public boolean delete(Plan plan);
}
