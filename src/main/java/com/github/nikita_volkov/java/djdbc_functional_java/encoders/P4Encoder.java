package com.github.nikita_volkov.java.djdbc_functional_java.encoders;

import djdbc.Encoder;
import fj.P4;

import java.sql.*;

public final class P4Encoder<_1, _2, _3, _4> implements Encoder<P4<_1, _2, _3, _4>> {

  private final Encoder<_1> encoder1;
  private final Encoder<_2> encoder2;
  private final Encoder<_3> encoder3;
  private final Encoder<_4> encoder4;

  public P4Encoder(Encoder<_1> encoder1, Encoder<_2> encoder2, Encoder<_3> encoder3, Encoder<_4> encoder4) {
    this.encoder1 = encoder1;
    this.encoder2 = encoder2;
    this.encoder3 = encoder3;
    this.encoder4 = encoder4;
  }

  @Override
  public void encodeParams(PreparedStatement preparedStatement, P4<_1, _2, _3, _4> input) throws SQLException {
    encoder1.encodeParams(preparedStatement, input._1());
    encoder2.encodeParams(preparedStatement, input._2());
    encoder3.encodeParams(preparedStatement, input._3());
    encoder4.encodeParams(preparedStatement, input._4());
  }

}
