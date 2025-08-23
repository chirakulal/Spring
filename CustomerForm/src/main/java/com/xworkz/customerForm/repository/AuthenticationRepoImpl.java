package com.xworkz.customerForm.repository;

import com.xworkz.customerForm.entity.CustomerEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class AuthenticationRepoImpl implements AuthenticationRepository{

    public AuthenticationRepoImpl(){
        System.out.println("Repo.........");
    }

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("authentication");

    @Override
    public boolean save(CustomerEntity customerEntity) {

        System.out.println(customerEntity);

        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        try{


            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(customerEntity);
            entityTransaction.commit();

            return true;
        }catch (Exception e){
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
        }finally {
            entityManager.close();
        }
        return false;
    }


    @Override
    public CustomerEntity sigIn(String name) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        CustomerEntity customerEntity;
        try{
            entityManager=entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            entityTransaction.begin();
         Query query = entityManager.createNamedQuery("getPasswordAndName");
            query.setParameter("nameBy",name);
        customerEntity =(CustomerEntity)  query.getSingleResult();
          entityTransaction.commit();


          return customerEntity;

        }catch (Exception e){
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }


        return null;
    }

    @Override
    public boolean updatePassword(String email, String password) {
        EntityManager entityManager =null;
        EntityTransaction entityTransaction =null;
        CustomerEntity customerEntity;

        try{
            entityManager =entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            entityTransaction.begin();
           Query query = entityManager.createNamedQuery("getAllByEmail");
            query.setParameter("emailBY",email);
           customerEntity =(CustomerEntity) query.getSingleResult();
           customerEntity.setPassword(password);

           entityTransaction.commit();
           return true;
        }catch (Exception e){
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }

            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        return false;
    }

    @Override
    public CustomerEntity getByEmail(String email) {

        EntityManager entityManager=null;
        EntityTransaction entityTransaction =null;
        CustomerEntity customerEntity;

        try{
            entityManager=entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            entityTransaction.begin();
           Query query = entityManager.createNamedQuery("getAllByEmail");
            query.setParameter("emailBY",email);
           customerEntity =(CustomerEntity) query.getSingleResult();

           entityTransaction.commit();

           return customerEntity;

        }catch (Exception e){
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }


        return null;
    }

    @Override
    public boolean update(CustomerEntity customerEntity) {

        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        CustomerEntity customerEntity1 =new CustomerEntity();

        try{
            entityManager =entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            entityTransaction.begin();

            customerEntity1 = getByEmail(customerEntity.getEmail());
            customerEntity1.setName(customerEntity.getName());
            customerEntity1.setPhoneNumber(customerEntity.getPhoneNumber());
            customerEntity1.setAge(customerEntity.getAge());
            customerEntity1.setAddress(customerEntity.getAddress());
            customerEntity1.setGender(customerEntity.getGender());

            System.out.println(customerEntity1);
            entityManager.merge(customerEntity1);
            entityTransaction.commit();

            return true;
        }catch (Exception e){
            if(entityTransaction.isActive()){
                entityTransaction.rollback();


            }
            e.printStackTrace();

        }finally {
            entityManager.close();
        }

        return false;
    }
}
