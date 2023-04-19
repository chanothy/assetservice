package edu.iu.c322.assetmanagement.assetservice.repository;

import edu.iu.c322.assetmanagement.assetservice.model.Asset;
import edu.iu.c322.assetmanagement.assetservice.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
}
