package edu.iu.c322.assetmanagement.assetservice.controller;

import edu.iu.c322.assetmanagement.assetservice.client.OrganizationClient;
import edu.iu.c322.assetmanagement.assetservice.model.Asset;
import edu.iu.c322.assetmanagement.assetservice.model.License;
import edu.iu.c322.assetmanagement.assetservice.model.Organization;
import edu.iu.c322.assetmanagement.assetservice.repository.AssetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assets")
public class AssetController {
    private AssetRepository repository;

    private OrganizationClient organizationClient;

    public AssetController(AssetRepository repository, OrganizationClient organizationClient) {
        this.repository = repository;
        this.organizationClient = organizationClient;
    }

    @GetMapping
    public List<Asset> getAssets(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Asset getAsset(@PathVariable int id){
        Asset asset = repository.findAll().stream().filter(x->x.getId() == id).findAny().orElse(null);
        if (asset == null) {
            throw new IllegalStateException("asset not found");
        }
        else {
            return asset;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@RequestBody Asset asset){
        Asset addedAsset = repository.save(asset);
        return addedAsset.getId();
    }

}
