package com.github.nikita_volkov.java.djdbc_functional_java.decoders;

import djdbc.Decoder;
import fj.*;

import java.sql.*;

public final class P4Decoder<_1, _2, _3, _4> extends Decoder.Rows<P4<_1, _2, _3, _4>> {

  private final Rows<_1> decoder1;
  private final Rows<_2> decoder2;
  private final Rows<_3> decoder3;
  private final Rows<_4> decoder4;

  public P4Decoder(Rows<_1> decoder1, Rows<_2> decoder2, Rows<_3> decoder3, Rows<_4> decoder4) {
    this.decoder1 = decoder1;
    this.decoder2 = decoder2;
    this.decoder3 = decoder3;
    this.decoder4 = decoder4;
  }

  @Override
  public P4<_1, _2, _3, _4> run(ResultSet resultSet) throws SQLException {
    return P.p(decoder1.run(resultSet), decoder2.run(resultSet), decoder3.run(resultSet), decoder4.run(resultSet));
  }

}
