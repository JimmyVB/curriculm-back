package com.curriculum.app.models.services;

import com.curriculum.app.models.entity.Usuario;

public interface IUsuarioService {

    public Usuario findByUsername(String username);
}
