package com.xworkz.customerForm.repository;

import com.xworkz.customerForm.entity.CustomerEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
@Slf4j
public class AuthenticationRepoImpl implements AuthenticationRepository{

    public AuthenticationRepoImpl(){
        log.info("Repo.........");
    }

    @Autowired
    EntityManagerFactory entityManagerFactory ;

    @Override
    public boolean save(CustomerEntity customerEntity) {

        log.info("CustomerEntity, {}",customerEntity);

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
    public void updateCustomer(CustomerEntity customerEntity) {
        EntityManager entityManager =null;
        EntityTransaction entityTransaction=null;

        try{
            entityManager =entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.merge(customerEntity);
            entityTransaction.commit();

        }catch (Exception e){
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
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
           customerEntity.setFailedAttempt(0);
           customerEntity.setAccountLocked(0);
            customerEntity.setLockTime(null);

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

            log.info("CustomerEntity, {}",customerEntity1);
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

    @Override
    public Long emailCount(String email) {
        EntityManager manager=null;
        EntityTransaction entityTransaction=null;
        long count =0;
        try{
            manager= entityManagerFactory.createEntityManager();
            entityTransaction = manager.getTransaction();

            entityTransaction.begin();
           Query query= manager.createNamedQuery("countEmail");
           query.setParameter("email",email);
           count = (long) query.getSingleResult();
           entityTransaction.commit();
        }catch (Exception e){
            if(entityTransaction==null&&entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.printStackTrace();
        }finally {
            manager.close();
        }
        return count;
    }

    @Override
    public Long countPhoneNumber(long phoneNumber) {

        EntityManager manager=null;
        EntityTransaction entityTransaction=null;
        long count =0;
        try{
            manager= entityManagerFactory.createEntityManager();
            entityTransaction = manager.getTransaction();

            entityTransaction.begin();
            Query query= manager.createNamedQuery("countPhoneNumber");
            query.setParameter("phoneNumber",phoneNumber);
            count = (long) query.getSingleResult();
            entityTransaction.commit();
        }catch (Exception e){
            if(entityTransaction==null&&entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.printStackTrace();
        }finally {
            manager.close();
        }
        return count;
    }

    @Override
    public Long countName(String name) {

        EntityManager manager=null;
        EntityTransaction entityTransaction=null;
        long count =0;
        try{
            manager= entityManagerFactory.createEntityManager();
            entityTransaction = manager.getTransaction();

            entityTransaction.begin();
            Query query= manager.createNamedQuery("countName");
            query.setParameter("name",name);
            count = (long) query.getSingleResult();
            entityTransaction.commit();
        }catch (Exception e){
            if(entityTransaction==null&&entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            e.printStackTrace();
        }finally {
            manager.close();
        }
        return count;
    }
}
