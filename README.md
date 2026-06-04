# Reloadable Dialog

[![GitHub commit activity](https://img.shields.io/github/commit-activity/t/qwertycxz/ReloadableDialog)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub commits since latest release](https://img.shields.io/github/commits-since/qwertycxz/ReloadableDialog/latest)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub contributors](https://img.shields.io/github/contributors/qwertycxz/ReloadableDialog)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub Created At](https://img.shields.io/github/created-at/qwertycxz/ReloadableDialog)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub last commit](https://img.shields.io/github/last-commit/qwertycxz/ReloadableDialog)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub top language](https://img.shields.io/github/languages/top/qwertycxz/ReloadableDialog)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/qwertycxz/ReloadableDialog/check.yml)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub branch check runs](https://img.shields.io/github/check-runs/qwertycxz/ReloadableDialog/master)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub Downloads (all assets, all releases)](https://img.shields.io/github/downloads/qwertycxz/ReloadableDialog/total)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub Sponsors](https://img.shields.io/github/sponsors/qwertycxz)](https://ko-fi.com/qwertycxz)
[![GitHub Issues or Pull Requests](https://img.shields.io/github/issues/qwertycxz/ReloadableDialog)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub Issues or Pull Requests](https://img.shields.io/github/issues-pr/qwertycxz/ReloadableDialog)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub Discussions](https://img.shields.io/github/discussions/qwertycxz/ReloadableDialog)](https://github.com/qwertycxz/ReloadableDialog)
[![CurseForge Game Versions](https://img.shields.io/curseforge/game-versions/1560532)](https://www.curseforge.com/minecraft/mc-mods/reloadabledialog)
[![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/qwertycxz/ReloadableDialog)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub repo file or directory count](https://img.shields.io/github/directory-file-count/qwertycxz/ReloadableDialog)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub repo size](https://img.shields.io/github/repo-size/qwertycxz/ReloadableDialog)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub followers](https://img.shields.io/github/followers/qwertycxz)](https://github.com/qwertycxz)
[![GitHub forks](https://img.shields.io/github/forks/qwertycxz/ReloadableDialog)](https://github.com/qwertycxz/ReloadableDialog)
[![GitHub User's stars](https://img.shields.io/github/stars/qwertycxz)](https://github.com/qwertycxz)
[![Modrinth Followers](https://img.shields.io/modrinth/followers/ReloadableDialog)](https://modrinth.com/mod/ReloadableDialog)
[![GitHub Release](https://img.shields.io/github/v/release/qwertycxz/ReloadableDialog)](https://github.com/qwertycxz/ReloadableDialog)

Minecraft 1.21.6 added a new feature called [dialog](https://minecraft.wiki/w/Dialog), which allows players to interact through a dialog interface. However, the dialog data is loaded only once when the server starts, and any changes to the dialog data require a server restart to take effect.

This mod fix that.

## What does it do and doesn't do?

This server-side mod allows you to reload dialog data without restarting the server. You can simply edit the dialog JSON files and run the command `/reload` to apply the changes immediately.

However, the reloaded dialog data cannot be sent to players who are already connected to the server. They will need to reconnect to see the updated dialog data. This is what a server-side mod can do without modifying the client.

## Download

[Maven Central](https://central.sonatype.com/artifact/top.qwertycxz/reloadabledialog)

[GitHub Packages](https://github.com/qwertycxz/ReloadableDialog/packages)

[CurseForge](https://www.curseforge.com/minecraft/mc-mods/reloadabledialog/files)

[Modrinth](https://modrinth.com/mod/reloadabledialog/versions)

## Requirement

* Minecraft ⩾ 1.21.6
* Fabric or NeoForge

## Usage

Very simple, just add the mod to your server and restart the server. After that, you can edit the dialog JSON files and run the command `/reload` to apply the changes.

## Contributor

[@qwertycxz](https://github.com/qwertycxz)

## How could I contribute?

[Issue](https://github.com/qwertycxz/ReloadableDialog/issues/new) and [Pull-requests](https://github.com/qwertycxz/ReloadableDialog/compare) are both welcomed.

## License

[Apache 2.0](LICENSE) © qwertycxz
