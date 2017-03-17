package com.github.nikita_volkov.java.djdbc_functional_java.decoders;

import djdbc.Decoder;
import fj.data.Option;

import java.sql.*;

public final class NullableColumnDecoder<row> extends Decoder.Rows<Option<row>> {

  private final int index;
  private final Rows<row> subDecoder;

  public NullableColumnDecoder(int index, Rows<row> columnDecoder) {
    this.index = index;
    this.subDecoder = columnDecoder;
  }

  @Override
  public Option<row> run(ResultSet resultSet) throws SQLException {
    if (resultSet.getObject(index) == null) return Option.none();
    else return Option.some(subDecoder.run(resultSet));
  }

}
