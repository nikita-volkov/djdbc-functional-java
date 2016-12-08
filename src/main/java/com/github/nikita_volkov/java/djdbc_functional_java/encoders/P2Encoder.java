package com.github.nikita_volkov.java.djdbc_functional_java.encoders;

import djdbc.Encoder;
import fj.P2;

import java.sql.*;

public final class P2Encoder<_1, _2> implements Encoder<P2<_1, _2>> {

  private final Encoder<_1> encoder1;
  private final Encoder<_2> encoder2;

  public P2Encoder(Encoder<_1> encoder1, Encoder<_2> encoder2) {
    this.encoder1 = encoder1;
    this.encoder2 = encoder2;
  }

  @Override
  public void encodeParams(PreparedStatement preparedStatement, P2<_1, _2> input) throws SQLException {
    encoder1.encodeParams(preparedStatement, input._1());
    encoder2.encodeParams(preparedStatement, input._2());
  }

}
