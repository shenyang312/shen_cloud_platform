package com.shen.cloud.util;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * create by emmet
 * create at 04/01/2018
 */
public class ResponseWrapper extends HttpServletResponseWrapper {

    private ServletOutputStream output;
    private ByteArrayOutputStream byteArrayOutputStream;

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
        try {
            output = response.getOutputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                output.write(b);
                byteArrayOutputStream.write(b);
            }
        });
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new ServletOutputStream() {
            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setWriteListener(WriteListener listener) {

            }

            @Override
            public void write(int b) throws IOException {
                output.write(b);
                byteArrayOutputStream.write(b);
            }
        };
    }

    public String getResponseContent() {
        return new String(byteArrayOutputStream.toByteArray());
    }
}

