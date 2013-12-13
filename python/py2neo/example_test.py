#!/usr/bin/env python
# -*- coding: utf-8 -*-

import example
import unittest

class TestExample(unittest.TestCase):
    def test_hello_cypher(self):
        friends = example.hello_cypher()
        self.assertEqual(friends, ["JnBrymn", "technige"])

if __name__ == '__main__':
    unittest.main()
