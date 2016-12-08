package com.github.nikita_volkov.java.djdbc_functional_java.decoders;

import djdbc.Decoder;
import fj.F0;

import java.sql.*;

public final class SingleWithDefaultDecoder<row> extends Decoder.Rows<row> {

  private final Rows<row> rowDecoder;
  private final F0<row> defaultRow;

  public SingleWithDefaultDecoder(Rows<row> rowDecoder, F0<row> defaultRow) {
    this.rowDecoder = rowDecoder;
    this.defaultRow = defaultRow;
  }

  @Override
  public row run(ResultSet resultSet) throws SQLException {
    if (resultSet.next()) {
      return rowDecoder.run(resultSet);
    } else {
      return defaultRow.f();
    }
  }

}
