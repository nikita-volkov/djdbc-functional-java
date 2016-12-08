package com.github.nikita_volkov.java.djdbc_functional_java.decoders;

import djdbc.Decoder;
import fj.data.Option;

import java.sql.*;

public final class OptionDecoder<row> extends Decoder.Rows<Option<row>> {

  private final Rows<row> rowDecoder;

  public OptionDecoder(Rows<row> rowDecoder) {
    this.rowDecoder = rowDecoder;
  }

  @Override
  public Option<row> run(ResultSet resultSet) throws SQLException {
    if (resultSet.next()) {
      return Option.some(rowDecoder.run(resultSet));
    }
    return Option.none();
  }

}
