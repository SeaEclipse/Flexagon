#!/usr/bin/env bash

pushd proxy
git rebase --interactive upstream/upstream
popd
