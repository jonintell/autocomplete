package com.bottomline.autocomplete.service;

import java.util.List;

import com.bottomline.autocomplete.model.Name;
import com.bottomline.autocomplete.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;


@Service
public class NameService {

    private final Trie trie = new Trie();

    @Autowired
    private NameRepository nameRepository;

    @PostConstruct
    private void init() {
        List<Name> names = nameRepository.findAll();
        names.forEach(name -> trie.insert(name.getName()));
    }

    public List<String> autocomplete(String prefix) {
        return trie.autocomplete(prefix);
    }

}
