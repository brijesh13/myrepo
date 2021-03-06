const WindowsUpdater = require('./lib/WindowsUpdater'),
    DarwinUpdater = require('./lib/DarwinUpdater'),
    LinuxUpdater = require('./lib/LinuxUpdater'),
    LinuxAutoUpdater = require('./lib/autoUpdater/LinuxAutoUpdater'),

    WINDOWS = 'Windows_NT',
    DARWIN = 'Darwin',
    LINUX = 'Linux',


    /**
     * @method initializeUpdater
     * @description Provides the updater class Instance based on the OS.
     * It uses Node.os.type() to detect the os.
     * https://nodejs.org/dist/latest-v8.x/docs/api/os.html#os_os_type
     *
     * @returns {?Object} WindowsAutoUpdate || DarwinUpdater || LinuxUpdater || null
     */
    init = function init (options = {}) {
        const { adapter } = options,
            os = require('os').type(),
            updaterOptions = { adapter, autoUpdater: adapter.getAutoUpdater() };

        switch (os) {
            case WINDOWS:
                return new WindowsUpdater(updaterOptions);
            case DARWIN:
                return new DarwinUpdater(updaterOptions);
            case LINUX:
                return new LinuxUpdater(Object.assign(updaterOptions, {
                    autoUpdater: new LinuxAutoUpdater({ quitApp: adapter.quitApp })
                }));
            default:
                return null;
        }
    };

module.exports = { init };
