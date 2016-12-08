package com.github.nikita_volkov.java.djdbc_functional_java.decoders;

import djdbc.Decoder;
import fj.*;

import java.sql.*;

public final class P2Decoder<_1, _2> extends Decoder.Rows<P2<_1, _2>> {

  private final Rows<_1> decoder1;
  private final Rows<_2> decoder2;

  public P2Decoder(Rows<_1> decoder1, Rows<_2> decoder2) {
    this.decoder1 = decoder1;
    this.decoder2 = decoder2;
  }

  @Override
  public P2<_1, _2> run(ResultSet resultSet) throws SQLException {
    return P.p(decoder1.run(resultSet), decoder2.run(resultSet));
  }

}
