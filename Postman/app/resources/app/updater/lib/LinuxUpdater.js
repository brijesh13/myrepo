var AbstractUpdater = require('./AbstractUpdater');

/**
 * @class LinuxUpdater
 * @extends AbstractUpdater
 *
 * It overrides the methods specific for linux updater.
 */
class LinuxUpdater extends AbstractUpdater {
    constructor (updaterOptions) {
        super(updaterOptions);
        this.autoUpdater.cleanUp({
            appInstallationPath: this.adapter.getAppInstallationPath(),
            appName: this.adapter.getAppName()
        });
    }

    downloadUpdate (updateInfo) {
        console.log('Linux updateInfo received', updateInfo);
        this.autoUpdater.downloadUpdate(this.adapter.getAppName(), updateInfo.downloadURL,
            this.adapter.getAppInstallationPath());
    }
}

module.exports = LinuxUpdater;
