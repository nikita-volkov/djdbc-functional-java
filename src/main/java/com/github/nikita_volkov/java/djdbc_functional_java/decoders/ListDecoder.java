package com.github.nikita_volkov.java.djdbc_functional_java.decoders;

import djdbc.Decoder;
import fj.data.List;

import java.sql.*;

public final class ListDecoder<row> extends Decoder.Rows<List<row>> {

  private final Rows<row> rowDecoder;

  public ListDecoder(Rows<row> rowDecoder) {
    this.rowDecoder = rowDecoder;
  }

  @Override
  public List<row> run(ResultSet resultSet) throws SQLException {
    List.Buffer<row> buffer = new List.Buffer<row>();
    while (resultSet.next()) {
      row row = rowDecoder.run(resultSet);
      buffer.snoc(row);
    }
    return buffer.toList();
  }

}
