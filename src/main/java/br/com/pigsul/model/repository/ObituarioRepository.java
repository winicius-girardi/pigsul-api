package br.com.pigsul.model.repository;

import br.com.pigsul.model.entity.Obituario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ObituarioRepository  {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ObituarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Obituario> getObituarioByLoteId(Integer loteId) {
        return jdbcTemplate.query("SELECT * FROM app_schema.obituario  WHERE id_lote= ?",
                            (rs, rowNum) -> new Obituario(rs.getInt("id_lote"),rs.getInt("id_obituario"),
                            rs.getInt("id_causa_morte"),rs.getInt("quantidade_animais_mortos"),rs.getFloat("peso_medio_estimado")),
                            loteId
        );

    }


    public void createObituario(Obituario obituario) {
        Object[] params={obituario.getIdLote(),obituario.getIdCausaMorte(),obituario.getQuantidadeAnimaisMortos(),obituario.getPesoMedioEstimado()};

        jdbcTemplate.update("INSERT INTO app_schema.obituario " +
                "(id_lote,id_causa_morte,quantidade_animais_mortos,peso_medio_estimado)"+
                "VALUES (?,?,?,?)",params);

    }
}
