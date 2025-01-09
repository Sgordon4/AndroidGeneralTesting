package com.example.generaltesting;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class UserAttributesTest {

	@Test
	public void testAttrExceptions(@TempDir Path tempDir) throws IOException {
		System.out.println("helloworld() testDir="+tempDir);

		Path testFile = tempDir.resolve("test.txt");

        //Before we make the test file, attempt to get user attributes from it
        UserDefinedFileAttributeView attrs = Files.getFileAttributeView(testFile, UserDefinedFileAttributeView.class);
        attrs.size("something");
	}
}