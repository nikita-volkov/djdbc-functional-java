package com.github.nikita_volkov.java.djdbc_functional_java.encoders;

import djdbc.Encoder;
import fj.P3;

import java.sql.*;

public final class P3Encoder<_1, _2, _3> implements Encoder<P3<_1, _2, _3>> {

  private final Encoder<_1> encoder1;
  private final Encoder<_2> encoder2;
  private final Encoder<_3> encoder3;

  public P3Encoder(Encoder<_1> encoder1, Encoder<_2> encoder2, Encoder<_3> encoder3) {
    this.encoder1 = encoder1;
    this.encoder2 = encoder2;
    this.encoder3 = encoder3;
  }

  @Override
  public void encodeParams(PreparedStatement preparedStatement, P3<_1, _2, _3> p3) throws SQLException {
    encoder1.encodeParams(preparedStatement, p3._1());
    encoder2.encodeParams(preparedStatement, p3._2());
    encoder3.encodeParams(preparedStatement, p3._3());
  }

}
