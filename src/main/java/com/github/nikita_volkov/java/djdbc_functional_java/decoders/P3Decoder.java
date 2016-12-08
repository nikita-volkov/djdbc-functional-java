package com.github.nikita_volkov.java.djdbc_functional_java.decoders;

import djdbc.Decoder;
import fj.*;

import java.sql.*;

public final class P3Decoder<_1, _2, _3> extends Decoder.Rows<P3<_1, _2, _3>> {

  private final Rows<_1> decoder1;
  private final Rows<_2> decoder2;
  private final Rows<_3> decoder3;

  public P3Decoder(Rows<_1> decoder1, Rows<_2> decoder2, Rows<_3> decoder3) {
    this.decoder1 = decoder1;
    this.decoder2 = decoder2;
    this.decoder3 = decoder3;
  }

  @Override
  public P3<_1, _2, _3> run(ResultSet resultSet) throws SQLException {
    return P.p(decoder1.run(resultSet), decoder2.run(resultSet), decoder3.run(resultSet));
  }

}
