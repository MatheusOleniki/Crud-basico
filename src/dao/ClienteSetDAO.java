package dao;

import domain.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClienteSetDAO implements IClienteDAO{

    private Set<Cliente> set;

    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (set.contains(cliente)) {
            return false;
        } else {
            set.add(cliente);
            return true;
        }
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = null;
        for (Cliente cliente: set) {
            if (cliente.getCpf().equals(cpf)) {
                clienteCadastrado = cliente;
                break;
            }
            if (clienteCadastrado != null) {
                set.remove(clienteCadastrado);
            }
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        if (this.set.contains(cliente)){
            for (Cliente clienteCadastrado : this.set) {
                if (clienteCadastrado.equals(cliente)) {
                    clienteCadastrado.setNome(cliente.getNome());
                    clienteCadastrado.setTel(cliente.getTel());
                    clienteCadastrado.setNumeroCasa(cliente.getNumeroCasa());
                    clienteCadastrado.setEnd(cliente.getEnd());
                    clienteCadastrado.setCidade(cliente.getCidade());
                    clienteCadastrado.setEstado(cliente.getEstado());
                    break;
                }
            }
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        Cliente clienteCadastrado = null;
        for (Cliente cliente: this.set) {
            if (cliente.getCpf().equals(cpf)) {
                return clienteCadastrado;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }
}
