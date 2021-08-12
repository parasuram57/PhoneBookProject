package com.hibernet.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernet.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Serializable> {

}
