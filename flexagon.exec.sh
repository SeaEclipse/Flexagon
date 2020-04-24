#!/usr/bin/env bash

case "$1" in
    "rb" | "rbp" | "rebuild")
        scripts/rebuildPatches.sh
    ;;
    "p" | "patch")
        scripts/build.sh
    ;;
    "m" | "up" | "merge")
        scripts/mergeUpstream.sh
    ;;
    "b" | "build")
        scripts/build.sh --jar
    ;;
    "e" | "edit")
        scripts/edit.sh
    ;;
    "w" | "wiggle")
        scripts/wigglePatch.py
    ;;
    *)
        echo
        echo "Ｆｌｅｘａｇｏｎ"
        echo
        echo "Forked from Travertine by Sea Eclipse [Final] ❤#6699"
        echo "HexaCord build tool command. This provides a variety of commands to control the HexaCord."
        echo "build. View below for details of the available commands."
        echo ""
        echo "Commands:"
        echo "  * rb, rbp, rebuild | Rebuilds the patches"
        echo "  * p, patch         | Applies all the patches to BungeeCord"
        echo "  * m, up, merge     | Utility to aid in merging upstream"
        echo "  * b, build         | Builds the project"
        echo "                     | The bootstrap artifact can be found in proxy/bootstrap/target/"
        echo "  * e, edit          | Runs git rebase -i for Hexagon, allowing patches to be easily modified"
        echo "  * w, wiggle        | Helps to apply patches that fail to using default Git."
    ;;
esac
