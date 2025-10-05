<p align="center">
  <small><i>WorldEditX</i></small>
</p>

WorldEditX is a lightweight cross-version bridge for WorldEdit, designed to make region selection handling simple and flexible.
It removes the hassle of targeting a specific WorldEdit version (6 or 7) by providing a unified API that works across both generations.

Instead of forcing server owners or developers to hard-depend on a single API, WorldEditX handles the version differences internally through reflection.

This project is not a full replacement for WorldEdit — it only focuses on region selection interoperability.

It offers the essential tools, such as:

Getting WorldEdit selections as Bukkit Location and custom Cuboid objects

Transparent support for both WorldEdit 6.x and 7.x APIs

Reflection-based loading (no compile-time dependency)

Simple integration into any plugin that relies on area selections

Our goal is to provide a clean, minimal, and reliable WorldEdit bridge that allows developers to focus on their gameplay features without worrying about API changes.

