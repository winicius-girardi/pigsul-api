package br.com.pigsul.model.repository;

import br.com.pigsul.model.dto.request.LoteRequestDto;
import br.com.pigsul.model.entity.Lote;
import br.com.pigsul.model.entity.Origem;
import br.com.pigsul.model.entity.Uf;
import br.com.pigsul.model.enumType.UfEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoteRepository {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public LoteRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }


/*SELECT l.id_usuario,l.id_lote,l.data_entrada_lote,l.data_saida_lote,l.estado_lote,
    l.qtd_animais_alojados, l.peso_medio_animais_entrada, l.peso_medio_animais_saida,
    l.id_origem, l.observacoes, l.quantidade_animais_saida, o.nome_granja, o.cidade_origem,
    o.id_uf, u.sigla, u.nome_uf
FROM app_schema.lote l
INNER JOIN app_schema.origem o ON l.id_origem = o.id_origem
INNER JOIN app_schema.uf u ON o.id_uf=u.id_uf
WHERE l.id_lote=1;
 */


    public void changeLoteByLoteId(int loteId, LoteRequestDto loteRequest){

    }

    public Lote getLoteByLoteId(Integer loteId){
        return (Lote) jdbcTemplate.query("SELECT * FROM app_schema.lote l, app_schema.origem o, " +
                        "INNER JOIN l.id_lote=o.id_lote " +
                        "WHERE l.id_lote= ?",
                            (rs, rowNum) -> new Lote(rs.getInt("id_usuario"),rs.getInt("id_lote"),
                            rs.getDate("data_entrada_lote").toLocalDate(), rs.getDate("data_saida_lote").toLocalDate(),
                            rs.getBoolean("estado_lote"), rs.getInt("quantidade_animais_alojados"),
                            rs.getFloat("peso_medio_animais_entrada"), rs.getFloat("peso_medio_animais_saida"),
                                new Origem(rs.getInt("id_origem"),rs.getString("nome_granja"),rs.getString("cidade_origem"),
                                new Uf(UfEnum.valueOf(rs.getString("sigla")))),
                            rs.getString("observacoes"), rs.getInt("quantidade_animais_saida")),
                        loteId
        );
    }

    public boolean getIdLoteExists(Integer idLote) {
        List<Integer>list =jdbcTemplate.query("SELECT id_lote FROM app_schema.lote " +
                "WHERE id_lote = ? ",
                    (rs,rowNum) -> rs.getInt("id_lote"),
                idLote
        );

        return !list.isEmpty();
    }

    public List<Lote> getLoteListByUserId(Integer userId,Boolean ativo) {

        return jdbcTemplate.query("SELECT l.id_usuario,l.id_lote, l.data_entrada_lote,l.estado_lote,l.qtd_animais_alojados" +
                "FROM app_schema.lote l" +
                "WHERE l.id_usuario= ? AND l.estado_lote= ?",
                    (rs,rowNum)-> new Lote(rs.getInt("id_usuario"),rs.getInt("id_lote"),
                    rs.getDate("data_entrada_lote").toLocalDate(), rs.getBoolean("estado_lote"),
                    rs.getInt("quantidade_animais_alojados")),
                userId,ativo);
    }
}
