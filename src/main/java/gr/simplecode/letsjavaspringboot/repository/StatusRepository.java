/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.simplecode.letsjavaspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.simplecode.letsjavaspringboot.model.StatusEntity;

/**
 *
 * @author oldspice
 */
@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long> {
}
