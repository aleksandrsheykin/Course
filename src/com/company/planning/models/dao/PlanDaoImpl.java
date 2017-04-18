package com.company.planning.models.dao;

import com.company.Main;
import com.company.planning.models.pojo.Plan;
import com.company.planning.models.pojo.User;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.company.planning.models.connection.*;

import java.sql.*;
import java.util.List;

/**
 * Created by admin on 18.04.2017.
 */
public class PlanDaoImpl implements PlanDao {

    static {
        PropertyConfigurator.configure("log4j.properties");
    }
    private static Logger logger = Logger.getLogger(Main.class);

    @Override
    public List<Plan> getAll() {
        Connection connection = DataBaseManager.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *"+
                    " from plans");

            ResultSet result = preparedStatement.executeQuery();

            List<Plan> listPlan = null;
            while (result.next()) {
                listPlan.add(new Plan(
                        result.getInt("plan_id"),
                        result.getDate("plan_data"),
                        result.getInt("plan_quantity"),
                        result.getInt("plan_cost"),
                        result.getInt("plan_user_id"),
                        result.getInt("plan_product_id"))
                );
            }
            return listPlan;

        } catch (SQLException e) {
            logger.warn("SQLException in Plan.getAll()");
            return null;
        }
    }

    @Override
    public Plan get(int id) {
        Connection connection = DataBaseManager.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *"+
                    " from plans where plan_id=?");
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            return new Plan(
                    result.getInt("plan_id"),
                    result.getDate("plan_data"),
                    result.getInt("plan_quantity"),
                    result.getInt("plan_cost"),
                    result.getInt("plan_user_id"),
                    result.getInt("plan_product_id")
            );

        } catch (SQLException e) {
            logger.warn("SQLException in Plan.get()");
            return null;
        }
    }

    @Override
    public boolean update(Plan plan) {
        Connection connection = DataBaseManager.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE plans SET(" +
                    " plan_data, plan_quantity, plan_cost, plan_user_id, plan_product_id)" +
                    " = (?, ?, ?, ?, ?) WHERE plan_id = ?");
            preparedStatement.setDate(1, (Date) plan.getDatePlan());
            preparedStatement.setInt(2, plan.getQuantity());
            preparedStatement.setInt(3, plan.getCost());
            preparedStatement.setInt(4, plan.getUserId());
            preparedStatement.setInt(5, plan.getProductId());
            preparedStatement.setInt(6, plan.getId_plan());
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            logger.warn("SQLException in Plan.update()");
            return false;
        }
    }

    @Override
    public boolean delete(Plan plan) {
        Connection connection = DataBaseManager.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from plans " +
                    " WHERE plan_id = ?");
            preparedStatement.setInt(1, plan.getId_plan());
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            logger.warn("SQLException in Plan.delete()");
            return false;
        }
    }
}
