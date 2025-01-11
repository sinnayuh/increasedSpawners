# Increased Spawners

A Minecraft plugin that extends the player activation range of mob spawners. When a spawner is placed, it automatically adjusts the activation range, and administrators can modify these ranges using simple commands.

## Features

- Automatically adjusts spawner activation range when placed
- Commands to view and modify spawner ranges
- Permission-based access control
- Simple and lightweight

## Installation

1. Download the latest release from the releases page
2. Place the .jar file in your server's `plugins` folder
3. Restart your server
4. Configure permissions for your administrators

## Commands

All commands can be accessed using `/increasedspawners`, `/is`, or `/inc`:

| Command | Description |
|---------|-------------|
| `/inc help` | Displays the help menu |
| `/inc version` | Shows the current plugin version |
| `/inc getradius` | Gets the activation range of the spawner you're looking at |
| `/inc setradius <number>` | Sets the activation range of the spawner you're looking at |

## Permissions

- `increasedspawners.admin` - Grants access to all plugin commands

## Configuration

No configuration needed! The plugin works out of the box.

## Usage

1. Place a spawner - it will automatically have an extended activation range
2. Look at a spawner and use `/inc getradius` to check its current range
3. Use `/inc setradius <number>` while looking at a spawner to modify its range

## Support

If you encounter any issues or have feature requests, please:
1. Check the existing issues on the GitHub repository
2. Create a new issue if your problem hasn't been reported

## Contributing

Contributions are welcome! Feel free to submit pull requests or create issues for bugs and feature requests.
